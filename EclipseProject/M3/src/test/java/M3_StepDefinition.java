import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class M3_StepDefinition {

	boolean result;
	ContainerTest container = new ContainerTest();
	
	@Given("a container with temperature {int} degrees celsius")
	public void a_container_with_temperature_degrees_celsius(int temp) {
	   result = container.setTemp(temp);
	}

	@Given("container is loaded (true|false)$")
	public void container_is_loaded(boolean isLoaded) {
	    container.setLoadedStatus(isLoaded);
	}

	@When("temperature is added (true|false)$")
	public void temperature_is_added(boolean tempAdded) {
	    container.setTempAdded(tempAdded);
	}

	@Then("temperature is stored")
	public void temperature_is_stored() {
		assertEquals(true,result);
	}
	
	@Then("temperature is not stored")
	public void temperature_is_not_stored() {
	    result = container.setTemp(60);
		assertEquals(false,result);
	}
}
