package collection_structure;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class StackCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Deque<String> deque = new ArrayDeque<>();
		
		deque.add("Happy Place");
		deque.add("Yellowface");
		deque.push("Love, Theoretically");
		deque.add("The Little Prince");
		
		for (String str : deque) {
			console.println(str);
		}
		
		console.println(deque.isEmpty());
		console.println(deque.size());
		console.println(deque.contains("Yellowface"));
		
		console.println(deque.peek());
		console.println(deque.element());
		
		console.println(deque.poll());
		console.println(deque.poll());
		console.println(deque.poll());
		console.printf("%s", deque.remove());
		console.println(deque.poll());
		
		console.close();
	}
	
}
