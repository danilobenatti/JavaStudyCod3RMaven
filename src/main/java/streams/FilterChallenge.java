package streams;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Product;

public class FilterChallenge {
	
	static NumberFormat cf = NumberFormat.getCurrencyInstance();
	static NumberFormat pf = NumberFormat.getPercentInstance();
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(FilterTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Product p1 = new Product("Lapis", 1.99, 0.35, 0, 0.001f);
		Product p2 = new Product("Notebook", 4899.89, 0.32, 0, 2.5f);
		Product p3 = new Product("Caderno", 30, 0.45, 0, 0.85f);
		Product p4 = new Product("Impressora", 1200, 0.40, 0, 6.65f);
		Product p5 = new Product("iPad", 3100, 0.29, 0, 0.602f);
		Product p6 = new Product("Relogio", 1900, 0.12, 0, 0.17f);
		Product p7 = new Product("Monitor", 800, 0.31, 0, 7.38f);
		
		List<Product> products = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
		
		Predicate<Product> bigDiscount = p -> p.getDiscount() >= 0.3;
		
		Predicate<Product> freeShipping = p -> Double
				.compare(p.getShippingCost(), 0.0) == 0;
		
		Predicate<Product> relevantPrice = p -> p.getPriceWithDiscount() >= 500;
		
		Function<Product, String> promotion = p -> StringUtils.joinWith(", ",
				p.getName(), cf.format(p.getPrice()), "discount of",
				pf.format(p.getDiscount()), "promo price",
				cf.format(p.getPriceWithDiscount()));
		
		products.stream().filter(bigDiscount).filter(freeShipping)
				.filter(relevantPrice).map(promotion)
				.forEach(p -> log.printf(Level.INFO, "%s", p));
	}
	
}
