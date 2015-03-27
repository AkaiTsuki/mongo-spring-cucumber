package me.msc.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jliu on 3/27/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:build/cucumber-spring-html-report",
                "json:build/cucumber-spring-json-report.json"},
        features = {"src/test/java/me/msc/cucumber/features"}, tags = {"@Spring"})
public class RunCukesSpringTest {
}
