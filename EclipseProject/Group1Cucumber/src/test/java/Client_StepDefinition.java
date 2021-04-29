import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Client_StepDefinition {

	Client client;
	Client client2;
	
	
	//Adding information
	@Given("a new client")
	public void a_new_client() {
	    Client client = new Client();
	    this.client = client;
	}
	
	@Then("I want to register contact info")
	public void i_want_to_register_contact_info() {
	    client.setName("Danish Crown");
	    client.setAddress("Randers");
	    client.setEmail("oscar@danishcrown.dk");
	    client.setRefPer("Oscar Westergaard");
	}
	
	@Then("add a password to the profile")
	public void add_a_password_to_the_profile() {
	    client.setPassword("password123");
	}
	
	@Then("I want to register a container to the profile")
	public void i_want_to_register_a_container_to_the_profile() {
		client.addContainer(new Container());
	}
	
	@Then("save all data")
	public void save_all_data() {
	    client.registerClient();
	}
	
	
	//Checking information
	@Given("a registered client")
	public void a_registered_client() {
	    Client client2 = new Client();
	    this.client2 = client2;
	    client2.setName("Tulip");
	    client2.setAddress("Esbjerg");
	    client2.setEmail("oscar@tulip.dk");
	    client2.setPassword("PassWord123");
	    client2.setRefPer("Westergaard Oscar");
	    
	}

	@Then("I want to check the client name")
	public void i_want_to_check_the_client_name() {
	    client2.getName();
	}
	
	@Then("edit the ID")
	public void edit_the_ID() {
	    client2.replaceID("TulipAccount");
	}
}
