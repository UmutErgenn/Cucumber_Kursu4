package Pages;

import Utilities._gwd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DialogContent extends Parent{  // inheritence

    public DialogContent() {
        PageFactory.initElements(_gwd.getDriver(),this);    // elementi kullandığım anda  bul
    }

    @FindBy(css = "input[formcontrolname='username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='logo-text-second']")   //span[class='mat-tooltip-trigger logo-text']
    private WebElement txtDashboard;

    @FindBy(xpath = "//ms-add-button//button")      //ms-add-button[contains(@tooltip,'TITLE.ADD')]//button
    private  WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']/input")
    private  WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']/input")
    private  WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']/input")
    private  WebElement intCodeInput;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']/input")
    private  WebElement priority;

    @FindBy(xpath = "//span[@class='mat-slide-toggle-bar']")//span[class='mat-slide-toggle-bar']>input
    private  WebElement checkbox;

    @FindBy(xpath = "//ms-save-button//button")
    private  WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')] ")     ////dynamic-view[@class='ng-star-inserted']      bu da bulur
    private WebElement successMessage;

    @FindBy(css = "a[class='ccb__edit']+button")
    private WebElement acceptCookies;

    @FindBy(xpath = "//dynamic-view[@class='ng-star-inserted']")
    private WebElement alreadyExist;

    @FindBy(xpath = "//mat-form-field//input[@data-placeholder='Name']")   // //ms-text-field//input[1]
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//mat-dialog-actions//button[2]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;

    @FindBy(xpath = "(//td[@role='cell'])[4]")
    private WebElement searchResultCellText;


    WebElement myElement;
    public void findAndSend(String strElement,String value)     // encapsulation
    {

        switch (strElement)
        {
            case "username" : myElement = username;break;
            case "password" : myElement = password;break;
            case "nameInput": myElement = nameInput;break;
            case "codeInput": myElement = codeInput;break;
            case "intCodeInput": myElement = intCodeInput;break;
            case "priority": myElement = priority;break;
            case "searchInput": myElement = searchInput;break;
        }
        sendKeysFunction(myElement,value);
    }

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "loginButton" : myElement = loginButton;break;
            case "addButton": myElement = addButton;break;
            case "checkbox": myElement = checkbox;break;
            case "saveButton": myElement = saveButton;break;
            case "acceptCookies": myElement = acceptCookies;break;
            case "searchButton": myElement = searchButton;break;
            case "deleteButton": myElement = deleteButton;break;
            case "deleteDialogBtn": myElement = deleteDialogBtn;break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement,String text)
    {
        switch (strElement)
        {
            case "txtDashboard" : myElement = txtDashboard;break;
            case "successMessage": myElement = successMessage;break;
            case "alreadyExist": myElement = alreadyExist;break;
            case "searchResultCell": myElement = searchResultCell;break;
            case "searchResultCellText": myElement = searchResultCellText;break;
        }
        verifyContainsTextFunction(myElement,text);
    }

    public void findAndDelete(String searchText)
    {
        // kelimeyi ara
        // sil
        findAndSend("searchInput",searchText);  // aranacak kelimeyi kutucuğa gönder
        findAndClick("searchButton");       // arama butonuna bas

//        wait.until(ExpectedConditions.stalenessOf(deleteButton));     stale zamanını yakalayamadım, işe yaramadı.
        findAndContainsText("searchResultCell",searchText); // arama sonuçlarının ilkinde aranan kelime gözükene kadar bekle.stale element hatası almamak için.

        findAndClick("deleteButton");       // silme butonuna bas,çöp kutusu
        findAndClick("deleteDialogBtn");        //dialogtaki silme butonuna bas
    }





}
