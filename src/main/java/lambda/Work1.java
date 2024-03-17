package lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Work1 implements Runnable {
	
	static Logger log = LogManager.getLogger();
	
	@Override
	public void run() {
		
		Configurator.initialize(Work1.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		for (int i = 0; i < 10; i++) {
			log.info("Task #01");
			try {
				Thread.sleep(500);
			} catch (Exception ex) {
				log.error(ex.getMessage());
				Thread.currentThread().interrupt();
			}
		}
	}
	
}
