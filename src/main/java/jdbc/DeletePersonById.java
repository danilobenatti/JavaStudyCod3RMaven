package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionDatabase;

public class DeletePersonById {
	
	public static void main(String[] args) {
		
		long id = 1;
		
		String sql = """
			DELETE FROM `javastudy`.`tbl_person` AS `p`
			WHERE `p`.`id` = ?
			""";
		try (Connection conn = ConnectionDatabase.getDataSourceConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, id);
			int execute = pstmt.executeUpdate();
			System.out.println(execute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
