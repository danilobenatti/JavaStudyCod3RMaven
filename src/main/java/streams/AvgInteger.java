package streams;

import java.util.function.IntConsumer;

public class AvgInteger implements IntConsumer {
	
	private int total = 0;
	private int count = 0;
	
	public double average() {
		return count > 0 ? ((double) total) / count : 0;
	}
	
	public void combine(AvgInteger other) {
		total += other.total;
		count += other.count;
	}
	
	@Override
	public void accept(int value) {
		total += value;
		count++;
	}
	
}
