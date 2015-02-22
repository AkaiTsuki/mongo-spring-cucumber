Feature: Dashboard
  As a member of the website
  In order to manage my articles
  I want to have a dashboard

  Background:
    Given I am a guest
    When I go to the login page
    And login with username and password
    Then I should go to my dashboard

  Scenario: List My Articles
    When I am at dashboard
    Then I should be able to see all my articles
    And my articles should list in reverse order of time