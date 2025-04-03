package beginners_level;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import static org.apache.commons.lang3.StringUtils.LF;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class CalculateAreaOfCircle {
	
	static final Locale LOCALE_BR = Locale.of("pt", "BR");
	static final NumberFormat NF = NumberFormat.getNumberInstance(LOCALE_BR);
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		NF.setMinimumFractionDigits(5);
		
		final double PI = 3.14159;
		
		console.println(PI);
		console.println(PI == Math.PI);
		console.println(MathUtils.TWO_PI);
		console.println(MathUtils.PI_SQUARED);
		
		double radius = Double.parseDouble(showInputDialog(null, "Inform radiu",
			"Input Value", QUESTION_MESSAGE));
		double diameter = 2 * radius;
		
		double areaByRadio = Math.PI * Math.pow(radius, 2);
		
		double areaByDiameter = Math.PI * Math.pow(diameter, 2) / 4;
		
		double perimeterByRadio = MathUtils.TWO_PI * radius;
		double perimeterByDiameter = FastMath.PI * diameter;
		
		console.println(areaByRadio);
		console.println(areaByDiameter);
		console.println(perimeterByRadio);
		console.println(perimeterByDiameter);
		
		console.printf("Area by radius: %s%c%n", NF.format(areaByRadio), '\u339F');
		console.printf("Area by \u2205: %.5f%c%n", areaByDiameter, '\u339F');
		console.printf("Perimeter by radius: %s%c%n", NF.format(perimeterByRadio), '\u339C');
		console.printf("Perimeter by \u2205: %.6f%c%n", perimeterByDiameter, '\u339C');
		
		StringBuilder sb = new StringBuilder();
		sb.append("Radius info: ");
		sb.append(radius).append(LF);
		sb.append("Area by radius: ");
		sb.append(NF.format(areaByRadio)).append('\u339F').append(LF);
		sb.append("Area by \u2205: ");
		sb.append(NF.format(areaByDiameter)).append('\u339F').append(LF);
		sb.append("Perimeter by radius: ");
		sb.append(NF.format(perimeterByRadio)).append('\u339C').append(LF);
		sb.append("Perimeter by \u2205: ");
		sb.append(NF.format(perimeterByDiameter)).append('\u339C');
		
		showMessageDialog(null, sb, "Result calc.", INFORMATION_MESSAGE);
		
	}
}
