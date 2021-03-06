package com.mint.modulePageElements;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mint.testBase.BasePageClass;

public class ProposalBriefPageElements extends BasePageClass {
	@FindBy(id = "react-select-2--value")
	WebElement advertiser;

	@FindBy(xpath = "//button[text()='Proceed']")
	WebElement proceedButton;

	@FindBy(id = "react-select-3--value")
	WebElement advertiserEntityName;

	@FindBy(id = "react-select-4--value")
	WebElement agency;

	@FindBy(id = "react-select-5--value")
	WebElement agencyEntityName;

	@FindBy(id = "react-select-6--value")
	WebElement brandName;

	@FindBy(id = "react-select-7--value")
	WebElement regionName;

	@FindBy(id = "react-select-8--value")
	WebElement currencyName;

	@FindBy(id = "react-select-9--value")
	WebElement proposalTypeCategory;

	@FindBy(id = "//div[@class='selectBox']//span[1]")
	WebElement proposalComposition;

	@FindBy(xpath = "//label[text()='Select All']")
	WebElement selectAll;

	@FindBy(xpath = "(//span[contains(@class,'over-select-button Select-control')])[2]")
	WebElement programType;

	@FindBy(xpath = "//label[text()='Proposal Start Date']/following::input[1]")
	WebElement proposalStartDate;

	@FindBy(xpath = "//*[contains(@class, 'react-datepicker__day') and  not(contains(@class, 'react-datepicker__day--disabled')) and not (contains(@class, 'react-datepicker__day-name')) ][1]")
	WebElement selectDateFromDatePicker;

	@FindBy(xpath = "//button[text()='Next month']")
	WebElement nextMonth;

	@FindBy(xpath = "//label[text()='Proposal End Date']/following::input[1]")
	WebElement proposalEndDate;

	@FindBy(xpath = "//label[text()='Client Ask Outlay']/following::input[1]")
	WebElement clientAskOutlay;

	@FindBy(xpath = "(//div//input[@class='form-control'])[2]")
	WebElement clientErOutlay;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextButton;

	WebDriver driver;

	public ProposalBriefPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ProposalBriefPageElements selectAdvertiser() {
		if (elementIsDisplayed(advertiser)) {
			clickAndtype(advertiser, "Abbott Healthcare");
			System.out.println("Advertiser field is getting selected");
		}
		return this;
	}

	public ProposalBriefPageElements clickOnProceedButton() {
		if (elementIsDisplayed(proceedButton)) {
			clickOn(proceedButton);
			logger.info("Clicking on proceed pop up button");
		}
		return this;
	}

	public ProposalBriefPageElements selectAdvertiserEntityName() {
		if (elementIsDisplayed(advertiserEntityName)) {
			clickAndtype(advertiserEntityName, "ABBOTT HEALTHCARE PVT LTD(MU)");
		}
		return this;
	}

	public ProposalBriefPageElements selectAgencyName() {
		if (elementIsDisplayed(agency)) {
			// clickAndtype(agency, "Group M");
		}
		return this;
	}

	public ProposalBriefPageElements selectAgencyEntityName() {
		if (elementIsDisplayed(agencyEntityName)) {
			clickAndtype(agencyEntityName, "GROUP M MEDIA INDIA PVT LTD (MU)");
		}
		return this;
	}

	public ProposalBriefPageElements selectBrandName() {
		if (elementIsDisplayed(brandName)) {
			clickAndtype(brandName, "DIGENE ANTACID");
		}
		return this;
	}

	public ProposalBriefPageElements selectRegionName() {
		/*
		 * if (elementIsDisplayed(regionName)) { // clickAndtype(regionName, "WEST"); }
		 */
		return this;
	}

	public ProposalBriefPageElements selectTheCurrency() {
		/*
		 * if (elementIsDisplayed(currencyName)) { // clickAndtype(currencyName,
		 * "Indian Rupees"); }
		 */
		return this;
	}

	public ProposalBriefPageElements selectTheProposalCategory() {
		/*
		 * if (elementIsDisplayed(proposalTypeCategory)) { //
		 * clickAndtype(proposalTypeCategory, "Campaign ER"); }
		 */
		return this;
	}

	public ProposalBriefPageElements selectTheProposalComposition() {
		/*
		 * if (elementIsDisplayed(proposalComposition)) {
		 * 
		 * clickOn(proposalComposition); clickOn(selectAll);
		 * clickOn(proposalComposition);
		 * 
		 * }
		 */
		return this;
	}

	public ProposalBriefPageElements selectTheProgramType() {
		/*
		 * if (elementIsDisplayed(programType)) {
		 * 
		 * clickOn(programType); clickOn(selectAll); clickOn(programType);
		 * 
		 * }
		 */
		return this;
	}

	public ProposalBriefPageElements selectTheProposalStartDate() {
		if (elementIsDisplayed(proposalStartDate)) {
			clickOn(proposalStartDate);
			clickOn(selectDateFromDatePicker);
		}
		return this;
	}

	public ProposalBriefPageElements selectTheProposalEndDate() {
		if (elementIsDisplayed(proposalEndDate)) {
			clickOn(proposalEndDate);
			clickOn(nextMonth);
			clickOn(selectDateFromDatePicker);
		}
		return this;
	}

	public ProposalBriefPageElements enterClientAskOutlayPrice() {
		if (elementIsDisplayed(clientAskOutlay)) {
			enterValueIn(clientAskOutlay, RandomStringUtils.randomNumeric(2));
		}
		return this;
	}

	public ProposalBriefPageElements enterClientAskEr() {
		if (elementIsDisplayed(clientErOutlay)) {
			enterValueIn(clientErOutlay, RandomStringUtils.randomNumeric(2));
		}
		return this;
	}

	public ProposalBriefPageElements clickOnNextButton() {
		if (elementIsDisplayed(nextButton)) {
			clickOn(nextButton);
		}
		return this;
	}
}