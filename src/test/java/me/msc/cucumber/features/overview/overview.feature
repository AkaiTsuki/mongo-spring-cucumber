@Overview
Feature: Cucumber Overview
  As a developer,
  In order to test if my code meet PO's acceptance criteria
  I want have an automation framework to test the program's behavior

  Scenario: Add Two Numbers
  A first taste on cucumber
    Given I have a formula "1 + 1"
    When I have my calculator
    Then I should get 2

  Scenario: Multiply Two Numbers
  A first taste on cucumber
    Given I have a formula "1 * 5"
    When I have my calculator
    Then I should get 5

  Scenario: Minus Two Numbers
  A first taste on cucumber
    * I have a formula "10 - 5"
    * I have my calculator
    * I should get 5

  Scenario Outline: Calculate Two Numbers
  Calculate two numbers
    Given I have a formula "<formula>"
    When I have my calculator
    Then I should get <result>

  Examples: Add
    | formula | result |
    | 1 + 1   | 2      |
    | 2 + 3   | 5      |

  Examples: Minus
    | formula | result |
    | 10 - 1  | 9      |
    | 3 - 2   | 1      |

  Scenario: Data Table
    Given I have a number table with operator
      | left | right | op |
      | 1    | 2     | +  |
      | 4    | 3     | -  |
      | 6    | 7     | *  |
      | 10   | 5     | /  |
    When I have my data table calculator
    And I compute all the rows
    Then I should get a list of results
      | 3  |
      | 1  |
      | 42 |
      | 2  |

  Scenario: Data Table - HashMap
    Given I have a table to be use as a map
      | 1 | 2 |
      | 3 | 4 |
    When I have my data table calculator
    And I compute all the rows
    Then I should get a list of results
      | 3 |
      | 7 |

  Scenario: Doc String
    Given I have a formula in json format
    """
      {
        "left": 1,
        "op": "+",
        "right": 3
      }
    """
    When I have my doc string calculator
#    When I have my calculator
    Then I should get result as 4

