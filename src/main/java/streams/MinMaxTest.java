package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;

public class MinMaxTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(MatchTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Student s1 = new Student("Bia", 'F', 16, 9.5);
		Student s2 = new Student("Luna", 'F', 18, 9.0);
		Student s3 = new Student("Ariel", 'F', 18, 7.0);
		Student s4 = new Student("Gui", 'M', 17, 10.0);
		Student s5 = new Student("Peter", 'M', 16, 5.0);
		Student s6 = new Student("Claus", 'M', 18, 7.5);
		Student s7 = new Student("Ariel", 'F', 16, 6.0);
		Student s8 = new Student("Joy", 'M', 17, 10.0);
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Comparator<Student> bestScore = (c1, c2) -> {
			if (c1.getAverage() > c2.getAverage())
				return 1;
			if (c1.getAverage() < c2.getAverage())
				return -1;
			return 0;
		};
		
		Comparator<Student> worstScore = (c1, c2) -> {
			if (c1.getAverage() > c2.getAverage())
				return -1;
			if (c1.getAverage() < c2.getAverage())
				return 1;
			return 0;
		};
		
		list.stream().max(bestScore).ifPresent(log::info);
		list.stream().max(worstScore).ifPresent(log::info);
		list.stream().max(bestScore.reversed()).ifPresent(log::info);
		list.stream().max(worstScore.reversed()).ifPresent(log::info);
		list.stream().min(bestScore).ifPresent(log::info);
		list.stream().min(worstScore).ifPresent(log::info);
		list.stream().min(bestScore.reversed()).ifPresent(log::info);
		list.stream().min(worstScore.reversed()).ifPresent(log::info);
	}
	
}
