package me.msc.cucumber.features.overview;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.overview.Calculator;

import static org.junit.Assert.*;

/**
 * Created by jiachiliu on 3/17/15.
 */
public class BasicStepDef {

    private String formula;
    private Calculator calculator;

    @Given("^I have a formula \"([^\"]*)\"$")
    public void I_have_a_formula(String formula) throws Throwable {
        this.formula = formula;
    }

    @When("^I have my calculator$")
    public void Use_my_calculator() throws Throwable {
        calculator = new Calculator();
    }

    @Then("^I should get (\\d+)$")
    public void I_should_get(int result) throws Throwable {
        assertEquals(result, calculator.compute(formula));
    }
}
