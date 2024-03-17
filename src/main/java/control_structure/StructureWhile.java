package control_structure;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StructureWhile {
	
	static Logger log = LogManager.getLogger();
	
	static final int FIND = 25;
	
	public static void main(String[] args) {
		
		Configurator.initialize(StructureWhile.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		// 0 - 9 (integer)
		log.info(new Random().nextInt(0, 11));
		
		// between 10 and 100 (integer)
		int min = 10;
		int max = 100;
		// find by 26 (integer)
		
		// solution 1
		int i = 0;
		int j = FIND + 1;
		while (j != FIND) {
			j = (new Random().nextInt(max - min + 1) + min);
			i++;
		}
		message(i, FIND);
		
		// solution 2
		int k = 0;
		int l = 0;
		do {
			l = new Random().nextInt(max - min + 1);
			k++;
		} while (l != FIND);
		message(k, FIND);
		
		// between the origin (inclusive) and the bound (exclusive)
		log.info(() -> "Random[0 - 100]: " + new Random().nextInt(0, 101));
		
		log.info(ThreadLocalRandom.current().nextInt(0, 10));
		log.info(ThreadLocalRandom.current().nextBoolean());
		
		for (String v = "#"; !v.equals("######"); v += "#") {
			log.info(v);
		}
	}
	
	public static void message(int i, int find) {
		log.info(new StringBuilder().append("Loop").append(SPACE).append(i)
				.append(SPACE).append("times until finding n").append('\u00BA')
				.append(SPACE).append(find));
	}
}
