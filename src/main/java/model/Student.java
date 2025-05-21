package model;

import java.time.LocalDate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.util.PersonUtil;
import util.Imc;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(builderMethodName = "student")
public class Student extends Person {
	
	private double average;
	private boolean goodBehavior;
	
	public Student(String name, Character gender, double average) {
		setName(name);
		setGender(gender);
		setAverage(average);
	}
	
	public int getAge() {
		return PersonUtil.getAge(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(super.getName());
		builder.append(", ");
		builder.append(super.getGender());
		builder.append(", ");
		builder.append(PersonUtil.getAgeWithSymbol(this));
		builder.append(", ");
		builder.append(this.average);
		builder.append(", ");
		builder.append(this.goodBehavior);
		builder.append(", ");
		builder.append(Imc.imcByGender(this));
		builder.append("]");
		return builder.toString();
	}

	public Student(@NonNull Long id, @NonNull String name,
			@NonNull Character gender, float weight, float height,
			@NonNull LocalDate birthDate, LocalDate deathDate) {
		super(id, name, gender, weight, height, birthDate, deathDate);
		this.average = getAverage();
		this.goodBehavior = isGoodBehavior();
	}

	public Student(@NonNull Long id, @NonNull String name,
			@NonNull Character gender, @NonNull LocalDate birthDate) {
		super(id, name, gender, birthDate);
	}

	public Student(PersonBuilder<?, ?> b) {
		super(b);
	}
}
