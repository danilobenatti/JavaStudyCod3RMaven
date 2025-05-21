package oo.inheritance.challenge;

import java.io.PrintWriter;

public class CarTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Beetle beetle = new Beetle();
		
		do {
			beetle.speedUp();
			console.printf("Up: %s%n", beetle);
		} while (beetle.speed < 80);
		
		do {
			beetle.speedDown();
			console.printf("Down: %s%n", beetle);
		} while (beetle.speed > 0);
		
		Ferrari ferrari = new Ferrari(400);
		ferrari.turboUp();
		
		do {
			ferrari.speedUp();
			console.printf("Up: %s%n", ferrari);
		} while (ferrari.speed < 100);
		
		ferrari.turboDown();
		do {
			ferrari.speedDown();
			console.printf("Down: %s%n", ferrari);
		} while (ferrari.speed > 0);
		
		console.close();
	}
	
}
