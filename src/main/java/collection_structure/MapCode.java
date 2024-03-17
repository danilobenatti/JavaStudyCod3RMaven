package collection_structure;

import static java.lang.String.format;
import static model.Customer.customer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Customer;

public class MapCode {
	
	static Logger log = LogManager.getLogger();
	
	static ZoneOffset offset = ZoneId.systemDefault().getRules()
			.getOffset(LocalDateTime.now());
	
	public static void main(String[] args) {
		
		Configurator.initialize(MapCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Customer cli1 = customer().id(10).name("Paul").gender('M')
				.bornDate(LocalDate.now().minusYears(15).minusWeeks(2)).build();
		cli1.killPersonAtDate(LocalDate.now().minusYears(2));
		
		Customer cli2 = customer().id(20).name("John").gender('M')
				.bornDate(LocalDate.now().minusYears(75).minusDays(25)).build();
		
		Customer cli3 = customer().id(30).name("Cloe").gender('F')
				.bornDate(LocalDate.now().minusYears(35).minusMonths(6))
				.build();
		cli3.killPersonNow();
		
		Customer cli4 = customer().id(40).name("Nany").gender('F')
				.bornDate(LocalDate.now().minusYears(25).minusDays(6)).build();
		cli4.killPersonAtDate(
				Date.from(Instant.now().minus(2, ChronoUnit.DAYS)),
				ZoneId.of("Brazil/Acre"));
		
		Customer cli5 = customer().id(50).name("Ivan").gender('M')
				.bornDate(LocalDate.now().minusYears(41).minusDays(27)).build();
		cli5.killPersonAtDate(Date.from(LocalDate.now().minusYears(4)
				.atStartOfDay().toInstant(offset)));
		
		Map<Integer, Customer> map = new HashMap<>();
		
		map.put(1, cli1);
		map.put(2, cli2);
		map.put(3, cli3);
		map.put(4, cli4);
		map.put(5, cli5);
		
		map.forEach((k, v) -> log.info(format("%d = %s", k, v)));
		
		log.info(map.isEmpty());
		log.info(map.size());
		log.info(() -> map.get(5).toString());
		
		log.info(map.keySet());
		log.info(map.values());
		log.info(map.entrySet());
		
		log.info(map.get(1));
		log.info(map.containsKey(2));
		log.info(map.containsValue(cli3));
		
		for (int key : map.keySet()) {
			log.info(key);
		}
		
		for (Customer cutomer : map.values()) {
			log.info(cutomer);
		}
		
		for (Map.Entry<Integer, Customer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Customer customer = entry.getValue();
			log.info(() -> key + " - " + customer.getAgeWithSymbol());
			
		}
		
	}
	
}
