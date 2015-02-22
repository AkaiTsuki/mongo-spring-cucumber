package me.msc.cucumber.features.experiment;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jiachiliu on 2/16/15.
 */

@ContextConfiguration({"classpath:cucumber.xml"})
public class ViewCustomerRestStepDef {

    @Autowired
    RestTemplate restTemplate;

    List customers;

    @When("^I am calling rest api to find all customers with url \"([^\"]*)\"$")
    public void I_am_calling_rest_api_to_find_all_customers_with_url(String url) throws Throwable {
        assertNotNull(restTemplate);
        ResponseEntity<List> objs = restTemplate.getForEntity(url, List.class);
        customers = objs.getBody();
    }

    @Then("^a list of customers should returned by the api$")
    public void a_list_of_customers_should_returned_by_the_api() throws Throwable {
        assertNotNull(customers);
        assertEquals(4, customers.size());
        System.out.println(customers);
    }


}
