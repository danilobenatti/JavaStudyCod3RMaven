package lambda;

import static java.text.NumberFormat.getCurrencyInstance;
import static java.text.NumberFormat.getPercentInstance;

import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import org.apache.commons.lang3.StringUtils;

import model.Product;

public class ConsumerTest {
	
	private static NumberFormat cf = getCurrencyInstance(Locale.of("pt", "BR"));
	private static NumberFormat pf = getPercentInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		cf.setRoundingMode(RoundingMode.HALF_EVEN);
		pf.setRoundingMode(RoundingMode.HALF_EVEN);
		pf.setMaximumFractionDigits(1);
		
		Consumer<Product> infoProductPrice = p -> console.println(message(p));
		
		Product p1 = new Product();
		p1.setName("Product Test1");
		p1.setPrice(10.5);
		
		Product p2 = new Product();
		p2.setName("Product Test2");
		p2.setPrice(8.5);
		p2.setDiscount(0.0558);
		
		List<Product> products = Arrays.asList(p1, p2);
		
		infoProductPrice.accept(p1);
		
		products.forEach(infoProductPrice);
		
		console.close();
	}
	
	static String message(Product product) {
		return StringUtils.joinWith(StringUtils.SPACE, product.getName(),
				"price", cf.format(product.getPrice()), "with",
				pf.format(product.getDiscount()), "off =",
				cf.format(product.getPriceWithDiscount()));
	}
}
