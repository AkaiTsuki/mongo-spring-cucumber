package me.msc.cucumber.features.overview;

import cucumber.api.Transform;
import cucumber.api.Transformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.overview.Calculator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by jiachiliu on 3/17/15.
 */
public class DocStringStepDef {

    private String formula;
    private int actual;
    private Calculator calculator;
    @Given("^I have a formula in json format$")
    public void I_have_a_formula_in_json_format(String json) throws Throwable {
        formula = transform(json);
    }

    @When("^I have my doc string calculator$")
    public void I_have_my_doc_string_calculator() throws Throwable {
        calculator = new Calculator();
        actual = calculator.compute(formula);
    }

    @Then("^I should get result as (\\d+)$")
    public void I_should_get_result_as(int expect) throws Throwable {
        assertEquals(expect, actual);
    }

    private String transform(String json) throws IOException {
        return new ObjectMapper().readValue(json, Script.class).toString();
    }


}
