package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder(builderMethodName = "person")
public class Person {
	
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	
	private static final Locale LOCALE = Locale.getDefault();
	
	private static final DateTimeFormatter DTF = DateTimeFormatter
			.ofLocalizedDate(FormatStyle.SHORT).localizedBy(LOCALE);
	
	@Include
	private long id;
	
	private String name;
	
	private char gender;
	
	private float weight;
	
	public double getWeight() {
		return Double.valueOf(this.weight);
	}
	
	private float height;
	
	public double getHeight() {
		return Double.valueOf(this.height);
	}
	
	private LocalDate birthDate;
	
	private LocalDate deathDate;
	
	public boolean isAlive() {
		return getBirthDate() != null & getDeathDate() == null;
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		if (isAlive() && getBirthDate().isBefore(now))
			return Period.between(getBirthDate(), now).getYears();
		else
			return Period.between(getBirthDate(), getDeathDate()).getYears();
	}
	
	public String getAgeWithSymbol() {
		char blackStar = '\u2605'; // Black Star
		char dagger = '\u271D'; // Latin Cross
		return isAlive() ? StringUtils.join(getAge(), blackStar)
				: StringUtils.join(getAge(), dagger);
	}
	
	public void killPersonNow() {
		if (isAlive() && LocalDate.now().compareTo(getBirthDate()) >= 0)
			setDeathDate(LocalDate.now(ZONE_ID));
	}
	
	public void killPersonAtDate(LocalDate date) {
		if (isAlive() && date.compareTo(getBirthDate()) >= 0)
			setDeathDate(date);
	}
	
	public void killPersonAtDate(Date date) {
		LocalDate killDate = date.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (isAlive() && killDate.compareTo(getBirthDate()) >= 0)
			setDeathDate(killDate);
	}
	
	public void killPersonAtDate(Date date, ZoneId zoneid) {
		LocalDate killDate = date.toInstant().atZone(zoneid).toLocalDate();
		if (isAlive() && killDate.compareTo(getBirthDate()) >= 0)
			setDeathDate(killDate);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append(", bornDate=");
		builder.append(birthDate != null ? birthDate.format(DTF) : null);
		builder.append(", deathDate=");
		builder.append(deathDate != null ? deathDate.format(DTF) : null);
		builder.append("]");
		return builder.toString();
	}
}