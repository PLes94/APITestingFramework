package my.testing.packagey.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/",
        glue = "my/testing/packagey/stepdefinitions/",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        dryRun = true,
        monochrome = true
)
public class TestRunner {

}
