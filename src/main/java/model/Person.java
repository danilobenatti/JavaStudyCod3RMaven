package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.util.PersonUtil;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder(builderMethodName = "person")
public class Person {
	
	@NonNull
	@EqualsAndHashCode.Include
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Character gender;
	
	private float weight;
	
	public double getWeight() {
		return Double.valueOf(this.weight);
	}
	
	private float height;
	
	public double getHeight() {
		return Double.valueOf(this.height);
	}
	
	@NonNull
	private LocalDate birthDate;
	
	public void setBirthDate(LocalDate date) {
		if (date.compareTo(LocalDate.now()) <= 0)
			this.birthDate = date;
	}
	
	private LocalDate deathDate;
	
	public void setDeathDate(LocalDate date) {
		if (date.compareTo(getBirthDate()) >= 0)
			this.deathDate = date;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
		StringBuilder builder = new StringBuilder();
		builder.append("Person [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(PersonUtil.getAgeWithSymbol(this));
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", height=");
		builder.append(height);
		builder.append(", bornDate=");
		builder.append(birthDate != null ? getBirthDate().format(dtf) : null);
		builder.append(", deathDate=");
		builder.append(deathDate != null ? getDeathDate().format(dtf) : null);
		builder.append("]");
		return builder.toString();
	}
}