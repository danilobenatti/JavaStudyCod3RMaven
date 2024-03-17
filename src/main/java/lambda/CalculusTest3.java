package lambda;

import java.util.function.BinaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CalculusTest3 {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CalculusTest3.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		BinaryOperator<Double> calc1 = (x, y) -> x + y;
		log.info(calc1.apply(2.0, 3.0));
		
		calc1 = (x, y) -> x * y;
		log.info(calc1.apply(2.0, 3.0));
		
		calc1 = (x, y) -> Math.pow(x * y, 2);
		log.info(calc1.apply(2.0, 3.0));
	}
}
