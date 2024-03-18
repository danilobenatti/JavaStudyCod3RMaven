package streams;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Level;
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
public class ReduceTest2 {
	
	static NumberFormat nf = NumberFormat
			.getNumberInstance(Locale.of("pt", "BR"));
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		nf.setRoundingMode(RoundingMode.HALF_EVEN);
		nf.setMaximumFractionDigits(1);
		
		Configurator.initialize(ReduceTest2.class.getName(),
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
		
		Predicate<Student> studentFemale = p -> p.getGender() == 'F';
		
		Predicate<Student> studentMale = p -> p.getGender() == 'M';
		
		Predicate<Student> approved = s -> s.getAverage() >= 7.5;
		
		Function<Student, Double> score = Student::getAverage;
		
		BinaryOperator<Double> sum = Double::sum;
		
		list.stream().filter(approved).map(score).reduce(sum)
				.ifPresent(log::info);
		
		log.info(list.stream().filter(approved).count());
		
		log.info(list.stream().filter(approved)
				.collect(Collectors.averagingDouble(Student::getAverage)));
		
		log.info(list.stream().filter(approved)
				.collect(Collectors.averagingDouble(Student::getAge)));
		
		log.printf(Level.INFO, "%s",
				list.stream().filter(s -> s.getGender() == 'F')
						.collect(Collectors.averagingDouble(Student::getAge)));
		
		log.printf(Level.INFO, "%s",
				list.stream().filter(s -> s.getGender() == 'M')
						.collect(Collectors.averagingDouble(Student::getAge)));
		
		log.printf(Level.INFO, "Average age for girls: %.2f",
				list.stream().filter(studentFemale).map(Student::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		log.printf(Level.INFO, "Average score of girls: %.2f", list.stream()
				.filter(studentFemale).map(Student::getAverage)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		log.printf(Level.INFO, "Average age for boys: %.2f",
				list.stream().filter(studentMale).map(Student::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		log.printf(Level.INFO, "Average score of boys: %.2f", list.stream()
				.filter(studentMale).map(Student::getAverage)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		Map<Character, List<String>> namesByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors
						.mapping(Student::getName, Collectors.toList())));
		namesByGender.entrySet().forEach(s -> log.info(s));
		
		Map<Character, List<String>> namesByGenderSorted = list.stream()
				.collect(groupingBy(Student::getGender,
						mapping(s -> s.getName().concat("(" + s.getAge() + ")"),
								collectingAndThen(toList(), s -> s.stream()
										.sorted().toList().reversed()))));
		namesByGenderSorted.entrySet().forEach(s -> log.info(s));
		
		Map<Character, List<Student>> mapStudy = list.stream()
				.collect(groupingBy(Student::getGender, mapping(
						s -> new Student(s.getName(), s.getGender(), s.getAge(),
								s.getAverage()),
						collectingAndThen(toList(), x -> x.stream()
								.sorted(Comparator.comparing(Student::getName)
										.thenComparing(Student::getAge)
										.reversed())
								.toList()))));
		mapStudy.entrySet().forEach(s -> log.info(s));
		
		Map<Character, Double> avgAgeByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingInt(Student::getAge)));
		avgAgeByGender.entrySet().forEach(s -> log.printf(Level.INFO, "%s=%s",
				s.getKey(), nf.format(s.getValue())));
		
		Map<Character, Double> avgScoreByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingDouble(Student::getAverage)));
		avgScoreByGender.entrySet().forEach(s -> log.printf(Level.INFO, "%s=%s",
				s.getKey(), nf.format(s.getValue())));
	}
	
}
