package streams;

import static model.Student.student;

import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Student;
import model.util.PersonUtil;
import util.ArithmeticUtil;

/**
 * https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 * 
 * @author danil
 * @since JDK21
 * @see
 */
public class ReduceTest2 {
	
	private static final NumberFormat NUMBER_FORMAT = NumberFormat
			.getNumberInstance(Locale.of("pt", "BR"));
	
	public Double add(Double x, Double y) {
		return x + y;
	}
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		NUMBER_FORMAT.setRoundingMode(RoundingMode.HALF_EVEN);
		NUMBER_FORMAT.setMaximumFractionDigits(2);
		
		Student s1 = student().id(1L).name("Bia").gender('F').score(9.5)
				.birthDate(LocalDate.now().minusYears(15)).build();
		Student s2 = student().id(2L).name("Luna").gender('F').score(9)
				.birthDate(LocalDate.now().minusYears(16)).build();
		Student s3 = student().id(3L).name("Ariel").gender('F').score(7)
				.birthDate(LocalDate.now().minusYears(13)).build();
		Student s4 = student().id(4L).name("Abel").gender('F').score(10)
				.birthDate(LocalDate.now().minusYears(14)).build();
		Student s5 = student().id(5L).name("Peter").gender('M').score(5)
				.birthDate(LocalDate.now().minusYears(15)).build();
		Student s6 = student().id(6L).name("Claus").gender('M').score(7.5)
				.birthDate(LocalDate.now().minusYears(16)).build();
		Student s7 = student().id(7L).name("Muriel").gender('M').score(6)
				.birthDate(LocalDate.now().minusYears(17)).build();
		Student s8 = student().id(8L).name("Joy").gender('M').score(10)
				.birthDate(LocalDate.now().minusYears(18)).build();
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Predicate<Student> studentFemale = p -> p.getGender() == 'F';
		
		Predicate<Student> studentMale = p -> p.getGender() == 'M';
		
		Predicate<Student> approved = s -> s.getScore() >= 7.5;
		
		Function<Student, Double> score = Student::getScore;
		
		BinaryOperator<Double> sum = Double::sum;
		
		BinaryOperator<Double> add = (x, y) -> x + y;
		
		list.stream().filter(approved).map(score).reduce(sum)
				.ifPresent(console::println);
		
		list.stream().filter(approved).map(score).reduce(add)
				.ifPresent(console::println);
		
		console.println(list.stream().filter(approved).map(score).reduce(0.0,
				(a, b) -> a + b));
		
		console.println(list.stream().filter(approved).map(score).reduce(0.0,
				ArithmeticUtil::adder));
		
		console.println(list.stream().filter(approved).count());
		
		console.println(list.stream().filter(approved)
				.collect(Collectors.averagingDouble(Student::getScore)));
		
		console.println(list.stream().filter(approved)
				.collect(Collectors.averagingDouble(PersonUtil::getAge)));
		
		console.printf("%s%n", list.stream().filter(s -> s.getGender() == 'F')
				.collect(Collectors.averagingDouble(PersonUtil::getAge)));
		
		console.printf("%s%n", list.stream().filter(s -> s.getGender() == 'M')
				.collect(Collectors.averagingDouble(PersonUtil::getAge)));
		
		console.printf("Average age for girls: %.2f%n",
				list.stream().filter(studentFemale).map(PersonUtil::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		console.printf("Average score of girls: %.2f%n", list.stream()
				.filter(studentFemale).map(Student::getScore)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		console.printf("Average age for boys: %.2f%n",
				list.stream().filter(studentMale).map(PersonUtil::getAge)
						.collect(AvgInteger::new, AvgInteger::accept,
								AvgInteger::combine)
						.average());
		
		console.printf("Average score of boys: %.2f%n", list.stream()
				.filter(studentMale).map(Student::getScore)
				.collect(AvgDouble::new, AvgDouble::accept, AvgDouble::combine)
				.average());
		
		Map<Character, List<String>> namesByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors
						.mapping(Student::getName, Collectors.toList())));
		
		namesByGender.entrySet().forEach(console::println);
		
		Map<Character, List<String>> namesByGenderSorted = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.mapping(
								s -> s.getName().concat("(" + s.getAge() + ")"),
								Collectors
										.collectingAndThen(Collectors.toList(),
												s -> s.stream().sorted()
														.toList()
														.reversed()))));
		namesByGenderSorted.entrySet().forEach(console::println);
		
		Map<Character, List<Student>> mapStudy = list.stream().collect(
				Collectors.groupingBy(Student::getGender, Collectors.mapping(
						s -> new Student(s.getId(), s.getName(), s.getGender(),
								s.getScore(), s.getBirthDate()),
						Collectors.collectingAndThen(Collectors.toList(), s -> s
								.stream()
								.sorted(Comparator.comparing(Student::getName)
										.thenComparing(Student::getAge)
										.reversed())
								.toList()))));
		
		mapStudy.entrySet().forEach(console::println);
		
		Map<Character, Double> avgAgeByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingInt(Student::getAge)));
		
		avgAgeByGender.entrySet().forEach(s -> console.printf("%s=%s%n",
				s.getKey(), NUMBER_FORMAT.format(s.getValue())));
		
		Map<Character, Double> avgScoreByGender = list.stream()
				.collect(Collectors.groupingBy(Student::getGender,
						Collectors.averagingDouble(Student::getScore)));
		
		avgScoreByGender.entrySet().forEach(s -> console.printf("%s=%s%n",
				s.getKey(), NUMBER_FORMAT.format(s.getValue())));
		
		console.close();
	}
	
}
