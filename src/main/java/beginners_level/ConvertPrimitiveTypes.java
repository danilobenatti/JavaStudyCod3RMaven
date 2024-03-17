package beginners_level;

public class ConvertPrimitiveTypes {
	
	public static void main(String[] args) {
		
		double d = 1; // implicitly
		System.out.println(d);
		
		float f = (float) 1.1234567890; // explicitly (cast)
		System.out.println(f);
		
		int i = 127;
		byte b = (byte) i;
		System.out.println(b);
		
		var v = 1.10F;
		double e = Double.parseDouble(String.valueOf(v));
		System.out.println(v + " - " + ((Object) v).getClass().getSimpleName());
		System.out.println(e + " - " + ((Object) e).getClass().getSimpleName());
		
	}
	
}
