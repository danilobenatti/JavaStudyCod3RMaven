package exception.custom_exception_a;

import org.apache.commons.lang3.StringUtils;

@SuppressWarnings("serial")
public class OutRangeNumberException extends RuntimeException {
	
	private final String attributeName;
	
	public OutRangeNumberException(String attributeName) {
		this.attributeName = attributeName;
	}
	
	@Override
	public String getMessage() {
		return StringUtils.join("Attribute %s is out range number")
				.formatted(this.attributeName);
	}
}
