package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(builderMethodName = "studentBuilder")
public class Student extends Person {
	
	private String name;
	private char gender;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(name);
		builder.append(", ");
		builder.append(gender);
		builder.append(", ");
		builder.append(age);
		builder.append(", ");
		builder.append(average);
		builder.append("]");
		return builder.toString();
	}
}
