package beginners_level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ArithmeticOperators {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ArithmeticOperators.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		log.info(2 + 3);
		
		var x = 34.56;
		double y = 2.2;
		
		log.info(x + y);
		log.info(x - y);
		log.info(x * y);
		log.info(x / y);
		log.info(x % y);
		
		int a = 8;
		int b = 3;
		
		log.info(a + b);
		log.info(a - b);
		log.info(a * b);
		log.info(a / b);
		log.info(a / (float) b);
		log.info(a / (double) b);
		log.info(a % b);
		
		// (34.56 + 2.2) - ((8 x 3) ÷ 2.2)
		log.info(x + y - a * b / y);
	}
	
}
