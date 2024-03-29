package standards.observer;

public class Girlfriend implements ObserverArrivalBirthdayParty {
	
	@Override
	public void itArrived(EventBirthdayPartyArrival event) {
		System.out.println("Guest has arrived!");
	}
	
}
