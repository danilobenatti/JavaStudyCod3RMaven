package streams;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class ReduceTest1 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<Number> nums = Arrays.asList(1, 2.2, 3, 4, 5.5, 6, 7, 8, 9.9, 10);
		
		BinaryOperator<Number> sum = (a, b) -> {
			MathContext mc = new MathContext(5, RoundingMode.HALF_EVEN);
			return BigDecimal.valueOf(a.doubleValue())
					.add(BigDecimal.valueOf(b.doubleValue()), mc);
		};
		
		DoubleBinaryOperator multi = (a, b) -> a * b;
		
		DoubleBinaryOperator div = (a, b) -> a / b;
		
		Optional<Number> total = nums.parallelStream().reduce(sum);
		console.println("Sum: " + (total.isPresent() ? total.get() : 0));
		
		Number add1 = nums.parallelStream().reduce(sum).get();
		console.println("Add1: " + add1);
		
		Number add2 = nums.stream().reduce(1000, sum);
		console.println("Add2: " + add2);
		
		
		nums.stream().filter(n -> n.intValue() % 2 == 0).reduce(sum)
				.ifPresent(console::println);
		
		nums.stream().filter(n -> n.intValue() % 2 != 0).reduce(sum)
				.ifPresent(console::println);
		
		nums.stream().mapToDouble(Number::doubleValue).filter(n -> n <= 3)
				.reduce(div).ifPresent(console::println);
		
		nums.stream().mapToDouble(Number::doubleValue).filter(n -> n > 3 && n < 10)
				.reduce(multi).ifPresent(console::println);
		
		console.close();
	}
	
}
