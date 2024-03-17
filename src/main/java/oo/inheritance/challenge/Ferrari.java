package oo.inheritance.challenge;

public class Ferrari extends Car {
	
	public Ferrari() {
		this(315);
	}
	
	Ferrari(int speedMax) {
		super(speedMax);
		delta = 15;
	}
	
	@Override
	void speedUp() {
		super.speed += 20;
	}
	
	@Override
	void speedDown() {
		if (super.speed >= 22) {
			super.speed -= 22;
		} else {
			super.speed = 0;
		}
	}
}
