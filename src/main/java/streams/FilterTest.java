package streams;

import static model.Student.studentBuilder;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;
import util.Imc;

public class FilterTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(FilterTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		int[] array = new int[] { 3, 2, 4, 7, 8, 6, 1, 10, 5, 0, 9 };
		
		Arrays.stream(array).filter(n -> n % 2 == 0).sorted()
				.forEach(n -> log.printf(Level.INFO, "%s", n));
		
		Arrays.stream(array).filter(n -> n % 2 != 0).sorted()
				.forEach(n -> log.printf(Level.INFO, "%s", n));
		
		Student std1 = studentBuilder().id(1).name("Joe").gender('M').weight(87)
				.height(1.84F).average(8.7).goodBehavior(true)
				.bornDate(LocalDate.of(1982, Month.JULY, 3)).build();
		Student std2 = studentBuilder().id(2).name("Ana").gender('F')
				.weight(72.6F).height(1.65F).average(9.5).goodBehavior(true)
				.bornDate(LocalDate.of(1988, Month.AUGUST, 13)).build();
		Student std3 = studentBuilder().id(3).name("Cloe").gender('F')
				.weight(65).height(1.73F).average(7.5).goodBehavior(false)
				.bornDate(LocalDate.of(2002, Month.MARCH, 5)).build();
		Student std4 = studentBuilder().id(4).name("Peter").gender('M')
				.weight(90).height(1.78F).average(8).goodBehavior(true)
				.bornDate(LocalDate.of(1978, Month.NOVEMBER, 7)).build();
		Student std5 = studentBuilder().id(5).name("Bill").gender('M')
				.weight(65.2F).height(1.58F).average(8.5).goodBehavior(false)
				.bornDate(LocalDate.of(2011, Month.OCTOBER, 21)).build();
		Student std6 = studentBuilder().id(6).name("Jacy").gender('F')
				.weight(58.5F).height(1.68F).average(9.8).goodBehavior(true)
				.bornDate(LocalDate.of(2008, Month.APRIL, 14)).build();
		
		std1.killPersonAtDate(LocalDate.of(2024, Month.MARCH, 04));
		
		Predicate<Student> atIdealWeight = p -> Imc
				.imcByGender(p.getWeight(), p.getHeight(), p.getGender())
				.contains("at ideal weight");
		
		Predicate<Student> isBehavior = Student::isGoodBehavior;
		
		Predicate<Student> avg = p -> p.getAverage() >= 7;
		
		Function<Student, String> msg = p -> StringUtils.joinWith(SPACE,
				p.getName(), "|", "Age:", p.getAgeWithSymbol(), "|", "Average:",
				p.getAverage(), "|", "BMI(IMC)",
				Imc.imcByGender(p.getWeight(), p.getHeight(), p.getGender()));
		
		Student[] stds = new Student[] { std1, std2, std3, std4, std5, std6 };
		
		Arrays.stream(stds).filter(avg).filter(isBehavior).filter(atIdealWeight)
				.map(msg).forEach(s -> log.info(s));
	}
	
}
