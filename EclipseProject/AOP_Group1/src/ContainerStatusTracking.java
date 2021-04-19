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
	private List<Journey> jl; //o1
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
	
	public void setMeasures (List<Integer> measures) {
		
	}
	
}

public class ContainerStatusTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ContainerStatus cs = new ContainerStatus();
		System.out.println(cs.getMeasure());
		int[] firstInput = {1,2,3};
		System.out.println(cs.AddMeasure(firstInput));
		System.out.println(cs.getMeasure().get(0)[1]);
		int[] secondInput = {1,2};
		System.out.println(cs.AddMeasure(secondInput));
		System.out.println(cs.getMeasure());
		
		
	}

}
