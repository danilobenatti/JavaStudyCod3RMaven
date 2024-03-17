package control_structure;

import static java.math.RoundingMode.HALF_EVEN;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StructureIfElse {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(StructureIfElse.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Builder builder = new Locale.Builder();
		Locale localeUS = builder.setRegion("en").setLanguage("US").build();
		
		BigDecimal value;
		
		try (Scanner sc = new Scanner(System.in).useLocale(localeUS)) {
			log.info("Inform final note: ");
			value = sc.nextBigDecimal().setScale(1, HALF_EVEN).abs()
					.stripTrailingZeros();
		}
		
		log.info(value);
		
		log.info(() -> message1(value));
		
		log.info(() -> message2(value));
		
	}
	
	private static String message1(BigDecimal value) {
		
		boolean approved = value.compareTo(BigDecimal.valueOf(7)) >= 0;
		boolean recovery = !approved
				&& value.compareTo(BigDecimal.valueOf(4.9)) >= 0;
		boolean lessEqualsThanTEN = value.compareTo(BigDecimal.TEN) <= 0;
		boolean greaterEqualsZERO = value.compareTo(BigDecimal.ZERO) >= 0;
		boolean intoRange = lessEqualsThanTEN && greaterEqualsZERO;
		
		if (!intoRange) {
			return "The value must be: greater or equal to ZERO and less or equal to TEN";
		} else if (approved) {
			return "Approved";
		} else if (recovery) {
			return "Recovery";
		} else {
			return "Disapproved";
		}
	}
	
	private static String message2(BigDecimal value) {
		
		boolean a = value.compareTo(BigDecimal.valueOf(9.0)) >= 0;
		boolean b = !a && value.compareTo(BigDecimal.valueOf(7.5)) >= 0;
		boolean c = !b && value.compareTo(BigDecimal.valueOf(5.0)) >= 0;
		boolean d = !c && value.compareTo(BigDecimal.valueOf(3.7)) >= 0;
		boolean e = value.compareTo(BigDecimal.valueOf(3.7)) < 0;
		boolean intoRange = value.compareTo(BigDecimal.TEN) <= 0
				&& value.compareTo(BigDecimal.ZERO) >= 0;
		
		if (!intoRange) {
			return "The value must be: greater or equal to ZERO and less or equal to TEN";
		} else if (a) {
			return "Approved: A";
		} else if (b) {
			return "Approved: B";
		} else if (c) {
			return "Approved: C";
		} else if (d) {
			return "Recovery: D";
		} else if (e) {
			return "Disapproved: E";
		} else {
			return "---";
		}
	}
	
}
