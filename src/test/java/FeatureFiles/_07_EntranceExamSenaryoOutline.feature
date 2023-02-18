#Senaryo :
#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption         | GradeLevelOption |
#| Math exam is1   | academicPeriod1              | gradeLevel1  |
#| IT exam is1     | academicPeriod1              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod1              | gradeLevel3  |
#| Math exam  is1  | academicPeriod1              | gradeLevel4  |

Feature: Exam Funcionality

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login succesfully

  Scenario Outline: Create and Delete Exam
    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    And User sending the keys in Dialog content
      | nameInput | <ExamName> |

    And Click on the element in the Form Content
      | academicPeriod         |
      | <academicPeriodOption> |
      | gradeLevel             |
      | <gradeLevelOption>     |

    And Click on the element in the Dialog
      | saveButton |

    Then Success message should be displayed

    And Click on the element in left nav
      | entranceExamsOne |
      | setupTwo         |
      | entranceExamsTwo |

    And User delete item from Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName         | academicPeriodOption | gradeLevelOption |
      | Math exam 1is1   | academicPeriod1      | gradeLevel2      |
      | IT exam 1is1     | academicPeriod1      | gradeLevel3      |
      | Oracle exam 1is1 | academicPeriod1      | gradeLevel4      |
      | Math exam  1is1  | academicPeriod1      | gradeLevel5      |