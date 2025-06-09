package lambda;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.function.Predicate;

import model.Product;

public class PredicateTest {
	
	private static NumberFormat cf = NumberFormat.getCurrencyInstance();
	
	static double price = 3_115.11;
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Predicate<Product> isExpensive = p -> p.getPriceWithDiscount() > price;
		
		Product product = new Product();
		product.setName("Product test");
		product.setPrice(3893.89);
		product.setDiscount(0.2);
		
		console.println(product);
		console.println(product.getPrice());
		console.println(product.getPriceWithDiscount());
		console.println(product.getPriceWithDiscount(0.05));
		console.println(cf.format(product.getPriceWithDiscount()));
		
		console.println(String.format("%n%s it's more expensive than %s? %s",
				cf.format(product.getPriceWithDiscount()), cf.format(price),
				isExpensive.test(product) ? "Yes" : "No"));
		
		console.close();
	}
	
}
