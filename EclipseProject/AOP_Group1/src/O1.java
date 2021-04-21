
import java.util.List;
import java.util.UUID;



public class O1 {
	private String journeyID;	
	
	public O1() {
		this.journeyID = UUID.randomUUID().toString();
	}
	
	
	private ContainerStatus cs = new ContainerStatus(); //O1

	public ContainerStatus getContainerStatus() { //O1
		return cs;
	}

	public void addMeasure(int[] measures) { //O1
		cs.AddMeasure(measures);
	}
	
	
	public List<int[]> getMeasure() {
		
		return cs.measures;
		
	}
	
	public String getJourneyID() {
		return null;
	}


	


	public static void main(String[] args) {
		

	}
}


