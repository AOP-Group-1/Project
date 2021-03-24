import java.util.LinkedList;
import java.util.UUID;

public class Journey {
	private String journeyID;
	private String origin;
	private String destination;
	private String contentType;
	private String company;

	// All journeys are stored in this linked list
	public static final LinkedList<Journey> ALLJOURNEYS = new LinkedList();

	public Journey(String orign, String destination, String contentType, String company) {
		this.journeyID = UUID.randomUUID().toString();
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		ALLJOURNEYS.addLast(this);
	}

	public String getJourneyID() {
		return this.journeyID;
	}

	public void updateJourneyInfo(Journey j) {
		this.origin = j.origin;
		this.destination = j.destination;
		this.contentType = j.contentType;
		this.company = j.company;
	}

	// select * from ALLJOURNEYS where origin
	public static void searchForJourneys(String orig, String dest, String cont, String comp) {
		LinkedList<Journey> filter = new LinkedList();
		LinkedList<Journey> filter1 = new LinkedList();
		LinkedList<Journey> filter2 = new LinkedList();
		LinkedList<Journey> filter3 = new LinkedList();
		if (orig != null) {
			for (Journey j : ALLJOURNEYS) {
				if (j.origin == orig)
					filter.addLast(j);
			}
		}else {
			filter=ALLJOURNEYS;
		}

		if (dest != null) {
			for (Journey j : filter) {
				if (j.destination == dest) {
					filter1.addLast(j);
				}
			}

		}else {
			filter1=filter;
		}

		if (cont != null) {
			for (Journey j : filter1) {
				if (j.destination == dest) {
					filter2.addLast(j);
				}
			}
			filter2=filter1;
		}
		
		if (comp != null) {
			for (Journey j : filter2) {
				if (j.destination == dest) {
					filter3.addLast(j);
				}
			}

		}else {
			filter3=filter2;
		}
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
		searchForJourneys(null, null, null, null);
		System.out.println(ALLJOURNEYS.size());
	}
}
