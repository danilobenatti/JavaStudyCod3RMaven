package jdbc;

import static model.Person.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import util.ConnectionDatabase;

public class SearchPersonByName {
	
	public static void main(String[] args) {
		
		String str = "N";
		List<Person> persons = new ArrayList<>();
		
		String sql = """
			SELECT `p`.* FROM `javastudy`.`tbl_person` AS `p`
			WHERE `p`.`col_firstname` LIKE ?
			""";
		
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			stmt.setString(1, "%".concat(str).concat("%"));
			
			ResultSet set = stmt.executeQuery();
			
			while (set.next()) {
				Person person = person().id(set.getLong("id"))
						.name(set.getString("col_firstname"))
						.gender(set.getString("col_gender").charAt(0))
						.weight(set.getFloat("col_weight"))
						.height(set.getFloat("col_height"))
						.birthDate(set.getDate("col_borndate").toLocalDate())
						.deathDate(set.getDate("col_deathdate") != null
								? set.getDate("col_deathdate").toLocalDate()
								: null)
						.build();
				persons.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		persons.forEach(System.out::println);
		
	}
	
}
