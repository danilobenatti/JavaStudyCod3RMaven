package lambda;

import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import model.Product;
import model.util.ProductUtil;

public class LambdaChallenger {
	
	private static final Locale LOCALE = Locale.of("pt", "BR");
	static NumberFormat cf = NumberFormat.getCurrencyInstance(LOCALE);
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		cf.setRoundingMode(RoundingMode.HALF_EVEN);
		cf.setMaximumFractionDigits(2);
		
		Product product = new Product();
		product.setName("Product 1");
		product.setPrice(3_235.89);
		product.setDiscount(0.13);
		
		Function<Product, Double> calcPrice = p -> ProductUtil.getPriceWithDiscount(p, 0.025);
		
		UnaryOperator<Double> tax = v -> v >= 2500 ? v * 1.085 : v;
		
		UnaryOperator<Double> taxShip = v -> v >= 3000 ? v + 100 : v + 50;
		
		Function<Double, String> currencyFormat = d -> cf.format(d);
		
		console.println(calcPrice.andThen(tax).andThen(taxShip)
				.andThen(currencyFormat).apply(product));
		
		console.close();
	}
	
}
