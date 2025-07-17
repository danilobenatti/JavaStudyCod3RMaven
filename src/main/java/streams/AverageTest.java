package streams;

import java.io.PrintWriter;

public class AverageTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Average avg1 = new Average().add(8.3).add(6.7);
		
		console.println(avg1.getValue());
		
		Average avg2 = new Average();
		avg2.accept(7.9);
		avg2.accept(6.6);
		
		console.println(avg2.getValue());
		
		console.println(Average.combiner(avg1, avg2).getValue());
		
		console.close();
	}
	
}
