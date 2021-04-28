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
Feature: Reading measured values

  @tag1
  Scenario: Successfully reading values from container log
    Given a container with logged values
    And user requests to see the logged data
    Then each log contains 3 integers
    And you can search for temperature, humidity and pressure
    
  Scenario: Unsuccessfully reading values from container log
  	Given a container with logged values2
  	And user requests to see weight
  	And also requests an empty input
  	
  Scenario: Trying to read values from container with no log
  	Given a container with no logged values
  	And user requests values

