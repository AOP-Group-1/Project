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
Feature: Registering containers for journeys

  @tag1
  Scenario: Register container for journey
    Given a container
    Then the client registers it for a journey
    Then a journey ID "string" is auto generated
    And submit the registration
    
  Scenario: Track container
  	Given a container on a journey;
  	Then the client searches for the container ID
  	
  Scenario: Track container with multiple input
  	Given a search for mulitple input
  	
  Scenario: Searching for uncompleted journeys
  	Given a search for an uncompleted journey
  	
  Scenario: Check availability for container
  	Given a need for a container
  	Then the client checks container availability
