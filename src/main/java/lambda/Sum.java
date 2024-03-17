package lambda;

public class Sum implements Calculus {
	
	@Override
	public double execute(double a, double b) {
		return a + b;
	}
	
}
