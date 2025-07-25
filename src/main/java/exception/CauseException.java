package exception;

import java.io.PrintWriter;

import model.Student;

public class CauseException {
	
	static PrintWriter console = new PrintWriter(System.out, true);
	
	public static void main(String[] args) {
		
		try {
			method_A(null);
		} catch (IllegalArgumentException e) {
			if (e.getCause() != null) {
				console.println(e.getCause().getMessage());
			}
		}
		
		method_A(null);
		
		console.close();
	}
	
	static void method_A(Student student) {
		try {
			method_B(student);
		} catch (Exception cause) {
			throw new IllegalArgumentException(cause);
		}
	}
	
	static void method_B(Student student) {
		if (student == null) {
			throw new NullPointerException("Student is null");
		}
		console.println(student.getName());
	}
	
}
