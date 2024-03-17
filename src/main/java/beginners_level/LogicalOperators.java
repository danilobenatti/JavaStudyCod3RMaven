package beginners_level;

public class LogicalOperators {
	
	public static void main(String[] args) {
		
		boolean a = 3 < 7; // true
		boolean b = 3 > 7; // false
		
		System.out.println(String.format("Ex.: AND -> %s", a && b)); // AND
		System.out.println(String.format("Ex.: OR -> %s", a || b)); // OR
		System.out.println(String.format("Ex.: XOR -> %s", a ^ !b)); // XOR
		System.out.println(a);
		System.out.println(!b);
		
	}
	
}
