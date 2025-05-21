package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;

/**
 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 * 
 * @author danil
 * @since JDK21
 * @see
 */
public class ReduceTest3 {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ReduceTest3.class.getName(),
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
		
		Function<Student, Double> score = Student::getAverage;
		
		BiFunction<Average, Double, Average> calculeAvg = (average, value) -> {
			average.accept(value);
			return average;
		};
		
		BinaryOperator<Average> combiner = Average::combine;
		
		Average result = list.stream().filter(approved).map(score)
				.reduce(new Average(), calculeAvg, combiner);
		log.info(result::average);
	}
	
}
