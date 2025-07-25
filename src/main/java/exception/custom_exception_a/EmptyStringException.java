package exception.custom_exception_a;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class EmptyStringException extends RuntimeException {
	
	private final String attribute;
	
	public EmptyStringException(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String getMessage() {
		return StringUtils.join("Attribute '%s' is empty")
				.formatted(this.attribute);
	}
}
