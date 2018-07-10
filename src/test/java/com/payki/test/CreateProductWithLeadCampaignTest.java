package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.pages.CampaignPage;
import com.paykickstart.pages.CheckoutPage;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.StartPage;

public class CreateProductWithLeadCampaignTest extends WebDriverUtility {

	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void verifyCreateLeadCampaign() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		start();

		StartPage log = new StartPage(driver);
		log.login();
		CampaignPage camp = new CampaignPage(driver);
		ProductPage product = new ProductPage(driver);
		String leadCamp = camp.createLeadCampaign();
		product.createLeadProduct(leadCamp);
		product.selectTemplate(Template.clean);
		FunnelPage funnel = new FunnelPage(driver);
		funnel.creteFunnel(leadCamp);
		/* System.out.println("successPage   " + driver.getTitle()); */
		funnel.getToCheckout();
		CheckoutPage check = new CheckoutPage(driver);
		check.checkoutCreditCard();
		driver.quit();
	}

}