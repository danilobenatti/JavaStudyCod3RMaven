package beginners_level;

import static util.Imc.imcByGender;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Person;

public class UseConsole {
	
	static Logger log = Logger.getLogger(UseConsole.class.getName());
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
			log.info("Inform name[Ex. Mary]: ");
			p.setName(scanner.next());
			log.info("Inform gender(M/F)[Ex. F]: ");
			p.setGender(Character.toUpperCase(scanner.next().charAt(0)));
			log.info("Inform height[Ex. 1.65]: ");
			p.setHeight(Float.parseFloat(scanner.next().replace(',', '.')));
			log.info("Inform weight[Ex. 68.7}]: ");
			p.setWeight(Float.parseFloat(scanner.next().replace(',', '.')));
			p.setBornDate(LocalDate.now().minusYears(27));
			p.setDeathDate(LocalDate.now());
		}
		
		Object[] params = { p, p.getAgeWithSymbol(),
			imcByGender(p.getWeight(), p.getHeight(), p.getGender()) };
		log.log(Level.INFO, "Info: {0}; Age: {1}; IMC = {2}", params);
		
	}
	
}
