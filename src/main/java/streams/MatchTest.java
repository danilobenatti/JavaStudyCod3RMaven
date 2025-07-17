package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import model.Student;

public class MatchTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Student s1 = new Student("Bia", 'F', 9.5);
		Student s2 = new Student("Luna", 'F', 9.0);
		Student s3 = new Student("Ariel", 'F', 7.0);
		Student s4 = new Student("Gui", 'M', 10.0);
		Student s5 = new Student("Peter", 'M', 5.0);
		Student s6 = new Student("Claus", 'M', 7.5);
		Student s7 = new Student("Ariel", 'F', 6.0);
		Student s8 = new Student("Joy", 'M', 5.0);
		
		List<Student> list = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Predicate<Student> approved = s -> s.getScore() >= 7.5;
		
		Predicate<Student> disapproved = s -> s.getScore() < 5.0;
		
		Predicate<Student> recovery = approved.and(disapproved).negate();
		
		console.println(list.stream().allMatch(approved));
		console.println(list.stream().allMatch(recovery));
		console.println(list.stream().allMatch(disapproved));
		console.println(list.stream().anyMatch(approved));
		console.println(list.stream().anyMatch(recovery));
		console.println(list.stream().anyMatch(disapproved));
		console.println(list.stream().noneMatch(approved));
		console.println(list.stream().noneMatch(recovery));
		console.println(list.stream().noneMatch(disapproved));
		
		console.close();
	}
	
}
