package exception.custom;

@SuppressWarnings("serial")
public class NegativeNumberException extends RuntimeException {
	
	private final String attribute;
	
	public NegativeNumberException(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String getMessage() {
		return String.format("Attribute '%s' is negative", this.attribute);
	}
}
