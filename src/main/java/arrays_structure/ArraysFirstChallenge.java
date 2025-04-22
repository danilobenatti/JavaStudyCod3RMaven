package arrays_structure;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.SPACE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import javax.swing.JOptionPane;

public class ArraysFirstChallenge {
	
	static final Locale LOCALE = new Locale.Builder().setLanguage("pt")
			.setRegion("BR").build();
	static final NumberFormat NF = NumberFormat.getInstance(LOCALE);
	
	public static void main(String[] args) {
		
		int size = (int) showInputDialog(null, "What is the number of grades?",
				"Number of grades", JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1);
		
		double[] notes = new double[size];
		
		for (int i = 0; i < size; i++) {
			var message = new StringBuilder().append("Enter note").append(SPACE)
					.append(i + 1).append('\u00AA').append(SPACE).append("of")
					.append(SPACE).append(size);
			notes[i] = Double.parseDouble(showInputDialog(null, message,
					"Info notes", JOptionPane.QUESTION_MESSAGE)
					.replace(',', '.').strip());
		}
		
		List<BigDecimal> list = new ArrayList<>();
		
		double sum = 0;
		for (double note : notes) {
			sum += note;
			list.add(BigDecimal.valueOf(note));
		}
		System.out.println(list.stream().reduce((x, y) -> x.add(y)).get());
		System.out.println(sum);
		
		double avg = sum / notes.length;
		System.out.println(avg);
		
		NF.setMaximumFractionDigits(3);
		NF.setMinimumFractionDigits(1);
		NF.setRoundingMode(RoundingMode.HALF_EVEN);
		
		String msg = "%s%nAverage note: %s";
		System.out.println(
				String.format(msg, Arrays.toString(notes), NF.format(avg)));
		
		showMessageDialog(null,
				String.format(msg, Arrays.toString(notes), NF.format(avg)),
				"Result", JOptionPane.INFORMATION_MESSAGE);
		
		BigDecimal reduceMax = list.stream().reduce(BigDecimal::max).get();
		System.out.println("reduceMax: " + reduceMax);
		BigDecimal reduceMin = list.stream().reduce(BigDecimal::min).get();
		System.out.println("reduceMax: " + reduceMin);
		
		BigDecimal maxBy = list.stream()
				.collect(Collectors.maxBy(BigDecimal::compareTo)).get();
		System.out.println("maxBy: " + maxBy);
		BigDecimal minBy = list.stream()
				.collect(Collectors.minBy(BigDecimal::compareTo)).get();
		System.out.println("minBy: " + minBy);
		
		Comparator<BigDecimal> comparator = Comparator.comparing(x -> x);
		
		BigDecimal max = list.stream().max(comparator).get();
		System.out.println("max: " + max);
		BigDecimal min = list.stream().min(comparator).get();
		System.out.println("min: " + min);
		
		BigDecimal sum1 = list.stream().reduce(BigDecimal::add).get();
		System.out.println("Sum 1: " + sum1);
		
		Double sum2 = list.stream()
				.collect(Collectors.summingDouble(BigDecimal::doubleValue));
		System.out.println("Sum 2: " + sum2);
		
		double sum3 = list.stream().mapToDouble(BigDecimal::doubleValue).sum();
		System.out.println("Sum 3: " + sum3);
		
		BinaryOperator<Double> accumulator1 = (x, y) -> x + y;
		
		Double sum4 = list.stream().map(BigDecimal::doubleValue)
				.reduce(accumulator1).get();
		System.out.println("Sum 4: " + sum4);
		
		BinaryOperator<BigDecimal> accumulator2 = (x, y) -> x.add(y);
		
		BigDecimal sumEx1 = list.stream().reduce(accumulator2).get();
		System.out.println("SumEx1: " + sumEx1);
		
		BigDecimal sumEx2 = list.stream()
				.collect(Collectors.reducing(BigDecimal::add)).get();
		System.out.println("SumEx2: " + sumEx2);
		
		Double avg1 = list.stream()
				.collect(Collectors.averagingDouble(BigDecimal::doubleValue));
		System.out.println("Average 1: " + avg1);
		
		double avg2 = list.stream().mapToDouble(BigDecimal::doubleValue)
				.average().orElse(Double.NaN);
		System.out.println("Average 2: " + avg2);
		
		double avg3 = DoubleStream.of(notes).average().orElse(Double.NaN);
		System.out.println("Average 3: " + avg3);
		
	}
	
}
