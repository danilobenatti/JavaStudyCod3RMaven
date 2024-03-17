package oo.composition;

public class Car {
	
	Motor motor;
	
	Car() {
		this.motor = new Motor(this);
	}
	
	void speedUp() {
		if (motor.injectionFactor < 2.5)
			motor.injectionFactor += 0.4;
	}
	
	void brake() {
		if (motor.injectionFactor > 0.5)
			motor.injectionFactor -= 0.4;
	}
	
	void turnOn() {
		motor.start = true;
	}
	
	void turnOff() {
		motor.start = false;
	}
	
	boolean isItOn() {
		return motor.start;
	}
}
