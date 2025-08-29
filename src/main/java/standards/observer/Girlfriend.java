package standards.observer;

public class Girlfriend implements ObserverArrivalBirthdayParty {
	
	@Override
	public void itArrived(EventBirthdayPartyArrival event) {
		System.out.println("Notify guests!");
		System.out.println("Turn off lights.");
		System.out.println("Wait...");
		System.out.println("Everyone screams...SURPRISE!!!");
	}
	
}
