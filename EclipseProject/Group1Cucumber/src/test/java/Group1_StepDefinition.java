import static org.junit.Assert.assertEquals;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Supplementary.DBConnection;
import dataLoaders.ContainerLoader;
import dataLoaders.MeasureLoader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mainFeatures.Client;
import mainFeatures.Container;
import mainFeatures.Journey;
import mainFeatures.MeasureLog;

public class Group1_StepDefinition {
	
	Client client1 = new Client();
	String refPer;
	String email;
	Container container1 = new Container(client1);
	Journey journey1 = new Journey(container1, "Denmark", "USA", "Bacon", "Danish Crown");
	int[] measure1;
	MeasureLog ml1 = new MeasureLog(measure1);
	String container_to_check;
	Container container2 = new Container(client1);
	DBConnection dbcon = new DBConnection();
	Client client2;
	Container container3;
	
	//Register client
	@Given("a new client with information")
	public void a_new_client_with_information() {
	    Client client1 = new Client();
	    this.client1 = client1;
	}
	
	@Given("a client ID {string} is auto generated")
	public void a_client_ID_is_auto_generated(String string) {
	    assertEquals(client1.getID().getClass(), string.getClass());
	}

	@Then("I want to register the information")
	public void i_want_to_register_the_information() {
	    client1.setName("Danish Crown");
	    client1.setAddress("Randers");
	    client1.setRefPer("Oscar");
	    client1.setEmail("oscar@danishcrown.dk");
	}
	
	@Then("create a password for the client")
	public void create_a_password_for_the_client() {
	    client1.setPassword("Password123");
	}
	
	@Then("save the data")
	public void save_the_data() {
	    client1.registerClient();
	}
	
	
	//Edit user info
	@Given("a registered client")
	public void a_registered_client() {
	    assertEquals(client1.getClass(), Client.class);
	}

	@Given("a new reference person is chosen")
	public void a_new_reference_person_is_chosen() {
	    String refPer = "August";
	    this.refPer = refPer;
	}

	@Then("the client edits reference person")
	public void the_client_edits_reference_person() {
	    client1.editInfo(refPer, "Reference_Person");
	}
	
	@Then("the client edits email")
	public void the_client_edits_email() {
	    client1.editInfo("august@danishcrown.dk", "Email");
	}
	
	
	//Search for client info
	@Given("a need for seeing client info related to client email")
	public void a_need_for_seeing_client_info_related_to_client_email() {
	    String email = "august@danishcrown.dk";
	    this.email = email;
	}

	@Then("the company searches using the email")
	public void the_company_searches_using_the_email() {
	    Client.searchForClient(null, email, null, null, null);
	}
	
	//Search for multiple client info
	@Given("a need for client info")
	public void a_need_for_client_info() {
	    //Empty
	}

	@Then("the company searches for mulitple info")
	public void the_company_searches_for_mulitple_info() {
	    Client.searchForClient(client1.getID(), client1.getEmail(), client1.getName(), client1.getAddress(), client1.getRefPer());
	}
	
	//Unsuccessful search for client info
	@Given("a need for seeing client info related to client email_")
	public void a_need_for_seeing_client_info_related_to_client_email_() {
	    //Empty
	}

	@Then("the company searches using nothing")
	public void the_company_searches_using_nothing() {
	    Client.searchForClient(null, null, null, null, null);
	}
	
	@Given("a need to know all clients")
	public void a_need_to_know_all_clients() {
	    //Empty
	}

	@Then("the company searches for all clients")
	public void the_company_searches_for_all_clients() {
	    Client.findAllClients();
	}
	
	
	//Register container for journey
	@Given("a container")
	public void a_container() {
	    Container container1 = new Container(client1);
	    this.container1 = container1;
	    container1.registerContainer();
	}
	
	@Then("the client registers it for a journey")
	public void the_client_registers_it_for_a_journey() {
	    Journey journey1 = new Journey(container1, "Denmark", "USA", "Bacon", "Danish Crown");
	    this.journey1 = journey1;
	}
	
	@Then("a journey ID {string} is auto generated")
	public void a_journey_ID_is_auto_generated(String string) {
	    assertEquals(journey1.getJourneyID().getClass(), string.getClass());
	}
	
	@Then("submit the registration")
	public void submit_the_registration() {
	    journey1.registerJourney();
	}
	
	//Tracking container
	@Given("a container on a journey;")
	public void a_container_on_a_journey() {
	    assertEquals(journey1.getComplete(), false);
	}
	
	@Then("the client searches for the container ID")
	public void the_client_searches_for_the_container_ID() {
	    Journey.searchForJourney(null, container1.getContainerID(), null, null, null, null, null, null, null, null);
	}
	
	//Track container with multiple input
	@Given("a search for mulitple input")
	public void a_search_for_mulitple_input() {
	    Journey.searchForJourney(journey1.getJourneyID(), journey1.getContainerID(), journey1.getClientID(), journey1.getOrigin(), journey1.getDestination(), journey1.getContentType(), journey1.getCompany(), "01-01-2020", "12-01-2020", "true");
	}
	
	//Track uncompleted journeys
	@Given("a search for an uncompleted journey")
	public void a_search_for_an_uncompleted_journey() {
	    Journey.searchForJourney(null, null, null, null, null, null, null, null, null, "false");
	}
	
	//Checking container availability
	@Given("a need for a container")
	public void a_need_for_a_container() {
		Journey journey2 = new Journey(container1,"origin","destination","content type", "company");
	    journey2.setComplete(true);
	    container1.addJourney(journey2);
		
		
		
	}

	@Then("the client checks container availability")
	public void the_client_checks_container_availability() {
		assertEquals(container1.notOnJourney(), true);
		
		
	}
	
	//Logging internal container measurements
	@Given("a container on a journey")
	public void a_container_on_a_journey_2() {
	    assertEquals(journey1.getClass(), Journey.class);
	    assertEquals(journey1.getComplete(), false);
	    assertEquals(journey1.getContainerID(), container1.getContainerID());
	}

	@Given("a set of internal measurements are measured")
	public void a_set_of_internal_measurements_are_measured() {
	    int[] measure1 = {-10, 18, 990};
	    this.measure1 = measure1;
	}

	@Then("the measurements are logged")
	public void the_measurements_are_logged() {
		MeasureLog ml1 = new MeasureLog(measure1);
		this.ml1 = ml1;
		journey1.addMeasureJourney(ml1);
		ml1.registerMeasureLog(journey1);
	}

	//Check internal status
	@Given("a container on a journey_")
	public void a_container_on_a_journey_() {
	    assertEquals(journey1.getClass(), Journey.class);
	    assertEquals(journey1.getComplete(), false);
	    assertEquals(journey1.getContainerID(), container1.getContainerID());
	}

	@Given("the client want to check the internal status of a specific container")
	public void the_client_want_to_check_the_internal_status_of_a_specific_container() {
	    String container_to_check = journey1.getJourneyID();
	    this.container_to_check = this.container_to_check;
	}

	@Then("the client searches for the internal status")
	public void the_client_searches_for_the_internal_status() {
	    MeasureLoader.searchForMeasures(container_to_check);
	}
	
	
	//Check for available containers
	@Given("a client need an avaiable container")
	public void a_client_need_an_avaiable_container() {
	    Container container2 = new Container(client1);
	    this.container2 = container2;
	}

	@Then("client searches for available containers")
	public void client_searches_for_available_containers() {
	    assertEquals(container2.notOnJourney(), true);
	}
	
	@Given("a container with a journey")
	public void a_container_with_a_journey() {
	    container1.addJourney(journey1);
	}


	@Then("the company searches for the measurement history")
	public void the_company_searches_for_the_measurement_history() {
	    for(int i = 0; i < container1.getJourneys().size(); i++) {
	    	container1.getJourneys().get(i).getMeasure();
	    }
	}
	
	
	//Managing database connection
	@Given("a need for the program")
	public void a_need_for_the_program() {
	    //empty
	}

	@Then("program is started")
	public void program_is_started() {
	    DBConnection dbcon = new DBConnection();
	    this.dbcon = dbcon;
	}

	@Then("later closed properly")
	public void later_closed_properly() {
	    dbcon.closeConnection();
	}
	
	//Loading properly from database
	@Given("a request for data in database")
	public void a_request_for_data_in_database() {
	    Client client2 = new Client();
	    this.client2 = client2;
	    Container container3 = new Container(client2);
	    this.container3 = container3;
	    container3.registerContainer();
	    
	}

	@Then("data is loaded")
	public void data_is_loaded() {
		System.out.println(client2.getID());
		ResultSet rs = ContainerLoader.searchForContainer(client2.getID());
		try {
			if (rs.next()) {
				String loadedContainerID = rs.getString("Containerid");
				Container container4 = new Container(client2, loadedContainerID);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
				
	}
}
