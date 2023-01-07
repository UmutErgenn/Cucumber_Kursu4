package Pages;

import Utilities._gwd;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Parent {
    WebDriverWait wait = new WebDriverWait(_gwd.getDriver(), Duration.ofSeconds(30));

    public void sendKeysFunction(WebElement element,String value)
    {
        waitUntillVisible(element);     //         element görünene kadar bekle
        scrollToElement(element);       //         elemente kadar scroll yap
        element.clear();                //         clear
        element.sendKeys(value);        //         sendkeys
    }

    public void clickFunction(WebElement element)
    {
        waitUntillClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void verifyContainsTextFunction(WebElement element,String value)
    {
        //         waitUntillVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));   //bazen yazı görünmeyebilir, o zaman bunu yaz
        org.testng.Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"the text you searched could not be find!");
    }
    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) _gwd.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);    // elemente kadar scroll yap.
    }
    public void waitUntillVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));   // element görünene kadar bekle
    }
    public void waitUntillClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));   // element görünene kadar bekle
    }




}