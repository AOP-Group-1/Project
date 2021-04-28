import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*Feature:
 * - Contains a set of measures (3 integers) and time (1 string)
 * - Keeps track of time of logged measures
 */
public class MeasureLog {

	//order of data is : temperature, humidity, atmospheric pressure, time
	int[] measures;
	String time;
	public MeasureLog(int[] measures) {
		this.measures = measures;
		//figure out current time:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		
		this.time = dtf.format(now);
		
		
	}
	

	
	public int getMeasure(String category) { //similar to Factory pattern
		if (category == null) {
			return 0;
		}
		if (category.equalsIgnoreCase("temperature")) {
			return measures[0];
		}
		if (category.equalsIgnoreCase("humidity")) {
			return measures[1];
		}
		if (category.equalsIgnoreCase("pressure")) {
			return measures[2];
		}
		return 0;
	}
	public String getTime () {
		return time;
	}
	
	public static void main(String[] args) {

		
		int[] test1 = {1,2,4};
		
		
		MeasureLog ML = new MeasureLog(test1);
		
		System.out.println(ML.getMeasure("Time"));
		System.out.println(ML.getTime());
		
		
	}
}