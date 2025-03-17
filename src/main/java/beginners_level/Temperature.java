package beginners_level;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

import org.apache.commons.lang3.math.Fraction;

public class Temperature {
	
	private static final Fraction FACTOR_F = Fraction.getFraction(9, 5);
	private static final Fraction FACTOR_C = Fraction.getFraction(5, 9);
	private static final float CONST_32 = 32.0f;
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		NumberFormat nf = NumberFormat
				.getCompactNumberInstance(Locale.of("pt", "BR"), Style.SHORT);
		
		float degreesCelsius = 0.0f;
		float degreesFahrenheit = 0.0f;
//		
		float celsius = (degreesFahrenheit - CONST_32) * FACTOR_C.floatValue();
		console.println(celsius);
		console.printf("0\u00B0F to Celsius \u007e %s\u00B0C%n", nf.format(celsius));
		
		float fahrenheit = (degreesCelsius * FACTOR_F.floatValue()) + CONST_32;
		console.println(fahrenheit);
		console.printf("0\u00B0C to Fahrenheit \u007e %s\u00B0F%n", nf.format(fahrenheit));
		
	}
	
}
