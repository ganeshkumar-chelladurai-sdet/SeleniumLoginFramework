package com.ganeshkumar.automation.SeleniumLoginFramework.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Represents the "limited functionalities" confirmation dialog
 * that appears after a successful login on LoginPage.
 *
 * Flow: LoginPage.clickSignIn() returns an instance of this class,
 * allowing tests to chain directly: loginPage.clickSignIn().clickOkay();
 *
 * Note: this page auto-redirects to a different site shortly after
 * a successful login (timing varies, observed under 1-2 seconds).
 * clickOkay()/clickCancel() call waitForDialog() first to avoid
 * acting on the dialog before it's confirmed visible.
 */

public class ConfirmationDialogPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='myModal']//p")
	WebElement dialogMessage;
	
	@FindBy(id = "cancelBtn")
	WebElement cancelButton;
	
	@FindBy(id = "okayBtn")
	WebElement okayButton;
	
	public ConfirmationDialogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForDialog() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(dialogMessage));
	}
	
	public void clickOkay() {
		waitForDialog();
		okayButton.click();
	}
	
	public void clickCancel() {
		waitForDialog();
		cancelButton.click();
	}
	
	public boolean isDialogDisplayed() {
		return dialogMessage.isDisplayed();
	}

}
