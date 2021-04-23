package runnerForPassedTestCases;


import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/features/PassedTestCasesForRegisterAndLogin.feature"
        ,glue = {"stepsForPassedTestCases"}
        ,plugin = {"pretty","html:target/reports/cucumber report.html"})
public class PassedTestCases extends TestBase {
}
