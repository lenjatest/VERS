package com.paykickstart.pages;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.paykickstart.common.WebDriverUtility;

public class FunnelPage extends WebDriverUtility {
	WebDriver driver;

	By funnel = By.cssSelector("[class='fa fa-filter']");
	By creteNewFunnel = By.cssSelector("a[data-target='#createFunnelModal']>i[class='icon plus']");
	By funnelTitle = By.cssSelector(".funnel_title");
	String funnelName = "autotest Funnel";
	By selectCampaign = By.xpath("//button[@data-id='funnel_campaign']//span[contains(text(), 'Select Campaign')]");
	By span = By
			.xpath("//ul[@class='dropdown-menu inner']//li//a/span[contains(text(), 'autotest0.05775032930696178')]");
	String str = "autotest0.05775032930696178";
	By saveFunnel = By.cssSelector(".create_funnel");
	By selectFunnelProduct = By.cssSelector("[data-target='#fefunnelsplanModal']");
	By selectProduct = By.cssSelector(".outerModalsBlock .fe .btn-default .pull-left");

	// By selectProduct =
	// By.cssSelector("[class='outerModalsBlock']>div[class='modal fade
	// in']>div>div>div>div>div>button");
	By selectProduct1 = By.cssSelector(".outerModalsBlock #fefunnelsplanModal .fe .text");
	// By saveButton =
	// By.cssSelector("div[class='outerModalsBlock']>div[id='fefunnelsplanModal']>div>div>div>div.modal-footer>button");
	By modalFooter = By.cssSelector(".outerModalsBlock #fefunnelsplanModal .modal-footer.single-btn");
	By saveButton = By.cssSelector(".outerModalsBlock #fefunnelsplanModal .funnelplans_save_btn");
	By saveBtn = By.xpath(
			"//div[@class='outerModalsBlock']//div[@id='fefunnelsplanModal']//div//div//div//button[contains(text(), 'Save')]");

	/*
	 * By copyLinkIcon =
	 * By.cssSelector("a[class='link url_update ']>i[title='Copy Link']");
	 */
	By copyLinkIcon = By.xpath("//a[@class='link url_update ']//i[@title='Copy Link']");

	/*
	 * By copyLink = By.cssSelector(".outerModalsBlock button[title='Copy Link']");
	 */
	By copyInputField = By.cssSelector(".outerModalsBlock div[class='input-group add-on'] input[class='form-control']");

	public FunnelPage(WebDriver driver) {
		this.driver = driver;
	}

	public void creteFunnel(String campaign) throws InterruptedException {
		click(driver, funnel);
		click(driver, creteNewFunnel);
		type(driver, funnelTitle, funnelName);
		click(driver, selectCampaign);
		/* click(driver, span); */
		/* ProductPage page = new ProductPage(driver); */
		By selectCampaignFromDropDown = By
				.xpath("//ul[@class='dropdown-menu inner']//li//a/span[contains(text(), '" + campaign + "')]");
		findSuccessElementByStringAndClick(driver, selectCampaignFromDropDown, campaign, selectCampaignFromDropDown);
		System.out.println("page.sameCampaign " + campaign);
		click(driver, saveFunnel);
		click(driver, selectFunnelProduct);
		click(driver, selectProduct);
		enter(driver, selectProduct);
		click(driver, selectProduct);
		click(driver, saveBtn);
//		click(driver, saveButton);

	}

	By exitFunnel = By.cssSelector(".btn_sidebar_exit_funnel");
	By selectAffiliatesRadioBtn = By.xpath("//input[@id='selected_affiliates']/parent::label");
	By selAffDropDown = By
			.xpath("//span[contains(text(), 'Select Affiliates')]/parent::button[@title='Select Affiliates']");
	By lenjaAffiliate = By
			.xpath("//span[contains(text(), 'Lenja Affiliate')]/parent::a/parent::li[@data-original-index='0']");

	public void creteFunnelWithAffiliates(String campaign) throws InterruptedException {
		click(driver, funnel);
		click(driver, creteNewFunnel);
		type(driver, funnelTitle, funnelName);
		click(driver, selectCampaign);
		String name = "//ul[@class='dropdown-menu inner']//li//a/span[contains(text(), '";
		String campaignFullName = name + campaign + "')]";
		By selectCampaignFromDropDown = By.xpath(campaignFullName);
		findSuccessElementByStringAndClick(driver, selectCampaignFromDropDown, campaign, selectCampaignFromDropDown);
		System.out.println("page.sameCampaign " + campaign);

		click(driver, selectAffiliatesRadioBtn);
		click(driver, selAffDropDown);
		click(driver, lenjaAffiliate);
		click(driver, funnelTitle);
		click(driver, saveFunnel);
		click(driver, selectFunnelProduct);
		click(driver, selectProduct);
		enter(driver, selectProduct);
		click(driver, selectProduct);
//		click(driver, selectProduct1);
		click(driver, saveBtn);
//		click(driver, saveButton);
		click(driver, exitFunnel);
	}

	By overrideSettings = By.cssSelector("a[class='url url_update '][data-target='#landingupdateURL']");
	By landingURL = By.cssSelector(".outerModalsBlock input#landing_url");
	String URL = "https://test.com";
	By overridePrice = By.cssSelector(".outerModalsBlock .pb0 .fa-square-o");
	By price = By.cssSelector(".outerModalsBlock div[class = 'form-group'] input.priceformat");
	By splitPay = By.cssSelector(".outerModalsBlock .js-is-split-pay");
	By reccuringFrequency = By.cssSelector(".outerModalsBlock .js-split-pay-recurring-frequency span.pull-left");
	By reccuringValue = By
			.cssSelector(".outerModalsBlock .js-split-pay-recurring-frequency li[data-original-index='2']");
	By ofPayments = By.cssSelector(".outerModalsBlock .js-split-pay-option [class='form-control js-grab-data']");
	String paymentsValue = "3";
	By pricePerInstallment = By.cssSelector(".outerModalsBlock .js-split-pay-option .priceformat");
	String pricePerInstallmentString = "32.99";
	By btnSave = By.cssSelector(".outerModalsBlock #landingPriceForm .single-btn");

	String priceString = "101";
	public double priceValue = Integer.parseInt(priceString);

	public void overrideFunnelSettings() throws InterruptedException {
		click(driver, overrideSettings);
		type(driver, landingURL, URL);
		click(driver, overridePrice);

		type(driver, price, priceValue);
		click(driver, splitPay);
		click(driver, reccuringFrequency);
		click(driver, reccuringValue);
		type(driver, ofPayments, paymentsValue);
		type(driver, pricePerInstallment, pricePerInstallmentString);
		click(driver, btnSave);

	}

	public String getToCheckout() throws InterruptedException, MalformedURLException {
		click(driver, copyLinkIcon);
		click(driver, copyInputField);
		String url = driver.findElement(copyInputField).getAttribute("value");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		driver.get(url);
		return url;

		/*
		 * driver.switchTo().window(tabs.get(1)); // switch back to main screen
		 * driver.get("https://www.news.google.com");
		 */
	}

	By closeDevconsole = By.cssSelector(".phpdebugbar-close-btn");

	String expectedFunnelLocatorElement = "//a[@class='campaign-logo']//span[contains(text(),'";
	String funnelNameToDelete = "autotest Funnel";
	By expectedFinalFunnelLocatorElement = By.xpath(expectedFunnelLocatorElement + funnelNameToDelete + "')]");
	By deleteFunnelIcon = By.cssSelector(".delete_funnel");
	By deleteFunnelConfirm = By.cssSelector(".deleteFunnel_confirm");
	// span[contains(text(),'AFFA')]//parent::a//parent::div//parent::li//a[@class='btn
	// btn-danger btn-xs add-tooltip delete_funnel']
	String expectedDeleteLocatorElement = "//a[@class='campaign-logo']//span[contains(text(),'";
	String funnelNameToDelete1 = "autotest Funnel";
	By FinalFunnelDeleteIcon = By.xpath(expectedDeleteLocatorElement + funnelNameToDelete1
			+ "')]//parent::a//parent::div//parent::li//a[@class='btn btn-danger btn-xs add-tooltip delete_funnel']");

	By nextButton = By.cssSelector("[rel='next']");

	public void removeFunnelsBySpecificString() throws InterruptedException {
		click(driver, funnel);
		// click(driver, closeDevconsole);
		String funnelElem;

		try {
			do {
				funnelElem = findAndRemoveFunnelOnPage(driver, expectedFinalFunnelLocatorElement, funnelNameToDelete,
						FinalFunnelDeleteIcon, deleteFunnelConfirm);
				System.out.println("fromdo " + funnelElem);
			} while (funnelElem.equals(funnelNameToDelete));
			if (funnelElem.isEmpty()) {
				if (nextButton != null) {
					click(driver, nextButton);
					System.out.println(funnelElem);
				}
			}
		} catch (Exception e) {
		} finally {
			System.out.println("No funnels with pointed funnel name left in the list");
		}
	}
}
