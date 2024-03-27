package oo.composition.challenge;

import static java.text.DateFormat.getDateInstance;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ShopTest {
	
	static Logger log = LogManager.getLogger();
	
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	private static final Locale LOCALE = Locale.getDefault();
	static NumberFormat nf = NumberFormat.getCurrencyInstance();
	static DateFormat df = getDateInstance(DateFormat.FULL, LOCALE);
	
	public static void main(String[] args) {
		
		Configurator.initialize(ShopTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy", LOCALE);
		
		Date date1 = Date.from(
				LocalDate.of(2023, 10, 1).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase1 = new Purchase(date1);
		Item item1 = new Item(new Product("Product1 Test", 5.6), 2);
		Item item2 = new Item(new Product("Product2 Test", 2.1), 1);
		purchase1.addItems(Arrays.asList(item1, item2));
		
		Date date2 = Date.from(
				LocalDate.of(2023, 11, 5).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase2 = new Purchase(date2);
		purchase2.addItem(new Product("Product3 Test", 10.9), 1);
		purchase2.addItem("Product4 Test", 7.8, 2);
		
		Date date3 = Date.from(
				LocalDate.of(2023, 11, 25).atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase3 = new Purchase(date3);
		purchase3.addItem("Product5 Test", 3.12, 2);
		
		Client cli1 = new Client("Client 1");
		cli1.addPurchases(Arrays.asList(purchase1, purchase2, purchase3));
		
		log.info(() -> sdf.format(purchase1.date));
		log.info(() -> df.format(purchase2.date));
		log.info(() -> df.format(purchase3.date));
		
		log.info(() -> nf.format(cli1.getTotal()));
		
		log.info(cli1.getTotalByDate());
		log.info(cli1.getTotalByYearAndMonth());
		
		log.info(cli1.getTotalByYearMonth(Year.of(2023), Month.NOVEMBER));
		log.info(() -> nf.format(
				cli1.getTotalByYearAndMonth(Year.of(2023), Month.OCTOBER)));
	}
}
