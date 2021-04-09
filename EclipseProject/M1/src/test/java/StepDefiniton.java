import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefiniton {

	newClient client = new newClient();
	
	@Given("a new client")
	public void a_new_client() {
		
	}

	@Given("the client is not registered yet (true|false)$")
	public void the_client_is_not_registered_yet(boolean notReg) {
		client.notRegistered(notReg);
		
	}

	@Given("the client supplies the important details (true|false)$")
	public void the_client_supplies_the_important_details(boolean infoAdd) {
		client.setChecksupplies(infoAdd);
	}

	@When("the logistics company registers the new client (true|false)$")
	public void the_logistics_company_registers_the_new_client(boolean regNew) {
	    client.setRegisterNew(regNew);
	}

	@When("the client enters their name")
	public void the_client_enters_their_name(String newName) {
	    client.setName(newName);
	}

	@When("the client enters their email")
	public void the_client_enters_their_email(String newEmail) {
	    client.setEmail(newEmail);
	}

	@When("the client enters their address")
	public void the_client_enters_their_address(String newAddress) {
	    client.setAddress(newAddress);
	}

	@When("the client enters their reference person")
	public void the_client_enters_their_reference_person(String newRefPer) {
	    client.setRefPer(newRefPer);
	}

	@Then("the client is successfully registered")
	public void the_client_is_successfully_registered() {
	    successfulRegister(true);
	}

	private void successfulRegister(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Then("the client get a client ID")
	public void the_client_get_a_client_ID() {
	    getClientID(true);
	}

	private void getClientID(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
