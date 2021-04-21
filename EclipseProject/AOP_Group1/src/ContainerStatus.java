import java.util.ArrayList;
import java.util.List;

public class ContainerStatus {
	
	// list of tuples, each tuple has corresponding category:
	//Index 0 = temperature, Index 1 = humidity, Index 2 = atmospheric pressure
	
	//( [1,2,3] , [1,2,4] , [2,3,4] )
	
	List<int[]> measures = new ArrayList<int[]>();
	
	public boolean addMeasureContainerStatus(int[] measure) {
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
