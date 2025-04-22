package collection_structure;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueCodeStudy {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Queue<String> queue = new LinkedList<>();
		
		console.println("Queue elements: " + queue);
		
		queue.add("apple");
		queue.add("banana");
		queue.add("cherry");
		
		console.println("Queue elements: " + queue);
		
		String apple = queue.remove();
		console.println("remove() method: " + apple);
		
		console.println("Queue elements: " + queue);
		
		queue.add("pineapple");
		
		String banana = queue.peek();
		console.println("Peeked element: " + banana);
		
		console.println("Queue elements: " + queue);
		
		int size = queue.size();
		console.println("Size of queue: " + size);
		
		Iterator<String> iterator = queue.iterator();
		
		while (iterator.hasNext()) {
			console.print(iterator.next());
			console.print(iterator.hasNext() ? ",\s" : "");
		}
		
		console.close();
	}
	
}
