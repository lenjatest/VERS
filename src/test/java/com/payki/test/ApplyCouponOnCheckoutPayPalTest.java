package com.paykickstart.test;

import org.testng.annotations.Test;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.Arrays;

import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.pages.CheckoutPage;
import com.paykickstart.pages.CouponPage;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.RefundPage;
import com.paykickstart.pages.StartPage;
import com.paykickstart.pages.TaxProfilePage;

public class ApplyCouponOnCheckoutPayPalTest extends WebDriverUtility {
	String successPage = new String("PayKickstart :: Edit Product");

	@Test(invocationCount = 1)
	public void ApplyCouponAlongWithTaxUsingCC() throws MalformedURLException, InterruptedException {
		System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());

		start();

		StartPage log = new StartPage(driver);
		log.login();

		TaxProfilePage taxPage = new TaxProfilePage(driver);
		taxPage.createSalesTaxProfile();
		String taxProfile = taxPage.checkIsTaxProfileCreated();

		ProductPage product = new ProductPage(driver);
		String sameCampaign = product.createCampaign();
		product.createProductWithTaxProfile(taxProfile);

		product.selectTemplate(Template.kale);
		CouponPage coup = new CouponPage(driver);
		coup.openCouponPage();
		coup.fillUpCouponPage(sameCampaign);
		String kupon = coup.checkIsCouponCreated();

		System.out.println("couponDiscount : " + kupon);
		FunnelPage funnel = new FunnelPage(driver);
		funnel.creteFunnel(sameCampaign);
		funnel.getToCheckout();

		CheckoutPage check = new CheckoutPage(driver);
		check.payPalWithCoupon(kupon);
		System.out.println("kupon :" + kupon);
		RefundPage refund = new RefundPage(driver);
		refund.openRefundPage();
		double priceAfterDiscount = product.priceValue - (product.priceValue * (coup.coupDiscInt / 100));
		System.out.println("coup.coupDiscInt " + coup.coupDiscInt);
		System.out.println("priceAfterDiscount " + priceAfterDiscount);
		double priceAfterDiscountAndTax = priceAfterDiscount + (priceAfterDiscount / 100) * taxPage.taxRateValue;
		System.out.println("priceAfterDiscountAndTax " + priceAfterDiscountAndTax);
		DecimalFormat df = new DecimalFormat("###.##");
		df.setRoundingMode(RoundingMode.CEILING);
		for (Number n : Arrays.asList(priceAfterDiscountAndTax)) {
			Double a = n.doubleValue();
			String expectedAmount = df.format(a);
			System.out.println("expectedAmount " + expectedAmount);
			String expectedAmountFinal = String.valueOf(expectedAmount).substring(0, 4);
			coup.checkTransactionWithCouponIsSucessfull(sameCampaign, expectedAmountFinal);
		}

		driver.quit();
	}

}
