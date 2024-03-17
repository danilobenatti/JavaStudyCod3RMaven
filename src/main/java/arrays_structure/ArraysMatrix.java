package arrays_structure;

import static java.lang.Float.parseFloat;

import java.util.Locale;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class ArraysMatrix {
	
	static Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Configurator.initialize(ArraysMatrix.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		float[][] students;
		/**
		 * float[][] students = { { Students }, { Grades } };
		 */
		
		try (Scanner sc = new Scanner(System.in)
				.useLocale(Locale.of("pt", "BR"))) {
			log.info("How many students?");
			int numberOfStudents = Integer.parseInt(sc.next().strip());
			log.info("How many grades per student?");
			int numberOfGrades = Integer.parseInt(sc.next().strip());
			
			students = new float[numberOfStudents][numberOfGrades];
			
			int i = 0;
			for (float[] student : students) {
				String msg = String.format("Student %d%n", i + 1);
				log.info(msg);
				int j = 0;
				for (float grade : student) {
					msg = String.format("Grade %d: ", j + 1);
					log.info(msg);
					students[i][j] = parseFloat(sc.next().replace(',', '.'));
					j++;
				}
				i++;
			}
		}
		
		int i = 0;
		var avgTotal = 0F;
		for (float[] student : students) {
			int j = 0;
			var sum = 0F;
			for (float grade : student) {
				sum += grade;
				j++;
			}
			var avgByStudent = (j > 0) ? sum / j : sum;
			avgTotal += avgByStudent;
			String msg = String.format("Student %d average = %.1f%n", i + 1,
					avgByStudent);
			log.info(msg);
			i++;
		}
		
		log.info("Geral average = {}", avgTotal / ((i > 0) ? i : 1));
		
	}
	
}
