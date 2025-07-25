package exception;

import java.io.PrintWriter;

import org.apache.commons.lang3.math.NumberUtils;

import model.Student;

public class BasicExceptionTest {
	
	static PrintWriter console = new PrintWriter(System.out, true);
	
	public static void main(String[] args) {
		
		Student student = null;
		
		try {
			printNameOfStudent(student);
		} catch (Exception ex) {
			console.println("Error: when printing student: " + ex.getMessage());
		}
		
		try {
			console.println(7 / NumberUtils.INTEGER_ZERO);
		} catch (ArithmeticException ex) {
			console.println("Error: division by zero: " + ex.getMessage());
		}
		
		console.println(String.format("%s", "End! ").repeat(5));
		
		console.close();
	}
	
	public static void printNameOfStudent(Student student) {
		console.println("Name of student: " + student.getName());
	}
	
}
