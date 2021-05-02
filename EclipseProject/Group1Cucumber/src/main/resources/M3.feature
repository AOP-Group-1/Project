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
Feature: Tracking internal container status

  @tag1
  Scenario: Add measurements to container
    Given a container on a journey
    And a set of internal measurements are measured
    Then the measurements are logged
   
  Scenario: Check internal status
  	Given a container on a journey_
  	And the client want to check the internal status of a specific container
  	Then the client searches for the internal status
  	
  Scenario: Check for available containers
  	Given a client need an avaiable container
  	Then client searches for available containers


