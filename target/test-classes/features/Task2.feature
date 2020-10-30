Feature: Task 2

  Scenario Outline: New scenario for adding/deleting/editing person and job
    Given I am on people/job page
    And I click <type> person
    Then Amount of people is <size>
    And After <action> person with "<name>" and "<job>" <status> on the page.
    Examples:
      | type   |  size | action   | status  | name      |     job      |
      | Add    |   4   | adding   |    is   | Vitalijs  | Engineer     |
      | delete |   2   | deleting | is not  | Mike      | Web Designer |
      | edit   |   3   | editing  |    is   | Vitalijs  | Engineer     |

  Scenario Outline: New scenario for resetting list after adding/deleting/editing person and job
    Given I am on people/job page
    And I click <type> person
    And I click reset original list
    Then Amount of people is <size>
    And Resetting After <action> person with "<name>" and "<job>" <status> on the page.
    Examples:
      | type   |  size | action   | status  | name      |     job      |
      | Add    |   3   | adding   | is not  | Vitalijs  | Engineer     |
      | delete |   3   | deleting |   is    | Mike      | Web Designer |
      | edit   |   3   | editing  | is not  | Vitalijs  | Engineer     |

    Scenario: New scenario to check that clear button on adding a user works correctly
      Given I am on people/job page
      And I click Add person button
      And I enter name "Vitalijs" and job "Engineer"
      When I click clear all fields
      Then Name and job fields are empty
