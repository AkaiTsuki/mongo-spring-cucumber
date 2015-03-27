package me.msc.cucumber.features.spring;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import me.msc.support.CucumberWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

/**
 * Created by jliu on 3/27/2015.
 */

@ContextConfiguration("classpath:cucumber-spring-test.xml")
public class SpringTestWorldStepDef {

    @Autowired
    private CucumberWorld cucumberWorld;

    private CucumberUser user;

    @When("^I read a user from world in other definition file with username \"([^\"]*)\"$")
    public void I_read_a_user_from_world_in_other_definition_file_with_username(String username) throws Throwable {
        user = (CucumberUser) cucumberWorld.get(username);
    }

    @Then("^I should get a user object with username \"([^\"]*)\"$")
    public void I_should_get_a_user_object_with_username(String expect) throws Throwable {
        assertEquals(expect, user.getUsername());
    }
}
