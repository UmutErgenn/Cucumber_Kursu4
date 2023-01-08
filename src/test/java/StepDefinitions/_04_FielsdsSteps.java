package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities._gwd;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class _04_FielsdsSteps extends DialogContent {
    LeftNav lf = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Navigate to Fields page")
    public void navigateToFieldsPage() {
        lf.findAndClick("setupOne");
        lf.findAndClick("parameters");
        lf.findAndClick("fields");
//        dc.findAndContainsText("searchResultCellText","Text");
    }

    @When("User a Fields name as {string} code as {string}")
    public void userAFieldsNameAsCodeAs(String name, String code) {
        dc.findAndContainsText("searchResultCellText","Text");
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndClick("saveButton");
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already");
        new Actions(_gwd.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    @When("User delete the {string}")
    public void userDeleteThe(String arananKelime) {
        dc.findAndDelete(arananKelime);
    }
}
