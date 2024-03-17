package lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CalculusTest1 {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CalculusTest1.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Calculus calc1 = new Sum();
		Calculus calc2 = new Multiply();
		
		log.info(calc1.execute(2, 3));
		log.info(calc2.execute(2, 3));
	}
	
}
