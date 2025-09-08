package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPerson {
	
	public static void main(String[] args) {
		
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
		
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(dml)) {
			pstmt.setString(1, "Henry");
			pstmt.setString(2, String.valueOf('M'));
			pstmt.setFloat(3, 89.5F);
			pstmt.setFloat(4, 1.83F);
			pstmt.setDate(5, Date.valueOf("1999-05-01"));
			pstmt.setDate(6, null);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
