package lambda;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class PredicateComposition {
	
	private static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(PredicateComposition.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		IntPredicate isEven = n -> n % 2 == 0;
		
		IntPredicate lesserThan = n -> n <= 999;
		IntPredicate greaterThan = n -> n >= 100;
		IntPredicate is3Dig = greaterThan.and(lesserThan);
		
		int num = 122;
		
		log.info(isEven.and(is3Dig).test(num));
		log.info(isEven.and(is3Dig).negate().test(num));
		log.info(isEven.or(is3Dig).test(num));
		
		Predicate<Integer> p1 = n -> n % 2 == 0;
		Predicate<Integer> p2 = n -> n >= 100 && n <= 999;
		log.info(xor(p1, p2).test(num));
		log.info(xor(isEven, is3Dig).test(num));
	}
	
	public static <T> Predicate<T> xor(Predicate<T> p1, Predicate<T> p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
	public static IntPredicate xor(IntPredicate p1, IntPredicate p2) {
		return t -> p1.test(t) ^ p2.test(t);
	}
	
}
