package com.paykickstart.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.BillingPage;
import com.paykickstart.pages.StartPage;

public class VerifyUpdateCCDetails extends WebDriverUtility {

	@Test(invocationCount = 14)
	public void verifyUpdateCCDetails() throws MalformedURLException, InterruptedException {
		start();
		StartPage startPage = new StartPage(driver);
		startPage.login();
		BillingPage billPage = new BillingPage(driver);
		billPage.updateCreditCardDetails();
		driver.quit();
	}

}
