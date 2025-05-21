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
	
	private Date date;
	
	List<Item> items = new ArrayList<>();
	
	public Purchase(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	LocalDate getPurchaseDate() {
		return ofInstant(getDate().toInstant(), ZONE_ID);
	}
	
	Year getPurchaseYear() {
		return Year.of(ofInstant(getDate().toInstant(), ZONE_ID).getYear());
	}
	
	Month getPurchaseMonth() {
		return ofInstant(getDate().toInstant(), ZONE_ID).getMonth();
	}
	
	void addItem(Product product, int quantity) {
		getItems().add(new Item(product, quantity));
	}
	
	void addItem(String description, double price, int quantity) {
		Product product = new Product(description, price);
		getItems().add(new Item(product, quantity));
	}
	
	void addItems(List<Item> items) {
		getItems().addAll(items);
	}
	
	double getTotal() {
		return (BigDecimal.valueOf(
				getItems().stream().mapToDouble(Item::getSubTotal).sum()))
				.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}
}
