package me.msc.cucumber.features.spring;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import me.msc.support.CucumberWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by jliu on 3/27/2015.
 */
@ContextConfiguration("classpath:cucumber-spring-test.xml")
public class SpringTestHookStepDef {

    @Autowired
    CucumberWorld cucumberWorld;

    @Before("@Spring")
    public void setup() {
        cucumberWorld.clean();
    }

    @After("@Spring")
    public void tearDown() {
        cucumberWorld.clean();
    }
}
