package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class MapChallenge {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(MapChallenge.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		/*
		 * 1. Number to binary string. ex. 6 -> 110
		 * 2. Invert string. ex. 110 -> 011
		 * 3. Convert again to integer. ex. 011 -> 3
		 */
		
		Function<Integer, String> toBinary = Integer::toBinaryString;
		
		UnaryOperator<String> invert = n -> new StringBuilder().append(n)
				.reverse().toString();
		
		Function<String, Integer> toInteger = n -> Integer.parseInt(n, 2);
		
		log.printf(Level.INFO, "%s",
				toBinary.andThen(invert).andThen(toInteger).apply(8));
		
		numbers.stream().map(toBinary).map(invert).map(toInteger)
		.forEach(t -> log.printf(Level.INFO, "Ex1.: %s", t));
		
		numbers.stream().map(Integer::toBinaryString).map(invert).map(toInteger)
				.forEach(t -> log.printf(Level.INFO, "Ex2.: %s", t));
	}
}
