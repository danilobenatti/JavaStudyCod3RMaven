package generics;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.TreeSet;

public class ComparableTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		TreeSet<MyNumber> numbers = new TreeSet<>(Collections.reverseOrder());
		
		numbers.add(new MyNumber(10));
		numbers.add(new MyNumber(1));
		numbers.add(new MyNumber(3));
		numbers.add(new MyNumber(6));
		numbers.add(new MyNumber(8));
		numbers.add(new MyNumber(9));
		numbers.add(new MyNumber(123));
		numbers.add(new MyNumber(-13));
		
		for (MyNumber number : numbers) {
			console.println(number);
		}
		
		console.close();
	}
	
}

class MyNumber implements Comparable<MyNumber> {
	
	private int value;
	
	public MyNumber(int value) {
		this.value = value;
	}
	
	@Override
	public int compareTo(MyNumber other) {
		return Integer.compare(this.value, other.value);
	}
	
	@Override
	public String toString() {
		return "MyNumber(" + this.value + ")";
	}
	
}
