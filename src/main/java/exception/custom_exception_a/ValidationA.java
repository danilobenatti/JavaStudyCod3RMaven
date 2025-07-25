package exception.custom_exception_a;

import org.apache.commons.math3.exception.OutOfRangeException;

import exception.custom.NegativeNumberException;
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
		if (student.getScore() < 0) {
			throw new NegativeNumberException("score");
		}
		if (student.getScore() < 0 || student.getScore() > 10) {
			throw new OutOfRangeException(student.getScore(), 0, 10);
		}
		if (student.getScore() < 0 || student.getScore() > 10) {
			throw new OutRangeNumberException("score");
		}
	}
}
