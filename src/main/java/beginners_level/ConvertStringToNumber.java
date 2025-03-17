package beginners_level;

import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertStringToNumber {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		String value1 = showInputDialog(null, "Info number1", "Input Number1",
				QUESTION_MESSAGE).replace(',', '.');
		
		String value2 = showInputDialog(null, "Info number2", "Input Number2",
				QUESTION_MESSAGE).replace(',', '.');
		
		double d1 = Double.parseDouble(value1);
		double d2 = Double.parseDouble(value2);
		
		List<Number> list = Arrays.asList(d1, d2);
		
		Long count = list.stream().collect(Collectors.counting());
		Double sum = list.stream().collect(Collectors.summingDouble(Number::doubleValue));
		Double avg = list.stream().collect(Collectors.averagingDouble(Number::doubleValue));
		
		console.println(count);
		console.println(sum);
		console.println(avg);
		
		console.flush();
		console.close();
	}
	
}
