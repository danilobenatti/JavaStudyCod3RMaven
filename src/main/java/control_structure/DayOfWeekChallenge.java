package control_structure;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

public class DayOfWeekChallenge {
	
	public static String getFullDayWeekByLocale(LocalDate date, Locale locale) {
		locale = locale == null ? Locale.US : locale;
		return switch (locale.toLanguageTag()) {
			case "pt-BR" -> StringUtils.capitalize(
					date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale));
			default ->
				date.getDayOfWeek().getDisplayName(TextStyle.FULL, locale);
		};
	}
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Builder builder = new Locale.Builder();
		Locale localeBR = builder.setLanguage("pt").setRegion("BR").build();
		
		Locale localeUS = Locale.of("en", "US");
		
		LocalDate date = LocalDate.of(2023, Month.SEPTEMBER, 9);
		
		DayOfWeek dayWeek = date.getDayOfWeek();
		
		// ISO-8601 standard, from 1 (Monday) to 7 (Sunday).
		console.println(new StringJoiner("\s").add(date.toString())
				.add("Day Of Week:").add(String.valueOf(dayWeek.getValue()))
				.add(getFullDayWeekByLocale(date, localeBR)));
		
		console.println(new StringBuilder().append(date).append(SPACE)
				.append("Day Of Week: ").append(dayWeek.getValue())
				.append(SPACE).append(getFullDayWeekByLocale(date, localeBR)));
		
		LocalDate now = LocalDate.now();
		
		console.println(new StringBuilder()
				.append(getFullDayWeekByLocale(now, localeBR)).append(SPACE)
				.append('\u0028').append(now.getDayOfWeek().getValue())
				.append('\u0029'));
		
		console.println(
				String.format("%s (%d)", getFullDayWeekByLocale(now, localeUS),
						now.getDayOfWeek().getValue()));
		
		LocalDate bornDate = LocalDate.of(1982, Month.JULY, 3);
		
		console.println(String.format("%s (%d) (%s)",
				getFullDayWeekByLocale(bornDate, localeBR),
				bornDate.getDayOfWeek().getValue(), bornDate.getDayOfWeek()
						.getDisplayName(TextStyle.SHORT, localeBR)));
		
		// Enums values
		console.println(dayWeek.ordinal() + SPACE + dayWeek.name());
		
		String str = switch (now.getDayOfWeek().getValue()) {
			case 1 -> "SEG";
			case 2 -> "TER";
			case 3 -> "QUA";
			case 4 -> "QUI";
			case 5 -> "SEX";
			case 6 -> "SAB";
			case 7 -> "DOM";
			default -> "Unexpected value";
		};
		
		console.println(String.format("%s (%s) %d", str,
				getFullDayWeekByLocale(now, localeBR),
				now.getDayOfWeek().getValue()));
		
		String result = switch (now.getDayOfWeek().ordinal()) {
			case 0 -> "SEG";
			case 1 -> "TER";
			case 2 -> "QUA";
			case 3 -> "QUI";
			case 4 -> "SEX";
			case 5 -> "SAB";
			case 6 -> "DOM";
			default -> "Unexpected value";
		};
		
		console.println(String.format("%s (%s) %d", result,
				getFullDayWeekByLocale(now, null),
				now.getDayOfWeek().ordinal()));
		
		console.close();
	}
	
}
