package beginners_level;

public class UnaryOperators {
	
	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		
		a++; // a = a + 1
		a--; // a = a - 1
		
		++b; // b = b + 1
		--b; // b = b - 1
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("Chalenge");
		System.out.println(++a == b--); // 2 - 2
		System.out.println(a == b); // 2 - 1
		System.out.println(a);
		System.out.println(b);
		
	}
	
}
