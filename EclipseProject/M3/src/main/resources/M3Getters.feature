#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Requesting information on container

  @tag1
	Scenario: User successfully asks for temperature
		Given a request for temperature "string"
		Then a list of temperatures

	Scenario: User successfully asks for humidity
		Given a request for humidity "string"
		Then a list of humidities

	Scenario: User successfully asks for atmospheric pressure
		Given a request for atmospheric pressure "string"
		Then a list of pressures
		
	Scenario: User unsuccessfully asks for category
		Given a request for temture "string"
		Then error message displayed
		
	Scenario: User asks for nothing
		Given an empty request "string"
		Then error message is displayed
