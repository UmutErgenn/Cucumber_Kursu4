package Runners;

import Utilities._gwd;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

@CucumberOptions(
        tags = "@Regression",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
)
public class _09_TestRunnerParallel extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser)
    {
        // browser türünü gwd'ye gönder
        _gwd.setThreadBrowserName(browser);
    }
}
