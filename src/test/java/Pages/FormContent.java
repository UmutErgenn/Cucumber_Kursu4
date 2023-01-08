package Pages;

import Utilities._gwd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormContent extends Parent {
    public FormContent() {PageFactory.initElements(_gwd.getDriver(), this);}

    @FindBy(xpath = "//mat-select[@formcontrolname='academicPeriod']/div/div[1]")
    private WebElement academicPeriod;
    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement academicPeriod1;

    @FindBy(xpath = "//mat-select[@formcontrolname='id']/div/div[1]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement gradeLevel2;

    WebElement myElement;

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "academicPeriod" : myElement = academicPeriod;break;
            case "academicPeriod1": myElement = academicPeriod1;break;
            case "gradeLevel": myElement = gradeLevel;break;
            case "gradeLevel2": myElement = gradeLevel2;break;
        }
        clickFunction(myElement);
    }


}
