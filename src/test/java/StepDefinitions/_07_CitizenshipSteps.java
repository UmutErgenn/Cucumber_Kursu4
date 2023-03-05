package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _07_CitizenshipSteps {
    LeftNav ln = new LeftNav();

    DialogContent dc = new DialogContent();

    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("citizenship");
    }

    @Then("User should login successfuly")
    public void userShouldLoginSuccessfuly() {

    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shorname) {
        dc.findAndClick("addButton");
        dc.findAndSend("nameInput", name);
        dc.findAndSend("shortName", shorname);
        dc.findAndClick("saveButton");
    }
}
