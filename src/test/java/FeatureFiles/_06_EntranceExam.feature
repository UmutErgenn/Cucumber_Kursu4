#    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
#    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.

#Senaryo :
#  Exam Formunun Çalışmasını test ediniz
#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

  Feature: Exam Funcionality
    Background:
      Given Navigate to Campus
      When Enter username and password and click Login button
      Then User should login succesfully

    Scenario: Create and Delete Exam
      And Click on the element in left nav
        | entranceExamsOne |
        | setupTwo |
        | entranceExamsTwo |

      And Click on the element in the Dialog
        | addButton |

      And User sending the keys in Dialog content
        | nameInput | umttExm2 |

      And Click on the element in the Form Content
        | academicPeriod |
        | academicPeriod1 |
        | gradeLevel |
        | gradeLevel2 |

      And Click on the element in the Dialog
        | saveButton |

      Then Success message should be displayed

      And Click on the element in left nav
        | entranceExamsOne |
        | setupTwo |
        | entranceExamsTwo |

      And User delete item from Dialog
        | umttExm2 |

      Then Success message should be displayed