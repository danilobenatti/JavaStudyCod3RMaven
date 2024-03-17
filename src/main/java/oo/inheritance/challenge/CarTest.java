package oo.inheritance.challenge;

public class CarTest {
	
	public static void main(String[] args) {
		
		Car beetle = new Beetle();
		beetle.speed = 0;
		
		do {
			beetle.speedUp();
			System.out.println("Up: " + beetle);
		} while (beetle.speed < 80);
		
		do {
			beetle.speedDown();
			System.out.println("Down: " + beetle);
		} while (beetle.speed > 0);
		
		Car ferrari = new Ferrari(400);
		ferrari.speed = 0;
		
		do {
			ferrari.speedUp();
			System.out.println("Up: " + ferrari);
		} while (ferrari.speed < 100);
		
		do {
			ferrari.speedDown();
			System.out.println("Down: " + ferrari);
		} while (ferrari.speed > 0);
	}
}
