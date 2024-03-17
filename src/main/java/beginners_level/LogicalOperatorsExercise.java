package beginners_level;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.fraction.Fraction;

public class LogicalOperatorsExercise {
	
	public static void main(String[] args) {
		
		Object[] numberOfTasks = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
		
		int input = (int) JOptionPane.showInputDialog(null,
			"What is the number of tasks?", "Number of tasks",
			JOptionPane.QUESTION_MESSAGE, null, numberOfTasks, 1);
		
		List<Boolean> taskList = new ArrayList<>();
		
		for (int i = 1; i <= input; i++) {
			String title = String.format("%d%c Task", i, '\u00BA');
			String message = String.format("%s is finish?", title);
			taskList.add(JOptionPane.showConfirmDialog(null, message, title,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
		}
		
		Long l1 = taskList.stream().filter(i -> i == Boolean.TRUE).count();
		Long l2 = taskList.stream().filter(i -> i == Boolean.FALSE).count();
		System.out.println(l1 + " finished");
		System.out.println(l2 + " pending");
		
		Fraction f1 = new Fraction((double) l1 / taskList.size());
		Fraction f2 = new Fraction((double) l2 / taskList.size());
		System.out.println(f1 + " finished");
		System.out.println(f2 + " pending");
		
		String format = "%.1f%%";
		String msgCompleted = "tasks are completed";
		String msgPending = "tasks are pending";
		String value = switch (l1.compareTo(l2)) {
			case 1 -> new StringBuilder()
				.append(String.format(format, f1.percentageValue()))
				.append(StringUtils.SPACE).append(msgCompleted)
				.append(StringUtils.LF)
				.append(String.format(format, f2.percentageValue()))
				.append(StringUtils.SPACE).append(msgPending)
				.toString();
			case 0 -> "Work is half done";
			case -1 -> new StringBuilder()
				.append(String.format(format, f2.percentageValue()))
				.append(StringUtils.SPACE).append(msgPending)
				.append(StringUtils.LF)
				.append(String.format(format, f1.percentageValue()))
				.append(StringUtils.SPACE).append(msgCompleted)
				.toString();
			default -> null;
		};
		System.out.println(value);
		JOptionPane.showMessageDialog(null, value, "Result",
			JOptionPane.INFORMATION_MESSAGE);
	}
	
}
