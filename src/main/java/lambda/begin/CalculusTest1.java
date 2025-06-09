package lambda.begin;

import java.io.PrintWriter;

public class CalculusTest1 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Calculus sum = new Sum();
		console.println(sum.execute(2, 3));
		
		Calculus multiply = new Multiply();
		console.println(multiply.execute(2, 3));
		
		console.close();
	}
	
}
