package oo.inheritance.challenge;

public class Ferrari extends Car implements SportsCar {
	
	Ferrari() {
		this(315);
	}
	
	Ferrari(int speedMax) {
		super(speedMax);
		setDelta(15);
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
	
	@Override
	public void turboUp() {
		setDelta(35);
	}
	
	@Override
	public void turboDown() {
		setDelta(15);
	}
	
}
