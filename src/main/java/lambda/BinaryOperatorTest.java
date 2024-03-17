package lambda;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.function.DoubleBinaryOperator;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class BinaryOperatorTest {
	
	static Logger log = LogManager.getLogger();
	
	static double value1 = 9.8;
	static double value2 = 5.7;
	
	public static void main(String[] args) {
		
		Configurator.initialize(BinaryOperatorTest.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		DoubleBinaryOperator avg = (n1, n2) -> (n1 + n2) / 2;
		
		BiFunction<Double, Double, String> result = (n1,
				n2) -> avg.applyAsDouble(n1, n2) >= 7.5 ? "Approved"
						: "Repproved";
		
		log.info(() -> StringUtils.joinWith(SPACE, "Average 1:",
				avg.applyAsDouble(value1, value2),
				result.apply(value1, value2)));
		
		value2 = 4.7;
		
		log.info(() -> new StringBuilder().append("Average 2: ")
				.append(avg.applyAsDouble(value1, value2)).append(SPACE)
				.append(result.apply(value1, value2)));
		
		value1 = 10;
		
		log.info(() -> new StringJoiner(SPACE).add("Average 3:")
				.add(String.valueOf(avg.applyAsDouble(value1, value2)))
				.add(result.apply(value1, value2)).toString());
	}
}
