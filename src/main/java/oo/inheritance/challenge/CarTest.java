package oo.inheritance.challenge;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class CarTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(CarTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Car beetle = new Beetle();
		beetle.speed = 0;
		
		do {
			beetle.speedUp();
			log.printf(Level.INFO, "Up: %s", beetle);
		} while (beetle.speed < 80);
		
		do {
			beetle.speedDown();
			log.printf(Level.INFO, "Down: %s", beetle);
		} while (beetle.speed > 0);
		
		Car ferrari = new Ferrari(400);
		ferrari.speed = 0;
		
		do {
			ferrari.speedUp();
			log.printf(Level.INFO, "Up: %s", ferrari);
		} while (ferrari.speed < 100);
		
		do {
			ferrari.speedDown();
			log.printf(Level.INFO, "Down: %s", ferrari);
		} while (ferrari.speed > 0);
	}
}
