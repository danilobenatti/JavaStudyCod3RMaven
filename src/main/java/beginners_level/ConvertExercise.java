package beginners_level;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class ConvertExercise {
	
	static Locale locale = new Locale.Builder().setLanguage("pt")
			.setRegion("BR").build();
	
	public static void main(String[] args) {
		
		Locale.setDefault(locale);
		
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		
		ArrayList<Double> list = new ArrayList<>();
		
		try (Scanner scanner = new Scanner(System.in).useLocale(locale);
				PrintWriter console = new PrintWriter(System.out, true)) {
			console.println(locale.getDisplayName());
			console.printf("%s (%s)%n",
					Currency.getInstance(locale).getDisplayName(),
					Currency.getInstance(locale).getSymbol());
			for (int i = 1; i <= 3; i++) {
				console.println(new StringBuilder().append("Info").append(SPACE)
						.append(i).append("\u00BA").append(SPACE)
						.append("salary:").append(SPACE));
				list.add(Double.valueOf(scanner.next().replace(',', '.')));
			}
			
			// calculate the average of the last three salaries.
			console.println(String.format("Major Salary is: %s", nf.format(
					list.stream().mapToDouble(i -> i).max().getAsDouble())));
			console.println(String.format("Minor Salary is: %s", nf.format(
					list.stream().mapToDouble(i -> i).min().getAsDouble())));
			console.println(String.format("Total Salary is: %s",
					nf.format(list.stream().mapToDouble(i -> i).sum())));
			console.println(String.format("Quantity Salary is: %d",
					list.stream().mapToDouble(i -> i).count()));
			console.println(String.format("Average Salary is: %s",
					nf.format(list.stream().mapToDouble(i -> i).average().getAsDouble())));
		}
		
	}
	
}
