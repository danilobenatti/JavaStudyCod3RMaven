package beginners_level;

public class Inference {
	
	public static void main(String[] args) {
		
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
		System.out.println("a) " + getType(a) + ", " + Double.MAX_VALUE);
		System.out.println("b) " + getType(b) + ", " + Double.MIN_VALUE);
		System.out.println("c) " + getType(c));
		System.out.println("d) " + getType(d));
		System.out.println("e+) " + getType(ep) + ", " + Float.MAX_VALUE);
		System.out.println("e-) " + getType(en) + ", " + Float.MIN_VALUE);
		System.out.println("f+) " + getType(fp) + ", " + Long.MAX_VALUE);
		System.out.println("f-) " + getType(fn) + ", " + Long.MIN_VALUE);
		System.out.println("g) " + getType(g));
		System.out.println("h) " + getType(h) + ", " + h + ", " + hs);
		System.out.println("i) " + getType(i));
		System.out.println("j) " + getType(j));
		
	}
	
	private static String getType(Object a) {
		return a.getClass().getSimpleName();
	}
	
}
