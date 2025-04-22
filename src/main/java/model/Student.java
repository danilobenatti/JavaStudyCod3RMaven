package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import util.Imc;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(builderMethodName = "student")
public class Student extends Person {
	
	private String name;
	private char gender;
	@SuppressWarnings("unused")
	private int age;
	private double average;
	private boolean goodBehavior;
	
	public Student(String name, char gender, int age, double average) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.average = average;
	}
	
	@Override
	public int getAge() {
		return super.getAge();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(name);
		builder.append(", ");
		builder.append(gender);
		builder.append(", ");
		builder.append(super.getAgeWithSymbol());
		builder.append(", ");
		builder.append(average);
		builder.append(", ");
		builder.append(goodBehavior);
		builder.append(", ");
		builder.append(Imc.imcByGender(this));
		builder.append("]");
		return builder.toString();
	}
}
