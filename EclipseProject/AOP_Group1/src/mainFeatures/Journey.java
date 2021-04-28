package mainFeatures;
//<<<<<<< HEAD
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
	
	//containerID and CustomerID must be auto-generated
	public Journey(String origin, String destination, String contentType,
			String company) {
		this.journeyID = UUID.randomUUID().toString();
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		this.containerID = "containerID";
		this.customerID = "customerID";
		this.journeyComplete = "false";
		registerJourney();
	}
	
	
	public String getJourneyID() {
		return journeyID;
	}

	public void registerJourney() {
		String sql = String.format(
				"insert into journey(journeyid,containerid,customerid,origin,destination,"
						+ "content_type,company,start_date,end_date,complete) "
						+ "values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%s,%s,%s);",
				this.journeyID, this.containerID, this.customerID, this.origin, this.destination, this.contentType,
				this.company, this.origin, "null", this.journeyComplete);
		DBConnection db = new DBConnection();
		db.update(sql);

	}
	
	
	//Removed for simplicity
//	public void updateJourney(String currentLocation,String journeyid) {
//		String sql="update journey set journey.current_location= "+'"'+currentLocation+'"'+" where journey.journeyid= "+ '\"'+journeyid+'\"'+";";
//		DBConnection db = new DBConnection();
//		db.update(sql);
//	}

	//Removed for 
//	public String getCurrentLocation(String journeyid) {
//		DBConnection db = new DBConnection();
//	
//		try {
//			ResultSet result=searchForJourney(journeyid,null,null,null,null,null,null,null,null,null,null);
//			String s;
//			while(result.next()) {
//				s=result.getString(8);
//				return s;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	//Current location removed from attributes
	public static String prepareStatement(String operation,String tableName,String jid, String conid, String cusid, String ori, String dest,
			String ctype, String comp, String sdate, String edate, String complete) {
		
		StringBuilder condition = new StringBuilder();
		if (jid != null)
			condition.append(String.format("journey.journeyid = \"%s\" and", jid));
		if (conid != null)
			condition.append(String.format("journey.containerid = \"%s\" and", conid));
		if (cusid != null)
			condition.append(String.format("journey.customerid = \"%s\" and ", cusid));
		if (ori != null)
			condition.append(String.format("journey.origin = \"%s\" and ", ori));
		if (dest != null)
			condition.append(String.format("journey.destination = \"%s\" and ", dest));
		if (ctype != null)
			condition.append(String.format("journey.content_type = \"%s\" and ", ctype));
		if (comp != null)
			condition.append(String.format("journey.company = \"%s\" and ", comp));
//		if (clocation != null)
//			condition.append(String.format("journey.current_location = \"%s\" and ", clocation));
		if (sdate != null)
			condition.append(String.format("journey.start_date = \"%s\" and ", sdate));
		if (edate != null)
			condition.append(String.format("journey.end_date = \"%s\" and ", edate));
		if (complete != null) {
			if (complete.equals("true")) {
				condition.append(String.format("journey.complete = %d and ", 1));
			} else {
				condition.append(String.format("journey.complete = %d and ", 0));
			}
		}

		if (condition.toString() != null) {
			condition.delete(condition.lastIndexOf("and"), condition.lastIndexOf("and") + 5);
		}
		String sql=operation+"* from "+tableName+" where "+condition.toString()+";";
		return sql;
	}
	
	
	
	
	//Current location removed from attributes
	public static ResultSet searchForJourney(String jid, String conid, String cusid, String ori, String dest,
			String ctype, String comp, String sdate, String edate, String complete) {
		DBConnection db = new DBConnection();
		String sql=prepareStatement("select","journey",jid,conid,cusid,ori,dest,ctype,comp,sdate,edate,complete);
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
		ResultSet rs=searchForJourney(null,containerid,null,null,null,null,null,null,null,null);
		return rs;
	}
	
	//O1 features
	private ContainerStatus cs = new ContainerStatus(); //O1

//	public ContainerStatus getContainerStatus() { //O1
//		return cs;
//	}

	public void addMeasureJourney(MeasureLog measures) { //O1
		cs.addMeasureContainerStatus(measures);
	}
	
	
	//Only for testing in main inside Container - delete before hand-in
	public List<MeasureLog> getMeasure() {
		
		return cs.measures;
		
	}
	


	
	

	public static void main(String[] args) {
		
		Journey j1 = new Journey("denmark","us","banana","bancorp");
        j1.registerJourney();
		
		Journey j = new Journey();
//		j.updateJourney("Germany", "1597f12b-ac0f-45a7-90c9-5ac3833bdfc7");
//		String location=j.getCurrentLocation("1597f12b-ac0f-45a7-90c9-5ac3833bdfc7");
//		System.out.println("current location:"+location);
//		
//		j.updateJourney("US", "1597f12b-ac0f-45a7-90c9-5ac3833bdfc7");
//		String location2=j.getCurrentLocation("1597f12b-ac0f-45a7-90c9-5ac3833bdfc7");
//		System.out.println("current location:"+location2);
		
	}
}




//First load in container objects from database
// then load in  their journeys
// then use the journey IDs from Measure database to load the measures into their respective journey.

