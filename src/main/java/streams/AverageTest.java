package streams;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class AverageTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(AverageTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Average avg1 = new Average();
		avg1.accept(8.3);
		avg1.accept(6.7);
		
		Average avg2 = new Average();
		avg2.accept(8.5);
		avg2.accept(7.0);
		
		log.info(avg1.average());
		log.info(avg2.average());
		
		log.info(Average.combine(avg1, avg2).average());
		
	}
	
}
