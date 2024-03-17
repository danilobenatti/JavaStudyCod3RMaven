package beginners_level;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.capitalize;

public class DotNotation {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		String str = "Hello World!";
		System.out.println(sb.append("a)").append(SPACE).append(str.length()));
		System.out.println("b) " + str.toUpperCase());
		System.out.println(format("c) %s", str.replace('!', '?')));
		System.out.println(format("d) %s", "Aloha Honua!".toLowerCase()));
		
		System.out.printf("e) %s%n", new StringBuilder().append(str).reverse());
		
		System.out.println(format("f) %s", capitalize("HELLO WORLD! x X"
			.replaceFirst("X", "everyone").toLowerCase().concat("!!!"))));
		
	}
	
}
