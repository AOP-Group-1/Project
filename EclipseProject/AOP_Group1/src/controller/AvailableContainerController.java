package controller;

import java.util.ArrayList;
import java.util.List;

import mainFeatures.Client;
import mainFeatures.Container;

public class AvailableContainerController {

	public static List<Container> availableContainers() {
		ClientController.clientLoader();
		Client client = ClientController.getClient();
		System.out.println(client.getName());
		List<Container> containerList = new ArrayList<Container>();
		//Container[] availableContainers;
		
		for (Container container : client.getContainers()) {
			if ((container != null) && container.notOnJourney()) {
				containerList.add(container);
				System.out.println("availablecontainercontroller: " + container.notOnJourney()); 
				}
			
		}
		return containerList;
		
		
		
	}
	//make a pop-up window with table of all available containers 
	
	
}
