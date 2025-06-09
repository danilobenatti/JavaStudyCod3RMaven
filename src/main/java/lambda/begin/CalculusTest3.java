package lambda.begin;

import java.io.PrintWriter;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;

public class CalculusTest3 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		BinaryOperator<Double> calcule = (x, y) -> x + y;
		
		DoubleBinaryOperator calc = (x, y) -> x + y;
		
		console.println(calcule.apply(2.0, 3.0));
		console.println(calc.applyAsDouble(2.0, 3.0));
		
		calcule = (x, y) -> x * y;
		calc = (x, y) -> x * y;
		console.println(calcule.apply(2.0, 3.0));
		console.println(calc.applyAsDouble(2.0, 3.0));
		
		calcule = (x, y) -> Math.pow(x * y, 2);
		calc = (x, y) -> Math.pow(x * y, 2);
		console.println(calcule.apply(2.0, 3.0));
		console.println(calc.applyAsDouble(2.0, 3.0));
		
		console.close();
	}
}
