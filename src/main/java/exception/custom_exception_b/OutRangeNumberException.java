package exception.custom_exception_b;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class OutRangeNumberException extends Exception {
	
	private final String attribute;
	
	public OutRangeNumberException(String attribute) {
		this.attribute = attribute;
	}
	
	@Override
	public String getMessage() {
		return StringUtils.join("Attribute %s is out range number")
				.formatted(this.attribute);
	}
}
