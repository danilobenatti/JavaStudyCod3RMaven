package oo.composition;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	
	protected static final LocalDate NOW = LocalDate.now();
	
	protected static final ZoneId ZONE_ID = ZoneId.systemDefault();
	
	final String name;
	
	Date dateOfBirth;
	
	Date dateOfDeath;
	
	final List<Course> courses = new ArrayList<>();
	
	public List<Course> getCourses() {
		return courses;
	}
	
	public Student(String name, Date dateOfBirth, Date dateOfDeath) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		setDateOfDeath(dateOfDeath);
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
		course.students.add(this);
	}
	
	public void addCourses(List<Course> courses) {
		this.courses.addAll(courses);
		courses.forEach(c -> c.students.add(this));
	}
	
	public List<String> listCourses() {
		return getCourses().stream().map(Course::getDescription).toList();
	}
	
	public static int totalHours(Student student) {
		return student.courses.stream().mapToInt(c -> c.hours).sum();
	}
	
	public int getAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
		if (isAlive())
			return Period.between(dateOfBirth, NOW).getYears();
		else
			return Period.between(dateOfBirth, dateOfDeath).getYears();
	}
	
	public int getAge(Date dateOfBirth, Date dateOfDeath) {
		Instant birthDate = dateOfBirth.toInstant();
		if (isAlive())
			return Period.between(birthDate.atZone(ZONE_ID).toLocalDate(), NOW)
					.getYears();
		if (dateOfDeath.after(dateOfBirth)) {
			Instant deathDate = dateOfDeath.toInstant();
			return Period.between(birthDate.atZone(ZONE_ID).toLocalDate(),
					deathDate.atZone(ZONE_ID).toLocalDate()).getYears();
		}
		return 0;
	}
	
	public int getAge() {
		Instant birthDate = this.dateOfBirth.toInstant();
		LocalDate localBirthDate = birthDate.atZone(ZONE_ID).toLocalDate();
		if (isAlive())
			return Period.between(localBirthDate, NOW).getYears();
		if (this.dateOfDeath.after(this.dateOfBirth)) {
			Instant deathDate = this.dateOfDeath.toInstant();
			LocalDate localDeathDate = deathDate.atZone(ZONE_ID).toLocalDate();
			return Period.between(localBirthDate, localDeathDate).getYears();
		}
		return 0;
	}
	
	public int getAge(Student s) {
		Instant birth = s.dateOfBirth.toInstant();
		LocalDate localDate = birth.atZone(ZONE_ID).toLocalDate();
		if (s.isAlive())
			return Period.between(localDate, NOW).getYears();
		if (s.dateOfDeath.after(s.dateOfBirth))
			return Period.between(localDate,
					s.dateOfDeath.toInstant().atZone(ZONE_ID).toLocalDate()).getYears();
		return 0;
	}
	
	public boolean isAlive() {
		return this.dateOfBirth != null && this.dateOfDeath == null;
	}
	
	public char getSymbol() {
		return isAlive() ? '\u272E' : '\u271F';
	}
	
	public String ageWithSymbol() {
		return String.format("%d%c", getAge(), getSymbol());
	}
	
	public void studentDeathNow() {
		setDateOfDeath(Date.from(Instant.now()));
	}
	
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		builder.append(name);
		builder.append(", ");
		builder.append(ageWithSymbol());
		builder.append(", courses=");
		builder.append(listCourses());
		builder.append("]");
		return builder.toString();
	}
	
	public String toString(String format) {
		StringBuilder builder = new StringBuilder();
		switch (format) {
			case "format1": 
				builder.append("Student [");
				builder.append(name);
				builder.append(", ");
				builder.append(ageWithSymbol());
				builder.append(", courses=");
				builder.append(listCourses());
				builder.append("]");
				break;
			case "format2":
				builder.append("Student [");
				builder.append(name);
				builder.append(", ");
				builder.append(ageWithSymbol());
				builder.append("]");
				break;
			default : throw new IllegalArgumentException("Unexpected value: " + format);
		}
		return builder.toString();
	}
}
