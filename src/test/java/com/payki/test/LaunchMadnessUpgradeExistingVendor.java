package com.paykickstart.test;

import org.testng.annotations.Test;

import java.io.IOException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.DimondCheckoutPage;

public class LaunchMadnessUpgradeExistingVendor extends WebDriverUtility {

	/*
	 * Sorry, you are not able to purchase this offer again. Only eligible to
	 * purchase the Diamond plan once. If you feel this message was shown by error,
	 * please contact support @paykickstart.com
	 */

	// @Test(invocationCount=1)

	public void verifyLaunchMadnessUpgradeExistingVendor() throws InterruptedException, IOException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		startForTest("https://dev.paykickstart.com/register/vendor/launch-madness");
		DimondCheckoutPage diamond = new DimondCheckoutPage(driver);
		diamond.dimondCheckoutCCExistingVendor();
		driver.quit();
	}

}