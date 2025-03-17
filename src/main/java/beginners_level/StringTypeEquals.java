package beginners_level;

import java.io.PrintWriter;
import java.util.Scanner;

public class StringTypeEquals {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		console.println("2" == "2");
		
		String str = new String("2");
		
		console.println("2" == str);
		console.println("2".equals(str));
		
		String value;
		try (Scanner scanner = new Scanner(System.in)) {
//			value = scanner.nextLine();
			value = scanner.next();
		}
		console.println(value.getClass().getSimpleName());
		console.println("2" == value.trim());
//		console.println("2".equals(value.trim()));
		console.println("2".equals(value));
		
		console.flush();
		console.close();
	}
	
}
