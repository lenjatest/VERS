package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.CouponPage;
import com.paykickstart.pages.StartPage;

public class DeleteCouponTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void createCoupon() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();
		CouponPage coup = new CouponPage(driver);
		coup.deleteCoupon();
		driver.quit();
	}

}
