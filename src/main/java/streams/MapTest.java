package streams;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

import util.StreamUtil;

public class MapTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		List<String> mark = new ArrayList<>();
		mark.addAll(Arrays.asList("Nike", "Adidas", "Skechers"));
		
		mark.stream().map(String::toUpperCase).forEach(s -> console.println(s));
		
		mark.add("New Balance");
		mark.add("Penalty");
		
		UnaryOperator<String> append = n -> n.concat("!!!");
		
		mark.stream().map(StreamUtil.upperCase).forEach(console::println);
		
		mark.stream().map(StreamUtil.upperCase_).forEach(console::println);
		
		mark.stream().map(StreamUtil.lowerCase).forEach(console::println);
		
		mark.stream().map(StreamUtil.lowerCase_).forEach(console::println);
		
		mark.stream().map(StreamUtil.firstLetter.andThen(StreamUtil.upperCase))
				.forEach(console::println);
		
		mark.stream().map(StreamUtil.firstLetter_.andThen(StreamUtil.upperCase_))
				.forEach(console::println);
		
		mark.stream().map(StreamUtil.lastLetter).forEach(console::println);
		mark.stream().map(StreamUtil.lastLetter_).forEach(console::println);
		
		mark.stream().map(StreamUtil.upperCase).map(StreamUtil.firstLetter)
				.map(append).forEach(console::println);
		
		mark.stream().map(StreamUtil.lowerCase).map(StreamUtil.lastLetter)
				.map(StreamUtil::addExclamationMark).forEach(console::println);
		
		console.close();
	}
	
}
