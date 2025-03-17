package beginners_level;

import org.apache.commons.math3.analysis.function.Power;
import org.apache.commons.math3.fraction.Fraction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ArithmeticExercise {
	
	static Logger log = LogManager.getLogger();
	
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		
		Configurator.initialize(ArithmeticExercise.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		int a = 3 * 4 - 10;
		int b = (int) Math.pow(a, 3);
		int c = new Double(Math.pow(a, 3)).intValue();
		int d = Double.valueOf(Math.pow(a, 3)).intValue();
		int e = ((Double) Math.pow(a, 3)).intValue();
		int f = (int) Math.round(Math.pow(a, 3));
		double g = new Power(3).value(a);
		
		log.info(() -> String.format("a: %d", a));
		log.info(() -> String.format("b: %d", b));
		log.info(() -> String.format("c: %d", c));
		log.info(() -> String.format("d: %d", d));
		log.info(() -> String.format("e: %d", e));
		log.info(() -> String.format("f: %d", f));
		log.info(() -> String.format("g: %.2f", g));
		
		Fraction f1 = new Fraction(1, 3);
		Fraction f2 = new Fraction(1, 2);
		Fraction sum = f1.add(f2);
		log.info(() -> "Math3 1: ".concat(sum.toString()));
		log.info(() -> "Math3 2: " + sum.getNumerator());
		log.info(() -> "Math3 3: " + sum.getDenominator());
		log.info(() -> String.format("Math3 4: %.3f", sum.doubleValue()));
		log.info(() -> String.format("Math3 5: %.3f", sum.percentageValue()));
		
		double p1 = Math.pow((6 * (3 + 2)), 2) / (3 * 2);
		double p2 = Math.pow((((1 - 5) * (2 - 7)) / 2), 2);
		double result1 = (Math.pow((p1 - p2), 3)) / Math.pow(10, 3);
		log.info("Solution 1: {}", result1);
		
		double e1 = Math.floorDiv((int) Math.pow((6 * (3 + 2)), 2), (3 * 2));
		double e2 = Math.pow(Math.floorDiv(((1 - 5) * (2 - 7)), 2), 2);
		double result2 = (Math.pow((e1 - e2), 3)) / Math.pow(10, 3);
		log.info("Solution 2: {}", result2);
		
		double s1 = new Power(2).value(6.0 * (3 + 2)) / (3 * 2);
		double s2 = new Power(2).value(((1 - 5) * (2 - 7)) / 2.0);
		double result3 = new Power(3).value(s1 - s2) / 1E3;
		log.info("Solution 3: {}", result3);
		
	}
	
}
