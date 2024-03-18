package model;

import static java.text.DateFormat.FULL;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;
import static java.text.DateFormat.getDateInstance;
import static java.text.NumberFormat.getCurrencyInstance;
import static java.time.Instant.parse;
import static java.util.Date.from;
import static org.apache.commons.lang3.StringUtils.LF;

import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.CharUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ProductTest {
	
	static Logger log = LogManager.getLogger();
	
	static final Locale LOCALE = Locale.of("pt", "BR");
	static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
	
	static DateFormat df = DateFormat.getDateTimeInstance(MEDIUM, FULL, LOCALE);
	static NumberFormat nf = NumberFormat.getNumberInstance(LOCALE);
	
	static String dateFormatted(Date date) {
		return getDateInstance(SHORT, LOCALE).format(date);
	}
	
	public static void main(String[] args) {
		
		Configurator.initialize(Product.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		var p1 = new Product();
		p1.name = "Product n\u00BA 1";
		p1.price = 150.8;
		p1.weight = 1.8f;
		p1.manufactureDate = from(parse("2023-09-19T00:00:00.00-03:00"));
		p1.setCubicVolume(10.5f, 20.9f, 30.1f);
		p1.setValidity(365L); // 365 days
		p1.setDiscount(0.25);
		
		float[] sidesP2 = new float[] { 15, 15, 30 };
		var p2 = new Product("Product n\u00BA 2", 89.56, 0.25, 0, 2.5f, sidesP2,
				Date.from(parse("2023-12-01T00:00:00.00Z")), null);
		p2.setValidity(18); // 18 months
		
		Product p3 = new Product();
		p3.name = "Product n\u00BA 3";
		p3.manufactureDate = from(Instant.now().atZone(ZoneId.systemDefault())
				.minusYears(2).toInstant());
		p3.setValidity(Year.of(1)); // 1 year
		p3.setDiscount(0.25);
		
		log.info(p1);
		log.info(p2);
		log.info(p3);
		
		String msg = "{}: {}";
		log.log(Level.INFO, msg, p1.name, p1);
		log.log(Level.INFO, msg, p2.name, p2);
		log.log(Level.INFO, msg, p3.name, p3);
		
		List<Double> shoppingCart = new ArrayList<>();
		shoppingCart.add(p1.getPriceWithDiscount());
		shoppingCart.add(p2.getPriceWithDiscount(0.15));
		shoppingCart.add(p2.getPriceWithDiscount());
		shoppingCart.add(p3.getPriceWithDiscount());
		
		double total = shoppingCart.stream().mapToDouble(i -> i).sum();
		log.info("{}".concat(LF), () -> getCurrencyInstance().format(total));
		
		log.info(() -> Instant.now().atZone(ZONE_ID));
		log.info("{}".concat(LF), () -> df.format(Date.from(Instant.now())));
		
		nf.setMaximumFractionDigits(2);
		nf.setRoundingMode(RoundingMode.HALF_EVEN);
		
		log.info(() -> String.format("Volume p1: %s%c",
				nf.format(p1.getCubicVolume()), Character.valueOf('\u33A4')));
		log.info(() -> String.format("Volume p1: %.2f%s",
				p1.getCubicVolume(), CharUtils.toString('\u33A4')));
		log.info(() -> String.format("Weight p1: %.2f%s", p1.weight,
				CharUtils.toString('\u338F')));
		
		String msgFactureP1 = "Facture p1: {}";
		log.info(msgFactureP1, p1.manufactureDate.toInstant());
		log.info(msgFactureP1, p1.manufactureDate);
		log.info(msgFactureP1, () -> dateFormatted(p1.manufactureDate));
		
		String msgP1 = "Validity p1: {}";
		log.info(msgP1, p1.validityDate);
		log.info(msgP1, p1.validityDate.toInstant().atZone(ZONE_ID));
		log.info(msgP1.concat(LF), () -> dateFormatted(p1.validityDate));
		
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		
		log.info(() -> String.format("Volume p2: %s%c",
				nf.format(p2.getCubicVolume()), Character.valueOf('\u33A4')));
		log.info(() -> String.format("Volume p2: %.2f%c",
				p2.getCubicVolume(p2.sides), CharUtils.toChar('\u33A4')));
		log.info(() -> String.format("Weight p2: %.2f%c", p2.weight,
				CharUtils.toChar('\u338F')));
		
		String msgFactureP2 = "Facture p2: {}";
		log.info(msgFactureP2,
				LocalDate.ofInstant(p2.manufactureDate.toInstant(), ZONE_ID));
		log.info(msgFactureP2, p2.manufactureDate);
		log.info(msgFactureP2, () -> dateFormatted(p2.manufactureDate));
		
		String msgP2 = "Validity p2: {}";
		log.info(msgP2, p2.validityDate);
		log.info(msgP2, p2.validityDate.toInstant().atZone(ZONE_ID));
		log.info(msgP2, () -> dateFormatted(p2.validityDate));
	}
	
}
