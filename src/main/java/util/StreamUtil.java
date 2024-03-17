package util;

import java.util.function.UnaryOperator;

public class StreamUtil {
	
	private StreamUtil() {
	}
	
	public static final UnaryOperator<String> upperCase = String::toUpperCase;
	
	public static final UnaryOperator<String> lowerCase = String::toLowerCase;
	
	public static final UnaryOperator<String> firstLetter = n -> String
			.valueOf(n.charAt(0));
	
	public static final UnaryOperator<String> lastLetter = n -> String
			.valueOf(n.charAt(n.length() - 1));
}
