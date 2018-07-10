package com.paykickstart.test;

import java.io.IOException;
import org.testng.annotations.Test;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.CheckoutPage;

public class CHECKOUTCCTEST extends WebDriverUtility {

	String successPage = new String("PayKickstart :: Edit Product");

//	 @Test(invocationCount = 1)
	public void verifyCheckoutWithCC() throws InterruptedException, IOException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		startForTest("http://localhost:8080/FaciesAnalyzer/testPopUpWidget.html");

		CheckoutPage check = new CheckoutPage(driver);
		check.checkoutCreditCard();
		driver.quit();
		// killChromeDriverProcess();
	}

}