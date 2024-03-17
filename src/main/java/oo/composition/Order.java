package oo.composition;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	String client;
	
	ArrayList<Item> items = new ArrayList<>();
	
	public void addItem(Item item) {
		this.items.add(item);
		item.order = this;
	}
	
	public void addItem(String product, int quantity, double price) {
		this.addItem(new Item(product, quantity, price));
	}
	
	public void addItems(List<Item> items) {
		this.items.addAll(items);
		items.forEach(i -> i.order = this);
	}
	
	public double getTotal() {
		return this.items.stream().mapToDouble(Item::getSubTotal).sum();
	}
	
	public static double getTotal(List<Item> items) {
		return items.stream().mapToDouble(Item::getSubTotal).sum();
	}
}
