import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

/* Features:
 * - Creates ContainerID
 * - Gets ContainerID
 * - Add measures to log
 * - Get measures from log
 */
public class Container {
	//public int journeyID;
	private List<Journey> jl = new ArrayList<Journey>(); //Journey
	private String ContainerID;

	public Container() {
		this.ContainerID = UUID.randomUUID().toString();
	}

	//container's addMeasurements -> Journeys AddMeasurements -> ContainerStatus' addMeasurements
	
	public String getContainerID() {
		return this.ContainerID;
	}
	
	public void addJourney (Journey j) {
		jl.add(j);
	}

	
	public void addMeasuresContainer (MeasureLog measures) { //construct a MeasureLog object from an int[] in the facade
		int numOfJourneys = jl.size();
		if (numOfJourneys <= 0) {
			return; //Give user a warning that container has no journeys yet.
		}
		jl.get(numOfJourneys - 1).addMeasureJourney(measures); //add the measurements to the current journey
		
		String sql = String.format("insert into container_status (Containerid, Internal_temperature, Humidity, Atmostpheric_pressure, Time) values(\"%s\",%d,%d,%d,\"%s\");", 
				jl.get(numOfJourneys - 1).getJourneyID(), measures.getMeasure("temperature"), 
														  measures.getMeasure("humidity"), 
														  measures.getMeasure("pressure"),
														  measures.getTime());
		DBConnection db = new DBConnection(); 
		db.update(sql); //update database with new measurements
	}


	public List<List<MeasureLog>> getMeasures () { //function to get all measures from a container
		List<List<MeasureLog>> res = new ArrayList<List<MeasureLog>>();
		for(int i = 0; i < jl.size(); i++) {
			res.add(jl.get(i).getMeasure());	
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Container c = new Container();
		Journey j = new Journey(c.getContainerID(),"customerIDplaceholder","Copenhagen","London","Bananas","DSV");
		c.addJourney(j);
		int[] test1 = {1,2,3};
		int[] test2 = {2,4,6};
		MeasureLog ml1 = new MeasureLog(test1); //part of facade to turn int[] into MeasureLog
		MeasureLog ml2 = new MeasureLog(test2);

		c.addMeasuresContainer(ml1);
 		c.addMeasuresContainer(ml2);
 		
 		Journey j2 = new Journey(c.getContainerID(),"customerIDplaceholder","Copenhagen","London","Bananas","DSV");
 		c.addJourney(j2);
 		c.addMeasuresContainer(ml2);
 		
		System.out.println(c.getMeasures());
		
		System.out.println(c.getMeasures().get(0).get(0).getMeasure("temperature"));
		// journeyID(abc1234):
		//    				 Temp | Humi | Atmo | time
		// JourneyID:	 	 10	  | 20   | 102
		// JourneyID:		 12	  | 2  | 101
		// 
	}
	
}
