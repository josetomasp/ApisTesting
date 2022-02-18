package automation_frontend;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = { "classpath:automation_frontend.steps"},
        monochrome = true,
        strict = true,
        tags = {"@ID001"},
        plugin = {"pretty", "html:target/cucumber-reports", "summary"}
)

public class DesaRunner extends AbstractTestNGCucumberTests {


}
