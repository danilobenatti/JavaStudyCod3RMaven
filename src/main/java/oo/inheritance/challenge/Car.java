package oo.inheritance.challenge;

public class Car {
	
	private int delta = 5;
	
	final int speedMax;
	
	int speed;
	
	Car(int speed) {
		speedMax = speed;
	}
	
	void speedUp() {
		if (this.speed + delta > speedMax) {
			this.speed = speedMax;
		} else {
			this.speed += delta;
		}
	}
	
	void speedDown() {
		if (this.speed >= delta) {
			this.speed -= delta;
		} else {
			this.speed = 0;
		}
		
	}
	
	public int getDelta() {
		return delta;
	}
	
	public void setDelta(int delta) {
		this.delta = delta;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(this.getClass().getSimpleName())
				.append(", speed = ").append(this.speed).toString();
	}
}
