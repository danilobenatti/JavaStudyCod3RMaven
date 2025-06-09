package lambda;

import java.io.PrintWriter;
import java.util.function.IntUnaryOperator;

public class UnaryOperatorTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		IntUnaryOperator plusTwo = n -> Math.addExact(n, 2);
		
		IntUnaryOperator multiByTwo = n -> Math.multiplyExact(n, 2);
		
		IntUnaryOperator powMath = n -> (int) Math.round(Math.pow(n, 2.2));
		
		console.println(plusTwo.applyAsInt(1));
		console.println(multiByTwo.applyAsInt(3));
		console.println(powMath.applyAsInt(3));
		console.println(plusTwo.andThen(multiByTwo).andThen(powMath).applyAsInt(4));
		console.println(powMath.compose(multiByTwo).compose(plusTwo).applyAsInt(4));
		
		console.close();
	}
	
}
