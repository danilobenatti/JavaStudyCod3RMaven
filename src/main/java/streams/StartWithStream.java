package streams;

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

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Person;

public class StartWithStream {
	
	static Logger log = LogManager.getLogger();
	static ZoneId zoneId = ZoneId.of("America/Sao_Paulo");
	static TimeZone timeZone = TimeZone.getTimeZone(zoneId);
	static ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
	static Locale aLocale = Locale.of("pt", "BR");
	
	public static void main(String[] args) {
		
		Configurator.initialize(StartWithStream.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		DateFormat dfPtBR = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, aLocale);
		DateFormat dfEnUS = DateFormat.getDateTimeInstance(DateFormat.FULL,
				DateFormat.FULL, Locale.of("en", "US"));
		
		Instant instant = new GregorianCalendar(timeZone, aLocale).toInstant();
		
		log.printf(Level.INFO, "%s", dfPtBR.format(Date.from(instant)));
		log.printf(Level.INFO, "%s", dfEnUS.format(Date.from(instant)));
		log.printf(Level.INFO, "%s%n",
				zonedDateTime.getChronology().getCalendarType());
		
		Person p = new Person(1, "Peter Parker", 'M', 78.8F, 1.73F,
				LocalDate.now().minusYears(17), null);
		
		List<Object> list = Arrays.asList("Tue", 'M', 1, 1F, 1.0E1,
				Date.from(instant), p, p.getAgeWithSymbol());
		
		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {
			log.printf(Level.INFO, "with While: %s", iterator.next());
		}
		
		for (Object object : list) {
			log.printf(Level.INFO, "with For: %s", msg(object));
		}
		
		Stream<Object> stream = list.stream();
		
		stream.forEach(o -> log.info(msg(o)));
		
		list.stream().forEach(o -> log.info(msg(o)));
		
		list.iterator().forEachRemaining(o -> log.info(msg(o)));
		
	}
	
	static String msg(Object obj) {
		return new StringBuilder().append(obj).append(" - ")
				.append(obj.getClass().getSimpleName()).append("\n").toString();
	}
}
