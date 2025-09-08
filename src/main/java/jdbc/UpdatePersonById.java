package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import util.ConnectionDatabase;

public class UpdatePersonById {
	
	public static void main(String[] args) {
		
		long id = 1;
		String firstname = "Henry Update";
		Date deathdate = Date.valueOf(LocalDate.now().minusDays(15));
		
		String sql = """
			UPDATE `javastudy`.`tbl_person`
			SET
			`col_firstname` = ?,
			`col_deathdate` = ?
			WHERE (`id` = ?)
			""";
		
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, firstname);
			pstmt.setDate(2, deathdate);
			pstmt.setLong(3, id);
			
			int update = pstmt.executeUpdate();
			
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
