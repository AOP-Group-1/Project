import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Journey_StepDefinition {
	
	
	
	@Given("an origin, a destination and a content type")
	public void an_origin_a_destination_and_a_content_type() {
	    Journey journey = new Journey("Copenhagen", "NYC", "Bacon", "DanishCrown");
	}
	
}
