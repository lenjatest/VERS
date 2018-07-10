package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.pages.CheckoutPage;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.StartPage;

public class CreditCardCheckoutSplitPayTest extends WebDriverUtility {

	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void verifyCreateEditCampaign() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
		start();

		StartPage log = new StartPage(driver);
		log.login();
		ProductPage product = new ProductPage(driver);
		product.createCampaign();
		product.createProduct();
		product.selectTemplate(Template.prettyPress);
		String sameCampaign = product.sameCampaign;
		FunnelPage funnel = new FunnelPage(driver);
		funnel.creteFunnel(sameCampaign);
		funnel.overrideFunnelSettings();
		funnel.getToCheckout();
		CheckoutPage check = new CheckoutPage(driver);
		check.checkoutCreditCardPrettyPressSplitPay();
		driver.quit();
	}

}