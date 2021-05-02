package mainFeatures;

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
	private List<Journey> jl = new ArrayList<Journey>(); //Journey
	private String ContainerID;
	private String OwnerID;
	
	public Container(Client owner) {
		this.OwnerID = owner.ID;
		this.ContainerID = UUID.randomUUID().toString();
		
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
			return true;
		}
		boolean allComplete = true;
		for (Journey journey : jl) {
			allComplete = allComplete && (journey.getComplete());
		}
		return allComplete;
		
		
	}
	

	public String getContainerID() {
		return this.ContainerID;
	}
	
	public String getOwnerID() {
		return this.OwnerID;
	}
	
	
	public void addJourney (Journey j) {
		jl.add(j);
	}

	
	public void addMeasuresContainer (MeasureLog measures) { //construct a MeasureLog object from an int[] in the facade
		int numOfJourneys = jl.size();
		if (numOfJourneys <= 0) {
			return; 
		}
		jl.get(numOfJourneys - 1).addMeasureJourney(measures); //add the measurements to the current journey
		
		

	}
	
	@Override
	public String toString() {
		return ContainerID.substring(0,6) + ", owned by: " + OwnerID.substring(0,6);
	}
	
	

	public List<List<MeasureLog>> getMeasures () { //function to get all measures from a container
		List<List<MeasureLog>> res = new ArrayList<List<MeasureLog>>();
		for(int i = 0; i < jl.size(); i++) {
			res.add(jl.get(i).getMeasure());	
		}
		return res;
	}
	
	
	public static void main(String[] args) {

	}
	
}
