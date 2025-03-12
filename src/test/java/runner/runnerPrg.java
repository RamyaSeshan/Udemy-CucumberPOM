package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "steps" },
		// tags = "@QA or @Dev or @Stage",
		//tags = "@datatable",
		plugin = { "html:target/cucumber-reports/cucumberReport.html" ,
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
		
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }    ) 

public class runnerPrg extends AbstractTestNGCucumberTests {

}
