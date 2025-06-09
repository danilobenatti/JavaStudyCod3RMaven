package lambda;

import java.io.PrintWriter;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.function.Predicate;

public class PredicateComposition {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		IntPredicate isEven = n -> n % 2 == 0;
		IntPredicate isOdd = n -> n % 2 != 0;
		
		IntPredicate lesserThan = n -> n <= 999;
		IntPredicate greaterThan = n -> n >= 100;
		
		IntPredicate is3Dig = greaterThan.and(lesserThan);
		
		int num = 122;
		
		console.println(isEven.and(is3Dig).test(num));
		console.println(isEven.and(is3Dig).negate().test(num));
		console.println(isEven.or(is3Dig).test(num));
		
		Predicate<Long> even = n -> n % 2 == 0;
		Predicate<Long> range = n -> n >= 100 && n <= 999;
		console.println(xor(even, range).test((long) num));
		console.println(xor(isOdd, is3Dig).test(num));
	}
	
	public static <T> Predicate<T> xor(Predicate<T> p1, Predicate<T> p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
	public static IntPredicate xor(IntPredicate p1, IntPredicate p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
	public static LongPredicate xor(LongPredicate p1, LongPredicate p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
	public static DoublePredicate xor(DoublePredicate p1, DoublePredicate p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
}
