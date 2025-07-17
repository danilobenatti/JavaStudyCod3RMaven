package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.StringUtils;

public class MapChallenge {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		/*
		 * 1. Number to binary string. ex. 6 -> 110
		 * 2. Invert string. ex. 110 -> 011
		 * 3. Convert again to integer. ex. 011 -> 3
		 */
		
		Function<Integer, String> toBinary = Integer::toBinaryString;
		
		UnaryOperator<String> invert = s -> new StringBuilder(s).reverse().toString();
		
		Function<String, Integer> toInteger = s -> Integer.parseInt(s, 2);
		
		console.println(StringUtils.center("1ºEx", 10, '*'));
		numbers.stream().map(toBinary).forEach(console::println);
		
		console.println(StringUtils.center("2ºEx", 10, '*'));
		numbers.stream().map(toBinary).map(invert).forEach(console::println);
		
		console.println(StringUtils.center("3ºEx", 10, '*'));
		console.println(String.format("Result: %d", toBinary.andThen(invert).andThen(toInteger).apply(8)));
		
		console.println(StringUtils.center("4ºEx", 10, '*'));
		numbers.stream().map(toBinary).map(invert).map(toInteger)
				.forEach(t -> console.print(String.format("%d\s", t)));
		
		console.println();
		
		console.println(StringUtils.center("5ºEx", 10, '*'));
		numbers.stream().map(Integer::toBinaryString).map(invert).map(toInteger)
				.forEach(t -> console.print(String.format("%d\s", t)));
		
		console.close();
	}
}
