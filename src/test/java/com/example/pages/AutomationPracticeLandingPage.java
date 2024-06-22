package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeLandingPage {

    private WebDriver driver;
    private WebDriverWait wait;

    
    // Constructor
    public AutomationPracticeLandingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Elements
    private By signInLinkLocator = By.className("login");
    private By emailInputLocator = By.id("email");
    private By passwordInputLocator = By.id("passwd");
    private By submitButtonLocator = By.id("SubmitLogin");
    private By alertLocator = By.xpath("//div[@class='alert alert-danger']/ol/li");
    private By accountLocator = By.className("account");

    // Methods
    public void open() {
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    public AutomationPracticeRegistrationPage clickCreateAccount() {
        WebElement signInLink = wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator));
        signInLink.click();
        return new AutomationPracticeRegistrationPage(driver);
    }
    
    public void enterEmailAddress(String emailAddress) {
    	WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
    	
//        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
    	 WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        passwordInput.sendKeys(password);
    }

   

    public void clickSignInButton() {
    	WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        signInButton.click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(alertLocator).getText();
    }
    
   
    

    // Other methods as needed
}
