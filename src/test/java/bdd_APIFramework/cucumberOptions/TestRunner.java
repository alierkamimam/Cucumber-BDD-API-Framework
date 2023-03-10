package bdd_APIFramework.cucumberOptions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun.txt"
        },

        features = "src\\test\\java\\bdd_APIFramework\\features",
        glue = "bdd_APIFramework\\stepDefinations",
        tags ="@Validating")
public class TestRunner {

}
