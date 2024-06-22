package com.example.stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import com.example.pages.AutomationPracticeHomePage;
import com.example.pages.AutomationPracticeLandingPage;
import com.example.pages.AutomationPracticeRegistrationPage;
import com.example.utils.Context;
import com.example.utils.DriverFactory;

import org.junit.Assert;

public class SignInSignOutStepDefs {

	private WebDriver driver;
    private AutomationPracticeLandingPage landingPage;
    private AutomationPracticeRegistrationPage registrationPage;
    private AutomationPracticeHomePage homePage;
    private Context context;
    
    public SignInSignOutStepDefs(Context context) {
    	driver = DriverFactory.getInstance().getDriver();
    	landingPage= new AutomationPracticeLandingPage(driver);
    	registrationPage= new AutomationPracticeRegistrationPage(driver);
    	homePage= new AutomationPracticeHomePage(driver);
    	this.context= context;
    	
    }


    @Given("I am on the Automation Practice signin page")
    public void i_am_on_the_automation_practice_signin_page() {
        landingPage.open();
    }

    @When("I sign in with {string} and {string}")
    public void i_sign_in_with_credentials(String email, String password) {
    	context.setContext("email", email);
    	context.setContext("password",password );
    	landingPage.enterEmailAddress(email);
        landingPage.enterPassword(password);
        landingPage.clickSignInButton();
    }

    @Then("I should be logged in successfully")
    public void i_should_see_result() {
    	boolean isLoggedIn = homePage.isUserLoggedIn();
    	System.out.println("boolen value is" +isLoggedIn);
        Assert.assertTrue("User should be logged in ", isLoggedIn);
        
        
    
    }
    @Then("I should see an error message as {string}")
    public void i_should_see_an_error_message_stating(String errorMessage) {
        Assert.assertEquals(errorMessage, landingPage.getErrorMessage());
        
    }
    @Given("I am logged in on the Automation Practice website")
    public void i_am_logged_in_on_the_automation_practice_website() {
        

    	landingPage.open();
//    	landingPage.enterEmailAddress(context.getContext("email"));
//        landingPage.enterPassword(context.getContext("password"));
    	landingPage.enterEmailAddress("testjoe2@example.com");
    	landingPage.enterPassword("Password123");
        landingPage.clickSignInButton();
        boolean isLoggedIn = homePage.isUserLoggedIn();
        Assert.assertTrue("User should be logged in ", isLoggedIn);
    }
    

    @When("I sign out from the account")
    public void i_sign_out_from_the_account() {
        homePage.clickSignOutButton();
    }

    @Then("I should be logged out successfully")
    public void i_should_be_logged_out_successfully() {
    	String actualTitle = homePage.getPageTitle();
        Assert.assertEquals(actualTitle, "Login - My Shop");
    }
    
   


    // Additional step definitions can be added as needed
}
