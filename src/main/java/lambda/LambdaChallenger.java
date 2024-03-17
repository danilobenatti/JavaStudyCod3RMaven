package lambda;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Product;

public class LambdaChallenger {
	
	private static final Locale IN_LOCALE = Locale.of("pt", "BR");
	static NumberFormat cf = NumberFormat.getCurrencyInstance(IN_LOCALE);
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(LambdaChallenger.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		cf.setRoundingMode(RoundingMode.HALF_EVEN);
		cf.setMaximumFractionDigits(2);
		
		Product product = new Product();
		product.setName("iPad");
		product.setPrice(3235.89);
		product.setDiscount(0.13);
		
		Function<Product, Double> calcPrice = Product::getPriceWithDiscount;
		
		UnaryOperator<Double> tax = p -> p >= 2500 ? p * 1.085 : p;
		
		UnaryOperator<Double> taxShip = p -> p >= 3000 ? p + 100 : p + 50;
		
		Function<Double, String> currencyFormat = d -> cf.format(d);
		
		log.info(() -> calcPrice.andThen(tax).andThen(taxShip)
				.andThen(currencyFormat).apply(product));
	}
}
