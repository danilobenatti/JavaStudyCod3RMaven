package exception;

import java.io.PrintWriter;

public class CheckedExceptionVsUncheckedException {
	
	static PrintWriter console = new PrintWriter(System.out, true);
	
	public static void main(String[] args) {
		
		try {
			generateError1();
		} catch (RuntimeException e) {
			console.println(e.getMessage());
		}
		
		generateError2();
		
		try {
			generateError3();
		} catch (Throwable e) {
			console.println(e.getMessage());
		}
		
		console.println("End!");
		
		console.close();
	}
	
	// unchecked exception
	static void generateError1() {
		throw new RuntimeException("an error occurred #1");
	}
	
	// checked exception
	static void generateError2() {
		try {
			throw new Exception("an error occurred #2");
		} catch (Exception e) {
			console.println(e.getMessage());
		}
	}
	
	static void generateError3() throws Exception {
			throw new Exception("an error occurred #3");
	}
	
}
