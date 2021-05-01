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
static private Client clientInstance;

 
	
	static private void loadClientData() {
		
		clientInstance = new Client();
		clientInstance.setName(clientLogin.getUsername());
		ResultSet rs = Client.searchForClient(null, null, clientInstance.getName(), null, null);
		try { 
			if (rs.next()) {
				clientInstance.setPassword(rs.getString("Password"));
				clientInstance.setEmail(rs.getString("Email"));
				clientInstance.setAddress(rs.getString("Address"));
				clientInstance.setRefPer(rs.getString("Reference_Person"));
				clientInstance.replaceID(rs.getString("Clientid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	static private void loadContainers(String OwnerID) {
		ResultSet rsContainers = ContainerLoader.searchForContainer(OwnerID);

		try {
			while (rsContainers.next()) { //loop through all containers matching client's ID
				String containerID = rsContainers.getString("Containerid");
				ResultSet rsJourneys = Journey.searchForJourney(null, containerID, null, null, null, null, null, null, null, null);
				// SearchForJourney malfunctions - doesnt find results.
				
				Container c = new Container(clientInstance,containerID);
				clientInstance.addContainer(c);
				System.out.println("(ClientController) loaded a container");
				while (rsJourneys.next()) { // loop through all journeys matching each container's ID
					System.out.println("(ClientController) loading a journey");
					String journeyID = rsJourneys.getString("journeyid");
					String journeyOrigin = rsJourneys.getString("Origin");
					String journeyDestination = rsJourneys.getString("Destination");
					String journeyContentType = rsJourneys.getString("Content_Type");
					String journeyName = rsJourneys.getString("Company");
					boolean journeyComplete = rsJourneys.getBoolean("Complete");
					// replace the new journey's ID with journeyID
					// load completion
					Journey j = new Journey(c,journeyOrigin, 
							journeyDestination, journeyContentType, journeyName);
					j.setComplete(journeyComplete);
					c.addJourney(j);
					System.out.println("(ClientController) " + j.getJourneyID());
					ResultSet rsMeasures = MeasureLoader.searchForMeasures(journeyID);
					while (rsMeasures.next()) {
						int measureTemp = rsMeasures.getInt("Internal_temperature");
						int measureHumid = rsMeasures.getInt("Humidity");
						int measurePress = rsMeasures.getInt("Atmospheric_pressure");
						String measureTime = rsMeasures.getString("Time");
						int[] measures = {measureTemp , measureHumid , measurePress};
						MeasureLog ml = new MeasureLog(measures);
						ml.replaceTime(measureTime);
						j.addMeasureJourney(ml);
						System.out.println("ClientController: Loaded measure: " + ml.getMeasure("temperature"));
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static public void clientLoader() {
		loadClientData();
		loadContainers(clientInstance.getID());
	}
	
	static public Client getClient() {
		return clientInstance;
	}
	
	
	
}
