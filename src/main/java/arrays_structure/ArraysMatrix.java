package arrays_structure;

import static java.lang.Float.parseFloat;
import static org.apache.commons.lang3.StringUtils.joinWith;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Locale.Builder;
import java.util.Scanner;

public class ArraysMatrix {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Builder buildLocale = new Locale.Builder();
		Locale localeBR = buildLocale.setLanguage("pt").setRegion("BR").build();
		
		float[][] students;
		/**
		 * float[][] students = { { Grades }, { Grades } };
		 */
		
		try (Scanner scan = new Scanner(System.in).useLocale(localeBR)) {
			console.println("How many students?");
			int numberOfStudents = Integer.parseInt(scan.next().strip());
			console.println("How many grades per student?");
			int numberOfGrades = Integer.parseInt(scan.next().strip());
			
			students = new float[numberOfStudents][numberOfGrades];
			
			int i = 0;
			for (float[] student : students) {
				console.println(joinWith("\s", "Student", i + 1));
				int j = 0;
				for (float grade : student) {
					console.println(joinWith("\s", "Grade", j + 1));
					students[i][j] = parseFloat(scan.next().replace(',', '.'));
					j++;
				}
				i++;
			}
			
			scan.reset();
			scan.close();
			
		}
		
		float sumOfAverages = 0f;
		for (float[] student : students) {
			float sum = 0f;
			for (float grade : student) {
				sum += grade;
			}
			float avg = sum / student.length;
			
			console.println(joinWith("\s", "Student", student, "average", avg));
			
			sumOfAverages += avg;
		}
		
		float generalAverage = sumOfAverages / students.length;
		
		console.println(joinWith("\s", "General average", generalAverage));
		
		console.flush();
		console.close();
	}
	
}
