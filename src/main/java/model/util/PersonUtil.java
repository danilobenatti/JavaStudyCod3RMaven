package model.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import model.Person;

public class PersonUtil {
	
	public static final Locale LOCALE = Locale.getDefault();
	
	public static final LocalDate NOW = LocalDate.now(ZoneId.systemDefault());
	
	public static boolean isAlive(Person p) {
		return p.getDeathDate() == null && p.getBirthDate() != null;
	}
	
	public static int getAge(Person p) {
		if (isAlive(p) && p.getBirthDate().isBefore(NOW))
			return Period.between(p.getBirthDate(), NOW).getYears();
		else
			return Period.between(p.getBirthDate(), p.getDeathDate()).getYears();
	}
	
	public static Character getSymbol(Person person) {
		/**
		 * '\u2605' BLACK STAR
		 * '\u271D' LATIN CROSS
		 * '\u272E' HEAVY OUTLINED BLACK STAR
		 * '\u271F' OUTLINED LATIN CROSS
		 **/
		return isAlive(person) ? '\u272E' : '\u271F';
	}
	
	public String getSymbolAsString(Person person) {
		return getSymbol(person).toString();
	}
	
	public static String getAgeWithSymbol(Person person) {
		return StringUtils.join(getAge(person), getSymbol(person));
	}
	
	public String getAgeWithSymbol_(Person person) {
		return String.join("\0", String.valueOf(getAge(person)),
				getSymbolAsString(person));
	}
	
	public String getAgeWithSymbol__(Person person ) {
		return new StringJoiner("").add(String.valueOf(getAge(person)))
				.add(getSymbolAsString(person)).toString();
	}
	
	public static boolean validyDeathDate(Person person, LocalDate deathDate) {
		return deathDate.isAfter(person.getBirthDate());
	}

	public static void personDiedNow(Person person) {
		if (isAlive(person) && validyDeathDate(person, NOW))
			person.setDeathDate(NOW);
	}
	
	public static void personDiedIn(Person person, LocalDate deathDate) {
		if (isAlive(person) && validyDeathDate(person, deathDate))
			person.setDeathDate(deathDate);
	}
	
	public static void personDiedIn(Person person, Date deathDate) {
		ZoneId zoneId = ZoneId.systemDefault();
		LocalDate date = deathDate.toInstant().atZone(zoneId).toLocalDate();
		personDiedIn(person, date);
	}
	
	public static void personDiedIn(Person person, Date deathDate, ZoneId z) {
		LocalDate date = deathDate.toInstant().atZone(z).toLocalDate();
		personDiedIn(person, date);
	}
	
}
