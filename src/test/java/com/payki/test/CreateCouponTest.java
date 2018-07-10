package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.pages.CouponPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.StartPage;

public class CreateCouponTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void createCoupon() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();
		ProductPage product = new ProductPage(driver);
		product.createCampaign();
		product.createProduct();
		product.selectTemplate(Template.clean);
		String sameCampaign = product.sameCampaign;
		CouponPage coup = new CouponPage(driver);
		coup.openCouponPage();
		coup.fillUpCouponPage(sameCampaign);
		coup.checkIsCouponCreated();
		driver.quit();
	}

}
