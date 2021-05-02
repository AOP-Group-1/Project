package dataLoaders;

import Supplementary.DBConnection;

public class JourneyUpdater {

	
	
	public static void UpdateCompletionJourney(String journeyID) {
			DBConnection db = new DBConnection();
			String sql = ("UPDATE journey SET Complete = " + "true" + " WHERE journeyID = \"" + journeyID + "\";");
			db.update(sql); //update the database
			System.out.println(journeyID);
		}
		
		
	
	
	public static void UpdateLocationJourney(String journeyID, String UpdatedLocation) {
		DBConnection db = new DBConnection();
		//("UPDATE client SET " + category + " = \"" + newInfo +"\" WHERE Clientid = \"" + ID + "\"");
		String sql = ("UPDATE journey SET Destination = " + "\"" + UpdatedLocation + "\" WHERE journeyid = \" " + journeyID + "\";");
		UpdateCompletionJourney(journeyID);
		
		db.update(sql); //update the database
		
		
		
	}
	
	
	
}
