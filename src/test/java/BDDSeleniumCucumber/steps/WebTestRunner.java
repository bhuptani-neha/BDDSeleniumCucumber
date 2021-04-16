package BDDSeleniumCucumber.steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber-report.html","pretty"}
		 ,features = "src/test/resources/features"
		 ,snippets = SnippetType.CAMELCASE
		 
		 )
public class WebTestRunner {

}