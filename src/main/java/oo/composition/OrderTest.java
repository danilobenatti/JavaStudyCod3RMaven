package oo.composition;

import java.io.PrintWriter;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Locale.Builder;

public class OrderTest {
	
	static Builder builder = new Locale.Builder();
	static final Locale US = builder.setLanguage("en").setRegion("US").build();
	static final Locale BR = builder.setLanguage("pt").setRegion("BR").build();
	
	static final NumberFormat NF_US = NumberFormat.getCurrencyInstance(US);
	static final NumberFormat NF_BR = NumberFormat.getCurrencyInstance(BR);
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		NF_BR.setMaximumFractionDigits(2);
		NF_BR.setRoundingMode(RoundingMode.HALF_UP);
		
		Order order = new Order();
		order.client = "Johny";
		order.addItem(new Item("Product 1", 20, 7.45));
		order.addItem("Product 2", 12, 3.89);
		order.addItem("Product 3", 3, 18.79);
		Item item = new Item("Product 4", 1, 2.2);
		order.addItems(Arrays.asList(item, new Item("Product 5", 1, 3)));
		
		console.println(order.items.size());
		console.println(NF_BR.format(order.items.get(0).getSubTotal()));
		console.println(NF_BR.format(order.getTotal()));
		console.println(NF_US.format(Order.getTotal(order.items)));
		
		console.close();
	}
	
}
