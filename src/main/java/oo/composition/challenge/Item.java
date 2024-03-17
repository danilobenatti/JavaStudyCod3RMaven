package oo.composition.challenge;

public class Item {
	
	Product product;
	
	int quantity;
	
	Item(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	double getSubTotal() {
		return this.product.price * this.quantity;
	}
}
