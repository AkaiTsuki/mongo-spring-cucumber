package me.msc.cucumber.features;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.collection.domain.Customer;
import me.msc.collection.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jiachiliu on 2/15/15.
 */

@ContextConfiguration("classpath:cucumber.xml")
public class ViewCustomerByFirstNameStepDef {

    @Autowired
    CustomerRepository customerRepository;

    String firstName;

    List<Customer> customers;

    @Given("^I have a first name \"([^\"]*)\"$")
    public void I_have_a_first_name(String firstName) throws Throwable {
        assertNotNull(customerRepository);
        this.firstName = firstName;
    }

    @When("^I find customers with this first name$")
    public void I_find_customers_with_this_first_name() throws Throwable {
        customers = customerRepository.findByFirstName(firstName);
    }

    @Then("^I should get a customer called \"([^\"]*)\"$")
    public void I_should_get_a_customer_called(String fullName) throws Throwable {
        assertNotNull(customers);
        assertEquals(1, customers.size());
        Customer customer = customers.get(0);
        String customerName = customer.getFirstName() + " " + customer.getLastName();
        assertEquals(fullName, customerName);
    }
}
