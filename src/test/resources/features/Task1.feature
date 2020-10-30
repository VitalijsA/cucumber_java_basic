@regression
Feature: Task 1
Background:
  @debugs
  Scenario Outline: Scenario outline for wrong value
    Given I am on enter number page
    When I enter number: "<number>"
    And I click submit number
    Then I see the message: "<message>"
    @not_working
    Examples:
      | number | message                        |
      | 5      | Number is too small            |
      | 505    | Number is too big              |
      | test   | Please enter a number          |

Scenario: New scenario for valid values
  Given I am on enter number page
  When  I enter number: 55
  And   I click submit number
  Then  I see the alert message "Square root of 55 is 7.42"

