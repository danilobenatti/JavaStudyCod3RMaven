package beginners_level;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class PrimitiveVsObject {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(PrimitiveVsObject.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		log.info(() -> "Text".toUpperCase());
		
		int a = 123;
		log.info(a);
		
		// Wrappers
		Byte b = 100;
		Short s = 10;
		Integer i = Integer.parseInt("1000");
		Long l = 100000L;
		Float f = 100000.5F;
		Double d = 100E205;
		Boolean e = true;
		Character c = '\u0040';
		
		log.info(b::byteValue);
		log.info(s::shortValue);
		log.info(i::intValue);
		log.info(l::longValue);
		log.info(f::floatValue);
		log.info(d::doubleValue);
		log.info(e::booleanValue);
		log.info(Boolean.parseBoolean("TRUE"));
		log.info(() -> c.charValue() + "gmail");
		log.info(() -> getUnicodeCharacterOfChar('@'));
		log.info(() -> BigDecimal.valueOf(d).toEngineeringString());
	}
	
	public static String getUnicodeCharacterOfChar(char ch) {
		return String.format("\\u%04x", (int) ch);
	}
	
}
