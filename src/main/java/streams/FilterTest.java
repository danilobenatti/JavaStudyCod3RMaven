package streams;

import static model.Student.student;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

import model.Student;
import model.util.PersonUtil;
import util.Imc;

public class FilterTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		int[] array = new int[] { 3, 2, 4, 7, 8, 6, 1, 10, 5, 0, 9 };
		
		Arrays.stream(array).filter(n -> n % 2 == 0).sorted()
				.forEach(n -> console.printf("%s%n", n));
		
		Arrays.stream(array).filter(n -> n % 2 != 0).sorted()
				.forEach(n -> console.printf("%s%n", n));
		
		Student s1 = student().id(1L).name("Joe").gender('M').weight(87)
				.height(1.84F).average(8.7).goodBehavior(true)
				.birthDate(LocalDate.of(1982, Month.JULY, 3)).build();
//		s1.killPersonAtDate(LocalDate.of(2024, Month.MARCH, 04));
		PersonUtil.personDiedIn(s1, LocalDate.of(2024, Month.MARCH, 04));
		
		Student s2 = student().id(2L).name("Ana").gender('F').weight(72.6F)
				.height(1.65F).average(9.5).goodBehavior(true)
				.birthDate(LocalDate.of(1988, Month.AUGUST, 13)).build();
		
		Student s3 = student().id(3L).name("Cloe").gender('F').weight(65)
				.height(1.73F).average(7.5).goodBehavior(false)
				.birthDate(LocalDate.of(2002, Month.MARCH, 5)).build();
		
		Student s4 = student().id(4L).name("Peter").gender('M').weight(90)
				.height(1.78F).average(8).goodBehavior(true)
				.birthDate(LocalDate.of(1978, Month.NOVEMBER, 7)).build();
		
		Student s5 = student().id(5L).name("Bill").gender('M').weight(65.2F)
				.height(1.58F).average(8.5).goodBehavior(false)
				.birthDate(LocalDate.of(2011, Month.OCTOBER, 21)).build();
		
		Student s6 = student().id(6L).name("Jacy").gender('F').weight(58.5F)
				.height(1.68F).average(9.8).goodBehavior(true)
				.birthDate(LocalDate.of(2008, Month.APRIL, 14)).build();
		
		Student[] students = new Student[] { s1, s2, s3, s4, s5, s6 };
		
		Predicate<Student> atIdealWeight = s -> Imc
				.imcByGender(s.getWeight(), s.getHeight(), s.getGender())
				.contains(Imc.AT_IDEAL_WEIGHT);
		
		Predicate<Student> isBehavior = Student::isGoodBehavior;
		
		Predicate<Student> avg = s -> s.getAverage() >= 7;
		
		Predicate<Student> isAlive = s -> PersonUtil.isAlive(s);
		
		Function<Student, String> msg = s -> StringUtils.joinWith(SPACE,
				s.getName(), "|", "Age:", PersonUtil.getAgeWithSymbol(s), "|",
				"Average:", s.getAverage(), "|", "BMI(IMC)",
				Imc.imcByGender(s));
		
		console.println();
		
		Arrays.stream(students).forEach(console::println);
		
		console.println();
		
		Arrays.stream(students).filter(avg).filter(isBehavior).filter(isAlive)
				.filter(atIdealWeight).map(msg).forEach(console::println);
		
		console.close();
	}
	
}
