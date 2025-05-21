package oo.polymorphism;

import java.io.PrintWriter;

public class CalculateForm {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		CircleForm circle = new CircleForm();
		
		double radius = 5;
		double area1 = circle.calculeteArea(radius);
		double perimeter1 = circle.calculetePerimeter(radius);
		double volume1 = circle.calculeteVolume(radius, 10); // height 10
		
		console.println(area1);
		console.println(perimeter1);
		console.println(volume1);
		
		SquareForm square = new SquareForm();
		
		double l = 5.5;
		double h = 10.5;
		double area2 = square.calculeteArea(l);
		double perimeter2 = square.calculetePerimeter(l);
		double volume2 = square.calculeteVolume(l, h);
		
		console.println(area2);
		console.println(perimeter2);
		console.println(volume2);
		
	}
	
}
