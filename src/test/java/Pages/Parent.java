package Pages;

import Utilities._gwd;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Parent {
    WebDriverWait wait = new WebDriverWait(_gwd.getDriver(), Duration.ofSeconds(3));

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
//        try {
//            element.click();
//        }catch (org.openqa.selenium.StaleElementReferenceException ex)
//        {
//            element.click();
//        }
//        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));
//      stale element hatasını gidermek için kullanılabilir.    progress barın çocukları 0 olana kadar bekle.
    }

    public void verifyContainsTextFunction(WebElement element,String value)
    {
        //         waitUntillVisible(element);
        wait.until(ExpectedConditions.textToBePresentInElement(element,value));   //bazen yazı görünmeyebilir, o zaman bunu yaz
        org.testng.Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"the text you searched could not be find!");
        new Actions(_gwd.getDriver()).sendKeys(Keys.ESCAPE).perform();
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

    public void waitUntilLoading(){
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));

        //        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"),0));
//      stale element hatasını gidermek için kullanılabilir.    progress barın çocukları 0 olana kadar bekle.
    }




}
