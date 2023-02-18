Feature: Fees Functionality
  @SmokeTest
  Scenario: Create Fees
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully
    And Navigate to fees page
    When create a fees
    Then Success message should be displayed