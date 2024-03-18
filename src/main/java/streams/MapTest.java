package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import util.StreamUtil;

public class MapTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(MapTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		List<String> stamp = new ArrayList<>();
		stamp.addAll(Arrays.asList("Nike", "Adidas", "Skechers"));
		
		stamp.stream().map(String::toUpperCase).forEach(s -> log.info(s));
		stamp.add("New Balance");
		stamp.add("Penalty");
		
		UnaryOperator<String> append = n -> n.concat("!!!");
		
		stamp.stream().map(StreamUtil.upperCase).forEach(s -> log.info(s));
		
		stamp.stream().map(StreamUtil.lowerCase).forEach(s -> log.info(s));
		
		stamp.stream().map(StreamUtil.firstLetter.andThen(StreamUtil.upperCase))
				.forEach(log::info);
		
		stamp.stream().map(StreamUtil.lastLetter).forEach(log::info);
		
		stamp.stream().map(StreamUtil.upperCase).map(StreamUtil.firstLetter)
				.map(append).forEach(log::info);
	}
	
}
