package oo.composition;

import java.io.PrintWriter;

public class CarTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Car c1 = new Car();
		console.println(c1.isItOn());
		
		c1.turnOn();
		console.println(c1.isItOn());
		
		console.println(c1.motor.rpm());
		
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		
		console.println(c1.motor.rpm());
		
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		c1.brake();
		
		console.println(c1.motor.rpm());
		
		console.close();
	}
	
}
