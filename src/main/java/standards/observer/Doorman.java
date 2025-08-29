package standards.observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Doorman {
	
	private List<ObserverArrivalBirthdayParty> observers = new ArrayList<>();
	
	public void recordsObservers(ObserverArrivalBirthdayParty observer) {
		this.observers.add(observer);
	}
	
	public void tracking() {
		try (Scanner scanner = new Scanner(System.in)) {
			String value = "";
			while (!value.equalsIgnoreCase("exit")) {
				System.out.println("Birthday person it arrived?");
				value = scanner.next();
				if (value.equalsIgnoreCase("yes")) {
					// Create the event.
					EventBirthdayPartyArrival event = new EventBirthdayPartyArrival(new Date());
					// Notify observers.
					observers.stream().forEach(o -> o.itArrived(event));
					value = "exit";
				} else {
					System.out.println("Not yet!!!");
				}
			}
		}
	}
}
