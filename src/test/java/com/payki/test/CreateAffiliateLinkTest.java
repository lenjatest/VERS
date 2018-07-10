package com.paykickstart.test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.Template;
import com.paykickstart.items.User;
import com.paykickstart.pages.AffiliatesLinkPage;
import com.paykickstart.pages.CampaignPage;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.ProductPage;
import com.paykickstart.pages.StartPage;

public class CreateAffiliateLinkTest extends WebDriverUtility {

	String successPage = new String("Login to PayKickstart");
	User affiliate = new User("testPay@mailinator.com", "XXXXXXXXXX");
	User lenjaVendor = new User("lenjatest@gmail.com", "XXXXXXXXXXXX");

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { affiliate } };
	}

	@BeforeTest
	public void setuapManualApprove() throws InterruptedException, MalformedURLException {
		start();
		StartPage startPage = new StartPage(driver);
		AffiliatesLinkPage affPage = new AffiliatesLinkPage(driver);
		startPage.login();
		affPage.setUpAffManualApproveMyPlatform();
		startPage.openAffiliatesPage();
		affPage.removeCertainAffiliate();

	}

	@Test(dataProvider = "getData", invocationCount = 1)
	public void verifyCreateAffiliateLinkTest(User user) throws MalformedURLException, InterruptedException {
		StartPage startPage = new StartPage(driver);
		CampaignPage campaign = new CampaignPage(driver);
		ProductPage product = new ProductPage(driver);
		AffiliatesLinkPage affPage = new AffiliatesLinkPage(driver);
		String sameCampaign = product.createCampaign();
		String affURL = product.copyAffiliateRequestURL(sameCampaign);
		System.out.println("affURL : " + affURL);
		startPage.logOut();
		startPage.loginUser(affiliate);
		product.openAffReqURLByAffiliate(affURL);
		startPage.logOut();
		startPage.loginUser(lenjaVendor);
		startPage.approveRequest(sameCampaign);
		campaign.openCampaignPage();
		product.createProduct();
		product.selectTemplate(Template.defaulte);
		FunnelPage funnel = new FunnelPage(driver);
		funnel.creteFunnelWithAffiliates(sameCampaign);
		startPage.openLinksPage();
		affPage.createNewLinkByVendor(sameCampaign);
		startPage.logOut();
		startPage.loginUser(affiliate);
		startPage.openaffiliateLinksPage();
		affPage.createNewLinkByAffiliate(sameCampaign);

		driver.quit();
	}

}
