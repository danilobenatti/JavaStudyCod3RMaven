package exception.custom_exception_b;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class EmptyStringException extends Exception {
	
	private final String attributeName;
	
	public EmptyStringException(String attributeName) {
		this.attributeName = attributeName;
	}
	
	@Override
	public String getMessage() {
		return StringUtils.join("Attribute '%s' is empty")
				.formatted(this.attributeName);
	}
}
