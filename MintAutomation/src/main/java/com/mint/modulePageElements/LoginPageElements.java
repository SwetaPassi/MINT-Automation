
package com.mint.modulePageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mint.testBase.BasePageClass;

public class LoginPageElements extends BasePageClass {

	@FindBy(xpath = "//li[@class='app-button-wrapper notranslate']//img[@alt='Graphic Link Mint-Staging-App']")
	WebElement mintStaginAppButton;

	@FindBy(id = "idp-discovery-username")
	WebElement emailAddress;

	@FindBy(id = "idp-discovery-submit")
	WebElement nextButton;

	@FindBy(id = "okta-signin-password")
	WebElement password;

	@FindBy(id = "okta-signin-submit")
	WebElement submitButton;

	WebDriver driver;

	public LoginPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void enterEmailAddress() {
		if (elementIsDisplayed(emailAddress)) {
			emailAddress.sendKeys(prop.getProperty("userName"));
		}
	}

	public void clickOnNextButton() {
		if (elementIsDisplayed(nextButton)) {
			clickOn(nextButton);
		}
	}

	public void enterPassword() {
		if (elementIsDisplayed(password)) {
			password.sendKeys(prop.getProperty("password"));
		}
	}

	public void clickOnSubmitButton() {
		if (elementIsDisplayed(submitButton)) {
			clickOn(submitButton);
		}
	}

	public void clickOnMintStaging() {
		if (elementIsDisplayed(mintStaginAppButton)) {
			clickOn(mintStaginAppButton);
		}
	}

	public void loginToFoxOktaAndClickOnMintStaging() {
		enterEmailAddress();
		clickOnNextButton();
		enterPassword();
		clickOnSubmitButton();
		System.out.println("Logging got successful");
		clickOnMintStaging();
	}
}