package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class ReduceTest1 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		BinaryOperator<Integer> sum = (x, n) -> x + n;
		
		DoubleBinaryOperator multi = (x, n) -> x * n;
		
		DoubleBinaryOperator div = (x, n) -> x / n;
		
		Optional<Integer> total = numbers.parallelStream().reduce(sum);
		console.println(total.isPresent() ? total.get() : 0);
		
		console.println(numbers.stream().reduce(100, sum));
		console.println(numbers.parallelStream().reduce(100, sum));
		
		numbers.stream().filter(n -> n % 2 == 0).reduce(sum)
				.ifPresent(console::println);
		
		numbers.stream().filter(n -> n % 2 != 0).reduce(sum)
				.ifPresent(console::println);
		
		numbers.stream().mapToDouble(Number::doubleValue).filter(n -> n <= 2)
				.reduce(div).ifPresent(console::println);
		
		numbers.stream().mapToDouble(Number::doubleValue).filter(n -> n >= 2)
				.reduce(multi).ifPresent(console::println);
		
		console.close();
	}
	
}
