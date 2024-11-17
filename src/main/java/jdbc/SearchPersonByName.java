package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class SearchPersonByName {
	
	public static void main(String[] args) {
		
		String str = "N";
		List<Person> list = new ArrayList<>();
		
		String sql = """
			SELECT `p`.* FROM `javastudy`.`tbl_person` AS `p`
			WHERE `p`.`col_firstname` LIKE ?
			""";
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%".concat(str).concat("%"));
			ResultSet set = stmt.executeQuery();
			while (set.next()) {
				Person person = Person.personBuilder().id(set.getLong("id"))
						.name(set.getString("col_firstname"))
						.gender(set.getString("col_gender").charAt(0))
						.weight(set.getFloat("col_weight"))
						.height(set.getFloat("col_height"))
						.bornDate(set.getDate("col_borndate") != null
								? set.getDate("col_borndate").toLocalDate()
								: null)
						.deathDate(set.getDate("col_deathdate") != null
								? set.getDate("col_deathdate").toLocalDate()
								: null)
						.build();
				list.add(person);
			}
			list.forEach(System.out::println);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
