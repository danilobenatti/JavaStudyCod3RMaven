package model;

import static java.text.DateFormat.FULL;
import static java.text.DateFormat.MEDIUM;
import static java.text.DateFormat.SHORT;
import static java.text.DateFormat.getDateInstance;
import static java.text.DateFormat.getDateTimeInstance;
import static java.text.NumberFormat.getCurrencyInstance;
import static java.text.NumberFormat.getNumberInstance;
import static java.time.LocalDate.ofInstant;
import static java.util.Date.from;
import static org.apache.commons.lang3.StringUtils.join;

import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.CharUtils;

public class ProductTest {
	
	static final Locale LOCALE_BR = Locale.forLanguageTag("pt-BR");
	
	static final Locale LOCALE_US = new Locale.Builder().setLanguage("en").setRegion("US").build();
	
	static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
	
	static final char SCC = CharUtils.toChar('\u33A4'); // Unicode Character
														// 'SQUARE CM CUBED'
	static final char SKG = CharUtils.toChar('\u338F'); // Unicode Character
														// 'SQUARE KG'
	static final char CS = '\u003A' + '\u0020'; // Characters ": "
	
	static final DateFormat DTF_BR = getDateTimeInstance(MEDIUM, FULL, LOCALE_BR);
	static final DateFormat DTF_US = getDateTimeInstance(MEDIUM, FULL, LOCALE_US);
	
	static final NumberFormat NF_BR = getNumberInstance(LOCALE_BR);
	
	static String dateFormatted(Date date) {
		return getDateInstance(SHORT, LOCALE_BR).format(date);
	}
	
	static String getMessage1(Product p) {
		return String.format("Vol.: %s%c", NF_BR.format(p.getVolume()), SCC);
	}
	
	static String getMessage2(Product p) {
		return "Vol.: " + NF_BR.format(p.getVolume()) + SCC;
	}
	
	static String getMessage3(Product p) {
		return join("Vol.: ", NF_BR.format(p.getVolume()) + SCC);
	}
	
	static String getMessage4(Product p) {
		StringBuilder sb = new StringBuilder("Vol.: ")
				.append(NF_BR.format(p.getVolume(p.getSides()))).append(SCC);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		var p1 = new Product();
		p1.setName("Product n\u00BA1");
		p1.setPrice(150.8);
		p1.setWeight(1.8f);
		p1.setManufactureDate(from(Instant.parse("2023-09-19T00:00:00.00-03:00")));
		p1.setVolume(10.5f, 20.9f, 30.1f);
		p1.setValidity(365L); // 365 days
		p1.setDiscount(0.25);
		
		float[] volP2 = new float[] { 15, 15, 30 };
		var p2 = new Product("Product n\u00BA2", 89.56, 0.25, 0, 2.5f, volP2,
				Date.from(Instant.parse("2023-12-01T00:00:00.00Z")), null);
		p2.setValidity(18); // 18 months
		
		Product p3 = new Product();
		p3.setName("Product n\u00BA3");
		p3.setManufactureDate(from(Instant.now().atZone(ZoneId.systemDefault()).minusYears(2).toInstant()));
		p3.setValidity(Year.of(1)); // 1 year
		p3.setPrice(63.87);
		p3.setDiscount(0.25);
		
		List<Product> set = new ArrayList<>(Arrays.asList(p1, p2, p3));
		set.forEach(p -> join(p.getName(), CS, p));
		
		set.forEach(p -> console.println(p.getName() + ": " + getMessage1(p)));
		set.forEach(p -> console.println(p.getName() + ": " + getMessage2(p)));
		set.forEach(p -> console.println(p.getName() + ": " + getMessage3(p)));
		set.forEach(p -> console.println(p.getName() + ": " + getMessage4(p)));
		
		List<Double> shoppingCart = new ArrayList<>();
		shoppingCart.add(p1.getPriceWithDiscount());
		shoppingCart.add(p2.getPriceWithDiscount(0.15)); // 15%
		shoppingCart.add(p3.getPriceWithDiscount(0.05)); // 5%
		
		shoppingCart.forEach(p -> console.println(getCurrencyInstance().format(p)));
		
		double total = shoppingCart.stream().mapToDouble(i -> i).sum();
		console.println(join("Total: ", getCurrencyInstance().format(total)));
		
		console.println(Instant.now().atZone(ZONE_ID));
		console.println(DTF_BR.format(Date.from(Instant.now())));
		console.println(DTF_US.format(Date.from(Instant.now())));
		
		NF_BR.setMaximumFractionDigits(2);
		NF_BR.setRoundingMode(RoundingMode.HALF_EVEN);
		
		console.println(String.format("Vol. p1: %s%c", NF_BR.format(p1.getVolume()), SCC));
		console.println(String.format("Vol. p1: %.2f%s", p1.getVolume(), SCC));
		console.println(String.format("Wgt. p1: %.2f%s", p1.getWeight(), SKG));
		
		String msgFactureP1 = "Facture p1: ";
		console.println(join(msgFactureP1, p1.getManufactureDate().toInstant()));
		console.println(join(msgFactureP1, p1.getManufactureDate()));
		console.println(join(msgFactureP1, dateFormatted(p1.getManufactureDate())));
		
		String msgValidityP1 = "Validity p1: ";
		console.println(join(msgValidityP1, p1.getValidityDate()));
		console.println(join(msgValidityP1, p1.getValidityDate().toInstant().atZone(ZONE_ID)));
		console.println(join(msgValidityP1, dateFormatted(p1.getValidityDate())));
		
		NF_BR.setMaximumFractionDigits(1);
		NF_BR.setMinimumFractionDigits(1);
		
		console.println(String.format("Wgt. p2: %.2f%c", p2.getWeight(), SKG));
		
		String msgFactureP2 = "Facture p2: ";
		console.println(join(msgFactureP2, ofInstant(p2.getManufactureDate().toInstant(), ZONE_ID)));
		console.println(join(msgFactureP2, p2.getManufactureDate()));
		console.println(join(msgFactureP2, dateFormatted(p2.getManufactureDate())));
		
		String msgValidityP2 = "Validity p2: ";
		console.println(join(msgValidityP2, p2.getValidityDate()));
		console.println(join(msgValidityP2, p2.getValidityDate().toInstant().atZone(ZONE_ID)));
		console.println(join(msgValidityP2, dateFormatted(p2.getValidityDate())));
		
		console.flush();
		console.close();
		
	}
	
}
