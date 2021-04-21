import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import com.mysql.cj.jdbc.result.ResultSetMetaData;


public class Journey {
	private String journeyID;
	private String containerID;
	private String customerID;
	private String origin;
	private String destination;
	private String contentType;
	private String company;
	private String currentLocation;
	private String journeyComplete;
	private ResultSet travelHistory;
	private ResultSet allJourneys;
	public Journey() {
		
	}
	public Journey(String containerID, String customerID, String origin, String destination, String contentType,
			String company) {
		//To satisfy the "automatically generate unique id" user story;
		
		this.journeyID = UUID.randomUUID().toString();
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		this.containerID = containerID;
		this.customerID = customerID;
		this.journeyComplete = "false";
	}
	
	

	public void registerJourney() {
		String sql = String.format(
				"insert into journey(journeyid,containerid,customerid,origin,destination,"
						+ "content_type,company,current_location,start_date,end_date,complete) "
						+ "values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,%s,%s);",
				this.journeyID, this.containerID, this.customerID, this.origin, this.destination, this.contentType,
				this.company, this.origin, "null", "null", this.journeyComplete);
		DBConnection db = new DBConnection();
		db.update(sql);

	}
	
	
	//To satisfy the "register for journey" user story;
	public void updateJourney(String currentLocation,String journeyid) {
		String sql="update journey set journey.current_location= "+'"'+currentLocation+'"'+" where journey.journeyid= "+ '\"'+journeyid+'\"'+";";
		DBConnection db = new DBConnection();
		db.update(sql);
	}
	
	public String getCurrentLocation(String journeyid) {
		DBConnection db = new DBConnection();
	
		try {
			ResultSet result=searchForJourney(journeyid,null,null);
			String s;
			while(result.next()) {
				s=result.getString(8);
				return s;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	//To satisfy the "search for journey based on certain criterion" user story;
	
	public static ResultSet searchForJourney(String journeyID, String contentType, String origin) {
		DBConnection db = new DBConnection();
		StringBuilder condition = new StringBuilder();
		if (journeyID != null)
			condition.append(String.format("journey.journeyid = \"%s\" and", journeyID));
		if (contentType != null)
			condition.append(String.format("journey.content_type = \"%s\" and", contentType));
		if (origin != null)
			condition.append(String.format("journey.customerid = \"%s\" and ", origin));
		

		if (condition.toString() != null) {
			condition.delete(condition.lastIndexOf("and"), condition.lastIndexOf("and") + 5);
		}
		String sql="select "+"* from "+"journey "+" where "+condition.toString()+";";
		ResultSet s = db.read(sql);
		return s;

	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Journey) {
			Journey j=(Journey) o;
			if(this.journeyID==j.journeyID) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public ResultSet showTravelHistory(String containerid) {
		ResultSet rs=searchForJourney(null,containerid,null);
		return rs;
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
	


	
	

	public static void main(String[] args) {
		
		Journey j1 = new Journey(UUID.randomUUID().toString(),UUID.randomUUID().toString(),"denmark","us","banana","bancorp");
        j1.registerJourney();
		
        ResultSet rs=searchForJourney(null,"banana",null);
        
        try {
			while(rs.next()) {
				System.out.println(rs.getString(6)+" "+rs.getString(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


