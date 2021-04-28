package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import Login.clientLogin;
import mainFeatures.Client;
import mainFeatures.Container;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void loadContainers() {
		//ResultSet rs = Container.searchForContainers()
		
		
	}
}
