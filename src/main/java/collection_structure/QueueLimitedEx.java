package collection_structure;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class QueueLimitedEx {
	
	public static class SizeLimitedQueue<E> extends LinkedList<E> {
		
		private static final long serialVersionUID = 1L;
		
		private int QueueLimit;
		
		public SizeLimitedQueue(int QueueLimit) {
			this.QueueLimit = QueueLimit;
		}
		
		@Override
		public boolean add(E e) {
			while (this.size() == QueueLimit) {
				super.remove();
			}
			super.add(e);
			return true;
		}
	}
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Queue<Integer> queue = new SizeLimitedQueue<>(4);
		
		for (int i = 0; i < 6; i++) {
			queue.add(i);
		}
		
		console.println("Size of queue: " + queue.size());
		
		console.println("Elements of queue: " + queue);
		
		Integer removed = queue.remove();
		
		console.println("Removed element: " + removed);
		
		console.println("Elements of queue: " + queue);
		
		Integer head = queue.peek();
		
		console.println("Head of queue: " + head);
		
		console.println("Elements of queue: " + queue);
		
		for (int i = 6; i < 8; i++)
			if (queue.add(i))
				console.printf("add: %s\n", i);
			
		console.println("Elements of queue: " + queue);
		
		console.close();
	}
	
}
