package me.msc.cucumber.features.overview;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.Transformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.overview.Calculator;

import static org.junit.Assert.*;

/**
 * Created by jliu on 3/18/2015.
 */
public class TransformStepDef {

    Integer actual;
    Script script;

    @Given("^I have a string number \"([^\"]*)\"$")
    public void I_have_a_string_number(@Transform(StringToIntegerConverter.class) Integer input) throws Throwable {
        actual = input;
    }

    @Then("^I should get the transformed string as (\\d+)$")
    public void I_should_get_the_transformed_string_as(Integer expect) throws Throwable {
        assertEquals(expect, actual);
    }

    @Given("^I have a formula \"([^\"]*)\" to transform$")
    public void I_have_a_formula_to_transform(@Transform(ScriptConverter.class) Script input) throws Throwable {
       script = input;
    }

    @When("^I have my transform calculator$")
    public void I_have_my_transform_calculator() throws Throwable {
        Calculator c= new Calculator();
        actual = c.compute(script.toString());
    }

    @Then("^I should get cacluated result (\\d+)$")
    public void I_should_get_cacluated_result(Integer expect) throws Throwable {
        assertEquals(expect, actual);
    }


    public static class StringToIntegerConverter extends Transformer<Integer> {

        @Override
        public Integer transform(String value) {
            return Integer.parseInt(value);
        }
    }

    public static class ScriptConverter extends Transformer<Script> {

        @Override
        public Script transform(String value) {
            Script s = new Script();
            String[] tokens = value.split(" ");
            s.setLeft(Integer.parseInt(tokens[0]));
            s.setOp(tokens[1]);
            s.setRight(Integer.parseInt(tokens[2]));
            return s;
        }
    }
}
