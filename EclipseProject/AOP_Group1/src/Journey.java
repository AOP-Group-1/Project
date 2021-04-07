import java.util.LinkedList;
import java.util.UUID;

class Container {
	private String ContainerID;

	public Container() {
		this.ContainerID = UUID.randomUUID().toString();
	}

	public String getContainerID() {
		return this.ContainerID;
	}
}

enum criticalArea {
	US("United States"), CHINA("People's Republic of China"), MEXICO("Mexico");

	private String fullName;

	private criticalArea(String name) {
		this.fullName = name.toUpperCase();
	}

	public String getFullName() {
		return this.fullName;
	}

}

public class Journey {
	private String journeyID;
	private String origin;
	private String destination;
	private String contentType;
	private String company;
	private String containerID;
	private String currentLocation;
	private LinkedList<String> travelHistory;
	private boolean journeyComplete;

	// All journeys are stored in this linked list
	private static LinkedList<Journey> ALLJOURNEYS = new LinkedList();

	public Journey(String origin, String destination, String contentType, String company, Container container) {
		for (criticalArea country : criticalArea.values()) {
			if (country.getFullName().equals(destination.toUpperCase())) {
				System.out.println("Shipping to chosen destination unavailable,registration denied");
				return;
			}
		}

		if (origin.equals(destination)) {
			System.out.println("Origin and destination can not be the same");
			return;
		}
		this.journeyID = UUID.randomUUID().toString();
		this.containerID = container.getContainerID();
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		this.currentLocation = origin;
		this.journeyComplete = false;
		this.travelHistory = new LinkedList();
		this.travelHistory.addLast(currentLocation);
		ALLJOURNEYS.addLast(this);
	}

	public String getJourneyID() {
		return this.journeyID;
	}

	// Update journey info
	public void updateJourneyInfo(String destination, String contentType, String currentLocation) {
		if (this.journeyComplete) {
			System.out.println("Update denied,jouney already complete");
			return;
		}
		if (destination != null) {
			this.destination = destination;
		}
		if (contentType != null)
			this.contentType = contentType;
		if (currentLocation != null) {
			this.currentLocation = currentLocation;
			if (this.destination.equals(this.currentLocation)) {
				this.journeyComplete = true;
			}
			this.travelHistory.addLast(this.currentLocation);
		}
	}

	public void showTravelHistory() {
		System.out.println("History of journey " + this.getJourneyID() + ":");
		System.out.println("Origin:" + travelHistory.getFirst());
		System.out.println("Destination:" + this.destination);
		System.out.println("Complete footprint:");
		for (int i = 0; i < travelHistory.size() - 1; i++) {
			System.out.print(travelHistory.get(i) + "==>");
		}
		System.out.print(travelHistory.getLast()+"\n");
	}
	public static void showContainerHistory(Container container) {
		LinkedList<Journey> journeys=new LinkedList();
		journeys=searchForJourneys(null,null,null,null,container);
		System.out.println("Journeys done by container"+container.getContainerID()+":");
		for(Journey j:journeys) {
			j.showTravelHistory();
			System.out.println();
		}
	}
	
	public void cancelJourney() {
		ALLJOURNEYS.remove(this);
	}

	// Search from ALLJOURNEYS based on filters;
	public static LinkedList<Journey> searchForJourneys(String orig, String dest, String cont, String comp,Container container) {
		LinkedList<Journey> filter = new LinkedList();
		LinkedList<Journey> filter1 = new LinkedList();
		LinkedList<Journey> filter2 = new LinkedList();
		LinkedList<Journey> filter3 = new LinkedList();
		LinkedList<Journey> filter4 = new LinkedList();
		if (orig != null) {
			for (Journey j : ALLJOURNEYS) {
				if (j.origin.equals(orig))
					filter.addLast(j);
			}
		} else {
			filter = ALLJOURNEYS;
		}

		if (dest != null) {
			for (Journey j : filter) {
				if (j.destination.equals(dest)) {
					filter1.addLast(j);
				}
			}

		} else {
			filter1 = filter;
		}

		if (cont != null) {
			for (Journey j : filter1) {
				if (j.contentType.equals(cont)) {
					filter2.addLast(j);
				}
			}
		} else {
			filter2 = filter1;
		}

		if (comp != null) {
			for (Journey j : filter2) {
				if (j.company.equals(comp)) {
					filter3.addLast(j);
				}
			}

		} else {
			filter3 = filter2;
		}
		
		if (container != null) {
			for (Journey j : filter3) {
				if (j.containerID.equals(container.getContainerID())) {
					filter4.addLast(j);
				}
			}

		} else {
			filter4 = filter3;
		}
		return filter4;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Journey) {
			Journey j = (Journey) o;
			if (j.getJourneyID() == this.journeyID) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		Container c=new Container();
		Journey j1 = new Journey("Denmark", "People's Republic of China", "Beef", "Happycorp", new Container());
		Journey j2 = new Journey("China", "China", "Beef", "Happycorp", new Container());
		Journey j3 = new Journey("Japan", "China", "Beef", "Happycorp", new Container());
		Journey j4 = new Journey("Korea", "China", "Beef", "Happycorp", new Container());
		Journey j5 = new Journey("China", "Latvia", "Beef", "Happycorp", new Container());
		Journey j6 = new Journey("Latvia", "China", "Beef", "Happycorp", c);
		Journey j7 = new Journey("US", "China", "Mango", "Happycorp", c);
		j4.cancelJourney();
		LinkedList<Journey> js = searchForJourneys(null, "China", null, null,null);
		System.out.println(js.size());
		j6.updateJourneyInfo(null, null, "Finland");
		j6.updateJourneyInfo(null, null, "North Pole");
		j6.updateJourneyInfo(null, null, "Antarctic Ocean");
		j6.updateJourneyInfo(null, null, "China");
		j7.updateJourneyInfo(null, null, "Pacific Ocean");
		j7.updateJourneyInfo(null, null, "Mexico");
		j7.updateJourneyInfo(null, null, "Korea");
		j7.updateJourneyInfo(null, null, "China");
		j7.updateJourneyInfo(null, null, "Korea");
		System.out.println("======");
		showContainerHistory(c);
	}
}