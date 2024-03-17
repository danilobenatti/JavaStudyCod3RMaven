package lambda;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class FunctionTest {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(FunctionTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		long n = 31;
		
		Function<Long, String> isEven = t -> t % 2 == 0 ? "even" : "odd";
		
		UnaryOperator<String> msg = m -> String.format("Number %d is %s", n, m);
		
		log.info(() -> isEven.andThen(msg).apply(n));
	}
}
