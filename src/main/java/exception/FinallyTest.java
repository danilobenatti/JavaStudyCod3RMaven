package exception;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

public class FinallyTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		try (Scanner scanner = new Scanner(System.in,
				Charset.forName("UTF-8"))) {
			console.println(7 / scanner.nextInt());
		} catch (ArithmeticException e) {
			console.println("Error: " + e.getMessage());
		} finally {
			console.println("Finally clause!");
		}
		
		console.close();
	}
	
}
