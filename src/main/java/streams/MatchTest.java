package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;

public class MatchTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(MatchTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Student s1 = new Student("Bia", 'F', 9.5);
		Student s2 = new Student("Luna", 'F', 9.0);
		Student s3 = new Student("Ariel", 'F', 7.0);
		Student s4 = new Student("Gui", 'M', 10.0);
		Student s5 = new Student("Peter", 'M', 5.0);
		Student s6 = new Student("Claus", 'M', 7.5);
		Student s7 = new Student("Ariel", 'F', 6.0);
		Student s8 = new Student("Joy", 'M', 10.0);
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Predicate<Student> approved = s -> s.getAverage() >= 7.5;
		
		Predicate<Student> disapproved = approved.negate();
		
		log.info(list.stream().allMatch(approved));
		log.info(list.stream().allMatch(disapproved));
		log.info(list.stream().anyMatch(approved));
		log.info(list.stream().anyMatch(disapproved));
		log.info(list.stream().noneMatch(approved));
		log.info(list.stream().noneMatch(disapproved));
		
	}
	
}
