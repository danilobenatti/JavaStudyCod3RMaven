package jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class SystemGetProperties {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(SystemGetProperties.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		String osArch = System.getProperty("os.arch");
		String osName = System.getProperty("os.name");
		String osVersion = System.getProperty("os.version");
		String fileSep = System.getProperty("file.separator");
		String userTimezone = System.getProperty("user.timezone");
		String userCountryFormat = System.getProperty("user.country.format");
		String userCountry = System.getProperty("user.country");
		String userHome = System.getProperty("user.home");
		String userLanguage = System.getProperty("user.language");
		 
		log.info("operating system name: {}", osName);
		log.info("operating system arch: {}", osArch);
		log.info("Operation System version: {}", osVersion);
		log.info("file separator: {}", fileSep);
		log.info("User Timezone: {}", userTimezone);
		log.info("User Country Format: {}", userCountryFormat);
		log.info("User Country: {}", userCountry);
		log.info("User Home: {}", userHome);
		log.info("User Language: {}", userLanguage);
		
		System.getProperties().forEach((k, v) -> log.info("{} -> {}", k, v));
		
	}
	
}
