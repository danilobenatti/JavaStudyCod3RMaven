package beginners_level;

import java.io.PrintWriter;

public class Attribution {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		int a = 3;
		int b = a;
		int c = a + b;
		
		c += b; // c = c + b;
		c -= a; // c = c - a;
		c *= b; // c = c * b;
		c /= a; // c = c / 3;
		console.println(c);

		c %= 2; // c = c % 2;
		console.println(c);
	}
	
}
