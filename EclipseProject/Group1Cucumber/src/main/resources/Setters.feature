@tag
Feature: Set a measure #measures = Temperature, Humidity, Atmosphere
  @tag2 #Do we need new tag numbers for each feature?
  Scenario: Temperature successfully set
    Given a tracked container with internal temperature -10 degrees celsius
    Then temperature is set true 
    Then temperature is equal to new value
  
  Scenario: Humidity successfully set
    Given a tracked container with air humidity 30 percent
    Then humidity is set true 
    Then humidity is equal to new value

  Scenario: Atmosphere successfully set
    Given a tracked container with atmospheric pressure 102 kilo Pascals
    Then atmospheric pressure is set true 
    Then atmospheric pressure is equal to new value  
  
  Scenario: Missing category used for setting measurement
  	Given a measurement 5 entered into Null category
  	Then null-category return value is false
	
	Scenario: No matching category used for setting measurement
		Given a measurement 5 entered into "unused space" category
  	Then unused space-category return value is false
  