package collection_structure;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class MessySetCode {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		HashSet set = new HashSet(); // Avoid this approach.
		set.add(1.2); // double -> Double
		set.add(true); // boolean -> Boolean
		set.add("Test"); // String
		set.add(1); // int -> Integer
		set.add('X'); // char -> Character
		
		String msg = "Size of 'set': %d%n";
		console.printf(msg, set.size());
		
		set.add("Test");
		set.add('x');
		
		console.printf(msg, set.size());
		
		console.println("Remove 'test'? " + set.remove("test"));
		console.println("Remove 'Test'? " + set.remove("Test"));
		console.println("If contains 'x' then remove 'x'? "
				+ (set.contains('x') && set.remove('x')));
		console.println("Contains 'x'? " + set.contains('x'));
		console.println("Contains 1.2(float)? " + set.contains(1.2f));
		console.println("Contains 1.2(double)? " + set.contains(1.2));
		
		console.printf(msg, set.size());
		
		Set numbers = new HashSet();
		numbers.add(1.1);
		numbers.add(1.2);
		numbers.add(1.3);
		
		console.println(numbers);
		console.println(set);
		
		console.println(set.addAll(numbers));
		console.println(set);
		console.println(set.retainAll(numbers)); // common values, intersection
		console.println(set);
		
		set.clear();
		console.println(set);
		
		console.close();
	}
	
}
