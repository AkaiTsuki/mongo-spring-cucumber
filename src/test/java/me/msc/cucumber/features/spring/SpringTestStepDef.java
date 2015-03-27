package me.msc.cucumber.features.spring;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.support.CucumberWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jliu on 3/27/2015.
 */
@ContextConfiguration("classpath:cucumber-spring-test.xml")
public class SpringTestStepDef {

    @Autowired
    private CucumberWorld cucumberWorld;

    private String username;


    @Given("^I have a username \"([^\"]*)\"$")
    public void I_have_a_username(String username) throws Throwable {
        this.username = username;
    }

    @When("^I create a user object$")
    public void I_create_a_user_object() throws Throwable {
        CucumberUser user = new CucumberUser();
        user.setUsername(this.username);
        cucumberWorld.put(username, user);
    }


    @Then("^It should saved into world object$")
    public void It_should_saved_into_world_object() throws Throwable {
        assertNotNull(cucumberWorld.get(username));
    }



}
