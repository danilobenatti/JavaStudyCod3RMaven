package oo.composition.challenge;

import static java.time.LocalDate.ofInstant;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Purchase {
	
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	
	Date date;
	
	List<Item> items = new ArrayList<>();
	
	Purchase(Date date) {
		this.date = date;
	}
	
	LocalDate getDate() {
		return ofInstant(this.date.toInstant(), ZONE_ID);
	}
	
	Year getYear() {
		return Year.of(ofInstant(this.date.toInstant(), ZONE_ID).getYear());
	}
	
	Month getMonth() {
		return ofInstant(this.date.toInstant(), ZONE_ID).getMonth();
	}
	
	void addItem(Product product, int quantity) {
		this.items.add(new Item(product, quantity));
	}
	
	void addItem(String description, double price, int quantity) {
		this.items.add(new Item(new Product(description, price), quantity));
	}
	
	void addItems(List<Item> items) {
		this.items.addAll(items);
	}
	
	double getTotal() {
		return (BigDecimal.valueOf(
				this.items.stream().mapToDouble(Item::getSubTotal).sum()))
				.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}
}
