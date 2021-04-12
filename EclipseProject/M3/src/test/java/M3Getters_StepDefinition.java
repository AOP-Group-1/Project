import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class M3Getters_StepDefinition {

	ContainerStatusTracking cst = new ContainerStatusTracking();
	
	
	@Given("a request for temperature {string}")
	public void a_request_for_temperature(String string) {
	    cst.getMeasure(string);
	}

	@Then("a list of temperatures")
	public void a_list_of_temperatures() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a request for humidity {string}")
	public void a_request_for_humidity(String string) {
	    cst.getMeasure(string);
	}

	@Then("a list of humidities")
	public void a_list_of_humidities() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a request for atmospheric pressure {string}")
	public void a_request_for_atmospheric_pressure(String string) {
	    cst.getMeasure(string);
	}

	@Then("a list of pressures")
	public void a_list_of_pressures() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

}
