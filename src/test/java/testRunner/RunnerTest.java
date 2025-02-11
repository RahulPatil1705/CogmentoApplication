package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = "src/test/java",  // Adjust path if necessary
	    glue = "steps",
	    dryRun = false,
	    monochrome = true,
	    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
	    tags = "@Sanity"
		)

public class RunnerTest extends AbstractTestNGCucumberTests {
}

