package lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ForeachTest {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(ForeachTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		ArrayList<Object> asList = new ArrayList<>();
		asList.add(1);
		asList.add(2L);
		asList.add(3F);
		asList.add(4.0);
		asList.add(BigDecimal.valueOf(5));
		
		Set<Object> numbers = new HashSet<>();
		numbers.addAll(asList);
		
		numbers.stream().forEachOrdered(n -> msg(n));
		
		List<Object> list = Arrays.asList("Tom", '\u0023', 2000, 3L, 2.5F, 5.0);
		
		for (Object o : list) {
			msg(o);
		}
		
		list.forEach(o -> msg(o));
		list.forEach(o -> log.info(message(o)));
		
		
	}
	
	public static void msg(Object object) {
		log.info(new StringBuilder().append(object.toString()).append(" -> ")
				.append(object.getClass().getSimpleName()));
	}
	
	public static String message(Object object) {
		return StringUtils.joinWith(StringUtils.SPACE, object.toString(), "->",
				object.getClass().getSimpleName());
	}
}
