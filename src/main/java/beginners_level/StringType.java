package beginners_level;

import static java.text.NumberFormat.getCurrencyInstance;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StringType {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(StringType.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		String str = "Hello".concat(SPACE).concat("world") + "!";
		log.info(str);
		log.info(str.charAt(11));
		log.info(str.indexOf("!"));
		log.info(str.charAt(str.length() - 1));
		log.info(str.contains("w"));
		log.info(str.toLowerCase().startsWith("hell"));
		log.info(str.endsWith(String.valueOf('\u0021'))); // '!'
		log.info(str.equalsIgnoreCase("Hello World!"));
		
		var txt = "Values by locale";
		var num = 10.0;
		log.info(() -> StringUtils.join(txt).concat(SPACE)
				.concat(String.format(Locale.getDefault(), "%.3f", num)));
		
		Locale localeBR = new Locale.Builder().setLanguage("pt").setRegion("BR")
				.build();
		
		NumberFormat cfBR = getCurrencyInstance(localeBR);
		NumberFormat cfUS = getCurrencyInstance(Locale.of("en", "US"));
		
		log.info(() -> StringUtils.join(txt).concat(SPACE)
				.concat(String.format("%s", cfBR.format(num))));
		
		log.info(() -> StringUtils.join(txt).concat(SPACE)
				.concat(String.format("%s", cfUS.format(num))));
		
		log.info(() -> StringUtils.join(txt).concat(SPACE)
				.concat(String.format(Locale.US, "%.2f", num)));
	}
	
}
