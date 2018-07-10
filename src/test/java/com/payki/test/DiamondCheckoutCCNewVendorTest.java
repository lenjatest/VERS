package com.paykickstart.test;

import org.testng.annotations.Test;

import java.io.IOException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.DimondCheckoutPage;

public class DiamondCheckoutCCNewVendorTest extends WebDriverUtility {

	@Test(invocationCount = 1)
	public void verifyDiamondCheckoutWithCCNewVendor() throws InterruptedException, IOException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		startForTest("https://dev.paykickstart.com/register/vendor/diamond");
		DimondCheckoutPage diamond = new DimondCheckoutPage(driver);
		diamond.dimondCheckoutCC();
		driver.quit();
	}

}