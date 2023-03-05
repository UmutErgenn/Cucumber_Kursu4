Feature: ApachePOI Citizen Functionalty

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully
    And Navigate to Fields page

  Scenario: Create fields from excel
    When User Create fields with ApachePOI

  Scenario: Delete fields from excel
    Then User Delete fields with ApachePOI