package lambda;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.commons.math4.core.jdkmath.JdkMath;

import model.Product;
import model.util.ProductUtil;

public class LambdaChallenger2 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		/**
		 * 1. Calculate the real price (with discount) from the product
		 * 2. Municipal Tax: >= 2500(8.5%) / < 2500(Exempt)
		 * 3. Shipping: >= 3000(R$ 100.00) / < 3000(R$ 50.00)
		 * 4. Round: Leave two decimal places
		 * 5. Format: R$ 1,234.58
		 */
		
		Function<Product, Double> price = p -> ProductUtil.getPriceWithDiscount(p, 0.025);
		
		UnaryOperator<Double> tax = v -> v >= 2_500 ? v * 1.085 : v;
		
		UnaryOperator<Double> ship = v -> v >= 3_000 ? v + 100 : v + 50;
		
		UnaryOperator<Double> round1 = v -> (double) JdkMath.round(v * 100) / 100;
		
		UnaryOperator<Double> round2 = v -> rounder(v, 3);
		
		Function<Double, String> formatUS = v -> fomatter(v, Locale.US);
		
		Function<Double, String> formatBR = v -> fomatter(v, Locale.of("pt", "BR"));
		
		Product product = new Product("Product 1", 3_235.89, 0.13, 0.0, 0.0f);
		
		String result1 = price.andThen(tax).andThen(ship).andThen(round1)
				.andThen(formatUS).apply(product);
		console.println("Result 1: " + result1);
		
		String result2 = price.andThen(tax).andThen(ship).andThen(round2)
				.andThen(formatBR).apply(product);
		console.println("Result 2: " + result2);
		
		console.close();
	}
	
	private static String fomatter(Double value, Locale locale) {
		NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
		formatter.setRoundingMode(RoundingMode.HALF_EVEN);
		formatter.setMinimumFractionDigits(2);
		return formatter.format(value);
	}
	
	private static Double rounder(Double value, int scale) {
		return BigDecimal.valueOf(value).setScale(scale, RoundingMode.HALF_EVEN).doubleValue();
	}
	
}
