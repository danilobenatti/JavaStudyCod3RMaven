package beginners_level;

import java.io.PrintWriter;

public class TernaryOperator {
	
	private static final String APP = "Approved";
	private static final String REC = "Recovery";
	private static final String DIS = "Disapproved";
	
	public static void main(String[] args) {
		
		PrintWriter console = new PrintWriter(System.out, true);
		
		double avg = 4.9;
		
		String result = avg >= 7.0 ? APP : avg >= 5.0 ? REC : DIS;
		console.println(result);
		
		avg = 6;
		
		if (avg >= 7.0) {
			result = APP;
		} else if (avg >= 5.0) {
			result = REC;
		} else {
			result = DIS;
		}
		console.println(result);
		
		console.println(test(7.6));
		
	}
	
	public static String test(double avg) {
		if (avg >= 7.0) {
			return APP;
		}
		return avg >= 5.0 ? REC : DIS;
	}
	
}
