package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Login.clientLogin;
import dataLoaders.ContainerLoader;
import dataLoaders.MeasureLoader;
import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;
import mainFeatures.MeasureLog;

public class ClientController {
private Client clientInstance;

 
	
	private void loadClientData() {
		
		clientInstance = new Client();
		clientInstance.setName(clientLogin.getUsername());
		ResultSet rs = Client.searchForClient(null, null, clientInstance.getName(), null, null);
		try { //ask if this is okay 
			// should we have classes for searching and loading data?
			rs.next();
			clientInstance.setPassword(rs.getString("Password"));
			clientInstance.setEmail(rs.getString("Email"));
			clientInstance.setAddress(rs.getString("Address"));
			clientInstance.setRefPer(rs.getString("Reference_Person"));
			clientInstance.replaceID(rs.getString("Clientid"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void loadContainers(String OwnerID) {
		ResultSet rsContainers = ContainerLoader.searchForContainer(OwnerID);
		try {
			while (rsContainers.next()) { //loop through all containers matching client's ID
				String containerID = rsContainers.getString("Containerid");
				ResultSet rsJourneys = Journey.searchForJourney(null, null, containerID, null, null, null, null, null, null, null, null);
				Container c = new Container(clientInstance);
				clientInstance.addContainer(c);
				while (rsJourneys.next()) { // loop through all journeys matching each container's ID
					String journeyID = rsContainers.getString("journeyid");
					String journeyOrigin = rsJourneys.getString("Origin");
					String journeyDestination = rsJourneys.getString("Destination");
					String journeyContentType = rsJourneys.getString("Content_Type");
					String journeyName = rsJourneys.getString("Company");
					Journey j = new Journey(c.getContainerID(),clientInstance.getID(),journeyOrigin, 
							journeyDestination, journeyContentType, journeyName);
					c.addJourney(j);
					ResultSet rsMeasures = MeasureLoader.searchForMeasures(journeyID);
					while (rsMeasures.next()) {
						int measureTemp = rsMeasures.getInt("Internal_temperature");
						int measureHumid = rsMeasures.getInt("Humidity");
						int measurePress = rsMeasures.getInt("Atmospheric_pressure");
						//MeasureLog ml = new MeasureLog({measureTemp, measureHumid,measurePress});
						//this is where we are : load the measures into each journey.
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
