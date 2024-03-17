package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class StreamsBegin {
	
	static Logger log = LogManager.getLogger();
	
	public static void main(String[] args) {
		
		Configurator.initialize(StreamsBegin.class.getName(),
				"./src/main/java/util/log4j2.properties");
		
		Consumer<Object> print = System.out::print;
		
		Stream<String> langsBackEnd = Stream.of("Java ", "C# ", "JS ", "PHP\n");
		langsBackEnd.forEach(print);
		
		Stream.of("Go", "Ruby on Rails", "Angular", "Node.js")
				.forEach(s -> log.printf(Level.INFO, ">>> %s", s));
		
		String[] langsFrontEnd = { "HTML ", "CSS ", "TypeScript ", "JS\n" };
		
		Stream.of(langsFrontEnd).forEach(print);
		Arrays.stream(langsFrontEnd).forEach(print);
		Arrays.stream(langsFrontEnd, 1, 3).forEach(print);
		
		List<String> othersLangs = Arrays.asList("Assembly ", "Basic ", "C ",
				"C++ ", "Cobol ", "Fortran\n");
		
		othersLangs.stream().forEach(print);
		othersLangs.parallelStream().forEach(print);
		
	}
	
}
