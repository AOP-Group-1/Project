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
Feature: Client management

  @tag1
  Scenario: Register new client
    Given a new client with information
    And a client ID "string" is auto generated
    Then I want to register the information
    And create a password for the client
    And save the data

	Scenario: Edit user information
		Given a registered client
		And a new reference person is chosen
		Then the client edits reference person
		And the client edits email
		
	Scenario: Search for client
		Given a need for seeing client info related to client email
		Then the company searches using the email
		
	Scenario: Search for mulitple inputs
		Given a need for client info
		Then the company searches for mulitple info
		
	Scenario: Unsuccessful search for client
		Given a need for seeing client info related to client email_
		Then the company searches using nothing
		
	Scenario: Searching for all clients
		Given a need to know all clients
		Then the company searches for all clients



