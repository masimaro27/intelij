package tutorial.cucumber.steps;

public class MyStepdefs_2 {
    @io.cucumber.java.en.Given("I have {int} beer cans2")
    public void iHaveOpeningBalanceBeerCans(int ob) {
        System.out.println(ob);
    }

    @io.cucumber.java.en.And("I have drunk {int} beer cans2")
    public void iHaveDrunkProcessedBeerCans(int process) {
        System.out.println(process);
    }

    @io.cucumber.java.en.When("I go to my fridge2")
    public void iGoToMyFridge() {

    }

    @io.cucumber.java.en.Then("I should have {int} beer cans2")
    public void iShouldHaveInStockBeerCans(int stock) {
        System.out.println(stock);
    }
}
