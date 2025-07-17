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
	
	private double score;
	private boolean goodBehavior;
	
	public Student(String name, Character gender, double score) {
		setName(name);
		setGender(gender);
		setScore(score);
	}
	
	public Student(Long id, String name, Character gender, double score,
			LocalDate birthDate) {
		setId(id);
		setName(name);
		setGender(gender);
		setScore(score);
		setBirthDate(birthDate);
	}
	
	public int getAge() {
		return PersonUtil.getAge(this);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(super.getId());
		builder.append(", ");
		builder.append(super.getName());
		builder.append(", ");
		builder.append(super.getGender());
		builder.append(", ");
		builder.append(PersonUtil.getAgeWithSymbol(this));
		builder.append(", ");
		builder.append(this.score);
		builder.append(", ");
		builder.append(this.goodBehavior);
		builder.append(", ");
		builder.append(Imc.bmiByGender(this));
		builder.append("]");
		return builder.toString();
	}

	public Student(@NonNull Long id, @NonNull String name,
			@NonNull Character gender, float weight, float height,
			@NonNull LocalDate birthDate, LocalDate deathDate) {
		super(id, name, gender, weight, height, birthDate, deathDate);
		this.score = getScore();
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
