import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;




/*
 * Each journey involves a container (but one container is typically
reused several times, for many journeys). For each container
involved in a journey the history of its internal status should be
tracked in terms of internal temperature, air humidity and
atmospheric pressure. The logistic company should be able to add
these measurements to the system and the clients should be able
to see them.
 */

// Container >Journey List > Journey > Internal status





class Container {
	//public int journeyID;
	private List<Journey> jl = new ArrayList<Journey>(); //Journey
	private String ContainerID;
	
	// Write: ONLY add measure to current journey (hard code path to addMeasure - current journey)
	// Journeys.get(Journeys.length - 1).getContainerStatus.getMeasure().AddMeasure(9, 4, 6)
	
	// Read: View history of all journeys
	// Journeys.get(Journeys.length - 1 - input).getContainerStatus.getMeasure().GetMeasure(some input)
	
	
	public Container() {
		this.ContainerID = UUID.randomUUID().toString();
	}

	//container's addMeasurements -> Journeys AddMeasurements -> ContainerStatus' addMeasurements
	
	public String getContainerID() {
		return this.ContainerID;
	}

	
	public void addMeasuresContainer (int[] measures) {
		int numOfJourneys = jl.size();
		jl.get(numOfJourneys - 1).addMeasureJourney(measures); //add the measurements to the current journey
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); //Get current time and format it
		
		String sql = String.format("insert into container_status (Containerid, Internal_temperature, Humidity, Atmostpheric_pressure, Time) values(\"%s\",%d,%d,%d,\"%s\");", 
				jl.get(numOfJourneys - 1).getJourneyID(), measures[0], measures[1], measures[2], dtf.format(now));
		DBConnection db = new DBConnection(); 
		db.update(sql); //update database with new measurements
	}

	// User requests container --> gets list of journeys --> selects journey --> gets measure categories --> selects measure
	public List<List<int[]>> getMeasures () {
		List<List<int[]>> res = new ArrayList<List<int[]>>();
		for(int i = 0; i < jl.size(); i++) {
			res.add(jl.get(i).getMeasure());	
		}
		return res;
	}
	
	public void addJourney (Journey j) {
		jl.add(j);
	}
	
}

public class ContainerStatusTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Container c = new Container();
		Journey j = new Journey(c.getContainerID(),"customerIDplaceholder","Copenhagen","London","Bananas","DSV");
		c.addJourney(j);
		int[] test1 = {1,2,3};
		int[] test2 = {2,4,6};
 		c.addMeasuresContainer(test1);
 		c.addMeasuresContainer(test2);
 		
 		Journey j2 = new Journey(c.getContainerID(),"customerIDplaceholder","Copenhagen","London","Bananas","DSV");
 		c.addJourney(j2);
 		c.addMeasuresContainer(test2);
 		
		System.out.println(c.getMeasures());
		
		System.out.println(c.getMeasures().get(0).get(0)[0]);
		// journeyID(abc1234):
		//    				 Temp | Humi | Atmo | time
		// JourneyID:	 	 10	  | 20   | 102
		// JourneyID:		 12	  | 2  | 101
		// 
	}

}
