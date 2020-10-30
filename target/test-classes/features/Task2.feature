Feature: Task 2

  Scenario Outline: New scenario for adding/deleting person and job
    Given I am on people/job page
    And I click <type> person
    Then Amount of people is <size>
    Examples:
      | type   |  size |
      | Add    |   4   |
      | delete |   2   |

  Scenario: New scenario for editing person
    Given I am on people/job page
    When I click edit person
    Then First persons name is "Vitalijs" and job is "Engineer"
