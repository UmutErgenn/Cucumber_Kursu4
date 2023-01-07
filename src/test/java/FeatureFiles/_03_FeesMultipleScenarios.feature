Feature: Fees Multi Scenario

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully
    And Navigate to fees page

  Scenario: Create Fees
    When create a fees
    Then Success message should be displayed

    Scenario: Create a Fees parameter data
      When Create a fees name as "umUlk111" code as"umUlk11" intCode as "umUlk1111" priority as"445"
      Then Success message should be displayed