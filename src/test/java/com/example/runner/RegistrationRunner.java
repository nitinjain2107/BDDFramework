package com.example.runner;


import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/",
glue="com.example.stepdefinations",
monochrome=true,
plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"},
tags="@Smoke")
	


public class RegistrationRunner {
	

}
