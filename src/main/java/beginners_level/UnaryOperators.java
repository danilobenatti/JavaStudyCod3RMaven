package beginners_level;

import java.io.PrintWriter;

public class UnaryOperators {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		int a = 1;
		int b = 2;
		
		a++; // a = a + 1
		a--; // a = a - 1
		
		++b; // b = b + 1
		--b; // b = b - 1
		
		console.println(a);
		console.println(b);
		
		console.println("Chalenge");
		console.println(++a == b--); // 2 - 2
		console.println(a == b); // 2 - 1
		console.println(a);
		console.println(b);
		
		console.close();
		
	}
	
}
