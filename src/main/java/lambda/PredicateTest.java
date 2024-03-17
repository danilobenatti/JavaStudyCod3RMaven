package lambda;

import java.text.NumberFormat;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Product;

public class PredicateTest {
	
	private static Logger log = LogManager.getLogger();
	
	private static NumberFormat cf = NumberFormat.getCurrencyInstance();
	
	static double price = 2500;
	
	public static void main(String[] args) {
		
		Configurator.initialize(PredicateTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Predicate<Product> isExpensive = p -> (p.getPrice()
				* (1 - p.getDiscount())) >= price;
		
		Product p = new Product();
		p.setName("Product test");
		p.setPrice(3893.89);
		p.setDiscount(0.2);
		
		log.info(p);
		log.info(() -> String.format("%s it's more expensive than %s? %s",
				cf.format(p.getPriceWithDiscount()), cf.format(price),
				isExpensive.test(p) ? "Yes" : "No"));
	}
}
