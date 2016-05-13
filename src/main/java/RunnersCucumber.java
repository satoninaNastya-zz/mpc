import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(format = { "pretty",
        "html:target/site/cucumber-pretty",
        "json:target/cucumber-r1.json" })

public class RunnersCucumber {
}
