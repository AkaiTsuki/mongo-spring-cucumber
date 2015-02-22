Feature: Article Management
  As a member of the website
  In order to share my life
  I want to be able to post articles

  Background:
    Given I am a guest
    When I go to the login page
    And login with username and password
    Then I should go to my dashboard

  Scenario: Post Article
    When I click post button
    Then I should see a form that I can input an article
    And I input content and submit
    Then I should see the article is published
