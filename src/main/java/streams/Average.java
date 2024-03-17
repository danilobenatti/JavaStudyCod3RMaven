package streams;

import java.util.function.DoubleConsumer;

public class Average implements DoubleConsumer {
	
	private double total;
	private int count;
	
	public double average() {
		return count > 0 ? total / count : 0;
	}
	
	@Override
	public void accept(double value) {
		total += value;
		count++;
	}
	
	public static Average combine(Average average1, Average average2) {
		Average average = new Average();
		average.total = average1.total + average2.total;
		average.count = average1.count + average2.count;
		return average;
	}
}
