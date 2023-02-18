#Senaryo :
#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  name, code, intCode ve priority için 5 farklı değerler için çalıştırınız.
Feature: Fee Functionality (DataTable- Scenario Outline)
  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully

  Scenario Outline: Create a Fees
    And Click on the element in left nav
      | setupOne |
      | parameters |
      | fees |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <Name> |
      | codeInput | <Code> |
      | intCodeInput | <IntCode> |
      | priority | <Priority> |

    And Click on the element in the Dialog
      | checkbox |
      | saveButton |

    Then Success message should be displayed

    And User delete item from Dialog
      | <Name> |

    Then Success message should be displayed
    Examples:
      | Name | Code | IntCode | Priority |
      | umt14 | umtt12 | umt211 | 256 |
      | umt25 | umtt13 | umt212 | 358 |
      | umt36 | umtt14 | umt213| 249 |
      | umt47 | umtt15 | umt214 | 578 |
      | umt58 | umtt16 | umt215 | 345 |