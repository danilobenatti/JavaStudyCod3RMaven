package oo.composition;

import static oo.composition.Student.totalHours;

import java.io.PrintWriter;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;

public class CourseTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		TimeZone timeZone = TimeZone.getTimeZone("America/Sao_Paulo");
		Locale locale = Locale.of("pt", "BR");
		Calendar calendar = Calendar.getInstance(timeZone, locale);
		
		calendar.set(1947, 11, 10);
		Student s1 = new Student("Jane", Date.from(calendar.toInstant()), null);
		s1.setDateOfDeath(Date.from(Instant.parse("2020-11-03T00:00:00Z")));
		
		calendar.set(1988, 8, 24);
		Student s2 = new Student("Mary", Date.from(calendar.toInstant()), null);
		
		calendar.set(1982, 3, 7);
		Student s3 = new Student("Paul", Date.from(calendar.toInstant()), null);
		s3.studentDeathNow();
		
		calendar.set(1950, 1, 5);
		Student s4 = new Student("Lacy", Date.from(calendar.toInstant()), null);
		
		Course course1 = new Course("Nature science", 50);
		Course course2 = new Course("Financial Mathematics", 60);
		Course course3 = new Course("Portuguese Language", 75);
		
		course1.addStudent(s1);
		
		List<Student> group = new ArrayList<>(Arrays.asList(s1, s2, s3));
		course2.addStudents(group);
		
		course3.addStudents(new ArrayList<>(Arrays.asList(s2, s3, s4)));
		
		console.println("\nCourse 1: " + course1.getDescription());
		course1.listStudents().stream().forEach(console::println);
		console.println("\nCourse 2: " + course2.getDescription());
		course2.listStudents().stream().forEach(console::println);
		console.println("\nCourse 3: " + course3.getDescription());
		course3.listStudents().stream().forEach(s -> console.println(s.toString("format2")));
		
		console.println();
		
		console.println(String.format("%s(%s) - %d", s1.name,
				s1.ageWithSymbol(), totalHours(s1)));
		
		console.println(new StringBuilder().append(s2.name)
				.append(String.format("(%s)", s2.ageWithSymbol())).append(" - ")
				.append(totalHours(s2)));
		
		console.println(StringUtils.joinWith(" - ",
				String.format("%s(%s)", s3.name, s3.ageWithSymbol()),
				totalHours(s3)));
		
		StringJoiner joiner = new StringJoiner("");
		joiner.add(s4.name).add("(" + s4.ageWithSymbol() + ") - ");
		joiner.add(String.valueOf(totalHours(s4)));
		console.println(joiner);
		
		console.close();
	}
	
}
