package util;

import java.util.Locale;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.StringUtils;

public class StreamUtil {
	
	private StreamUtil() {
	}
	
	public static final UnaryOperator<String> upperCase = String::toUpperCase;
	
	public static final UnaryOperator<String> upperCase_ = s -> StringUtils.upperCase(s, Locale.getDefault());
	
	public static final UnaryOperator<String> lowerCase = String::toLowerCase;
	
	public static final UnaryOperator<String> lowerCase_ = s -> StringUtils.lowerCase(s, Locale.getDefault());
	
	public static final UnaryOperator<String> firstLetter = s -> String.valueOf(s.charAt(0));
	
	public static final UnaryOperator<String> firstLetter_ = s -> StringUtils.substring(s, 0, 1);
	
	public static final UnaryOperator<String> lastLetter = s -> String.valueOf(s.charAt(s.length() - 1));
	
	public static final UnaryOperator<String> lastLetter_ = s -> StringUtils.substring(s, s.length() - 1);
	
	public static final String addExclamationMark(String s) {
		return s + "!!!";
	}
}
