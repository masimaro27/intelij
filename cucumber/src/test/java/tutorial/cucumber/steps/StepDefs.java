package tutorial.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tutorial.cucumber.SpringIntegrationTest;

public class StepDefs extends SpringIntegrationTest {
    @Given("I have {int} beer cans3")
    public void i_have_beer_cans3(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("1");
    }
    @And("I have drunk {int} beer cans3")
    public void iHaveDrunkProcessedBeerCans(int process) {
        System.out.println(process);
    }
    @When("I go to my fridge3")
    public void i_go_to_my_fridge3() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("2");
    }
    @Then("I should have {int} beer cans3")
    public void i_should_have_beer_cans3(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("3");
    }
}
