package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin={"pretty",
                "rerun:target/failedScenarios.txt",
                "json:target/reports/json-reports/cucumber1.json"
        },
        features="src/test/resources/features",
        glue = "stepdefs",
        tags="@Team",
        dryRun = false
)
public class TeamRunner {

}
