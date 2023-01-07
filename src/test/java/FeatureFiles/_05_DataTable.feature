Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully

    Scenario: Create Fees
      And Click on the element in left nav
        | setupOne |
        | parameters |
        | fees |