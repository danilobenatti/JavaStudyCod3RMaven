package oo.composition;

public class Item {
	
	String product;
	
	int quantity;
	
	double price;
	
	Order order;
	
	public Item(String productName, int quantity, double price) {
		this.product = productName;
		this.quantity = quantity;
		this.price = price;
	}
	
	public double getSubTotal() {
		return this.price * this.quantity;
	}
}
