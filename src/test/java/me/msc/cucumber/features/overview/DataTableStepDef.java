package me.msc.cucumber.features.overview;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.overview.Calculator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by jiachiliu on 3/17/15.
 */
public class DataTableStepDef {

    private List<String> formulaList;
    private Calculator calculator;
    private List<Integer> actualResults;

    @Given("^I have a number table with operator$")
    public void I_have_a_number_table_with_operator(List<Script> scripts) throws Throwable {
        formulaList = new LinkedList<String>();
        for (Script r : scripts) {
            formulaList.add(r.toString());
        }
    }

    @When("^I have my data table calculator$")
    public void I_have_my_data_table_calculator() throws Throwable {
        calculator = new Calculator();
    }

    @And("^I compute all the rows$")
    public void I_compute_all_the_rows() throws Throwable {
        actualResults = new LinkedList<Integer>();
        for (String formula : formulaList)
            actualResults.add(calculator.compute(formula));
    }

    @Then("^I should get a list of results$")
    public void I_should_get_a_list_of_results(List<Integer> expected) throws Throwable {
        assertEquals(expected, actualResults);
    }

    @Given("^I have a table to be use as a map$")
    public void I_have_a_table_to_be_use_as_a_map(Map<Integer, Integer> map) throws Throwable {
        formulaList = new LinkedList<String>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            formulaList.add(String.format("%d %s %d", entry.getKey(), "+", entry.getValue()));
        }
    }
}
