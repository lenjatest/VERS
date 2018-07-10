package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.StartPage;
import com.paykickstart.pages.TaxProfilePage;

public class CreateVATTaxProfileTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void createProfileVatTax() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();
		TaxProfilePage taxPage = new TaxProfilePage(driver);
		taxPage.createVATTaxProfile();
		taxPage.checkIsTaxProfileCreated();

		driver.quit();
	}

}
