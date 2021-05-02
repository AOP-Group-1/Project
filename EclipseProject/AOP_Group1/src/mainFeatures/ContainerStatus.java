package mainFeatures;
import java.util.ArrayList;
import java.util.List;

/* Feature
 * - Contains a list of logged measures and times
 */
public class ContainerStatus {

	
	List<MeasureLog> measures = new ArrayList<MeasureLog>();
	
	public void addMeasureContainerStatus(MeasureLog measure) {
		this.measures.add(measure);
	}
	
	
	public List<MeasureLog> getMeasure() {
		return measures;
	}

}


