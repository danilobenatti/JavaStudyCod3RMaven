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
		String name = "Peter Update";
		Date date = Date.valueOf(LocalDate.now().minusDays(15));
		
		String sql = """
			UPDATE `javastudy`.`tbl_person`
			SET
			`col_firstname` = ?,
			`col_deathdate` = ?
			WHERE `id` = ?
			""";
		
		try (Connection conn = ConnectionDatabase.getDataSourceConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDate(2, date);
			pstmt.setLong(3, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
