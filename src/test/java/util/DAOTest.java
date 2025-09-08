package util;

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
		
		Person p = Person.person().id(0L).name("Test").gender('M').weight(90.0F)
				.height(1.83F)
				.birthDate(LocalDate.now().minus(45, ChronoUnit.YEARS))
				.deathDate(null).build();
		
		int i = dao.include(dml, p.getName(), p.getGender(),
				p.getWeight(), p.getHeight(), p.getBirthDate(),
				p.getDeathDate());
		
		dao.close();
		
		System.out.println(i);
		assertTrue(i > 0);
		
	}
	
}
