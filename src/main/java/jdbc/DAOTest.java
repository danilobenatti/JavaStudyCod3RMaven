package jdbc;

import java.sql.Date;

import dao.DAO;

public class DAOTest {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
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
		
		dao.include(dml, "Henry", String.valueOf('M'), 89.5F, 1.83F,
				Date.valueOf("1999-05-01"), null);
		
	}
	
}
