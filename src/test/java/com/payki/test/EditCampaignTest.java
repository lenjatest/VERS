package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.CampaignPage;
import com.paykickstart.pages.StartPage;

public class EditCampaignTest extends WebDriverUtility {

	String successPage = new String("PayKickstart");

	@Test(invocationCount = 1)
	public void verifyRemoveCampaign() throws MalformedURLException, InterruptedException {
		start();

		StartPage log = new StartPage(driver);
		log.login();
		CampaignPage campaign = new CampaignPage(driver);
		campaign.editCampaign();
		driver.quit();
	}

}
