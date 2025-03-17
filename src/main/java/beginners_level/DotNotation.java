package beginners_level;

import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.capitalize;

import java.io.PrintWriter;

public class DotNotation {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		String str = "Hello World!";
		
		console.println(sb.append("a)").append(SPACE).append(str.length()));
		console.println("b) " + str.toUpperCase());
		console.println(format("c) %s", str.replace('!', '?')));
		console.println(format("d) %s", "Aloha Honua!".toLowerCase()));
		
		console.printf("e) %s%n", new StringBuilder(str).reverse());
		
		console.println(format("f) %s", capitalize("HELLO WORLD! x X"
			.replaceFirst("X", "everyone").toLowerCase().concat("!!!"))));
		
	}
	
}
