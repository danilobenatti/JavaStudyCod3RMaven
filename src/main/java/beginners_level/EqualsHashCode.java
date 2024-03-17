package beginners_level;

import static model.Customer.customer;

import java.time.LocalDate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Customer;

public class EqualsHashCode {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(EqualsHashCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		var c1 = customer().id(1).name("John W.").email("john@mail.com")
				.bornDate(LocalDate.now().minusYears(47))
				.deathDate(LocalDate.now()).build();
		
		var c2 = c1;
		c2.setName("John Wick");
		c2.setEmail("jhon99@mail.com");
		c2.setGoodPayer(false);
		
		var c3 = new Customer();
		c3.setId(1);
		c3.setName("Jhon Wick");
		c3.setEmail("jhon@email.com");
		
		log.printf(Level.INFO, "1) %s", c1);
		log.printf(Level.INFO, "2) %s", c2);
		log.printf(Level.INFO, "3) %s", c3);
		
		log.printf(Level.INFO, "c1 == c2? %s", c1 == c2);
		log.printf(Level.INFO, "c1 equals c2? %s", c1.equals(c2));
		
		log.printf(Level.INFO, "c3 == c1? %s", c3 == c1);
		log.printf(Level.INFO, "c3 equals c1? %s", c3.equals(c1));
		
		log.printf(Level.INFO, "c3 == c2? %s", c3 == c2);
		log.printf(Level.INFO, "c3 equals c2? %s", c3.equals(c2));
	}
	
}
