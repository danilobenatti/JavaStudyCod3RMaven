package standards.observer;

public class SurpriseBirthday {
	
	public static void main(String[] args) {
		
		Girlfriend girlfriend = new Girlfriend();
		Doorman doorman = new Doorman();
		
		doorman.recordsObservers(girlfriend);
		doorman.recordsObservers(e -> {
			System.out.println("Lambda Surprise!!!");
			System.out.println("In day: " + e.getMoment());
		});
		doorman.tracking();
	}
}
