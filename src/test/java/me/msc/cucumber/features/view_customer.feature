Feature: View Customers

  @Functional
  Scenario: View Customer
    Given I am navigate to application
    And the page loaded
    When I click the navigation link
    Then the customer link should show up
    When I click the customer link
    Then a list of customers should show up

  @Integration
  Scenario: View By First Name
    Given I have a first name "John"
    When I find customers with this first name
    Then I should get a customer called "John Smith"

  @RestApi
  Scenario: View Customer Via Rest Api
    When I am calling rest api to find all customers with url "http://localhost:8080/mongo/collection/customer"
    Then a list of customers should returned by the api