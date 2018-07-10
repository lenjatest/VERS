package com.paykickstart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;

public class AffiliatesLinkPage extends WebDriverUtility {

	WebDriver driver;

	public AffiliatesLinkPage(WebDriver driver) {
		this.driver = driver;
	}

	By newLinkBtn = By.xpath("//a[@data-target='#newLink']");
	By selectCampaign = By.cssSelector(".product_id_trackinglink .pull-left");
	By select = By.xpath("//button[@title='Select']");
	By selectFunnel = By.xpath(
			"//div[@class='btn-group bootstrap-select form-control funnels_selector open']//span[contains(text(), 'autotest Funnel')]");
	By selectAffiliate = By.cssSelector(".affiliate_selector .btn-default .pull-left");
	By selectAffDropDown = By.cssSelector(".affiliate_selector li[data-original-index='1']");
	By trackingLinktitle = By.xpath("//input[@name='title']");
	String title = createNewName("AutoTestLink");
	By btnCreateLink = By.xpath("//button[contains(text(), 'Create Link')]");
	By expectedlinkName = By.xpath("//h5[@class='text-detail-center'][contains(text(), '" + title + "')]");
	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");

	public void createNewLinkByVendor(String sameCampaign) throws InterruptedException {
		click(driver, newLinkBtn);
		click(driver, selectCampaign);
		By campaign = By.xpath(
				"//div[@class='btn-group bootstrap-select form-control product_id_trackinglink open']//span[contains(text(), '"
						+ sameCampaign + "')]/parent::a");
		findSuccessElementByStringAndClick(driver, campaign, sameCampaign, campaign);
		click(driver, select);
		click(driver, selectFunnel);
		click(driver, selectAffiliate);
		click(driver, selectAffDropDown);
		type(driver, trackingLinktitle, title);
		click(driver, btnCreateLink);
		type(driver, searchField, title);
		click(driver, iconSearch);
		findStringOnPage(driver, expectedlinkName, title);

	}

	By campaignAffLink = By.xpath("//h4[contains(text(), 'autotest0.1996856973981348')]");
	By createNewLinkBtn = By.xpath("//button[contains(text(), 'Create New Tracking Link')]");
	By inputLinkTitle = By.xpath("//div[@class='modal-footer no-flex']//input[@id='trackinglink_title']");
	String titleAff = createNewName("AutoTestAffLink");
	By saveBtn = By.xpath("//div[@class='modal-footer no-flex']//i[@class='fa fa-save']");
	By expectedLinkAffname = By.xpath("//b[@class='link-title'][contains(text(), '" + titleAff + "')]");
	By showAll = By.xpath("//span[contains(text(), 'Show')]");

	public void createNewLinkByAffiliate(String sameCampaign) throws InterruptedException {
		By campaign = By.xpath("//h4[contains(text(), '" + sameCampaign + "')]");
		Boolean elem = driver.findElements(showAll).size() != 0;
		if (elem) {
			click(driver, showAll);
		}

		findSuccessElementByStringAndClick(driver, campaign, sameCampaign, campaign);
		click(driver, createNewLinkBtn);
		type(driver, inputLinkTitle, titleAff);
		click(driver, saveBtn);

		findStringOnPage(driver, expectedLinkAffname, titleAff.toUpperCase());

	}

	By lenjaAffiliate = By.xpath("//li[@data-id='515']//h5[contains(text(), 'Lenja Affiliate')]");
	String lenjaAff = "Lenja Affiliate";
	By editAfficon = By.xpath("//li[@data-id='515']//i[@class='icon edit']");
	By autoOn = By.xpath("//label[@for='auto-off']");
	By btnSave = By.xpath("//i[@class='icon save']");
	By avatar = By.xpath("//img[@class='avatar']");
	By myPlatSett = By.xpath("//ul[@class='dropdown-menu']//a[contains(text(), 'Platform Settings')]");
	By affApprovalDropDown = By
			.xpath("//button[@data-id='affiliate_approval']//span[@class='filter-option pull-left']");
	By manual = By.xpath("//span[contains(text(), 'Manual')]");

	public void setUpmanualAffiliateApprove() throws InterruptedException {

		findSuccessElementByStringAndClick(driver, lenjaAffiliate, lenjaAff, editAfficon);
		click(driver, autoOn);
		click(driver, btnSave);

	}

	public void setUpAffManualApproveMyPlatform() throws InterruptedException {
		click(driver, avatar);
		click(driver, myPlatSett);
		click(driver, affApprovalDropDown);
		click(driver, manual);
		click(driver, btnSave);
	}

	By removeIcon = By.xpath("//a[@data-id='515']//i[@class='icon remove']");
	By deleteBtn = By.xpath("//button[contains(text(), 'Delete')]");

	public void findAffiliate() throws InterruptedException {
		type(driver, searchField, lenjaAff);
		click(driver, iconSearch);
	}

	public void removeCertainAffiliate() throws InterruptedException {
		boolean removeAff = driver.findElements(removeIcon).size() != 0;
		if (removeAff) {
			click(driver, removeIcon);
			click(driver, deleteBtn);
		}
	}

	public void editAffiliate() throws InterruptedException {
		findSuccessElementByStringAndClick(driver, lenjaAffiliate, lenjaAff, editAfficon);

	}

	By manageFunnelIcon = By.xpath("//div[@id='funneldetail']//i[@class='icon edit']");
	By overrideSettings = By.xpath("//a[@class='trigger url '][contains(text(), 'Override Settings')]");
	By firstTierComission = By.xpath("//div[@class='popover-content']//input[@name='commission_1']");
	String comiss1 = "39";
	By secondTierComission = By.xpath("//div[@class='popover-content']//input[@name='commission_2']");
	String comiss2 = "19";
	By rebillComiss1 = By.xpath("//div[@class='popover-content']//input[@name='rebill_commission_1']");
	String rebillCom1 = "9";
	By rebillComiss2 = By.xpath("//div[@class='popover-content']//input[@name='rebill_commission_2']");
	String rebillCom2 = "29";
	By price = By.xpath("//div[@class='popover-content']//input[@name='price']");
	String priceValue = "59";
	By landingUrl = By.xpath("//div[@class='popover-content']//input[@name='landing_url']");
	String text = "http://dev.paykickstart.com/register/vendor/professional-30?";
	By saveSettings = By.xpath("//div[@class='popover-content']//button[contains(text(), 'Save')]");
	By btnClose = By.xpath("//div[@class='popover-content']//button[contains(text(), 'Close')]");
	By closeFunnelDetails = By.xpath("//div[@id='funnel_details']//button[@class='close']//span");

	public void getToComissSettings(String campaign) throws InterruptedException {
		// scrollPage();
		By campaignProduct = By.xpath("//td[@class='campaign_name'][contains(text(), '" + campaign + "')]");
		By editIcon = By.xpath("//td[@class='campaign_name'][contains(text(), '" + campaign
				+ "')]/parent::tr//i[@class='icon edit add-tooltip']");
		findSuccessElementByStringAndClick2(driver, campaignProduct, campaign, editIcon);
		click(driver, manageFunnelIcon);
		click(driver, overrideSettings);

	}

	public void overrideSettings() throws InterruptedException {
		type(driver, firstTierComission, comiss1);
		type(driver, secondTierComission, comiss2);
		type(driver, rebillComiss1, rebillCom1);
		type(driver, rebillComiss2, rebillCom2);
		type(driver, price, priceValue);
		type(driver, landingUrl, text);
		click(driver, saveSettings);
		click(driver, btnClose);
		click(driver, closeFunnelDetails);

	}

	String attribute = "value";

	public void checkCommissSaved() throws InterruptedException {
		getExpectedStringByAttribute(driver, firstTierComission, attribute, comiss1);
		getExpectedStringByAttribute(driver, secondTierComission, attribute, comiss2);
		getExpectedStringByAttribute(driver, rebillComiss1, attribute, rebillCom1);
		getExpectedStringByAttribute(driver, rebillComiss2, attribute, rebillCom2);
		getExpectedStringByAttribute(driver, rebillComiss2, attribute, rebillCom2);
		getExpectedStringByAttribute(driver, price, attribute, priceValue);
		getExpectedStringByAttribute(driver, landingUrl, attribute, text);
	}

}
