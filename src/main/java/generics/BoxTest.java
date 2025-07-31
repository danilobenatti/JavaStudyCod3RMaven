package generics;

import java.io.PrintWriter;

public class BoxTest {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		BoxWithSomeThings boxA = new BoxWithSomeThings();
		boxA.setThing(2.3);
		
		Double thingA = (Double) boxA.getThing();
		console.println(thingA);
		
		BoxWithSomeThings boxB = new BoxWithSomeThings();
		boxB.setThing("Hey!");
		
		String thingB = (String) boxB.getThing();
		console.println(thingB);
		
		console.close();
	}
	
}
