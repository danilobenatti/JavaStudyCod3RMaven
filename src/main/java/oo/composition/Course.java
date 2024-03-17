package oo.composition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.ToString;
import lombok.ToString.Exclude;

@ToString
public class Course {
	
	String description;
	
	int hours;
	
	@Exclude
	final List<Student> students = new ArrayList<>();
	
	public Course(String description, int hours) {
		this.description = description;
		this.hours = hours;
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
		student.courses.add(this);
	}
	
	public void addStudent(String name, Date dateOfBirth) {
		this.addStudent(new Student(name, dateOfBirth, null));
	}
	
	public void addStudents(List<Student> students) {
		this.students.addAll(students);
		students.forEach(s -> s.courses.add(this));
	}
	
	public List<Student> listStudents() {
		return this.students.stream().toList();
	}
}
