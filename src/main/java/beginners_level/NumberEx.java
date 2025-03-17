package beginners_level;

import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;

import org.apache.commons.lang3.math.NumberUtils;

public class NumberEx {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Number num1 = 5.49;
		Number num2 = 5.5;
		
		float max = NumberUtils.max(num1.floatValue(), num2.floatValue());
		console.println("Max. " + max);
		
		float min = NumberUtils.min(num1.floatValue(), num2.floatValue());
		console.println("Min. " + min);
		
		int compare = Float.compare(num1.floatValue(), num2.floatValue());
		console.println(compare);
		
		if (compare == 0) {
			console.println(num1 + " == " + num2);
		} else if (compare > 0) {
			console.println(num1 + " > " + num2);
		} else if (compare < 0) {
			console.println(num1 + " < " + num2);
		}
		
		MessageFormat msg = new MessageFormat("{0} {1} {2}", Locale.US);
		String str = switch (compare) {
			case 0 -> msg.format(new Object[] { num1, "==", num2 });
			case 1 -> msg.format(new Object[] { num1, ">", num2 });
			case -1 -> msg.format(new Object[] { num1, "<", num2 });
			default -> throw new IllegalArgumentException(
					"Unexpected value: " + compare);
		};
		console.println(str);
		
		console.flush();
		console.close();
	}
	
}
