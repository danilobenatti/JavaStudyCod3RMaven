package oo.composition;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

@ToString()
public class Course {
	
	@ToString.Include(name = "Name", rank = 1)
	final String description;
	
	public String getDescription() {
		return description;
	}
	
	int hours;
	
	@ToString.Exclude
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
		return this.students;
	}
	
}
