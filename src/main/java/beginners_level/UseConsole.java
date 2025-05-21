package beginners_level;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Person;
import model.Student;
import model.util.PersonUtil;
import util.Imc;

public class UseConsole {
	
	static Logger log = Logger.getLogger(UseConsole.class.getName());
	
	public static void main(String[] args) {
		
		Person p = new Student();
		
		try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
			log.info("Inform name[Ex. Mary]: ");
			p.setName(scanner.nextLine());
			log.info("Inform gender(M/F)[Ex. F]: ");
			p.setGender(Character.toUpperCase(scanner.nextLine().charAt(0)));
			log.info("Inform height[Ex. 1.65]: ");
			p.setHeight(Float.parseFloat(scanner.nextLine().replace(',', '.')));
			log.info("Inform weight[Ex. 68.7}]: ");
			p.setWeight(Float.parseFloat(scanner.nextLine().replace(',', '.')));
			
			p.setBirthDate(LocalDate.now().minusYears(27));
			p.setDeathDate(LocalDate.now());
			
		}
		
		Object[] params = { p, PersonUtil.getAgeWithSymbol(p),
			Imc.imcByGender(p.getWeight(), p.getHeight(), p.getGender()) };
		log.log(Level.INFO, "Info: {0}; Age: {1}; IMC = {2}", params);
		
	}
	
}
