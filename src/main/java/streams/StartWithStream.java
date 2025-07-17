package streams;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import model.Student;
import model.util.PersonUtil;

public class StartWithStream {
	
	static final ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
	static final TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	static final ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
	static final Locale aLocale = Locale.of("pt", "BR");
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		DateFormat dfPtBR = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, aLocale);
		DateFormat dfEnUS = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, Locale.of("en", "US"));
		
		Instant instant = new GregorianCalendar(timeZone, aLocale).toInstant();
		Date date = Date.from(instant);
		
		console.println(dfPtBR.format(date));
		console.println(dfEnUS.format(date));
		console.println(zonedDateTime.getChronology().getCalendarType());
		
		Student p = new Student(1L, "Peter Parker", 'M', 78.8F, 1.73F,
				LocalDate.now().minusYears(17), null);
		
		List<Object> list = Arrays.asList(p.getName(), p.getGender(), 1, 1F,
				1.0E1, date, p, PersonUtil.getSymbol(p));
		
		Iterator<Object> iterator = list.iterator();
		
		while (iterator.hasNext()) {
			console.println(
					StringUtils.join("with While: ", msg(iterator.next())));
		}
		
		for (Object object : list) {
			console.println(String.join(" ", "with For:", msg(object)));
		}
		
		Stream<Object> stream = list.stream();
		
		stream.forEach(o -> console.println(msg(o)));
		
		list.stream().forEach(o -> console.println(msg(o)));
		
		list.iterator().forEachRemaining(o -> console.println(msg(o)));
		
		console.close();
	}
	
	static String msg(Object obj) {
		return StringUtils.joinWith(StringUtils.SPACE, obj, "->",
				obj.getClass().getSimpleName());
	}
}
