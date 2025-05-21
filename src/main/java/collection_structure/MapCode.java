package collection_structure;

import static java.time.temporal.ChronoUnit.DAYS;
import static model.Customer.customer;

import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Customer;
import model.util.PersonUtil;

public class MapCode {
	
	private static final LocalDate NOW = LocalDate.now();
	
	private static final ZoneId ZONE_ID = ZoneId.of("Brazil/Acre");
	
	private static final ZoneOffset ZONE_OFFSET = ZoneId.systemDefault()
			.getRules().getOffset(LocalDateTime.now());
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Customer c1 = customer().id(10L).name("Paul").gender('M')
				.birthDate(NOW.minusYears(15).minusWeeks(2)).build();
//		c1.killPersonAtDate(NOW.minusYears(2));
		PersonUtil.personDiedIn(c1, NOW.minusYears(2));
		
		Customer c2 = customer().id(20L).name("John").gender('M')
				.birthDate(NOW.minusYears(75).minusDays(25)).build();
		
		Customer c3 = customer().id(30L).name("Cloe").gender('F')
				.birthDate(NOW.minusYears(35).minusMonths(6)).build();
		PersonUtil.personDiedNow(c3);
		
		Customer c4 = customer().id(40L).name("Nany").gender('F')
				.birthDate(NOW.minusYears(25).minusDays(6)).build();
		Date c4_DateDeath = Date.from(Instant.now().minus(2, DAYS));
		PersonUtil.personDiedIn(c4, c4_DateDeath);
		
		Customer c5 = customer().id(50L).name("Ivan").gender('M')
				.birthDate(NOW.minusYears(41).minusDays(27)).build();
		Date c5DateDeath = Date.from(NOW.minusYears(4).atStartOfDay().toInstant(ZONE_OFFSET));
		PersonUtil.personDiedIn(c5, c5DateDeath, ZONE_ID);
		
		Map<Integer, Customer> map = new HashMap<>();
		map.put(1, c1);
		map.put(2, c2);
		map.put(3, c3);
		map.put(4, c4);
		map.put(5, c5);
		
		map.forEach((k, v) -> console.println(String.format("%d = %s", k, v)));
		
		console.println("\nisEmpty: " + map.isEmpty());
		console.println("\nsize: " + map.size());
		console.println("\nget(5): " + map.get(5).toString());
		
		console.println("\nkeySet: " + map.keySet());
		console.println("\nvalues: " + map.values());
		console.println("\nentrySet: " + map.entrySet());
		
		console.println("\nget(1): " + map.get(1));
		console.println("\ncontainsKey(2): " + map.containsKey(2));
		console.println("\ncontainsValue(c3): " + map.containsValue(c3));
		
		for (int key : map.keySet()) {
			console.println(String.format("%d", key));
		}
		
		for (Customer cutomer : map.values()) {
			console.println(cutomer);
		}
		
		for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Customer customer = entry.getValue();
			console.println(key + " - " + PersonUtil.getAgeWithSymbol(customer));
		}
		
		console.close();
	}
	
}
