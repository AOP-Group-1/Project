import static org.junit.Assert.assertEquals;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class M3andO1_StepDefinition {

	Container container = new Container();
	Journey journey = new Journey();
	MeasureLog ml;
	Container container2;
	MeasureLog ml2;
	Container container3;
	List<List<MeasureLog>> loggedData;
	Container container4;
	Container container5;

	//Successfully adding measures
	@Given("a container with a {string} containerID")
	public void a_container_with_a_containerID(String string) {
		assertEquals(container.getContainerID().getClass(), string.getClass());
	}
	
	@Then("container is provided with a journey")
	public void container_is_provided_with_a_journey() {
	    container.addJourney(journey);
	}
	
	@When("a measure log is created")
	public void a_measure_log_is_created() {
		int[] measuredValues = {-10, 15, 1013};
		MeasureLog ml = new MeasureLog(measuredValues);
		this.ml = ml;
	}
	
	@Then("the measure log is added to the journey")
	public void the_measure_log_is_added_to_the_journey() {
	    container.addMeasuresContainer(ml);
	}
	
	
	//Unsuccessfully adding measures
	@Given("a container")
	public void a_container() {
	    Container container2 = new Container();
	    this.container2 = container2;
	}
	
	@Given("measurements are added without container having a journey")
	public void measurements_are_added_without_container_having_a_journey() {
		int[] measuredValues2 = {-5, 30, 1020};
		MeasureLog ml2 = new MeasureLog(measuredValues2);
		this.ml2 = ml;
		container2.addMeasuresContainer(ml2);
	}
	
	//Successfully reading measures
	@Given("a container with logged values")
	public void a_container_with_logged_values() {
	    Container container3 = new Container();
	    Journey journey3 = new Journey();
	    container3.addJourney(journey3);
	    this.container3 = container3;
	    int[] measuredValues3 = {-1, 35, 1025};
	    MeasureLog ml3 = new MeasureLog(measuredValues3);
	    container3.addMeasuresContainer(ml3);
	}
	
	@Given("user requests to see the logged data")
	public void user_requests_to_see_the_logged_data() {
	    this.loggedData = container3.getMeasures();
	}
	
	@Then("each log contains 3 integers")
	public void each_log_contains_integers() {
		assertEquals(loggedData.get(0).get(0).measures.getClass(), int[].class);
	    assertEquals(loggedData.get(0).get(0).measures.length, 3);
	}
	
	@Then("you can search for temperature, humidity and pressure")
	public void you_can_search_for_temperature_humidity_and_pressure() {
	    loggedData.get(0).get(0).getMeasure("temperature");
	    loggedData.get(0).get(0).getMeasure("humidity");
	    loggedData.get(0).get(0).getMeasure("pressure");
	}
	
	//Unsuccessfully reading measures
	@Given("a container with logged values2")
	public void a_container_with_logged_values2() {
		Container container4 = new Container();
	    Journey journey4 = new Journey();
	    container4.addJourney(journey4);
	    this.container4 = container4;
	    int[] measuredValues4 = {-20, 10, 1005};
	    MeasureLog ml4 = new MeasureLog(measuredValues4);
	    container4.addMeasuresContainer(ml4);
	}

	@Given("user requests to see weight")
	public void user_requests_to_see_weight() {
		assertEquals(container4.getMeasures().get(0).get(0).getMeasure("weight"), 0);
	}
	
	@Given("also requests an empty input")
	public void also_requests_an_empty_input() {
		assertEquals(container4.getMeasures().get(0).get(0).getMeasure(null), 0);
	}
	
	
	//Trying to read values from container with no log
	@Given("a container with no logged values")
	public void a_container_with_no_logged_values() {
		Container container5 = new Container();
	    Journey journey5 = new Journey();
	    container5.addJourney(journey5);
	    this.container5 = container5;
	}
	
	@Given("user requests values")
	public void user_requests_values() {
	    container5.getMeasures();
	}
	
}
	
	