package Pages;

import Utilities._gwd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{    // sayfanın solundaki table gibi olan yer için özel

    public LeftNav() {
        PageFactory.initElements(_gwd.getDriver(),this);    // elementi kullandığım anda  bul
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "(//span[text()='Parameters'])")
    private WebElement parameters;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement fees;

    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    private WebElement citizenship;

    @FindBy(xpath = "(//span[text()='Fields'])[1]")
    private WebElement fields;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExamsOne;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupTwo;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsTwo;

    WebElement myElement;

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "setupOne" : myElement=setupOne;break;
            case "parameters" : myElement=parameters;break;
            case "fees" : myElement=fees;break;
            case "fields" : myElement=fields;break;
            case "entranceExamsOne" : myElement=entranceExamsOne;break;
            case "setupTwo" : myElement=setupTwo;break;
            case "entranceExamsTwo" : myElement=entranceExamsTwo;break;
            case "citizenship" : myElement=citizenship;break;
        }
        clickFunction(myElement);
    }



}
