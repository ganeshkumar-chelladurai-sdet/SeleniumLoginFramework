package com.ganeshkumar.automation.SeleniumLoginFramework.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "username")
	WebElement usernameField;
	
	@FindBy(id = "password")
	WebElement passwordField;
	
	@FindBy(id = "terms")
	WebElement termsCheckbox;
	
	@FindBy(name = "radio")
	List<WebElement> roleRadioButtons;	//	Admin, User
	
	@FindBy(tagName = "select")
	WebElement roleDropdown;	//	Student, Teacher, Consultant
	
	@FindBy(id = "signInBtn")
	WebElement signInButton;
	
	@FindBy(className = "alert-danger")
	WebElement errorMessage;
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUsername(String username) {
		usernameField.clear();
		usernameField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	public void checkAgreeTerms() {
		if(!termsCheckbox.isSelected()) {
			termsCheckbox.click();
		}
	}
	public void selectRole(String role) {
		if(role.equalsIgnoreCase("Admin") || role.equalsIgnoreCase("User")){
			for(WebElement radio : roleRadioButtons) {
				if(radio.getAttribute("value").equalsIgnoreCase(role)) {
					radio.click();
					break;	
				}
			}
		} else {
			Select dropdown = new Select(roleDropdown);
			dropdown.selectByVisibleText(role);
		}
	}
	public ConfirmationDialogPage clickSignIn() {
		signInButton.click();
		return new ConfirmationDialogPage(driver);
	}
	
	public String getErrorMessage() {
		return errorMessage.getText();
	}

}
