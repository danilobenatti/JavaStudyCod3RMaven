package collection_structure;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class BehaviorSetCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Set<String> set = new HashSet<>();
		set.add("Anna");
		set.add("Olaf");
		set.add("Elza");
		set.add("Esven");
		
		for (String str : set) {
			console.println(str);
		}
		console.println();
		
		SortedSet<String> sortedSet = new TreeSet<>();
		sortedSet.add("Anna");
		sortedSet.add("Olaf");
		sortedSet.add("Elza");
		sortedSet.add("Esven");
		
		for (String str : sortedSet) {
			console.println(str);
		}
		console.println();
		
		Set<Integer> dayWeek = new TreeSet<>();
		dayWeek.add(DayOfWeek.SUNDAY.getValue());
		dayWeek.add(DayOfWeek.THURSDAY.getValue());
		dayWeek.add(DayOfWeek.MONDAY.getValue());
		dayWeek.add(DayOfWeek.TUESDAY.getValue());
		dayWeek.add(DayOfWeek.WEDNESDAY.getValue());
		dayWeek.add(DayOfWeek.FRIDAY.getValue());
		dayWeek.add(DayOfWeek.SATURDAY.getValue());
		
		for (Integer integer : dayWeek) {
			console.println(DayOfWeek.of(integer).getDisplayName(TextStyle.FULL,
					Locale.getDefault()));
		}
		console.println();
		
		for (Integer integer : dayWeek) {
			console.println(DayOfWeek.of(integer).getDisplayName(TextStyle.FULL,
					Locale.of("pt", "BR")));
		}
		console.println();
		
		console.close();
	}
	
}
