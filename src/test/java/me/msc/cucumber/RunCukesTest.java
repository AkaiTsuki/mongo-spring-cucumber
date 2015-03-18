package me.msc.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jiachiliu on 2/14/15.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:build/cucumber-html-report",
                "json:build/cucumber-json-report.json"},
        features = {"src/test/java/me/msc/cucumber/features"}, tags = {"@Overview"})
public class RunCukesTest {
}
