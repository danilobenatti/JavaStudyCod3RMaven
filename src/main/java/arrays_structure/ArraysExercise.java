package arrays_structure;

import java.io.PrintWriter;
import java.util.Arrays;

public class ArraysExercise {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, false);
		
		double[] grades = new double[4];
		grades[0] = 7.9;
		grades[1] = 8;
		grades[2] = 6.7;
		grades[3] = 9.7;
		
		console.println(Arrays.toString(grades));
		
		var total = 0.0;
		for (var grade : grades)
			total += grade;
		console.println(total);
		
		console.println(total / grades.length);
		
		var sum = 0F;
		for (int i = 0; i < grades.length; i++)
			sum += (float) grades[i];
		console.println(sum);
		console.println(sum / grades.length);
		
		double[] gradesStudentA = { 6.9, 8.9, 5.5, 10 };
		var totalStudentA = 0F;
		for (int i = 0; i < gradesStudentA.length; i++)
			totalStudentA += gradesStudentA[i];
		console.println(totalStudentA);
		console.println(totalStudentA / gradesStudentA.length);
		
		var gradesStudentB = new double[] { 5.6, 8, 7.5, 9.2 };
		var totalStudentB = 0F;
		for (int i = 0; i < gradesStudentB.length; i++)
			totalStudentB += gradesStudentB[i];
		console.println(totalStudentB);
		console.println(totalStudentB / gradesStudentB.length);
		
		console.close();
		
	}
	
}
