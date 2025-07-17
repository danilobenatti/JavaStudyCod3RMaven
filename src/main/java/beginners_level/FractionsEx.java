package beginners_level;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.Fraction;

public class FractionsEx {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		StringBuilder builder = new StringBuilder();
		
		BigDecimal n1 = BigDecimal.valueOf(7.73);
		BigDecimal n2 = BigDecimal.valueOf(3.1);
		
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
		BigDecimal divisor = BigDecimal.valueOf(denominator);
		
		MathContext mc = new MathContext(2, RoundingMode.HALF_EVEN);
		
		BigDecimal[] divideAndRemainder = num.divideAndRemainder(divisor, mc);
		
		long quotient = divideAndRemainder[0].longValueExact();
		long remainder = divideAndRemainder[1].longValueExact();
		
		builder.append(StringUtils.join("\nQuotient: ", quotient));
		builder.append(StringUtils.join("\nRemainder: ", remainder));
		
		builder.append(StringUtils.join("\nReduced form: "));
		if (quotient != 0)
			builder.append(StringUtils.join(quotient, " "));
		builder.append(StringUtils.join(remainder, " / ", divisor));
		
		console.println(builder);
		
		BigFraction f2 = BigFraction.getReducedFraction(numerator, denominator);
		BigFraction f3 = new BigFraction(numerator, denominator);
		
		console.println(f2);
		console.println(f2.percentageValue());
		console.println(f2.getNumerator());
		console.println(f2.getDenominator());
		
		console.println(f3);
		console.println(f3.percentageValue());
		console.println(f3.getNumerator());
		console.println(f3.getDenominator());
		
		console.close();
	}
	
}
