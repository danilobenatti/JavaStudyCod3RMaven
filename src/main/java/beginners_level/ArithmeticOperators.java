package beginners_level;

import java.io.PrintWriter;

public class ArithmeticOperators {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		console.println(2 + 3);
		
		var x = 34.56;
		double y = 2.2;
		
		console.println(x + y);
		console.println(x - y);
		console.println(x * y);
		console.println(x / y);
		console.println(x % y);
		
		int a = 8;
		int b = 3;
		
		console.println(a + b);
		console.println(a - b);
		console.println(a * b);
		console.println(a / b);
		console.println(a / (float) b);
		console.println(a / (double) b);
		console.println(a % b);
		
		// (34.56 + 2.2) - ((8 x 3) ÷ 2.2)
		console.println(x + y - a * b / y);
		
		console.close();
	}
	
}
