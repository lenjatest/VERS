package com.paykickstart.test;

import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.StartPage;
import com.paykickstart.pages.TaxProfilePage;

public class RemoveAllTaxProfiles extends WebDriverUtility {

	String successPage = new String("PayKickstart");

	// @Test(invocationCount = 1)
	public void verifyRemoveFunnelBySpecificString() throws MalformedURLException, InterruptedException {
		start();

		StartPage log = new StartPage(driver);
		log.login();
		TaxProfilePage taxPg = new TaxProfilePage(driver);
		taxPg.removeAllTaxProfiles();
		driver.quit();
	}

}
