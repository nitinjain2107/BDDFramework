package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationPracticeRegistrationPage {

	private WebDriver driver;
	private WebDriverWait wait;

	// Constructor
	public AutomationPracticeRegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Elements
	private By emailInputLocator = By.id("email_create");
	private By createAccountButtonLocator = By.id("SubmitCreate");
	private By registrationFormLocator = By.id("account-creation_form");
	private By titleMrRadioLocator = By.id("id_gender1");
	private By titleMrsRadioLocator = By.id("id_gender2");
	private By firstNameInputLocator = By.id("customer_firstname");
	private By lastNameInputLocator = By.id("customer_lastname");
	private By passwordInputLocator = By.id("passwd");
	private By daysDropdownLocator = By.id("days");
	private By monthsDropdownLocator = By.id("months");
	private By yearsDropdownLocator = By.id("years");
	private By registerButtonLocator = By.id("submitAccount");
	private By errorMessageBoxLocator = By.cssSelector(".alert-danger");

	// Methods
	public void enterEmailAddress(String emailAddress) {
		WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInputLocator));
		
		emailInput.sendKeys(emailAddress);
	}

	public void clickCreateAccountButton() {
		WebElement createAccountButton = wait
				.until(ExpectedConditions.elementToBeClickable(createAccountButtonLocator));
		createAccountButton.click();
	}

	public void waitForRegistrationForm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(registrationFormLocator));
	}

	public void fillRegistrationForm(String title, String firstName, String lastName, String password, String dob) {
		if (title.equalsIgnoreCase("Mr")) {
			driver.findElement(titleMrRadioLocator).click();
		} else if (title.equalsIgnoreCase("Mrs")) {
			driver.findElement(titleMrsRadioLocator).click();
		}

		WebElement firstNameInput = driver.findElement(firstNameInputLocator);
		firstNameInput.sendKeys(firstName);

		WebElement lastNameInput = driver.findElement(lastNameInputLocator);
		lastNameInput.sendKeys(lastName);

		WebElement passwordInput = driver.findElement(passwordInputLocator);
		passwordInput.sendKeys(password);

		String[] dobParts = dob.split("/");
		String day = dobParts[0];
		String month = dobParts[1];
		String year = dobParts[2];
		day = removeLeadingZero(day);
		month = removeLeadingZero(month);
		Select daysDropdown = new Select(driver.findElement(daysDropdownLocator));
		daysDropdown.selectByValue(day);

		Select monthsDropdown = new Select(driver.findElement(monthsDropdownLocator));
		monthsDropdown.selectByValue(month);

		Select yearsDropdown = new Select(driver.findElement(yearsDropdownLocator));
		yearsDropdown.selectByValue(year);

	}

	public AutomationPracticeHomePage submitRegistration() {
		WebElement registerButton = wait.until(ExpectedConditions.elementToBeClickable(registerButtonLocator));
		registerButton.click();
		return new AutomationPracticeHomePage(driver);
	}

	private String removeLeadingZero(String str) {
		if (str.startsWith("0")) {
			return str.substring(1);
		}
		return str;
	}

	public String getErrorMessage() {

		 WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageBoxLocator));
	        return errorMessageElement.getText().trim();
	        // Trim to remove leading/trailing spaces
	}

	public By errorMessageBoxLocator() {
		return errorMessageBoxLocator;
	}
}
