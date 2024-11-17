package jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class SystemGetEnvironment {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(SystemGetEnvironment.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		String url = System.getenv("url");
		String username = System.getenv("username");
		String password = System.getenv("password");
		log.info("URL: {}", url);
		log.info("Username: {}", username);
		log.info("Password: {}", password);
		
	}
	
}
