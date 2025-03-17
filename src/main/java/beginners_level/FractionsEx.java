package beginners_level;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.fraction.Fraction;

public class FractionsEx {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		StringBuilder builder = new StringBuilder();
		
		BigDecimal n1 = BigDecimal.valueOf(8);
		BigDecimal n2 = BigDecimal.valueOf(3);
		
		BigDecimal number = n1.divide(n2, 10, RoundingMode.HALF_EVEN).negate();
		builder.append(number);
		
		Fraction fraction = new Fraction(number.doubleValue());
		builder.append(StringUtils.join("\nFraction: ", fraction));
		
		int numerator = fraction.getNumerator();
		builder.append(StringUtils.join("\nNumerator: ", numerator));
		
		int denominator = fraction.getDenominator();
		builder.append(StringUtils.join("\nDenominator: ", denominator));
		
		Fraction reducedFraction = Fraction.getReducedFraction(
				fraction.getNumerator(), fraction.getDenominator());
		builder.append(StringUtils.join("\nReduced: ", reducedFraction));
		
		BigDecimal num = BigDecimal.valueOf(numerator);
		BigDecimal den = BigDecimal.valueOf(denominator);
		
		BigDecimal[] divideAndRemainder = num.divideAndRemainder(den,
				MathContext.DECIMAL32);
		long quotient = divideAndRemainder[0].longValueExact();
		long remainder = divideAndRemainder[1].longValueExact();
		
		builder.append(StringUtils.join("\nQuotient: ", quotient));
		builder.append(StringUtils.join("\nRemainder: ", remainder));
		
		builder.append(StringUtils.join("\nReduced form: "));
		if (quotient != 0)
			builder.append(quotient).append(StringUtils.SPACE);
		builder.append(StringUtils.join(remainder, " / ", den));
		
		console.println(builder);
		
	}
	
}
