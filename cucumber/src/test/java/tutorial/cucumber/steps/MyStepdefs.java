package tutorial.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorial.cucumber.SpringIntegrationTest;

public class MyStepdefs extends SpringIntegrationTest {
    @Given("I have <opening balance> beer cans")
    public void iHaveOpeningBalanceBeerCans() {
        System.out.println("MyStepdefs");
    }

    @And("I have drunk <processed> beer cans")
    public void iHaveDrunkProcessedBeerCans() {
        System.out.println("MyStepdefs");
    }

    @When("I go to my fridge")
    public void iGoToMyFridge() {
        System.out.println("MyStepdefs");
    }

    @Then("I should have <in stock> beer cans")
    public void iShouldHaveInStockBeerCans() {
        System.out.println("MyStepdefs");
    }
}
