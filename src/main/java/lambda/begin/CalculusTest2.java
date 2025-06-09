package lambda.begin;

import java.io.PrintWriter;
import java.util.function.Supplier;

public class CalculusTest2 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Calculus calcule = (x, y) -> {
			return x + y;
		};
		
		console.println(calcule.execute(2, 3));
		
		calcule = (x, y) -> x * y;
		
		console.println(calcule.execute(2, 3));
		
		calcule.text();
		
		Supplier<String> msg = calcule::text;
		console.println(msg.get());
		
		console.println(calcule.text());
		
		msg = Calculus::other;
		console.println(msg.get());
		
		console.println(Calculus.other());
		
		console.close();
	}
}
