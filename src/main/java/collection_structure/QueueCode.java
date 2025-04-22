package collection_structure;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCode {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Queue<String> queue = new LinkedList<>();
		
		boolean addPeter = queue.add("Peter");
		console.println("add 'Peter'? " + addPeter);
		
		boolean offerJohn = queue.offer("John");
		console.println("offer 'John'? " + offerJohn);
		
		queue.add("Mary");
		queue.offer("Will");
		queue.add("Anne");
		queue.offer("Cloe");
		
		console.println("show queue: " + queue);
		
		console.println("isEmpty: " + queue.isEmpty());
		console.println("size: " + queue.size());
		console.println("contains: " + queue.contains("Cloe"));
		
		Collection<String> values = Arrays.asList("Cloe", "Will", "Marie");
		
		console.println("containsAll: " + queue.containsAll(values));
		
		console.println("1º peek: " + queue.peek());
		console.println("2º peek: " + queue.peek());
		console.println("1º element: " + queue.element());
		console.println("2º element: " + queue.element());
		
		console.println(queue.poll());
		console.println(queue.remove());
		
		for (String str : queue) {
			console.println(">>> " + str + " <<<");
		}
		
		queue.clear();
		console.println(queue);
		
		console.close();
	}
	
}
