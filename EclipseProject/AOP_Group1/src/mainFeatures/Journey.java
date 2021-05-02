package mainFeatures;

import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;



public class Journey {
	private String journeyID;
	private String containerID;
	private String clientID;
	private String origin;
	private String destination;
	private String contentType;
	private String company;
	private boolean journeyComplete;

	private ContainerStatus cs;
	
	

	public Journey(Container container, String origin, String destination, String contentType,
			String company) {
		this.journeyID = UUID.randomUUID().toString();
		this.origin = origin;
		this.destination = destination;
		this.contentType = contentType;
		this.company = company;
		this.containerID = container.getContainerID();
		this.clientID = container.getOwnerID();
		this.journeyComplete = false;
		this.cs = new ContainerStatus();

	}
	
	
	public String getJourneyID() {
		return journeyID;
	}
	
	public String getOrigin() {
		return origin;
	}
 	
	public String getDestination() {
		return destination;
	}
	
	public String getContentType() {
		return contentType;
	}
	
	public String getCompany() {
		return company;
	}
	public String getContainerID() {
		return containerID;
	}
	public String getClientID() {
		return clientID;
	}
	
	public void setComplete(boolean completion) {
		this.journeyComplete = completion;
	}
	
	public void replaceID(String loadedID) {
		this.journeyID = loadedID;
	}
	

	public void registerJourney() {
		String sql = String.format(
				"insert into journey(journeyid,containerid,clientid,origin,destination,"
						+ "content_type,company,complete) "
						+ "values(\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",%b);",
				this.journeyID, this.containerID, this.clientID, this.origin, this.destination, this.contentType,
				this.company, this.journeyComplete);
		DBConnection db = new DBConnection();
		db.update(sql);
	}
	
	public boolean getComplete() {
		return journeyComplete;
	}
	
	@Override
	public String toString() {
		return "Journey: " + journeyID.substring(0,5);
	}
	
	
	

	public static String prepareStatement(String operation,String tableName,String jid, String conid, String cusid, String ori, String dest,
			String ctype, String comp, String sdate, String edate, String complete) {
		
		StringBuilder condition = new StringBuilder();
		if (jid != null)
			condition.append(String.format("journeyid = \"%s\" and", jid));
		if (conid != null)
			condition.append(String.format("Containerid = \"%s\" and", conid));
		if (cusid != null)
			condition.append(String.format("Clientid = \"%s\" and ", cusid));
		if (ori != null)
			condition.append(String.format("Origin = \"%s\" and ", ori));
		if (dest != null)
			condition.append(String.format("Destination = \"%s\" and ", dest));
		if (ctype != null)
			condition.append(String.format("Content_type = \"%s\" and ", ctype));
		if (comp != null)
			condition.append(String.format("Company = \"%s\" and ", comp));
		if (complete != null) {
			if (complete.equals("true")) {
				condition.append("journey.complete = true and ");
			} else {
				condition.append("journey.complete = false and ");
			}
		}

		if (condition.toString() != null) {
			condition.delete(condition.lastIndexOf("and"), condition.lastIndexOf("and") + 5);
		}
		String sql=operation+" * from "+tableName+" where "+condition.toString()+";";
		return sql;
	}
	
	
	
	
	//Current location removed from attributes
	public static ResultSet searchForJourney(String jid, String conid, String cusid, String ori, String dest,
			String ctype, String comp, String sdate, String edate, String complete) {
		DBConnection db = new DBConnection();
		String sql=prepareStatement("select","journey",jid,conid,cusid,ori,dest,ctype,comp,sdate,edate,complete);
		ResultSet rs = db.read(sql);
		return rs;

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
	public void addMeasureJourney(MeasureLog measures) { //O1
		cs.addMeasureContainerStatus(measures);
		
		
		
	}
	
	
	//Only for testing in main inside Container - delete before hand-in
	public List<MeasureLog> getMeasure() {
		
		return cs.measures;
		
	}
	


	
	

	public static void main(String[] args) {
		Client client1 = new Client();
		client1.setAddress("DTU");
		client1.setEmail("dtu@dtu");
		client1.setName("Sofaer");
		client1.setRefPer("bananaPerson");
		client1.setPassword("banana");
		client1.registerClient();
		client1.editInfo("maroon","Name");
		Container container1 = new Container(client1);
		container1.registerContainer();
		Journey j1 = new Journey(container1,"denmark","us","banana","bancorp");
		j1.setComplete(true);
		j1.registerJourney();
 		
		MeasureLog ml = new MeasureLog(new int[] {5,2,4});
		ml.registerMeasureLog(j1);
		j1.addMeasureJourney(ml);
		
	}
}



