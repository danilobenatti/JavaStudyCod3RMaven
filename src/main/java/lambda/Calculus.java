package lambda;

@FunctionalInterface
public interface Calculus {
	
	double execute(double a, double b);
	
	default String text() {
		return "Text";
	}
	
	static String other() {
		return "Other";
	}
}
