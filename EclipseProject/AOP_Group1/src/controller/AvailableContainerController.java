package controller;

import java.util.ArrayList;
import java.util.List;

import mainFeatures.Client;
import mainFeatures.Container;

// Controller for finding Available controller
public class AvailableContainerController {

	public static List<Container> availableContainers() {
		ClientController.clientLoader();
		Client client = ClientController.getClient();
		System.out.println(client.getName());
		List<Container> containerList = new ArrayList<Container>();
		
		for (Container container : client.getContainers()) {
			if ((container != null) && container.notOnJourney()) {
				containerList.add(container);
				}
			
		}
		return containerList;
		
		
		
	}
	
	
}
