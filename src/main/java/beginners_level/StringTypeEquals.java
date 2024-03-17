package beginners_level;

import java.util.Scanner;

public class StringTypeEquals {
	
	public static void main(String[] args) {
		
		System.out.println("2" == "2");
		
		String str = new String("2");
		
		System.out.println("2" == str);
		System.out.println("2".equals(str));
		
		String value;
		try (Scanner scanner = new Scanner(System.in)) {
//			value = scanner.nextLine();
			value = scanner.next();
		}
		System.out.println(value.getClass().getSimpleName());
		System.out.println("2" == value.trim());
//		System.out.println("2".equals(value.trim()));
		System.out.println("2".equals(value));
	}
	
}
