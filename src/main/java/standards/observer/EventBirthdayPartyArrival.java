package standards.observer;

import java.util.Date;

public class EventBirthdayPartyArrival {
	
	private final Date moment;
	
	public EventBirthdayPartyArrival(Date moment) {
		this.moment = moment;
	}
	
	public Date getMoment() {
		return this.moment;
	}
	
}
