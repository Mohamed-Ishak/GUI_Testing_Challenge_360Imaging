package runnerForFailedTestCases;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/FailedTestCasesForRegisterAndLogin.feature"
                 ,glue = {"stepsForFailedTestCases"}
                 ,plugin = {"pretty","html:target/reports/cucumber report.html"})
public class FailedTestCases extends TestBase {
}


