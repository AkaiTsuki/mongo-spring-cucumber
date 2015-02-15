Feature: View Customers
  Scenario: View Customer
    Given I am navigate to application
    And the page loaded
    When I click the navigation link
    Then the customer link should show up
    When I click the customer link
    Then a list of customers should show up