package com.mint.modulePageElements;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.mint.testBase.BasePageClass;

public class MyProposalPageElements extends BasePageClass {

	@FindBy(xpath = "//span[text()='Proposal']")
	WebElement proposalButton;
	
	@FindBy(xpath = "//span[text()='My Proposal']")
	WebElement myProposalButton;
	
	@FindBy(xpath= "//select[@class='form-control']")
	WebElement selectChannel;
	
	@FindBy(xpath = "//a[text()='Create Proposal']")
	WebElement createProposal;
	
	WebDriver driver;

	public MyProposalPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public MyProposalPageElements clickOnProposalButton() throws InterruptedException {
		windowHandle(1);
		Thread.sleep(5000);
		if (elementIsDisplayed(proposalButton)) {
			clickOn(proposalButton);
		}
		return this;
	}
	
	public MyProposalPageElements clickOnMyProposalButton() throws InterruptedException {
		if (elementIsDisplayed(myProposalButton)) {
			clickOn(myProposalButton);
			selectDropdownByValue(selectChannel, "9");
		}
		return this;
	}
	
	public void selectChannel() throws Exception {
		selectDropdownByValue(selectChannel, "9");
	}
	
	public MyProposalPageElements createProposalButton() throws Exception {
		Thread.sleep(10000);
		if (elementIsDisplayed(createProposal)) {
			clickOn(createProposal);
		}
		return this;
	}
}