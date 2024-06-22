package bddtask.BDDProject;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources",
glue="bddtask.BDDProject",
plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})
	

public class RunCucumberTest {

}
