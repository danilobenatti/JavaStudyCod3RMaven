package control_structure;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Customer;
import model.Employed;
import model.Person;

public class StructureSwitch {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(StructureSwitch.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Employed e1 = new Employed();
		e1.setName("John");
		Customer c1 = new Customer();
		c1.setName("Peter");
		
		log.printf(Level.INFO, whoIs(e1));
		log.printf(Level.INFO, whoIs(c1));
	}
	
	private static String whoIs(Person person) {
		return switch (person) {
			case Employed e -> new StringBuilder().append("Is Employed: ")
				.append(e.getName()).toString();
			case Customer c -> new StringBuilder().append("Is Customer: ")
				.append(c.getName()).toString();
			default -> "Unknown";
		};
	}
	
}
