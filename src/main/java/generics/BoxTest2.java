package generics;

import java.io.PrintWriter;

public class BoxTest2 {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		BoxGeneric<String> boxA = new BoxGeneric<>();
		boxA.setAnyThing("String");
		
		console.println(boxA.getAnyThing());
		
		console.close();
	}
	
}
