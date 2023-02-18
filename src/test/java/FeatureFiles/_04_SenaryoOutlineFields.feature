#Senaryo
#CitizenShip sayfasına gidiniz.
#Create işlemini doğrulayınız.
#Daha sonra aynı bilgilerle tekrar Create yapılamadığını doğrulayınız.
#Daha sonra Bilgileri siliniz.
#Yukarıdki işlemleri Parameter yöntemi ile yapınız.

  Feature: Fields

    Background:
      Given Navigate to Campus
      When Enter username and password and click Login button
      Then User should login succesfully
      And Navigate to Fields page

    @Regression @SmokeTest  # ikisiyle de çalış
      Scenario Outline: Create Fields
        When User a Fields name as "<Name>" code as "<Code>"
        Then Success message should be displayed

        #When User a Fields name as "<Name>" code as "<Code>"
        #Then Already exist message should be displayed

        When User delete the "<Name>"
        Then  Success message should be displayed

        Examples:
          | Name    | Code    |
          | VataIf1 | ifaVat1 |
          | VataIf2 | ifaVat2 |
          #| VataIf3 | ifaVat3 |
          #| VataIf4 | ifaVat4 |
