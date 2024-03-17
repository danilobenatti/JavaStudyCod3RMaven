package exception;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import model.Student;

public class BasicExceptionTest {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(BasicExceptionTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Student student = null;
		
		try {
			printNameOfStudent(student);
		} catch (Exception ex) {
			log.printf(Level.ERROR, "Error: when printing student: %s",
					ex.getMessage());
		}
		
		try {
			log.info(7 / NumberUtils.INTEGER_ZERO);
		} catch (ArithmeticException ex) {
			log.printf(Level.ERROR, "Error: division by zero: %s",
					ex.getMessage());
		}
		
		log.info(() -> String.format("%s", "End! ").repeat(5));
	}
	
	public static void printNameOfStudent(Student student) {
		log.printf(Level.INFO, "Name of student: %s", student.getName());
	}
	
}
