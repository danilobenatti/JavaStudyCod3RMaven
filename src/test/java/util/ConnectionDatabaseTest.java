package util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import dao.DAO;
import model.Person;

@TestMethodOrder(OrderAnnotation.class)
class ConnectionDatabaseTest {
	
	@Test
	@Order(1)
	void ShowDatabasesTest() {
		List<String> list = new ArrayList<>();
		try (Connection conn = ConnectionDatabase.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SHOW DATABASES")) {
			while (rs.next()) {
				list.add(rs.getString("Database"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list.forEach(System.out::println);
		Assertions.assertNotNull(list);
	}
	
	@Test
	@Order(2)
	void CreateDatabaseTest() {
		// Data Definition Language
		String ddl = """
			CREATE DATABASE IF NOT EXISTS `javastudy`
			CHARACTER SET `utf8mb4`
			COLLATE `utf8mb4_unicode_ci`
			""";
		// Data Manipulation Language
		String dml = """
			SELECT schema_name FROM information_schema.schemata
			WHERE schema_name = 'javastudy'
			""";
		try (Connection conn = ConnectionDatabase.getConnection();
				Statement stmt = conn.createStatement()) {
			stmt.execute(ddl);
			boolean execute = stmt.execute(dml);
			Assertions.assertTrue(execute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Order(3)
	void CreateTablePersonTest() {
		String ddl = """
			CREATE TABLE IF NOT EXISTS `javastudy`.`tbl_person`(
			`id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
			`col_firstname` VARCHAR(150) NOT NULL,
			`col_gender` CHAR(1) NOT NULL,
			`col_weight` FLOAT NOT NULL,
			`col_height` FLOAT NOT NULL,
			`col_borndate` DATE NOT NULL,
			`col_deathdate` DATE NULL,
			PRIMARY KEY (`id`)
			)
			""";
		try (Connection conn = ConnectionDatabase.getConnection();
				Statement stmt = conn.createStatement()) {
			Assertions.assertFalse(stmt.execute(ddl));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Order(4)
	@ParameterizedTest(name = "[{index}] - {0}")
	@CsvFileSource(numLinesToSkip = 1, delimiter = ';', nullValues = { "NULL" },
		files = "./src/test/resources/data_person.csv")
	void InsertPersonTest(String firstname, Character gender, float weight,
			float height, Date borndate, Date deathdate) {
		Person person = Person.person().id(0L).name(firstname).gender(gender)
				.weight(weight).height(height)
				.birthDate(borndate.toLocalDate())
				.deathDate(deathdate != null ? deathdate.toLocalDate() : null)
				.build();
		InsertPerson(person);
	}
	
	private boolean InsertPerson(Person person) {
		boolean result = true;
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
				PreparedStatement pstmt = conn.prepareStatement(dml,
						Statement.RETURN_GENERATED_KEYS)) {
			DAO.setAttributes(pstmt, person.getName(), person.getGender(),
					person.getWeight(), person.getHeight(),
					person.getBirthDate(), person.getDeathDate());
			result = pstmt.execute();
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				System.out.println(rs.getLong(1));
			}
			Assertions.assertFalse(result);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Order(5)
	@ParameterizedTest(name = "[{index}] - {0}")
	@ValueSource(strings = {
			"SELECT * FROM `javastudy`.`tbl_person` AS `p` WHERE `p`.`col_firstname` LIKE ?",
			"SELECT * FROM `javastudy`.`tbl_person` AS `p` WHERE `p`.`col_firstname` NOT LIKE ?" })
	void listAllPersonTest(String sql) {
		
		List<Person> persons = new ArrayList<>();
		
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql,
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY)) {
			pstmt.setString(1, "%N%");
			ResultSet resultSet = pstmt.executeQuery();
			
			while (resultSet.next()) {
				persons.add(getPerson(resultSet));
			}
			
			if (resultSet.last()) {
				System.out.println("Persons Found: " + resultSet.getRow());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		persons.forEach(System.out::println);
		Assertions.assertTrue(persons.size() > 0);
	}
	
	private Person getPerson(ResultSet resultSet) throws SQLException {
		return Person.person().id(resultSet.getLong("id"))
				.name(resultSet.getString("col_firstname"))
				.gender(resultSet.getString("col_gender").charAt(0))
				.weight(resultSet.getFloat("col_weight"))
				.height(resultSet.getFloat("col_height"))
				.birthDate(resultSet.getDate("col_borndate").toLocalDate())
				.deathDate(resultSet.getDate("col_deathdate") != null
						? resultSet.getDate("col_deathdate").toLocalDate()
						: null)
				.build();
	}
	
	@Order(6)
	@ParameterizedTest(name = "[{index}] - {0}")
	@CsvSource(delimiter = ';', value = { "1; Henry Update", "2; Nany Update" })
	void UpdatePersonTest(long id, String name) {
		String dml = """
			UPDATE `javastudy`.`tbl_person`
			SET
			`col_firstname` = ?,
			`col_deathdate` = ?
			WHERE `id` = ?
			""";
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dml)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, Date.valueOf(LocalDate.now().minusDays(15)));
			pstmt.setLong(3, id);
			int execute = pstmt.executeUpdate();
			System.out.println(execute);
			Assertions.assertEquals(1, execute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Order(7)
	@ParameterizedTest(name = "[{index}] - {0}")
	@ValueSource(longs = { 1, 2 })
	void DeletePersonTest(long id) {
		String dml = """
			DELETE FROM `javastudy`.`tbl_person` AS `p`
			WHERE `p`.`id` = ?
			""";
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dml)) {
			pstmt.setLong(1, id);
			int execute = pstmt.executeUpdate();
			System.out.println(execute);
			Assertions.assertTrue(execute > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
