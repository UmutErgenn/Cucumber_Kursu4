package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature"},  // çalışacak olan feature file's ın path(yol)'i verilecek
        glue = {"StepDefinitions"}       // Step definations'ın klasörü yazılacak

)
public class _01_TestRunner extends AbstractTestNGCucumberTests {



}
