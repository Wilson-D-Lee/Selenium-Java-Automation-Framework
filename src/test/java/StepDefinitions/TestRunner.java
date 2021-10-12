package StepDefinitions;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

// Test runner allows you to run test selectively with Cucumber Options for reporting -
// HTML5 |JSON | JUNIT/XML

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"StepDefinitions"},
        plugin = {"json:target/cucumber.json"})

//      plugin = {"pretty", "json:target/cucumber.json"}
//      Cucumber mvn file Reporting.

//      plugin = {"pretty", "json:target/jsonReports/report.json"}
//      JSON file Reporting.

//      plugin = {"pretty", "html:target/htmlReports"}
//      HTML file Reporting.

//      plugin = {"pretty", "junit:target/junitReports/report.xml"}
//      XML Reports can be good for later Jenkins Integration
class TestRunner {

}
