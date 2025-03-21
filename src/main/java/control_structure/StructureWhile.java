package control_structure;

import static org.apache.commons.lang3.StringUtils.SPACE;

import java.io.PrintWriter;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;

public class StructureWhile {
	
	static PrintWriter console = new PrintWriter(System.out, true);
	
	static final int FIND = 25;
	
	public static void main(String[] args) {
		
		// 0 - 9 (integer)
		console.println(new Random().nextInt(0, 11));
		
		// between 10 and 100 (integer)
		int min = 10;
		int max = 100;
		// find by 26 (integer)
		
		// solution 1
		int i = 0;
		int j = FIND + 1;
		while (j != FIND) {
			j = (new Random().nextInt(max - min + 1) + min);
			i++;
		}
		message(i, FIND);
		
		// solution 2
		int k = 0;
		int l = 0;
		do {
			l = new Random().nextInt(max - min + 1);
			k++;
		} while (l != FIND);
		message_(k, FIND);
		
		// between the origin (inclusive) and the bound (exclusive)
		console.println("Random[0 - 100]: " + new Random().nextInt(0, 101));
		
		console.println(ThreadLocalRandom.current().nextInt(0, 10));
		console.println(ThreadLocalRandom.current().nextBoolean());
		
		for (String v = "#"; !v.equals("######"); v = v.concat("#")) {
			console.println(v);
		}
		
		console.flush();
		console.close();
	}
	
	public static void message(int i, int find) {
		console.println(new StringBuilder().append("Loop ").append(i)
				.append(SPACE).append("times until finding n").append('\u00BA')
				.append(SPACE).append(find));
	}
	
	public static void message_(int i, int find) {
		console.println(new StringJoiner("\s").add("Loop")
				.add(String.valueOf(i)).add("times until finding nº")
				.add(String.valueOf(find)));
	}
}
