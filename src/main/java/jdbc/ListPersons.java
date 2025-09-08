package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Person;
import util.ConnectionDatabase;

public class ListPersons {
	
	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		
		String sql = """
			SELECT `p`.* FROM `javastudy`.`tbl_person` AS `p` LIMIT 0, 10
			""";
		
		try (Connection conn = ConnectionDatabase.getConnection();
				Statement stmt = conn.createStatement()) {
			ResultSet result = stmt.executeQuery(sql);
			while (result.next()) {
				
				Person p = new Person(result.getLong("id"),
						result.getString("col_firstname"),
						result.getString("col_gender").charAt(0),
						result.getFloat("col_weight"),
						result.getFloat("col_height"),
						result.getDate("col_borndate").toLocalDate(),
						result.getDate("col_deathdate") != null
								? result.getDate("col_deathdate").toLocalDate()
								: null);
				persons.add(p);
				
				persons.add(Person.person().id(result.getLong("id"))
						.name(result.getString("col_firstname"))
						.gender(result.getString("col_gender").charAt(0))
						.weight(result.getFloat("col_weight"))
						.height(result.getFloat("col_height"))
						.birthDate(result.getDate("col_borndate").toLocalDate())
						.deathDate(result.getDate("col_deathdate") != null
								? result.getDate("col_deathdate").toLocalDate()
								: null)
						.build());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		persons.forEach(System.out::println);
		
	}
	
}
