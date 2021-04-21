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


class ContainerStatus {
	
	// list of tuples, each tuple has corresponding category:
	//Index 0 = temperature, Index 1 = humidity, Index 2 = atmospheric pressure
	
	List<int[]> measures = new ArrayList<int[]>();
	
	public boolean AddMeasure(int[] measure) {
		if(measure.length == 3) {
			this.measures.add(measure);
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public List<int[]> getMeasure() {
		return measures;
	}

}


class Container {
	//public int journeyID;
	private List<O1> jl = new ArrayList<O1>(); //o1
	public ContainerStatus status;
	private String ContainerID;
	
	// Write: ONLY add measure to current journey (hard code path to addMeasure - current journey)
	// Journeys.get(Journeys.length - 1).getContainerStatus.getMeasure().AddMeasure(9, 4, 6)
	
	// Read: View history of all journeys
	// Journeys.get(Journeys.length - 1 - input).getContainerStatus.getMeasure().GetMeasure(some input)
	
	
	public Container() {
		this.ContainerID = UUID.randomUUID().toString();
	}

	
	
	public String getContainerID() {
		return this.ContainerID;
	}
	
	public void addMeasures (int[] measures) {
		int numOfJourneys = jl.size();
		jl.get(numOfJourneys - 1).addMeasure(measures);
	}

	// User requests container --> gets list of journeys --> selects journey --> gets measure categories --> selects measure
	public List<List<int[]>> getMeasures () {
		List<List<int[]>> res = new ArrayList<List<int[]>>();
		for(int i = 0; i < jl.size(); i++) {
			res.add(jl.get(i).getMeasure());	
		}
		return res;
	}
	
	public void addJourney (O1 j) {
		jl.add(j);
	}
	
}

public class ContainerStatusTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Container c = new Container();
		O1 j = new O1();
		c.addJourney(j);
		int[] test1 = {1,2,3};
		int[] test2 = {2,4,6};
 		c.addMeasures(test1);
 		c.addMeasures(test2);
 		
 		c.addJourney(new O1());
 		c.addMeasures(test2);
 		
		System.out.println(c.getMeasures());
	}

}
