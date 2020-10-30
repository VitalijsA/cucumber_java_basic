Feature: Activity one task

  Scenario: Verify "I am feeling lucky" button
    Given Navigate to the url "https://www.google.com/"
    When Click accept button
    When I enter "testText" in input
    Then Text input field is present
    And Text input has "testText" inside it
    And Search button is present
    And I'm feeling lucky button is present

