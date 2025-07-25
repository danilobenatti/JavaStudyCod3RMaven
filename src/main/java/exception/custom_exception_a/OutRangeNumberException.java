package exception.custom_exception_a;

@SuppressWarnings("serial")
public class OutRangeNumberException extends RuntimeException {
	
	private final String attribute;
	
	public OutRangeNumberException(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String getMessage() {
		return String.format("Attribute '%s' is out of range", this.attribute);
	}
}
