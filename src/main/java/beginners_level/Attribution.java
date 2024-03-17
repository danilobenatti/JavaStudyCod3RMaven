package beginners_level;

public class Attribution {
	
	public static void main(String[] args) {
		
		int a = 3;
		int b = a;
		int c = a + b;
		
		c += b; // c = c + b;
		c -= a; // c = c - a;
		c *= b; // c = c * b;
		c /= a; // c = c / 3;
		System.out.println(c);

		c %= 2; // c = c % 2;
		System.out.println(c);
	}
	
}
