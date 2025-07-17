package streams;

import java.util.function.DoubleConsumer;

public class Average implements DoubleConsumer {
	
	private double total;
	private int count;
	
	public double getValue() {
		return count > 0 ? total / count : 0;
	}
	
	@Override
	public void accept(double value) {
		total += value;
		count++;
	}
	
	public Average add(double value) {
		total += value;
		count++;
		return this;
	}
	
	public static Average combiner(Average avg1, Average avg2) {
		Average avg = new Average();
		avg.total = avg1.total + avg2.total;
		avg.count = avg1.count + avg2.count;
		return avg;
	}
}
