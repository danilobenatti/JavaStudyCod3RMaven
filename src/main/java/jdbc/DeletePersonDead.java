package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;

import util.ConnectionDatabase;

public class DeletePersonDead {
	
	public static void main(String[] args) {
		
		Year year = Year.of(LocalDate.now(ZoneId.of("UTC-03:00")).getYear());
		
		String sql = """
			DELETE FROM `javastudy`.`tbl_person` AS `p`
			WHERE YEAR(`p`.`col_deathdate`) <= ?
			""";
		try (Connection conn = ConnectionDatabase.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setLong(1, year.getValue());
			int execute = pstmt.executeUpdate();
			System.out.println(execute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
