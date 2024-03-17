package collection_structure;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Product;

public class ArrayListCode {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ArrayListCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		List<Product> products = new ArrayList<>();
		
		Product p1 = new Product("Product Test 1", 10.5, 5.0f, 0,
				new float[] { 5, 4, 3 }, Date.from(Instant.now()), null);
		p1.setValidity(365L);
		
		Date manufactured2YearAgo = Date.from(LocalDate.now().minusYears(2)
				.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		Product p2 = new Product("Product Test 2", 15.5, 7.5f, 0,
				new float[] { 7, 8, 9 }, manufactured2YearAgo, null);
		p2.setValidity(24);
		
		Product p3 = new Product("Product Test 3", 15.5, 7.5f, 0,
				new float[] { 9, 5, 2 }, manufactured2YearAgo, null);
		p3.setValidity(Year.of(1));
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		log.info(products.contains(p1));
		log.info(products.get(0));
		log.info(products.get(1));
		log.info(products.get(2));
		
		log.info(products.remove(p1));
		
		for (Product product : products) {
			log.printf(Level.INFO, "%s", product);
		}
		log.printf(Level.INFO, "%n%s", products.remove(0));
		
	}
	
}
