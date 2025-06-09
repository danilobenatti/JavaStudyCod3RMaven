package lambda;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class ForeachTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		ArrayList<Object> asList = new ArrayList<>();
		asList.add(1);
		asList.add(2L);
		asList.add(3F);
		asList.add(4.0);
		asList.add(BigDecimal.valueOf(5000));
		
		asList.forEach(n -> console.println(message(n)));
		
		Set<Object> numbers = new HashSet<>();
		numbers.addAll(asList);
		
		numbers.stream().forEachOrdered(n -> console.println(message(n)));
		
		List<Object> list = Arrays.asList("Tom", '\u0023', 2000, 3L, 2.5F, 5.0);
		
		for (Object o : list) {
			console.println(message(o));
		}
		
		list.forEach(o -> console.println(message(o)));
		
		list.forEach(console::println);
		
		console.close();
	}
	
	public static String message(Object object) {
		String value = object.toString();
		String type = object.getClass().getSimpleName();
		return StringUtils.join(value, " -> ", type);
	}
	
}
