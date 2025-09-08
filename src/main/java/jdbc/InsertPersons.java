package jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Person;
import util.ConnectionDatabase;

public class InsertPersons {
	
	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		
		File file = new File("./src/test/resources/data_person.csv");
		
		try (BufferedReader reader = new BufferedReader(
				new FileReader(file, Charset.forName("UTF-8")))) {
			reader.readLine(); // Read and discard the first line
			String line;
			while ((line = reader.readLine()) != null) {
				List<String> split = Arrays.stream(line.split(";"))
						.map(String::trim).toList();
				
				persons.add(Person.person().id(0L).name(split.get(0))
						.gender(split.get(1).charAt(0))
						.weight(Float.valueOf(split.get(2)))
						.height(Float.valueOf(split.get(3)))
						.birthDate(Date.valueOf(split.get(4)).toLocalDate())
						.deathDate(!split.get(5).isBlank()
								&& !split.get(5).toUpperCase().matches("NULL")
										? Date.valueOf(split.get(5)).toLocalDate()
										: null)
						.build());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String dml = """
			INSERT INTO `javastudy`.`tbl_person`
			(`col_firstname`,
			`col_gender`,
			`col_weight`,
			`col_height`,
			`col_borndate`,
			`col_deathdate`)
			VALUES
			(?, ?, ?, ?, ?, ?)
			""";
		
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dml)) {
			conn.setAutoCommit(false);
			
			for (Person p : persons) {
				pstmt.setString(1, p.getName());
				pstmt.setString(2, String.valueOf(p.getGender()));
				pstmt.setDouble(3, p.getWeight());
				pstmt.setDouble(4, p.getHeight());
				pstmt.setDate(5, Date.valueOf(p.getBirthDate()));
				pstmt.setDate(6,
						p.getDeathDate() != null
								? Date.valueOf(p.getDeathDate())
								: null);
				pstmt.addBatch();
			}
			int[] batch = pstmt.executeBatch();
			conn.commit();
			System.out.println(batch.length);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
