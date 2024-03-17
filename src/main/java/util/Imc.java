package util;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.apache.commons.lang3.StringUtils.joinWith;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Class for calculating the Body Mass Index (BMI). Based on the individual's
 * weight, height and gender.
 * 
 * @author danil
 *
 */
public class Imc {
	
	static final String UNDER_WEIGHT = "under weight";
	static final String AT_IDEAL_WEIGHT = "at ideal weight";
	static final String A_LITTLE_OVERWEIGHT = "a little overweight";
	static final String OVER_IDEAL_WEIGHT = "over ideal weight";
	static final String OBESITY = "obesity";
	
	static final NumberFormat nf = NumberFormat.getInstance(Locale.ROOT);
	
	private Imc() {
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI).
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @return value Double BMI value.
	 */
	public static double calcImc(double weight, double height) {
		if (weight > 0 && height > 0) {
			RoundingMode roundingMode = RoundingMode.HALF_EVEN;
			return BigDecimal.valueOf(weight)
					.divide(BigDecimal.valueOf(height).pow(2), roundingMode)
					.setScale(1, roundingMode).doubleValue();
		}
		return 0;
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI).
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @return value Double BMI value.
	 */
	@Deprecated(forRemoval = true, since = "2024/03/03")
	public static double calcImc(float weight, float height) {
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		nf.setRoundingMode(RoundingMode.HALF_EVEN);
		double value = 0;
		if (weight > 0 && height > 0)
			value = weight / Math.pow(height, 2);
		return Float.valueOf(nf.format(value));
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI) by the
	 * individual's gender.
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @param sex    Gender of the person, male or female only.
	 * @return info BMI calculation information.
	 * @throws info NullPointException
	 * @since 1.0
	 */
	public static String imcByGender(double weight, double height, char sex) {
		return switch (sex) {
			case '\u0066', '\u0046' -> femaleImc(calcImc(weight, height));
			case '\u006D', '\u004D' -> maleImc(calcImc(weight, height));
			default -> null;
		};
	}
	
	/**
	 * Method that calculates the <b>body mass index</b> (BMI) by the
	 * individual's gender.
	 * 
	 * @param weight Person's weight in kilograms.
	 * @param height Height of the person in meters.
	 * @param sex    Gender of the person, male or female only.
	 * @return info BMI calculation information.
	 * @throws info NullPointException
	 * @since 1.0
	 */
	@Deprecated(forRemoval = true, since = "2024/03/03")
	public static String imcByGender(float weight, float height, char sex) {
		return switch (sex) {
			case '\u0066', '\u0046' -> femaleImc(calcImc(weight, height));
			case '\u006D', '\u004D' -> maleImc(calcImc(weight, height));
			default -> null;
		};
	}
	
	/**
	 * Method that returns information about the BMI calculation for females.
	 * 
	 * @param value Calculated BMI.
	 * @return info BMI calculation information for women.
	 */
	public static String femaleImc(double value) {
		String msg = null;
		value = BigDecimal.valueOf(value).setScale(1, RoundingMode.HALF_EVEN)
				.doubleValue();
		if (value < 19.1) {
			msg = joinWith(SPACE, nf.format(value), UNDER_WEIGHT);
		} else if (value > 19.2 && value < 25.8) {
			msg = joinWith(SPACE, nf.format(value), AT_IDEAL_WEIGHT);
		} else if (value > 25.9 && value < 27.3) {
			msg = joinWith(SPACE, nf.format(value), A_LITTLE_OVERWEIGHT);
		} else if (value > 27.4 && value < 32.3) {
			msg = joinWith(SPACE, nf.format(value), OVER_IDEAL_WEIGHT);
		} else {
			msg = joinWith(SPACE, nf.format(value), OBESITY);
		}
		return msg;
	}
	
	/**
	 * Method that returns information about the BMI calculation for males.
	 * 
	 * @param value Calculated BMI.
	 * @return info BMI calculation information for men.
	 */
	public static String maleImc(double value) {
		String msg = null;
		value = BigDecimal.valueOf(value).setScale(1, RoundingMode.HALF_EVEN)
				.doubleValue();
		if (value < 20.7) {
			msg = joinWith(SPACE, nf.format(value), UNDER_WEIGHT);
		} else if (value > 20.8 && value < 26.4) {
			msg = joinWith(SPACE, nf.format(value), AT_IDEAL_WEIGHT);
		} else if (value > 26.5 && value < 27.8) {
			msg = joinWith(SPACE, nf.format(value), A_LITTLE_OVERWEIGHT);
		} else if (value > 27.9 && value < 31.1) {
			msg = joinWith(SPACE, nf.format(value), OVER_IDEAL_WEIGHT);
		} else {
			msg = joinWith(SPACE, nf.format(value), OBESITY);
		}
		return msg;
	}
	
}
