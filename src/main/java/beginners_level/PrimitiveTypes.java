package beginners_level;

import java.io.PrintWriter;

public class PrimitiveTypes {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		/**
		 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
		 * 1byte = 8bit
		 */
		
		// Integer numeric types
		byte age = 98; // -128...127 (8bit)
		console.println("age=" + age);
		
		short number = 32767; // -32768...32767 (16bit)
		console.println("number=" + number);
		
		int id = 56789; // -2147483648...2147483647 (32bit)
		console.println("id=" + id);
		
		long points = 3_234_845_223L; // -9223372036854775808...9223372036854775807 (64bit)
		console.println("points=" + points);
		
		// Real numeric types with floating point
		float salary = 11_445.44F; // 32-bit IEEE 754
		console.println("salary=" + salary);
		
		double distance = 2_991_797_103.01; // 64-bit IEEE 754
		console.println("distance=" + distance);
		
		// Boolean type
		boolean isAlive = true; // true or false
		console.println("isAlive=" + isAlive);
		
		// Character type
		char status = 'A'; // 16-bit Unicode.
		console.println("status=" + status);
		char symbol = '\u00A7'; // §
		console.println("symbol=" + symbol);
		/**
		 * It has a minimum value of '\u0000' (or 0) and a maximum value of
		 * '\uffff' (or 65,535 inclusive).
		 */
	}
	
}
