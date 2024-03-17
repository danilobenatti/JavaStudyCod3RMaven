package collection_structure;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class MessySetCode {
	
	static Logger log = LogManager.getLogger();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Configurator.initialize(MessySetCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		HashSet set = new HashSet(); // Avoid this approach.
		set.add(1.2); // double -> Double
		set.add(true); // boolean -> Boolean
		set.add("Test"); // String
		set.add(1); // int -> Integer
		set.add('X'); // char -> Character
		
		String msg = "Size of 'set': %d%n";
		log.printf(Level.INFO, msg, set.size());
		
		set.add("Test");
		set.add('x');
		
		log.printf(Level.INFO, msg, set.size());
		
		log.info(() -> "Remove 'test'? " + set.remove("test"));
		log.info(() -> "Remove 'Test'? " + set.remove("Test"));
		log.info(() -> "If contains 'x' then remove 'x'? "
				+ (set.contains('x') && set.remove('x')));
		log.info(() -> "Contains 'x'? " + set.contains('x'));
		log.info(() -> "Contains 1.2(float)? " + set.contains(1.2f));
		log.info(() -> "Contains 1.2(double)? " + set.contains(1.2));
		log.printf(Level.INFO, msg, set.size());
		
		Set numbers = new HashSet();
		numbers.add(1.1);
		numbers.add(1.2);
		numbers.add(1.3);
		
		log.info(numbers);
		log.info(set);
		
		log.info(set.addAll(numbers));
		log.info(set);
		log.info(set.retainAll(numbers)); // common values, intersection
		log.info(set);
		
		set.clear();
		log.info(set);
	}
	
}
