package collection_structure;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class BehaviorSetCode {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(BehaviorSetCode.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Set<String> set = new HashSet<>();
		set.add("Anna");
		set.add("Olaf");
		set.add("Elza");
		set.add("Esven");
		
		for (String str : set) {
			log.info(str);
		}
		
		SortedSet<String> sortedSet = new TreeSet<>();
		sortedSet.add("Anna");
		sortedSet.add("Olaf");
		sortedSet.add("Elza");
		sortedSet.add("Esven");
		
		for (String str : sortedSet) {
			log.info(str);
		}
		
		Set<Integer> dayWeek = new TreeSet<>();
		dayWeek.add(DayOfWeek.SUNDAY.getValue());
		dayWeek.add(DayOfWeek.THURSDAY.getValue());
		dayWeek.add(DayOfWeek.MONDAY.getValue());
		dayWeek.add(DayOfWeek.TUESDAY.getValue());
		dayWeek.add(DayOfWeek.WEDNESDAY.getValue());
		dayWeek.add(DayOfWeek.FRIDAY.getValue());
		dayWeek.add(DayOfWeek.SATURDAY.getValue());
		
		for (Integer integer : dayWeek) {
			log.info(() -> DayOfWeek.of(integer).getDisplayName(TextStyle.FULL,
					Locale.getDefault()));
		}
		
		for (Integer integer : dayWeek) {
			log.info(() -> DayOfWeek.of(integer).getDisplayName(TextStyle.FULL,
					Locale.of("en", "US")));
		}
		
	}
	
}
