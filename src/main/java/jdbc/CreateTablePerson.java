package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTablePerson {
	
	public static void main(String[] args) {
		
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
		
		try (Connection conn = ConnectionFactory.getConnection();
				Statement stmt = conn.createStatement()) {
			stmt.execute(ddl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
