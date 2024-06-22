package com.example.runner;


import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/SigninAndSignOut.feature"},
glue="com.example.stepdefinations",
monochrome=true,
plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"})
	


public class RegistrationRunner {
	

}
