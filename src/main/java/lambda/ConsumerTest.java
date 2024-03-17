package lambda;

import static java.text.NumberFormat.getCurrencyInstance;
import static java.text.NumberFormat.getPercentInstance;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Product;

public class ConsumerTest {
	
	private static Logger log = LogManager.getLogger();
	
	private static NumberFormat cf = getCurrencyInstance(Locale.of("en", "US"));
	private static NumberFormat pf = getPercentInstance(Locale.of("en", "US"));
	
	public static void main(String[] args) {
		
		Configurator.initialize(ConsumerTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		cf.setRoundingMode(RoundingMode.HALF_EVEN);
		pf.setRoundingMode(RoundingMode.HALF_EVEN);
		pf.setMaximumFractionDigits(1);
		
		Consumer<Product> showmeProductPrice = p -> log.info(() -> msg(p));
		
		Product p1 = new Product();
		p1.setName("Product Test1");
		p1.setPrice(10.5);
		
		Product p2 = new Product();
		p2.setName("Product Test2");
		p2.setPrice(8.5);
		
		List<Product> products = Arrays.asList(p1, p2);
		
		showmeProductPrice.accept(p1);
		
		products.forEach(showmeProductPrice);
	}
	
	static String msg(Product product) {
		return StringUtils.joinWith(StringUtils.SPACE, product.getName(),
				"price", cf.format(product.getPrice()), "with",
				pf.format(product.getDiscount()), "off =",
				cf.format(product.getPriceWithDiscount()));
	}
}
