package oo.polymorphism;

public class CircleForm implements GeometricFigure {
	
	@Override
	public double calculeteArea(double... ds) {
		double radius = ds[0];
		return Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public double calculetePerimeter(double... ds) {
		double radius = ds[0];
		return 2 * Math.PI * radius;
	}
	
	@Override
	public double calculeteVolume(double... ds) {
		double radius = ds[0];
		double height = ds[1];
		return calculeteArea(radius) * height;
	}
	
}
