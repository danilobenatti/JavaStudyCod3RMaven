package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

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
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Student s1 = new Student("Bia", 'F', 9.5);
		Student s2 = new Student("Luna", 'F', 9.0);
		Student s3 = new Student("Ariel", 'F', 7.0);
		Student s4 = new Student("Gui", 'M', 10.0);
		Student s5 = new Student("Peter", 'M', 5.0);
		Student s6 = new Student("Claus", 'M', 7.5);
		Student s7 = new Student("Ariel", 'F', 10.0);
		Student s8 = new Student("Joy", 'M', 6.0);
		
		List<Student> students = Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8);
		
		Predicate<Student> approved = s -> s.getScore() >= 7.5;
		
		Function<Student, Double> score = Student::getScore;
		
		BiFunction<Average, Double, Average> calcAvg1 = (avg, value) -> {
			avg.accept(value);
			return avg;
		};
		
		BinaryOperator<Average> combinerAvg1 = (x, y) -> Average.combiner(x, y); 
		
		Average avg1 = students.stream().filter(approved).map(score)
				.reduce(new Average(), calcAvg1, combinerAvg1);
		
		console.println(avg1.getValue());
		
		BiFunction<Average, Double, Average> calcAvg2 = (avg, value) -> avg.add(value);
		
		BinaryOperator<Average> combinerAvg2 = Average::combiner;
		
		Average avg2 = students.stream().filter(approved).map(score)
				.reduce(new Average(), calcAvg2, combinerAvg2);
		
		console.println(avg2.getValue());
		
		console.close();
	}
	
}
