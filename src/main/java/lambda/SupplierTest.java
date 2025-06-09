package lambda;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Supplier<List<String>> list = () -> Arrays.asList("Lion", "Keth",
				"Beth", "Paul");
		
		console.println(list.get());
		
		console.close();
	}
	
}
