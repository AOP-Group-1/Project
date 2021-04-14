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
Feature: journey management

  @tag1
  Scenario: successful add
    Given a new journey
    And corresponding containers are not registered yet
    And the client supplies the important details
    When the client registers new containers
    And the client enters their origin
    And the client enters their destination 
    And the client enters their content type
    And the client enters their company
    Then the container is successfully registered
    And the journey get a journey ID


