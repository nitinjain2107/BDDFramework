package com.example.stepdefinations;

import com.example.utils.DriverFactory;

import io.cucumber.java.After;

public class Hooks {
	
	
	@After
	public void teardown() {
		DriverFactory.getInstance().quitDriver();
	}

}
