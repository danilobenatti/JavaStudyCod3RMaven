package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class OthersMethodTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(OthersMethodTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		List<String> list = new ArrayList<>();
		list.add("Boo");
		list.add("Foo");
		list.add("Boo");
		list.add("Foo");
		list.add("Gel");
		list.add("Yoh");
		list.add("Bar");
		list.add("Gel");
		list.add("Bar");
		
		list.stream().forEach(l -> log.info(l));
		log.info("--- <0> ---\n");
		
		list.stream().distinct().forEach(l -> log.info(l));
		log.info("--- <1> ---\n");
		
		list.stream().distinct().skip(2).forEach(l -> log.info(l));
		log.info("--- <2> ---\n");
		
		list.stream().distinct().limit(2).skip(1).forEach(l -> log.info(l));
		log.info("--- <3> ---\n");
		
		list.stream().distinct().skip(2).limit(1).forEach(l -> log.info(l));
		log.info("--- <4> ---\n");
		
		Predicate<String> predicate = l -> l.charAt(0) != 'Y';
		list.stream().distinct().takeWhile(predicate).forEach(l -> log.info(l));
		log.info("--- <5> ---\n");
	}
	
}
