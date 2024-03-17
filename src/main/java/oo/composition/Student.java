package oo.composition;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student {
	
	private static final ZoneId SYSTEM_DEFAULT = ZoneId.systemDefault();
	
	String name;
	
	Date dateOfBirth;
	
	Date dateOfDeath;
	
	final List<Course> courses = new ArrayList<>();
	
	public Student(String name, Date dateOfBirth, Date dateOfDeath) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.setDateOfDeath(dateOfDeath);
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
		course.students.add(this);
	}
	
	public void addCourses(List<Course> courses) {
		this.courses.addAll(courses);
		courses.forEach(c -> c.students.add(this));
	}
	
	public static int totalHours(Student student) {
		return student.courses.stream().mapToInt(c -> c.hours).sum();
	}
	
	public int calculeAge(LocalDate dateOfBirth, LocalDate dateOfDeath) {
		if (dateOfDeath == null) {
			return Period.between(dateOfBirth, LocalDate.now()).getYears();
		}
		if (dateOfDeath.isAfter(dateOfBirth)) {
			return Period.between(dateOfBirth, dateOfDeath).getYears();
		}
		return 0;
	}
	
	public int calculeAge(Date dateOfBirth, Date dateOfDeath) {
		if (dateOfDeath == null) {
			return Period.between(dateOfBirth.toInstant().atZone(SYSTEM_DEFAULT)
					.toLocalDate(), LocalDate.now()).getYears();
		}
		if (dateOfDeath.after(dateOfBirth)) {
			return Period.between(
					dateOfBirth.toInstant().atZone(SYSTEM_DEFAULT)
							.toLocalDate(),
					dateOfDeath.toInstant().atZone(SYSTEM_DEFAULT)
							.toLocalDate())
					.getYears();
		}
		return 0;
	}
	
	public int calculeAge() {
		if (isAlive()) {
			return Period.between(this.dateOfBirth.toInstant()
					.atZone(SYSTEM_DEFAULT).toLocalDate(), LocalDate.now())
					.getYears();
		}
		if (this.dateOfDeath.after(this.dateOfBirth)) {
			return Period.between(
					this.dateOfBirth.toInstant().atZone(SYSTEM_DEFAULT)
							.toLocalDate(),
					this.dateOfDeath.toInstant().atZone(SYSTEM_DEFAULT)
							.toLocalDate())
					.getYears();
		}
		return 0;
	}
	
	public boolean isAlive() {
		return this.dateOfDeath == null;
	}
	
	public char getSymbol() {
		return isAlive() ? '\u272E' : '\u271F';
	}
	
	public String ageWithSymbol() {
		return String.format("%d%c", calculeAge(), getSymbol());
	}
	
	public void studentDeathNow() {
		this.setDateOfDeath(Date.from(Instant.now()));
	}
	
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(calculeAge());
		builder.append(", courses=");
		builder.append(courses);
		builder.append("]");
		return builder.toString();
	}
}
