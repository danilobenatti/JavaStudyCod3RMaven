package lambda;

import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import org.apache.commons.lang3.StringUtils;

public class BinaryOperatorTest {
	
	static double value1 = 9.8;
	static double value2 = 5.7;
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		BinaryOperator<Double> avg = (n1, n2) -> (n1 + n2) / 2;
		
		BiFunction<Double, Double, String> result = (n1,
				n2) -> avg.apply(n1, n2) >= 7.5 ? "Approved" : "Repproved";
		
		Function<Double, String> msg = v -> v >= 7.5 ? "Approved" : "Repproved";
		
		console.println(StringUtils.joinWith(StringUtils.SPACE, "Average 1:",
				avg.apply(value1, value2), result.apply(value1, value2)));
		
		value2 = 4.7;
		
		console.println(new StringBuilder().append("Average 2: ")
				.append(avg.apply(value1, value2)).append(StringUtils.SPACE)
				.append(result.apply(value1, value2)));
		
		value1 = 10;
		value2 = 5;
		
		console.println(new StringJoiner(" ").add("Average 3:")
				.add(String.valueOf(avg.apply(value1, value2)))
				.add(result.apply(value1, value2)).toString());
		
		console.println("Average 4: " + avg.andThen(msg).apply(value1, value2));
		
		console.close();
	}
}
