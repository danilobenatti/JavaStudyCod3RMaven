package generics;

import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ComparableTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ComparableTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		TreeSet<Integer> numbers = new TreeSet<>();
		
		numbers.add(10);
		numbers.add(1);
		numbers.add(3);
		numbers.add(6);
		numbers.add(8);
		numbers.add(9);
		numbers.add(123);
		numbers.add(-13);
		
		for (Integer integer : numbers) {
			log.info(integer);
		}
		
	}
	
}
