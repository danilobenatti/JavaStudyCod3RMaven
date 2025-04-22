package jdbc;

import static model.Person.person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class ListPersons {
	
	public static void main(String[] args) {
		
		List<Person> list = new ArrayList<>();
		
		String sql = """
			SELECT `p`.* FROM `javastudy`.`tbl_person` AS `p`
			""";
		
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet set = stmt.executeQuery(sql);
			while (set.next()) {
				list.add(person().id(set.getLong("id"))
						.name(set.getString("col_firstname"))
						.gender(set.getString("col_gender").charAt(0))
						.weight(set.getFloat("col_weight"))
						.height(set.getFloat("col_height"))
						.birthDate(set.getDate("col_borndate") != null
								? set.getDate("col_borndate").toLocalDate()
								: null)
						.deathDate(set.getDate("col_deathdate") != null
								? set.getDate("col_deathdate").toLocalDate()
								: null)
						.build());
			}
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
