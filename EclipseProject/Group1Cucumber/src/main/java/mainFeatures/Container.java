package mainFeatures;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import Supplementary.DBConnection;

/* Features:
 * - Creates ContainerID
 * - Gets ContainerID
 * - Add measures to log
 * - Get measures from log
 */
public class Container {
	private List<Journey> jl = new ArrayList<Journey>(); //Journey
	private String ContainerID;
	private String OwnerID;
	
	public Container(Client owner) {
		this.OwnerID = owner.ID;
		this.ContainerID = UUID.randomUUID().toString();
		//registerContainer(); Leave this method for when we want to upload the container to the database,
		// i.e. "Add new container"
	}
	
	// constructor for when we are loading the containers
	public Container(Client owner, String loadedContainerID) {
		this.OwnerID = owner.ID;
		this.ContainerID = loadedContainerID;
	}

	
	public void registerContainer() {
		String sql = String.format(
				"insert into container(Containerid,Ownerid) "
						+ "values(\"%s\",\"%s\");",
				this.ContainerID,this.OwnerID);
		DBConnection db = new DBConnection();
		db.update(sql);

	}
	
	
	public List<Journey> getJourneys() {
		return jl;
	}
	
	public boolean notOnJourney() {
		if (jl.isEmpty()) {
			System.out.println("(containerClass) Container has no journeys");
			return true;
		}
		boolean allComplete = true;
		for (Journey journey : jl) {
			allComplete = allComplete && (journey.getComplete());
		}
		return allComplete;
		
		
	}
	
	//empty constructor should probably be removed
//	public Container(String string) {
//		// TODO Auto-generated constructor stub
//	}

	//container's addMeasurements -> Journeys AddMeasurements -> ContainerStatus' addMeasurements
	
	public String getContainerID() {
		return this.ContainerID;
	}
	
	public String getOwnerID() {
		return this.OwnerID;
	}
	
	
	public void addJourney (Journey j) {
		jl.add(j);
	}

	
//	public void addMeasuresContainer (MeasureLog measures) { //construct a MeasureLog object from an int[] in the facade
//		int numOfJourneys = jl.size();
//		if (numOfJourneys <= 0) {
//			return; //Give user a warning that container has no journeys yet.
//		}
//		jl.get(numOfJourneys - 1).addMeasureJourney(measures); //add the measurements to the current journey
//		
//		
//		//uploading to database was moved to the MeasureLog.registerMeasureLog's responsibility
////		String sql = String.format("insert into container_status (journeyid, Internal_temperature, Humidity, Atmospheric_pressure, Time) values(\"%s\",%d,%d,%d,\"%s\");", 
////				jl.get(numOfJourneys - 1).getJourneyID(), measures.getMeasure("temperature"), 
////														  measures.getMeasure("humidity"), 
////														  measures.getMeasure("pressure"),
////														  measures.getTime());
////		DBConnection db = new DBConnection(); 
////		db.update(sql); //update database with new measurements
//	}
	
	@Override
	public String toString() {
		return ContainerID.substring(0,6) + ", owned by: " + OwnerID.substring(0,6);
	}
	
	

//	public List<List<MeasureLog>> getMeasures () { //function to get all measures from a container
//		List<List<MeasureLog>> res = new ArrayList<List<MeasureLog>>();
//		for(int i = 0; i < jl.size(); i++) {
//			res.add(jl.get(i).getMeasure());	
//		}
//		return res;
//	}
//	
	
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Container c = new Container("123");
//		//Journey j = new Journey("Copenhagen","London","Bananas","DSV");
//		Client client = new Client();
//		//Container c = new Container(client);
//		//Journey j = new Journey(c.getContainerID(),"customerIDplaceholder","Copenhagen","London","Bananas","DSV");
//		//c.addJourney(j);
//		int[] test1 = {1,2,3};
//		int[] test2 = {2,4,6};
//		MeasureLog ml1 = new MeasureLog(test1); //part of facade to turn int[] into MeasureLog
//		MeasureLog ml2 = new MeasureLog(test2);
//
//		c.addMeasuresContainer(ml1);
// 		c.addMeasuresContainer(ml2);
// 		

 		
 		//Journey j2 = new Journey("Copenhagen","London","Bananas","DSV");
 		//c.addJourney(j2);
 		//c.addMeasuresContainer(ml2);
// 		
//		System.out.println(c.getMeasures());
//		
//		System.out.println(c.getMeasures().get(0).get(0).getMeasure("temperature"));
//		// journeyID(abc1234):
//		//    				 Temp | Humi | Atmo | time
//		// JourneyID:	 	 10	  | 20   | 102
//		// JourneyID:		 12	  | 2  | 101
		// 
//	}
	
}
