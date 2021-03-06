package com.mint.moduleTestScripts;

import org.testng.annotations.Test;

import com.mint.modulePageElements.LoginPageElements;
import com.mint.modulePageElements.MyProposalPageElements;
import com.mint.modulePageElements.ProposalBriefPageElements;
import com.mint.testBase.TestBaseClass;

public class CreateProposalBriefTestScripts extends TestBaseClass {

	@Test(description = "performs the login functionality")
	public void createProposalBriefTestScripts() throws Exception {
		LoginPageElements loginPageElements = new LoginPageElements(driver);
		loginPageElements.loginToFoxOktaAndClickOnMintStaging();
		MyProposalPageElements myProposalScreenPage = new MyProposalPageElements(driver);
		myProposalScreenPage.clickOnProposalButton().clickOnMyProposalButton().createProposalButton();
		ProposalBriefPageElements proposalBriefPageElements = new ProposalBriefPageElements(driver);
		proposalBriefPageElements.selectAdvertiser().clickOnProceedButton().selectAdvertiserEntityName().selectAgencyName()
				.selectAgencyEntityName().selectBrandName().selectRegionName().selectTheCurrency()
				.selectTheProposalCategory().selectTheProposalComposition().selectTheProgramType()
				.selectTheProposalStartDate().selectTheProposalEndDate().enterClientAskOutlayPrice()
				.enterClientAskEr()
				.clickOnNextButton();
	}
}