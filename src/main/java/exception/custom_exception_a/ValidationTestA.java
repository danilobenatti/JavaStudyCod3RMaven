package exception.custom_exception_a;

import static exception.custom_exception_a.ValidationA.validStudent;

import java.io.PrintWriter;

import org.apache.commons.math3.exception.OutOfRangeException;

import exception.custom.NegativeNumberException;
import model.Student;

public class ValidationTestA {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		try {
			validStudent(new Student("   ", 'F', 9.5));
		} catch (Exception e) {
			console.println(e.getMessage());
		}
		
		try {
			validStudent(new Student("Test", 'F', -9.5));
		} catch (Exception e) {
			console.println(e.getMessage());
		}
		
		try {
			validStudent(new Student("...", 'F', 11));
		} catch (EmptyStringException e) {
			console.println(e.getMessage());
		} catch (OutRangeNumberException e) {
			console.println(e.getMessage());
		} catch (NegativeNumberException e) {
			console.println(e.getMessage());
		} catch (OutOfRangeException e) {
			console.println(e.getMessage());
		}
		
		try {
			validStudent(new Student("Test", 'F', -11));
		} catch (EmptyStringException | OutRangeNumberException
				| NegativeNumberException | IllegalArgumentException e) {
			console.println(e.getMessage());
		}
		
		console.println("Validation it's working!");
		
		console.close();
	}
	
}
