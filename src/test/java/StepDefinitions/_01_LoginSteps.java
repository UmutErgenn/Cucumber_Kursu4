package StepDefinitions;

import Pages.DialogContent;
import Utilities._gwd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps {

    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        _gwd.getDriver().get("https://test.mersys.io/");        //https://demo.mersys.io/
        _gwd.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click Login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {         // bu isim değişmemeli

        dc.findAndSend("username","turkeyts");
        dc.findAndSend("password","TechnoStudy123");
        dc.findAndClick("loginButton");
    }

    @Then("User should login succesfully")
    public void userShouldLoginSuccesfully() {
        dc.findAndContainsText("txtDashboard","2022-2023 Academic Period - Europe/London");
        // TODO : accept cookies kapatılacak
        dc.findAndClick("acceptCookies");

    }
}
