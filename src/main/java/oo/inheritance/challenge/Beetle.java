package oo.inheritance.challenge;

public class Beetle extends Car {
	
	Beetle() {
		super(80);
	}

	@Override
	void speedUp() {
		super.speed += 7;
	}
	
}
