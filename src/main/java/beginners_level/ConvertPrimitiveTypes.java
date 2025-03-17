package beginners_level;

import java.io.PrintWriter;

public class ConvertPrimitiveTypes {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		double d = 1; // implicitly
		console.println(d);
		
		float f = (float) 1.1234567890; // explicitly (cast)
		console.println(f);
		
		int i = 128;
		byte b = (byte) i;
		console.println(b);
		
		var v = 1.10F;
		double e = Double.parseDouble(String.valueOf(v));
		console.println(v + " - " + ((Object) v).getClass().getSimpleName());
		console.println(e + " - " + ((Object) e).getClass().getSimpleName());
		
		console.close();
		
	}
	
}
