package me.msc.cucumber.features;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.support.BrowserDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by jiachiliu on 2/14/15.
 */
public class ViewCustomerStepDef {

    WebElement navigationLink;
    WebElement customerLink;

    @Given("^I am navigate to application$")
    public void I_am_navigate_to_application() throws Throwable {
        BrowserDriver.loadPage("http://localhost:8080");
    }

    @And("^the page loaded$")
    public void the_page_loaded() throws Throwable {
        navigationLink = BrowserDriver.waitForElement(BrowserDriver.findElementById("navigationLink"));
    }


    @When("^I click the navigation link$")
    public void I_click_the_navigation_link() throws Throwable {
        assertNotNull(navigationLink);
        navigationLink.click();
        customerLink = BrowserDriver.waitForElement(BrowserDriver.findElementById("customerLink"));
    }

    @Then("^the customer link should show up$")
    public void the_customer_link_should_show_up() throws Throwable {
        assertNotNull(customerLink);
    }

    @When("^I click the customer link$")
    public void I_click_the_customer_link() throws Throwable {
        customerLink.click();
    }

    @Then("^a list of customers should show up$")
    public void a_list_of_customers_should_show_up() throws Throwable {
        WebElement customerList = BrowserDriver.waitUntilFindById("customerList", 10);
        assertNotNull(customerList);
        List<WebElement> customers = BrowserDriver.waitUntilFindAllByClass("customerCls", 10);
        assertEquals(4, customers.size());
    }
}
