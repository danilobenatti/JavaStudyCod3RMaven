package oo.composition;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car c1 = new Car();
		System.out.println(c1.isItOn());
		
		c1.turnOn();
		System.out.println(c1.isItOn());
		
		System.out.println(c1.motor.rpm());
		
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		System.out.println(c1.motor.rpm());
		
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		System.out.println(c1.motor.rpm());
	}
	
}
