package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.CampaignPage;
import com.paykickstart.pages.StartPage;

public class CreateLeadCampaignWithMailChimpTest extends WebDriverUtility {

	String successPage = new String("Success Page");

	@Test(invocationCount = 1)
	public void verifyCreateLeadCampaign() throws MalformedURLException, InterruptedException {
		start();

		System.out.println("Before login   " + driver.getTitle());
		StartPage log = new StartPage(driver);
		log.login();

		CampaignPage campaign = new CampaignPage(driver);
		campaign.createLeadCampaign();
		driver.quit();
	}

}
