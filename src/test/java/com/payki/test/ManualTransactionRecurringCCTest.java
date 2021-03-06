package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.ManualTransactionPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.StartPage;

public class ManualTransactionRecurringCCTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void createManualTransaction() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();
		ProductPage product = new ProductPage(driver);
		product.createCampaign();
		product.createProduct();
		ManualTransactionPage transPage = new ManualTransactionPage(driver);
		transPage.manualTransaction(product.sameCampaign);
		driver.quit();
	}

}
