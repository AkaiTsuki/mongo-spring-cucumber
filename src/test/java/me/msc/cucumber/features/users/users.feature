@User
Feature: User Management
  As a user
  In order to use the website
  I want to be able to register and login to the website

  Scenario: User Register
    Given I am a guest user
    When I go to the login page
    Then I should be able to find register button
    When I click the register button
    Then I should be able to see the register page
    When I input and submit the register information
    Then I should be able to register and redirect to login page

  Scenario: User Login
    Given I am a guest user
    When I go to the login page
    And I input the username and password
    Then I should be able to login to the home page