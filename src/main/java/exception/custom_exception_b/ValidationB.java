package exception.custom_exception_b;

import org.apache.commons.math3.exception.OutOfRangeException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import model.Student;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationB {
	
	public static void validStudent(Student student)
			throws EmptyStringException, OutRangeNumberException,
			OutOfRangeException {
		
		if (student == null) {
			throw new IllegalArgumentException("Student is null!");
		}
		if (student.getName() == null || student.getName().isBlank()) {
			throw new EmptyStringException("name");
		}
		if (student.getScore() < 0 || student.getScore() > 10) {
			throw new OutOfRangeException(student.getScore(), 0, 10);
		}
		if (student.getScore() < 0 || student.getScore() > 10) {
			throw new OutRangeNumberException("score");
		}
	}
}
