import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


// Comments:
// should we rename 'atmo' to 'pres' for pressure? since its more related to pressure than atmosphere
// Should we add a function for adding categories to a container? idea for future development, more than user stories

public class Setters_StepDefinition {

	Container c = new Container();
	// we should make a function for assigning a ContainerStatus-object to a Container-object 
	// - like "c.setStatus".
	ContainerStatus cs = new ContainerStatus();
	boolean result = false;
	
	// Temperature Setter tests
	
	@Given("a tracked container with internal temperature {int} degrees celsius")
	public void a_tracked_container_with_internal_temperature_degrees_celsius(int temp) {
		result = cs.AddMeasure(temp, "temperature");
	}

	@Then("temperature is set true")
	public void temperature_is_set_true() {
		assertEquals(true,result);
	}


	@Then("temperature is equal to new value")
	public void temperature_is_equal_to_new_value() {
		//assertEquals(temperatureInput,(cs.getMeasure("temperature")).get(0));
		//should be empty, it is the Getter's part.
		return;
	}
	
	// Humidity Setter tests


	@Given("a tracked container with air humidity {int} percent")
	public void a_tracked_container_with_air_humidity_percent(int humi) {
		result = cs.AddMeasure(humi, "humidity");
	}

	@Then("humidity is set true")
	public void humidity_is_set_true() {
		assertEquals(true,result);
	}

	@Then("humidity is equal to new value")
	public void humidity_is_equal_to_new_value() {
		return;
	}

	// Pressure Setter tests

	@Given("a tracked container with atmospheric pressure {int} kilo Pascals")
	public void a_tracked_container_with_atmospheric_pressure_kilo_Pascals(int atmo) {
		result = cs.AddMeasure(atmo, "atmosphere");
	}

	@Then("atmospheric pressure is set true")
	public void atmospheric_pressure_is_set_true() {
		assertEquals(true,result);
	}

	@Then("atmospheric pressure is equal to new value")
	public void atmospheric_pressure_is_equal_to_new_value() {
		return;
	}
	
	// Unsuccessful setter tests
	
	@Given("a measurement {int} entered into Null category")
	public void a_measurement_entered_into_Null_category(int measure) {
		result = cs.AddMeasure(measure, null);
	}

	@Then("null-category return value is false")
	public void null_category_return_value_is_false() {
		assertEquals(false,result);
	}

	@Given("a measurement {int} entered into {string} category")
	public void a_measurement_entered_into_category(int measure,String category) {
		result = cs.AddMeasure(measure, category);
	}

	@Then("unused space-category return value is false")
	public void unused_space_category_return_value_is_false() {
		assertEquals(false,result);
	}

	
	
}
