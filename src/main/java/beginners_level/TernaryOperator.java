package beginners_level;

public class TernaryOperator {
	
	private static final String APP = "Approved";
	private static final String REC = "Recovery";
	private static final String DIS = "Disapproved";
	
	public static void main(String[] args) {
		
		double avg = 6.6;
		String result = avg >= 7.0 ? APP : avg >= 5.0 ? REC : DIS;
		System.out.println(result);
		
		if (avg >= 7.0) {
			result = APP;
		} else if (avg >= 5.0) {
			result = REC;
		} else {
			result = DIS;
		}
		System.out.println(result);
		
	}
	
}
