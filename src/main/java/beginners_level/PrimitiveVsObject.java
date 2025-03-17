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
		
		log.info(() -> {
			String string = "TEXT";
			return string.toUpperCase();
		});
		
		int a = 123;
		log.info(a);
		
		// Wrappers
		Byte b = 100;
		log.info("b={}", b::byteValue);
		
		Short s = 10;
		log.info("s={}", s::shortValue);
		
		Integer i = Integer.parseInt("1000");
		log.info("i={}", i::intValue);
		
		Long l = 100000L;
		log.info("l={}", l::longValue);
		
		Float f = 100000.5F;
		log.info("f={}", f::floatValue);
		
		Double d = 1000E205;
		log.info("d={}", d::doubleValue);
		log.info(() -> "d=".concat(BigDecimal.valueOf(d).toEngineeringString()));
		
		Boolean e = true;
		log.info("e={}", e::booleanValue);
		log.info(Boolean.parseBoolean("TRUE"));
		
		Character c = '\u0040'; // = @
		log.info(() -> c.charValue() + "gmail");
		
		log.info(() -> getUnicodeCharacterOfChar('@'));
	}
	
	public static String getUnicodeCharacterOfChar(char ch) {
		return String.format("\\u%04x", (int) ch);
	}
	
}
