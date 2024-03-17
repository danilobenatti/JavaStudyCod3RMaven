package collection_structure;

import java.util.ArrayDeque;
import java.util.Deque;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StackCode {
	
	static Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(StackCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.add("Happy Place");
		deque.add("Yellowface");
		deque.push("Love, Theoretically");
		deque.add("The Little Prince");
		
		for (String str : deque) {
			logger.info(str);
		}
		
		logger.info(deque::isEmpty);
		logger.info(deque::size);
		logger.info(deque.contains("Yellowface"));
		
		logger.info(deque::peek);
		logger.info(deque::element);
		
		logger.info(deque::poll);
		logger.info(deque::poll);
		logger.info(deque::pop);
		logger.printf(Level.INFO, "%s", deque.remove());
		logger.info(deque::poll);
	}
	
}
