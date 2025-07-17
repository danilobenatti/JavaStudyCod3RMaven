package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class MapFirstSteps {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<Number> list = Arrays.asList(3, 1, 7, 4, 6, 5, 8, 10, 9, 2);
		
		list.stream().map(n -> n.longValue() * 2).forEach(n -> console.printf("%d\s", n));
		console.println();
		
		list.stream().map(n -> n.longValue() - 2).forEach(n -> console.printf("%d\s", n));
		console.println();
		
		console.close();
	}
	
}
