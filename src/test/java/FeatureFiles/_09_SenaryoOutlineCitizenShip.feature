#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Daha sonra Bilgileri siliniz
#Yukarıdaki işlemleri Parameter yöntemi ile yapınız.

Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to Campus
    When Enter username and password and click Login button
    Then User should login successfuly
    And Navigate to CitizenShip page

    @Regression
  Scenario Outline: CitizenShip Create
    When User a CitizenShip name as "<Name>" short name as "<ShortName>"


    When User a CitizenShip name as "<Name>" short name as "<ShortName>"


    When User delete the "<Name>"


    Examples:
      | Name    | ShortName |
      | vatIs11 | isVat11   |
      | vatIs21 | isVat12   |
      | vatIs31 | isVat13   |
      | vatIs41 | isVat14   |
