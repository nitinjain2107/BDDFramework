package com.example.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import com.example.pages.AutomationPracticeHomePage;
import com.example.pages.AutomationPracticeLandingPage;
import com.example.pages.AutomationPracticeRegistrationPage;
import com.example.utils.DriverFactory;

import java.util.Map;


public class RegistrationStepDef {

	private WebDriver driver = DriverFactory.getInstance().getDriver();
    private AutomationPracticeLandingPage landingPage= new AutomationPracticeLandingPage(driver);
    private AutomationPracticeRegistrationPage registrationPage= new AutomationPracticeRegistrationPage(driver);
    private AutomationPracticeHomePage homePage= new AutomationPracticeHomePage(driver);


    @Given("I am on the Automation Practice landing page")
    public void i_am_on_the_automation_practice_landing_page() {
        landingPage.open();
    }

    @When("I navigate to create an account section")
    public void i_navigate_to_create_an_account_section() {
        registrationPage = landingPage.clickCreateAccount();
    }

    @When("I enter valid email address {string}")
    public void i_enter_valid_email_address(String emailAddress) {
        registrationPage.enterEmailAddress(emailAddress);
    }

    @When("I click on the Create an account button")
    public void i_click_on_the_create_an_account_button() {
        registrationPage.clickCreateAccountButton();
    }

    @Then("I should see the Create an account form")
    public void i_should_see_the_create_an_account_form() {
        registrationPage.waitForRegistrationForm();
    }

    @Then("I fill out the registration form with:")
    public void i_fill_out_the_registration_form_with(Map<String, String> formData) {
        registrationPage.fillRegistrationForm(
            formData.get("Title"),
            formData.get("First Name"),
            formData.get("Last Name"),
            formData.get("Password"),
            formData.get("Date of Birth")
        );
    }

    @Then("I complete the registration")
    public void i_complete_the_registration() {
        registrationPage.submitRegistration();
    }

    @Then("I should be registered successfully and logged in")
    public void i_should_be_registered_successfully_and_logged_in() {
        // Add verification steps for successful registration and login if needed
    	
    	boolean isLoggedIn = homePage.isUserLoggedIn();
        Assert.assertTrue("User should be logged in after successful registration", isLoggedIn);
        
        
    }
    @When("I enter existing email address {string}")
    public void i_enter_existing_email_address(String emailAddress) {
        registrationPage.enterEmailAddress(emailAddress);
    }
    @Then("I should see an error message stating {string}")
    public void i_should_see_an_error_message_stating(String expectedErrorMessage) {
    	 String actualErrorMessage = registrationPage.getErrorMessage();
         Assert.assertEquals("Error message for existing mail", expectedErrorMessage, actualErrorMessage);
         
         
    }
//
    @When("I enter invalid email address {string}")
    public void i_enter_invalid_email_address(String invalidEmail) {
        registrationPage.enterEmailAddress(invalidEmail);
    }
//
    @Then("I should see an error message stating {string} for invalid email")
    public void i_should_see_an_error_message_stating_for_invalid_email(String expectedErrorMessage) {
        String actualErrorMessage = registrationPage.getErrorMessage();
        Assert.assertEquals("Error message for invalid email mismatch", expectedErrorMessage, actualErrorMessage);
        
    }

    

}
