Feature: Datatable Functionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully

    Scenario: Create Fees
      And Click on the element in left nav
        | setupOne |
        | parameters |
        | fields |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Dialog content
        | nameInput | umtt101 |
        | codeInput | umtttt101 |

      And Click on the element in the Dialog
        | saveButton |

      Then Success message should be displayed

      And User delete item from Dialog
        | umtt101 |

      Scenario: Create a Fees
        And Click on the element in left nav
          | setupOne |
          | parameters |
          | fees |

        And Click on the element in the Dialog
          | addButton |

        And User sending the keys in Dialog content
          | nameInput | umtt101 |
          | codeInput | umtttt0101 |
          | intCodeInput | umttrgn101 |
          | priority | 154 |

        And Click on the element in the Dialog
          | checkbox |
          | saveButton |

        Then Success message should be displayed

        And User delete item from Dialog
          | umtt101 |

        Then Success message should be displayed