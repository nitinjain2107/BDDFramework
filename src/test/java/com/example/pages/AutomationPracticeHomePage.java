package com.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationPracticeHomePage {
	
	 private WebDriver driver;
	 private WebDriverWait wait;
	
	public AutomationPracticeHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
	 private By logoutLinkLocator = By.linkText("Sign out");
	 
//	 private By accountInfoLocator = By.className("account");
	 
	 
	 
	 public boolean isUserLoggedIn() {
			// TODO Auto-generated method stub
			try {
				WebElement signOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLinkLocator));
	            // Example: Check for logout link or profile element indicating logged-in state
	            return signOutButton.isDisplayed(); // Example condition
	        } catch (Exception e) {
	            return false; // Return false if element is not found or exception occurs
	        }
		}
//	 public boolean isUserLoggedIn() {
//	        WebElement accountInfoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfoLocator));
//	        return accountInfoElement.isDisplayed();
//	    }
	 public void clickSignOutButton() {
	        WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(logoutLinkLocator));
	        signOutButton.click();
	    } 
	 
	 public String getPageTitle() {
	        return driver.getTitle();
	    }
	 
	

}
