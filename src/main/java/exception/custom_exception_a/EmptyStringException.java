package exception.custom_exception_a;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class EmptyStringException extends RuntimeException {
	
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
