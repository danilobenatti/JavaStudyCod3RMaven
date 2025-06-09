package beginners_level;

import java.io.PrintWriter;

import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.commons.math4.core.jdkmath.JdkMath;

public class ArithmeticExercise {
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		int a = 3 * 4 - 10;
		int b = (int) Math.pow(a, 3);
		int c = new Double(JdkMath.pow(a, 3)).intValue();
		int d = Double.valueOf(JdkMath.pow(a, 3)).intValue();
		int e = ((Double) JdkMath.pow(a, 3)).intValue();
		int f = (int) JdkMath.round(Math.pow(a, 3));
		double g = new Power(3).value(a);
		
		console.println(String.format("a: %d", a));
		console.println(String.format("b: %d", b));
		console.println(String.format("c: %d", c));
		console.println(String.format("d: %d", d));
		console.println(String.format("e: %d", e));
		console.println(String.format("f: %d", f));
		console.println(String.format("g: %.2f", g));
		
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(1, 2);
		Fraction sum = f1.add(f2);
		console.println("Math3 1: ".concat(sum.toString()));
		console.println("Math3 2: " + sum.getNumerator());
		console.println("Math3 3: " + sum.getDenominator());
		console.println(String.format("Math3 4: %.3f", sum.doubleValue()));
		console.println(String.format("Math3 5: %.3f", sum.percentageValue()));
		
		double p1 = JdkMath.pow((6 * (3 + 2)), 2) / (3 * 2);
		double p2 = JdkMath.pow((((1 - 5) * (2 - 7)) / 2), 2);
		double result1 = (JdkMath.pow((p1 - p2), 3)) / JdkMath.pow(10, 3);
		console.println("Solution 1: " + result1);
		
		double e1 = JdkMath.floorDiv((int) Math.pow((6 * (3 + 2)), 2), (3 * 2));
		double e2 = JdkMath.pow(JdkMath.floorDiv(((1 - 5) * (2 - 7)), 2), 2);
		double result2 = (JdkMath.pow((e1 - e2), 3)) / JdkMath.pow(10, 3);
		console.println("Solution 2: " + result2);
		
		double s1 = new Power(2).value(6.0 * (3 + 2)) / (3 * 2);
		double s2 = new Power(2).value(((1 - 5) * (2 - 7)) / 2.0);
		double result3 = new Power(3).value(s1 - s2) / 1E3;
		console.println("Solution 3: " + result3);
		
		console.close();
	}
	
}
