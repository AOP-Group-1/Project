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
Feature: client management

  @tag1
  Scenario: Successful add
    Given a new client
    And the client is not registered yet
    And the client supplies the important details
    When the logistics company registers the new client
    And the client enters their name
    And the client enters their email
    And the client enters their address
    And the client enters their reference person
    Then the client is successfully registered
    And the client get a client ID

 
