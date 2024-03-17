package arrays_structure;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

import javax.swing.JOptionPane;

public class ArraysFirstChallenge {
	
	static NumberFormat nf = NumberFormat.getInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		
		int input = (int) showInputDialog(null, "What is the number of grades?",
			"Number of grades", JOptionPane.QUESTION_MESSAGE, null,
			new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1);
		
		float[] notes = new float[input];
		
		for (int i = 0; i < input; i++) {
			var message = new StringBuilder().append("Enter note").append(SPACE)
				.append(i + 1).append('\u00AA').append(SPACE).append("of")
				.append(SPACE).append(input);
			notes[i] = Float
				.parseFloat(showInputDialog(null, message, "Info notes",
					JOptionPane.QUESTION_MESSAGE).replace(',', '.').strip());
		}
		
		var sum = 0F;
		for (var note : notes) {
			sum = Float.sum(sum, note);
		}
		
		nf.setMaximumFractionDigits(1);
		nf.setMinimumFractionDigits(1);
		nf.setRoundingMode(RoundingMode.HALF_EVEN);
		
		var avg = sum / notes.length;
		
		showMessageDialog(null, String.format("%s%nAverage note: %s",
			Arrays.toString(notes), nf.format(avg)), "Result",
			JOptionPane.INFORMATION_MESSAGE);
	}
	
}
