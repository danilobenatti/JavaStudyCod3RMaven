package model;

import static java.time.format.DateTimeFormatter.ofLocalizedDate;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;

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
	
	private LocalDate bornDate;
	
	private LocalDate deathDate;
	
	private static final ZoneId ZONE_ID = ZoneId.systemDefault();
	
	public boolean isAlive() {
		return this.bornDate != null & this.deathDate == null;
	}
	
	public int getAge() {
		LocalDate now = LocalDate.now();
		if (!isAlive() && this.deathDate.isAfter(this.bornDate)) {
			return Period.between(this.bornDate, this.deathDate).getYears();
		} else if (isAlive() && this.bornDate.isBefore(now)) {
			return Period.between(this.bornDate, now).getYears();
		}
		return 0;
	}
	
	public String getAgeWithSymbol() {
		String blackStar = String.valueOf('\u2605');
		String dagger = String.valueOf('\u2020');
		return isAlive() ? String.valueOf(getAge()).concat(blackStar)
				: String.valueOf(getAge()).concat(dagger);
	}
	
	public void killPersonNow() {
		if (isAlive() && LocalDate.now().compareTo(this.bornDate) >= 0) {
			this.deathDate = LocalDate.now(ZONE_ID);
		}
	}
	
	public void killPersonAtDate(LocalDate date) {
		if (isAlive() && date.compareTo(this.bornDate) >= 0) {
			this.deathDate = date;
		}
	}
	
	public void killPersonAtDate(Date date) {
		LocalDate killDate = date.toInstant().atZone(ZoneId.systemDefault())
				.toLocalDate();
		if (isAlive() && killDate.compareTo(this.bornDate) >= 0) {
			this.deathDate = killDate;
		}
	}
	
	public void killPersonAtDate(Date date, ZoneId zoneid) {
		LocalDate killDate = date.toInstant().atZone(zoneid).toLocalDate();
		if (isAlive() && killDate.compareTo(this.bornDate) >= 0) {
			this.deathDate = killDate;
		}
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = ofLocalizedDate(FormatStyle.SHORT)
				.localizedBy(Locale.getDefault());
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
		builder.append(bornDate != null ? bornDate.format(dtf) : null);
		builder.append(", deathDate=");
		builder.append(deathDate != null ? deathDate.format(dtf) : null);
		builder.append("]");
		return builder.toString();
	}
}