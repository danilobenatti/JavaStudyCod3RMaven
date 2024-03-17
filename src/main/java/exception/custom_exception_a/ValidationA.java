package exception.custom_exception_a;

import org.apache.commons.math3.exception.OutOfRangeException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Student;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationA {
	
	public static void validStudent(Student student) {
		if (student == null) {
			throw new IllegalArgumentException("Student is null!");
		}
		if (student.getName() == null || student.getName().isBlank()) {
			throw new EmptyStringException("name");
		}
		if (student.getAverage() < 0 || student.getAverage() > 10) {
			throw new OutOfRangeException(student.getAverage(), 0, 10);
		}
		if (student.getAverage() < 0 || student.getAverage() > 10) {
			throw new OutRangeNumberException("average");
		}
	}
}
