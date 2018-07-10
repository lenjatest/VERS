package com.paykickstart.test;

import org.testng.annotations.Test;

import java.io.IOException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.DimondCheckoutPage;

public class LaunchMadnessCheckoutPayPalNewVendorTest extends WebDriverUtility {

	@Test(invocationCount = 1)
	public void verifyLaunchMadnessPayPalNewVendor() throws InterruptedException, IOException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		startForTest("https://dev.paykickstart.com/register/vendor/launch-madness");
		DimondCheckoutPage diamond = new DimondCheckoutPage(driver);
		diamond.dimondCheckoutPayPal();
		driver.quit();
	}

}