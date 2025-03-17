package beginners_level;

import java.io.PrintWriter;

public class Inference {
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		var a = 1.797E+308;
		var b = 4.9E-324;
		var c = 4.5D;
		var d = 4.5;
		var ep = 3.4E38F;
		var en = 1.4E-45F;
		var fp = 9_223_372_036_854_775_807L;
		var fn = -9_223_372_036_854_775_808L;
		var g = 45;
		var h = (short) -32768;
		short hs = (short) (h + h);
		var i = '4';
		var j = "4.50";
		
		console.println("a) " + getType(a) + ", " + Double.MAX_VALUE);
		console.println("b) " + getType(b) + ", " + Double.MIN_VALUE);
		console.println("c) " + getType(c));
		console.println("d) " + getType(d));
		console.println("e+) " + getType(ep) + ", " + Float.MAX_VALUE);
		console.println("e-) " + getType(en) + ", " + Float.MIN_VALUE);
		console.println("f+) " + getType(fp) + ", " + Long.MAX_VALUE);
		console.println("f-) " + getType(fn) + ", " + Long.MIN_VALUE);
		console.println("g) " + getType(g));
		console.println("h) " + getType(h) + ", " + h + ", " + hs);
		console.println("i) " + getType(i));
		console.println("j) " + getType(j));
		
		console.close();
	}
	
	private static String getType(Object obj) {
		return obj.getClass().getSimpleName();
	}
	
}
