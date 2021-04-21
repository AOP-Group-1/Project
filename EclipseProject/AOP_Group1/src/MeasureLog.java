import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MeasureLog {

	//order of data is : temperature, humidity, atmospheric pressure, time
	int[] measures;
	String time;
	public MeasureLog(int[] measures, String time) {
		this.measures = measures;
		this.time = time;
		
		
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

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now(); 
		int[] test1 = {1,2,4};
		
		
		MeasureLog ML = new MeasureLog(test1,dtf.format(now));
		
		System.out.println(ML.getMeasure("Time"));
		System.out.println(ML.getTime());
		
		
	}
}
