package beginners_level;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringToNumber {
	
	public static void main(String[] args) {
		
		double d1 = Double.parseDouble(showInputDialog(null, "Info number1",
			"Input Number1", QUESTION_MESSAGE).replace(',', '.'));
		double d2 = Double.parseDouble(showInputDialog(null, "Info number2",
			"Input Number2", QUESTION_MESSAGE).replace(',', '.'));
		
		List<Double> list = Arrays.asList(d1, d2);
		
		Long count = list.stream().collect(Collectors.counting());
		Double sum = list.stream().collect(Collectors.summingDouble(d -> d));
		Double avg = list.stream().collect(Collectors.averagingDouble(d -> d));
		
		System.out.println(count);
		System.out.println(sum);
		System.out.println(avg);
	}
	
}
