package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_FeesSteps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate to fees page")
    public void navigateToFeesPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("fees");
    }

    @When("create a fees")
    public void createAFees() {
        String randomGenName = RandomStringUtils.randomAlphanumeric(8);
        String randomGenCode = RandomStringUtils.randomNumeric(4);
        String randomGenIntCode = RandomStringUtils.randomNumeric(4);
        String randomGenPriority = RandomStringUtils.randomNumeric(4);


        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",randomGenName);
        dc.findAndSend("codeInput",randomGenCode);
        dc.findAndSend("intCodeInput",randomGenIntCode);
        dc.findAndSend("priority",randomGenPriority);
        dc.findAndClick("checkbox");
        dc.findAndClick("saveButton");
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("successMessage","success");
    }


    @When("Create a fees name as {string} code as{string} intCode as {string} priority as{string}")
    public void createAFeesNameAsCodeAsIntCodeAsPriorityAs(String name, String code, String intCode, String priority) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput",name);
        dc.findAndSend("codeInput",code);
        dc.findAndSend("intCodeInput",intCode);
        dc.findAndSend("priority",priority);
        dc.findAndClick("checkbox");
        dc.findAndClick("saveButton");
    }
}
