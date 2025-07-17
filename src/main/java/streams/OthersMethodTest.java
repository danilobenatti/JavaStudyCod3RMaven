package streams;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public class OthersMethodTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<String> list = new ArrayList<>();
		list.add("Boo");
		list.add("Foo");
		list.add("Boo");
		list.add("Foo");
		list.add("Gel");
		list.add("Yoh");
		list.add("Bar");
		list.add("Gel");
		list.add("Bar");
		list.add("Orn");
		
		list.stream().forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <all> ---\n");
		
		list.stream().distinct().forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <Distinct> ---\n");
		
		list.stream().distinct().skip(2).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <Skip> ---\n");
		
		list.stream().distinct().limit(2).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <Limit> ---\n");
		
		list.stream().distinct().skip(2).limit(1).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <Skip and Limit> ---\n");
		
		list.stream().distinct().limit(2).skip(1).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <Limit and Skip> ---\n");
		
		Predicate<String> predicate1 = l -> !l.contains("Y");
		
		Predicate<String> predicate2 = l -> l.charAt(0) != 'Y';
		
		Predicate<String> predicate3 = l -> l.endsWith("o");
		
		Predicate<String> predicate4 = l -> StringUtils.containsIgnoreCase(l, "O");
		
		list.stream().distinct().filter(predicate1).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <predicate1> ---\n");
		
		list.stream().distinct().takeWhile(predicate2).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <predicate2> ---\n");
		
		list.stream().distinct().filter(predicate3).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <predicate3> ---\n");
		
		list.stream().distinct().filter(predicate4).forEach(l -> console.printf("%s\s", l));
		console.print("\n--- <predicate4> ---\n");
		
		console.close();
	}
	
}
