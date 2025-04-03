package util;

import static model.Person.person;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

import dao.DAO;
import model.Person;

class DAOTest {
	
	DAO dao = new DAO();
	
	@Test
	void IncludeTest() {
		
		String sql = """
			INSERT INTO `javastudy`.`tbl_person`
			(`col_firstname`,
			`col_gender`,
			`col_borndate`)
			VALUES
			(?, ?, ?)
			""";
		
		Person p = person().name("Test").gender('M')
				.bornDate(LocalDate.now().minus(45, ChronoUnit.YEARS)).build();
		
		int i = dao.include(sql, p.getName(), p.getGender(), p.getBornDate());
		dao.close();
		System.out.println(i);
		assertTrue(i > 0);
		
	}
	
}
