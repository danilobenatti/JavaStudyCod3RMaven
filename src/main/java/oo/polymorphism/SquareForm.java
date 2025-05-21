package oo.polymorphism;

public class SquareForm implements GeometricFigure {

	@Override
	public double calculeteArea(double... ds) {
		double l = ds[0];
		return Math.pow(l, 2);
	}

	@Override
	public double calculetePerimeter(double... ds) {
		double l = ds[0];
		return 4 * l;
	}

	@Override
	public double calculeteVolume(double... ds) {
		double l = ds[0];
		double h  = ds[1];
		return calculeteArea(l) * h;
	}
	
}
