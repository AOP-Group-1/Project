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
Feature: Assign measurements to container log

  @tag1
  Scenario: Container is properly set up to receive measurements
    Given a container with a "string" containerID
    Then container is provided with a journey
    When a measure log is created
    Then the measure log is added to the journey
    
  Scenario: Container is NOT properly set up to receive measurements
  	Given a container
  	And measurements are added without container having a journey
		#Maybe addd a "Then" and have the facade do something


