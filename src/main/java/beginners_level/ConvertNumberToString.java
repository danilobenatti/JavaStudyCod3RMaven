package beginners_level;

import java.io.PrintWriter;

public class ConvertNumberToString {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Integer num1 = 1000;
		console.println(num1.toString().length());
		
		int num2 = 1000;
		console.println(("" + num2).length());
		console.println(Integer.toString(num2).length());
		
		console.close();
	}
	
}
