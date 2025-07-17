package util.enums;

import lombok.Getter;

@Getter
public enum ImcLevel {
	
	UNKNOWN((byte) -2, "bmi unknown"),
	UNDER_WEIGHT((byte) -1, "under weight"),
	AT_IDEAL_WEIGHT((byte) 0, "at ideal weight"),
	A_LITTLE_OVERWEIGHT((byte) 1, "a little overweight"),
	OVER_IDEAL_WEIGHT((byte) 2, "over ideal weight"),
	OBESITY((byte) 3, "obesity");
	
	private Byte code;
	private String value;
	
	ImcLevel(Byte code, String value) {
		this.code = code;
		this.value = value;
	}
	
	public static ImcLevel toEnum(Byte code) {
		if (code == null)
			return null;
		for (ImcLevel level : ImcLevel.values())
			if (code.equals(level.getCode()))
				return level;
		throw new IllegalArgumentException("Invalid code: " + code);
	}
}
