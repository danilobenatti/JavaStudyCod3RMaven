package oo.composition;

public class Motor {
	
	Car car;
	
	boolean start = false;
	
	double injectionFactor = 1;
	
	Motor(Car car) {
		this.car = car;
	}
	
	int rpm() {
		return !start ? 0 : (int) Math.round(injectionFactor * 3000);
	}
}
