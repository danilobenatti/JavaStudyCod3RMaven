package util;

import java.util.function.BinaryOperator;

public class ArithmeticUtil {
	
	public static double adder(double x, double y) {
		return x + y;
	}
	
	public static final BinaryOperator<Double> adder = (x, y) -> x + y;
	
}
