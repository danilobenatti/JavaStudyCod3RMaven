package streams;

import java.util.function.DoubleConsumer;

public class AvgDouble implements DoubleConsumer {
	
	private double total = 0;
	private int count = 0;
	
	public double average() {
		return count > 0 ? total / count : 0;
	}
	
	public void combine(AvgDouble other) {
		total += other.total;
		count += other.count;
	}
	
	@Override
	public void accept(double value) {
		total += value;
		count++;
	}
	
}
