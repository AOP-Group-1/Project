import java.util.ArrayList;
import java.util.List;

/* Feature
 * - Contains a list of logged measures and times
 */
public class ContainerStatus {
	
	// list of tuples, each tuple has corresponding category:
	//Index 0 = temperature, Index 1 = humidity, Index 2 = atmospheric pressure
	
	//( [1,2,3] , [1,2,4] , [2,3,4] )
	
	List<MeasureLog> measures = new ArrayList<MeasureLog>();
	
	public void addMeasureContainerStatus(MeasureLog measure) {
		this.measures.add(measure);
	}
	
	
//	public List<MeasureLog> getMeasure() {
//		return measures;
//	}

}


//User -> Choose a container -> (Show basic info) -> choose journey -> show measurements 




