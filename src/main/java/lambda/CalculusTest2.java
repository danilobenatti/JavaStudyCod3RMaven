package lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CalculusTest2 {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CalculusTest2.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Calculus calc1 = (x, y) -> x + y;
		Calculus calc2 = (x, y) -> x * y;
		
		log.info(calc1.execute(2, 3));
		log.info(calc2.execute(2, 3));
		
		log.info(calc1::text);
		log.info(Calculus::other);
	}
}
