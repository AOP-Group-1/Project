package controller;

import mainFeatures.Client;

public class ClientEditController {

	
	static public void editClientInfo(Client client,String newInfo, String category) {
		if (category == null)
				return;
		else if (category.equalsIgnoreCase("Name")) {
			client.setName(newInfo);
		}	
		else if (category.equalsIgnoreCase("Password")) {
			client.setPassword(newInfo);
		}
		else if (category.equalsIgnoreCase("Email")) {
			client.setEmail(newInfo);
		}
		else if (category.equalsIgnoreCase("Reference_Person")) {
			client.setRefPer(newInfo);
		}
		else if (category.equalsIgnoreCase("Address")) {
			client.setAddress(newInfo);
		}
		client.editInfo(newInfo, category);
		
	}
	
	

	
	

}
