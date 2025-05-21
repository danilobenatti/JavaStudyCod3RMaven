package oo.composition;

public class Motor {
	
	final Car car;
	
	boolean start = false;
	
	double injectionFactor = 1;
	
	Motor(Car car) {
		this.car = car;
	}
	
	int rpm() {
		return start ? (int) Math.round(injectionFactor * 3000) : 0;
	}
}
