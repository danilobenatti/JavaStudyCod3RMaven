package beginners_level;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.LF;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.math3.util.MathUtils;

public class CalculateAreaOfCircle {
	
	static NumberFormat nf = NumberFormat
		.getNumberInstance(Locale.of("pt", "BR"));
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		nf.setMinimumFractionDigits(5);
		
		final double PI = 3.14159;
		
		console.println(PI);
		console.println(PI == Math.PI);
		
		double radius = Double.parseDouble(showInputDialog(null, "Inform radiu",
			"Input Value", QUESTION_MESSAGE));
		double diameter = 2 * radius;
		
		double areaByRadio = Math.PI * Math.pow(radius, 2);
		
		double areaByDiameter = Math.PI * Math.pow(diameter, 2) / 4;
		
		double perimeterByRadio = MathUtils.TWO_PI * radius;
		double perimeterByDiameter = Math.PI * diameter;
		
		console.println(areaByRadio);
		console.println(areaByDiameter);
		console.println(perimeterByRadio);
		console.println(perimeterByDiameter);
		
		console.printf("Area by radius: %s%c%n", nf.format(areaByRadio),
			'\u339F');
		console.printf("Area by \u2205: %.5f%c%n", areaByDiameter, '\u339F');
		console.printf("Perimeter by radius: %s%c%n",
			nf.format(perimeterByRadio), '\u339C');
		console.printf("Perimeter by \u2205: %.6f%c%n", perimeterByDiameter,
			'\u339C');
		
		StringBuilder sb = new StringBuilder();
		sb.append("Radius info: ");
		sb.append(radius).append(LF);
		sb.append("Area by radius: ");
		sb.append(nf.format(areaByRadio)).append('\u339F').append(LF);
		sb.append("Area by \u2205: ");
		sb.append(nf.format(areaByDiameter)).append('\u339F').append(LF);
		sb.append("Perimeter by radius: ");
		sb.append(nf.format(perimeterByRadio)).append('\u339C').append(LF);
		sb.append("Perimeter by \u2205: ");
		sb.append(nf.format(perimeterByDiameter)).append('\u339C');
		showMessageDialog(null, sb, "Result calc.", INFORMATION_MESSAGE);
		
	}
}
