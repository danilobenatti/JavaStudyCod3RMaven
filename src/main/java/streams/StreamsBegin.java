package streams;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsBegin {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		Consumer<Object> println = System.out::println;
		
		Stream<String> langsBackEnd = Stream.of("Java ", "C# ", "JS ", "PHP");
		langsBackEnd.forEach(println);
		console.println();
		
		Stream.of("Go", "Ruby on Rails", "Angular", "Node.js")
				.forEach(s -> console.printf(">>> %s%n", s));
		console.println();
		
		String[] langsFrontEnd = { "HTML ", "CSS ", "TypeScript ", "JS" };
		
		Stream.of(langsFrontEnd).forEach(println);
		console.println();
		
		Arrays.stream(langsFrontEnd).forEach(println);
		console.println();
		
		Arrays.stream(langsFrontEnd, 1, 3).forEach(println);
		console.println();
		
		List<String> othersLangs = Arrays.asList("Assembly ", "Basic ", "C ",
				"C++ ", "Cobol ", "Fortran");
		
		othersLangs.stream().forEach(println);
		console.println();
		
		othersLangs.parallelStream().forEach(println);
		
		console.close();
	}
	
}
