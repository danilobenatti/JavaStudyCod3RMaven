package jdbc;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class GFG {
	
	public static void main(String[] args) {
		
		/**
		 * https://docs.oracle.com/javase/10/docs/api/java/time/ZoneId.html#getAvailableZoneIds()
		 */
		
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		
		System.out.println(zoneIds.iterator().next());
		
		ArrayList<String> zoneList = new ArrayList<>(zoneIds);
		
		Collections.sort(zoneList);
		
		zoneList.forEach(System.out::println);
		
		LocalDateTime dt = LocalDateTime.now();
		
		int i = 0;
		for (String string : zoneList) {
			String s = zoneList.get(i);
			ZoneId zoneId = ZoneId.of(s);
			ZonedDateTime zonedDateTime = dt.atZone(zoneId);
			ZoneOffset offset = zonedDateTime.getOffset();
			System.out.println("ZoneId = " + zoneId + "; offset = " + offset);
			i++;
		}
		
	}
	
}
