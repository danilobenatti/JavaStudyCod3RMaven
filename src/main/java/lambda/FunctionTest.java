package lambda;

import java.io.PrintWriter;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class FunctionTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		int a = 32;
		
		Function<Integer, String> isEvenOrOdd = t -> t % 2 == 0 ? "even" : "odd";
		
		console.println(isEvenOrOdd.apply(a));
		
		Function<String, String> message = v -> String.format("Num. is %s", v);
		
		UnaryOperator<String> msg = m -> String.format("Number %d is %s", a, m);
		
		console.println(isEvenOrOdd.andThen(message).apply(a));
		
		console.println(isEvenOrOdd.andThen(msg).apply(a));
		
		console.close();
	}
	
}
