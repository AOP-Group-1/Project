import java.util.ArrayList;
import java.util.List;



/*
 * Each journey involves a container (but one container is typically
reused several times, for many journeys). For each container
involved in a journey the history of its internal status should be
tracked in terms of internal temperature, air humidity and
atmospheric pressure. The logistic company should be able to add
these measurements to the system and the clients should be able
to see them.
 */

class ContainerStatus {
		
	List<Integer> temp = new ArrayList<Integer>();
	List<Integer> humi = new ArrayList<Integer>();	
	List<Integer> atmo = new ArrayList<Integer>();
	
	public boolean AddMeasure(int measure, String category) {
		if (category == null) {
			return false;
		}
		else if (category.equalsIgnoreCase("temperature")) {
			this.temp.add(measure);
			return true;
		} 
		else if (category.equalsIgnoreCase("humidity")) {
			this.humi.add(measure);
			return true;
		}
		else if (category.equalsIgnoreCase("atmosphere")) {
			this.atmo.add(measure);
			return true;
		}
		return false;
	}
	
	public List<Integer> getMeasure(String category) {
		if (category == null) {
			System.out.println("Category not found...");
			return null;
		}
		else if (category.equalsIgnoreCase("temperature")) {
			return this.temp;
		} 
		else if (category.equalsIgnoreCase("humidity")) {
			return this.humi;
		}
		else if (category.equalsIgnoreCase("atmosphere")) {
			return this.atmo;
		}
		System.out.println("Category not found...");
		return null;
		
	}
	
}


class Container {
	//public int journeyID;
	public ContainerStatus status;
	
}

public class ContainerStatusTracking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ContainerStatus cs = new ContainerStatus();
		System.out.println(cs.getMeasure("temperature"));
		cs.AddMeasure(-10, "temperature");
		System.out.println(cs.getMeasure("temperature"));
		cs.getMeasure("teststst");
		
		
	}

}
