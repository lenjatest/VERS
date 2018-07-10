package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.pages.CheckoutPage;
import com.paykickstart.pages.CouponPage;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.RefundPage;
import com.paykickstart.pages.StartPage;

public class FreeTrialCouponCCTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void ApplyCouponAlongWithTaxUsingCC() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();

		ProductPage product = new ProductPage(driver);
		String sameCampaign = product.createCampaign();
		product.createTrialRecurringProduct();
		product.selectTemplate(Template.defaulte);

		CouponPage coup = new CouponPage(driver);
		coup.openCouponPage();
		coup.fillUpCouponPage(sameCampaign);
		String kupon = coup.checkIsCouponCreated();

		System.out.println("couponDiscount : " + kupon);
		FunnelPage funnel = new FunnelPage(driver);
		funnel.creteFunnel(sameCampaign);
		funnel.getToCheckout();

		CheckoutPage check = new CheckoutPage(driver);
		check.checkoutCreditCardWithValidCoupon(kupon);
		RefundPage refund = new RefundPage(driver);
		refund.openRefundPage();

		check.checkExpectedTransactionAmount(sameCampaign, ProductPage.trialAmmount);

		driver.quit();
	}

}
