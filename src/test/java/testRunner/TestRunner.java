package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={".//Features//Login.feature"},
				//{".//Features//LoginDDT.feature"},
				//{".//Features//LoginDDTwithexcel.feature"},
		glue="stepDefination",
		plugin= {
				"pretty",
				"html:reports/myreport.html",
				"json:reports/myreport.json"},
		       //"return:target/return.text\"},
	
		        dryRun= false,
				monochrome=true
				//tags="@Sanity"
		
		)

public class TestRunner {

}
 