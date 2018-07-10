package com.paykickstart.test;

import org.testng.annotations.Test;

import java.io.IOException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.DimondCheckoutPage;

public class DiamondCheckoutPayPalNewVendorTest extends WebDriverUtility {
	
//	We need to test for a new PK vendor and Existing member
//	Existing members should be able to use their existing login details and will upgrade them to premium and push their next billing date out 1 year

	@Test(invocationCount = 1)
	public void verifyDiamondPayPalCheckout() throws InterruptedException, IOException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		startForTest("https://dev.paykickstart.com/register/vendor/diamond");
		DimondCheckoutPage diamond = new DimondCheckoutPage(driver);
		diamond.dimondCheckoutPayPal();
		driver.quit();
	}

}