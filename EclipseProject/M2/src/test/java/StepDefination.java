import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination {
	
	newJourney journey = new newJourney();
	
	@Given("a new journey")
	public void a_new_journey() {
	    
	}

	@Given("corresponding containers are not registered yet")
	public void corresponding_containers_are_not_registered_yet(boolean notReg) {
	    journey.notRegistered(notReg);
	}

	@Given("the client supplies the important details")
	public void the_client_supplies_the_important_details(boolean infoAdd) {
	    journey.setChecksupplies(infoAdd);
	}

	@When("the client registers new containers")
	public void the_client_registers_new_containers(boolean regNew) {
	    journey.setRegisterNew(regNew);
	}

	@When("the client enters their origin")
	public void the_client_enters_their_origin(String newOrgin) {
	    journey.setOrigin(newOrgin);
	}

	@When("the client enters their destination")
	public void the_client_enters_their_destination(String newDestination) {
	    journey.setDestination(newDestination);
	}

	@When("the client enters their content type")
	public void the_client_enters_their_content_type(String newContentType) {
	    journey.setContentType(newContentType);
	}

	@When("the client enters their company")
	public void the_client_enters_their_company(String newCompany) {
	    journey.setCompany(newCompany);
	}

	@Then("the container is successfully registered")
	public void the_container_is_successfully_registered() {
		successfulRegister(true);
	}

	private void successfulRegister(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Then("the journey get a journey ID")
	public void the_journey_get_a_journey_ID() {
		getClientID(true);
	}

	private void getClientID(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
