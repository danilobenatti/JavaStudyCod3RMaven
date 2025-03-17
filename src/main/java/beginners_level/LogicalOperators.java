package beginners_level;

import java.io.PrintWriter;

public class LogicalOperators {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		boolean a = 3 < 7; // true
		boolean b = 3 > 7; // false
		
		console.println(String.format("Ex.: AND -> %s", a && b)); // AND
		console.println(String.format("Ex.: OR -> %s", a || b)); // OR
		console.println(String.format("Ex.: XOR -> %s", a ^ !b)); // XOR
		console.println(a);
		console.println(!b);
		
		console.flush();
		console.close();
	}
	
}
