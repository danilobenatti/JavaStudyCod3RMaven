package oo.composition.challenge;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ShopTest {
	
	private static final Locale PT_BR = Locale.of("pt", "BR");
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	private static final Locale LOCALE_DEFAULT = Locale.getDefault();
	static NumberFormat nf = NumberFormat.getCurrencyInstance();
	static DateFormat df_local = DateFormat.getDateInstance(DateFormat.FULL, LOCALE_DEFAULT);
	static DateFormat df_ptBR = DateFormat.getDateInstance(DateFormat.FULL, PT_BR);
	
	public static void main(String[] args) {
		
		df_local.setTimeZone(TimeZone.getTimeZone(ZONE_ID));
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		SimpleDateFormat sdf = new SimpleDateFormat("d-MMMM-yyyy", LOCALE_DEFAULT);
		
		DateFormat df = SimpleDateFormat.getDateInstance(SimpleDateFormat.LONG, LOCALE_DEFAULT);
		
		LocalDate localDate1 = LocalDate.of(2023, 10, 1);
		Date date1 = Date.from(localDate1.atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase1 = new Purchase(date1);
		Item item1 = new Item(new Product("Product1 Test", 5.6), 2);
		Item item2 = new Item(new Product("Product2 Test", 2.1), 1);
		purchase1.addItems(Arrays.asList(item1, item2));
		
		LocalDate localDate2 = LocalDate.of(2023, 11, 5);
		Date date2 = Date.from(localDate2.atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase2 = new Purchase(date2);
		purchase2.addItem(new Product("Product3 Test", 10.9), 1);
		purchase2.addItem("Product4 Test", 7.8, 2);
		
		LocalDate localDate3 = LocalDate.of(2023, 11, 25);
		Date date3 = Date.from(localDate3.atStartOfDay(ZONE_ID).toInstant());
		Purchase purchase3 = new Purchase(date3);
		purchase3.addItem("Product5 Test", 3.12, 2);
		
		Client c1 = new Client("Client 1");
		c1.addPurchases(Arrays.asList(purchase1, purchase2, purchase3));
		
		console.println(sdf.format(purchase1.getDate()));
		console.println(df.format(purchase1.getDate()));
		console.println(df_local.format(purchase2.getDate()));
		console.println(df_ptBR.format(purchase3.getDate()));
		
		console.println(nf.format(c1.getTotal()));
		
		console.println(c1.getTotalByDate());
		console.println(c1.getTotalByYearAndMonth());
		
		console.println(c1.getTotalByYearMonth(Year.of(2023), Month.NOVEMBER));
		console.println(c1.getTotalByYearMonth(Year.of(2023), Month.OCTOBER));
		
		double total = c1.getTotalByYearAndMonth(Year.of(2023), Month.OCTOBER);
		console.println(nf.format(total));
		
		nf.setCurrency(Currency.getInstance(Locale.US));
		console.println(nf.format(total));
		
		console.close();
	}
}
