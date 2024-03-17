package collection_structure;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCode {
	
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<>();
		
		boolean addPeter = queue.add("Peter");
		boolean offerJohn = queue.offer("John");
		System.out.println(addPeter);
		System.out.println(offerJohn);
		queue.add("Mary");
		queue.offer("Will");
		queue.add("Anne");
		queue.offer("Cloe");
		
		System.out.println(queue.isEmpty());
		System.out.println(queue.size());
		System.out.println(queue.contains("Cloe"));
		Collection<String> values = Arrays.asList("Cloe","Will","Mary");
		System.out.println(queue.containsAll(values));
		
		System.out.println(queue.peek());
		System.out.println(queue.peek());
		System.out.println(queue.element());
		System.out.println(queue.element());
		
		System.out.println(queue.poll());
		System.out.println(queue.remove());
		
		for (String str : queue) {
			System.out.println(">>> " + str);
		}
		
		queue.clear();
		System.out.println(queue);
	}
	
}
