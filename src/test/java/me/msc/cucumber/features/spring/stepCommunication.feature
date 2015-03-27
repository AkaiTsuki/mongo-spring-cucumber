@Spring
Feature: Step Communication
  As a developer
  In order to reuse step defs in different definition file
  I want to be able to read and write stateful object between different step definition file

  Scenario: Test Scenario 1
    Given I have a username "cucumber"
    When I create a user object
    Then It should saved into world object
    When I read a user from world in other definition file with username "cucumber"
    Then I should get a user object with username "cucumber"

  Scenario: Test Scenario 2
      Given I have a username "cucumber"
      Then there should be no user with same username in the world