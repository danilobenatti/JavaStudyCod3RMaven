package beginners_level;

import org.apache.commons.lang3.math.Fraction;

public class Temperature {
	
	private static final Fraction FACTOR_F = Fraction.getFraction(9, 5);
	private static final Fraction FACTOR_C = Fraction.getFraction(5, 9);
	private static final float CONST_32 = 32.0f;
	
	public static void main(String[] args) {
		
		float degreesCelsius = 0.0f;
		float degreesFahrenheit = 0.0f;
//		
		float resultCelsius = (degreesFahrenheit - CONST_32) * FACTOR_C.floatValue();
		System.out.printf("0°F to Celsius: %.1f°C%n", resultCelsius);
		
		float resultFahrenheit = (degreesCelsius * FACTOR_F.floatValue()) + CONST_32;
		System.out.printf("0°C to Fahrenheit: %.1f°F%n", resultFahrenheit);
		
	}
	
}
