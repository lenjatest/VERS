package com.paykickstart.pages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paykickstart.common.WebDriverUtility;

public class CampaignPage extends WebDriverUtility {

	WebDriver driver;

	By campaignMainMenu = By.xpath("//a[@data-original-title='Campaigns']");
	By campaignSubMenu = By.cssSelector("ul[class='collapse open in']>li>a[data-original-title='Campaigns']");
	By createCampaignBtn = By.cssSelector("a[class='btn btn-custom green create-campaign-btn']");
	By campaignName = By.cssSelector(
			"div[class='modal-dialog center-modal']>form[class='productEditForm']>div[class='modal-content']>div[class='modal-body']>div[class='form-group']>input");
	By saveCampaignName = By.cssSelector("div>button[id='save-campaign-btn']");
	By saveCampaign = By.xpath("//a[@class='btn btn-custom green update-product-btn1 builder-button']");
	By enableMarketCat = By.cssSelector(".pk-settings-input .blocked-is_marketplace .btn-group .active");
	By marketplace = By.cssSelector(".js-marketplace-list .btn-group .btn");
	By category = By.cssSelector(".opt");
	By paypal = By.cssSelector(".blocked-pp_gateway .btn-group .notActive");

	By hover = By.cssSelector(
			"div[class='btn-group bootstrap-select show-tick form-control js-marketplace-category dropup open']>div[class='dropdown-menu open']");
	By closeDevconsole = By.cssSelector(".phpdebugbar-close-btn");
	By makePrimaryOnCheckoutRadioButton = By.cssSelector(".blocked-pp_gateway-list input[name='primary-checkout']");

	By campaignLogo = By.cssSelector(".campaign-logo");

	String campaignNewName = createNewName("autotest");
	public static String campaignLeadName = createNewName("LeadCampaign");

	String expectedCampaignName = "LeadCampaign";

	By iconRemoveCampaign = By.cssSelector("[class='btn btn-danger btn-xs has-tooltip productDeleteModal']");
	By deleteCampaignButton = By.cssSelector(".modal-footer .delete_submit");
	By supportURL = By.cssSelector("input[name='support_url']");
	String URL = "http://test.support.ca";
	By saveBtnCampaign = By.cssSelector(".btn-group .btn-custom .icon");
	By iconGoBack = By.cssSelector(".gobackto");
	By product = By.xpath("//a[@data-product-name='autotest0.7056418337026475']/parent::div/div/a");
	By closeModal = By.cssSelector(".btn-primary");

	public CampaignPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openCampaignPage() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
	}

	By upsell = By.xpath("//a[@data-toggle='upsell'][contains(text(), 'Enable')]");

	public void createCampaignMain(Boolean enableUpsell) throws InterruptedException {
		openCampaignPage();
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);

		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		click(driver, makeCardPrimary);
		click(driver, creditCard);

		// click(driver, payPalAccount);
		click(driver, stripe);
		if (enableUpsell) {
			click(driver, upsell);
		}
		type(driver, supportURL, URL);
		click(driver, saveBtnCampaign);
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

	}

	public void createCampaign() throws InterruptedException {
		createCampaignMain(false);
	}

	public void createCampaignUpsell() throws InterruptedException {
		createCampaignMain(true);
	}

	By enableLeadCampaigns = By.cssSelector(".js-is_lead_tracking_enabled .notActive");
	By addLeadCampaign = By.cssSelector("[data-target='#modalLeadCampaignAdd']");
	By leadNametestclick = By.cssSelector(".form-group-v2#lead-name-wrapper");
	By leadName = By.cssSelector("#lead-name");
	String leadNameString = createNewName("Lead");
	By landingPageURl = By.cssSelector("#lead-landing-page-url");
	String landingPageURlString = "https://test.com";
	By thankYouPage = By.cssSelector("#lead-redirect-url");
	String thankYou = "https://thankyouPage.com";
	By affiliates = By.cssSelector("[title='All Affiliates']>.pull-left");
	By selectedAffiliates = By.xpath("//span[@class='text'][contains(text(), 'Selected Affiliates')]");
	By selectAffiliates = By.cssSelector(".btn-default[data-id='affiliates-ids']");
	By randomAffiliate = By.cssSelector("#lead-affiliates-ids-wrapper  [class='dropdown-menu open'] li");
	By comissionTier1 = By.cssSelector("#lead-commission-tier-1");
	String comissTier1 = "9.9";
	By comissionTier2 = By.cssSelector("#lead-commission-tier-2");
	String comissTier2 = "4.9";
	By selectEmailService = By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select service')]");
	By selectEmailService2 = By.cssSelector("[id='lead-email-service-wrapper'] .filter-option.pull-left");
	By btnSelectEmailService = By.cssSelector("button[title='Select service']");

	By selectService = By.cssSelector("#lead-email-service-wrapper [data-original-index='2'] span.text");
	By EmailAccount = By.cssSelector("#lead-email-account-wrapper .pull-left");
	By selectEmailAccount = By.cssSelector("#lead-email-account-wrapper li[data-original-index='1'] .text");
	By listType = By.cssSelector("#lead-email-type-wrapper .pull-left");
	By listTypeSelectFromDropDown = By.cssSelector("#lead-email-type-wrapper li[data-original-index='1'] .text");

	By selectListMenu = By.cssSelector("#lead-email-list-wrapper .pull-left");
	By selectList = By.cssSelector("#lead-email-list-wrapper [data-original-index='1'] .text");

	By btnAdd = By.cssSelector(".js-submit-button");
	String expectedLocatorElem1 = "//td[contains(text(), '";
	By expectedLocatorOfCreatedLeadCampaign = By.xpath(expectedLocatorElem1 + leadNameString + "')]");
	// td[contains(text(), 'Lead0.03352028388750228')]
	By makeCardPrimary = By.cssSelector(".blocked-cc_gateway-list>[name='primary-checkout']");
	By creditCard = By.cssSelector(".notActive[data-toggle='cc_gateway']");
	By stripe = By.cssSelector("[for='cc_gateway_stripe_0']");
	By backDrop = By.cssSelector("dropdown-backdrop");
	By saveBtn = By.xpath("//button[@type='submit']//i[@class='icon save']");
	By welDoneMessage = By.xpath("//div[@class='ajs-message ajs-error ajs-visible']");

	By membIntegrDisable = By.xpath("//a[@data-toggle='is_enabled_membership'][contains(text(), 'Disable')]");

	public String createLeadCampaign() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		// click(driver, closeDevconsole);
		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		click(driver, makeCardPrimary);
		click(driver, creditCard);
		click(driver, stripe);
		type(driver, supportURL, URL);
		click(driver, enableLeadCampaigns);
		click(driver, addLeadCampaign);
		type(driver, leadName, leadNameString);
		type(driver, landingPageURl, landingPageURlString);
		type(driver, thankYouPage, thankYou);

		click(driver, affiliates);
		click(driver, selectedAffiliates);
		click(driver, selectAffiliates);
		selectRandomItems(driver, randomAffiliate);
		type(driver, comissionTier1, comissTier1);
		type(driver, comissionTier2, comissTier2);
		click(driver, comissionTier2);

		click(driver, selectEmailService);

		click(driver, selectService);

		click(driver, EmailAccount);
		click(driver, selectEmailAccount);

		click(driver, listType);
		click(driver, listTypeSelectFromDropDown);

		click(driver, selectListMenu);
		click(driver, selectList);
		click(driver, comissionTier2);

		click(driver, btnAdd);

		System.out.println("expectedLocatorOfCreatedLeadCampaign:  " + expectedLocatorOfCreatedLeadCampaign);

		By expectedLeadCampaign = By
				.xpath("//a[@class='js-edit-campaign-lead-campaign'][contains(text(), '" + leadNameString + "')]");

		WebElement elem = driver.findElement(expectedLeadCampaign);
		assertNotNull(elem);
		System.out.println("check not null :" + elem);
		scrollPageToBottom(driver);

		click(driver, membIntegrDisable);
		click(driver, saveBtn);
		boolean message = driver.findElements(welDoneMessage).size() != 0;
		if (message)
			;
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);
		String leadCampaign = campaignNewName;
		System.out.println("leadCampaign :" + leadCampaign);
		return leadCampaign;

	}

	By removeCampaign = By.cssSelector("[data-product-name='" + campaignNewName + "'][id='productDeleteModal']");
	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");

	public void removeCampaign() throws InterruptedException {
		// click(driver, closeDevconsole);
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		getScriptOnPage(driver, campaignNewName);

		String sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);
		findAndRemoveElemFromPage(driver, campaignLogo, sameCampaign, removeCampaign, deleteCampaignButton);
	}

	String au = "au";
	String attribute = "data-product-name";

	public void removeCampaignBySubstring() throws InterruptedException {
		// click(driver, closeDevconsole);
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		String nameSubstring = findExpectedStringByAttribute(driver, deleteIcon, attribute, au);
		System.out.println("nameSubstring from DeleteIcon " + nameSubstring);
		By deleteIconWhereString = By.cssSelector("[data-product-name='" + nameSubstring + "[id='productDeleteModal']");
		do {
			findSuccessStringRemove(driver, deleteIcon, au, deleteIconWhereString, deleteCampaignButton);

		} while (nameSubstring.startsWith(au));

	}

	public void deleteCampaign() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		try {
			do {
				click(driver, iconRemoveCampaign);
				click(driver, deleteCampaignButton);

			} while (driver.findElements(iconRemoveCampaign).size() != 0);

		} catch (NoSuchElementException e) {

		}
		try {

			Boolean elem = driver.findElements(iconRemoveCampaign).size() != 0;
			assertFalse(elem);
			System.out.println("elem :" + elem);
		} catch (Exception e) {

		}

	}

	String removeName2 = "[data-product-name='";
	String expectedCampaignNameToDelete = "au";
	String campaignNameToDelete = "au";
	String namefull1 = removeName2 + expectedCampaignNameToDelete + "']";
	By removeCampaignByString = By.cssSelector(namefull1 + "[id='productDeleteModal']");

	// By deleteIcon
	// =By.cssSelector("[data-product-name='autotest0.6792938618582265'][id='productDeleteModal']");

	String camapignNameToDelete1 = "au";
	By nextButton = By.cssSelector("[rel='next']");

	String prefix = "au";;
	By deleteIcon = By.cssSelector("a[id='productDeleteModal']");

	public void removeCampaignByMatchingString() throws InterruptedException {

		// click(driver, closeDevconsole);
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		List<WebElement> campaignElemList;

		List<By> forRemoveList = new ArrayList<By>(); // list for elements to remove

		try {
			campaignElemList = findAllWebElementsOnPage(driver, deleteIcon, camapignNameToDelete1);
			System.out.println("Lenja List campaignElemList : " + campaignElemList);
			// int i = 0;
			for (WebElement webElement : campaignElemList) {

				try {

					// i = i + 1;
					// System.out.println("i = " + i);
					if (webElement.getAttribute("data-product-name").startsWith(prefix)) {
						String element = webElement.getAttribute("data-product-name");
						System.out.println("webElement get attribute: " + element);
						By deleteIconFinal = By
								.cssSelector("[data-product-name='" + element + "'][id='productDeleteModal']");
						forRemoveList.add(deleteIconFinal); // fill list with elements to remove
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Exception :" + e.getMessage());
				}

			}

			// remove elements and button
			for (By removeEl : forRemoveList) {
				click(driver, removeEl);
				click(driver, deleteCampaignButton);
			}

		} catch (Exception e) {

		}
	}

	By payPalAccount = By.cssSelector("//label[@for='pp_gateway_paypalmarketplace_1']");

	public void editCampaign() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		// click(driver, closeDevconsole);
		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		type(driver, supportURL, URL);
		scrollPageToBottom(driver);
		click(driver, saveBtn);

		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

		String name1 = "[data-product-name='";
		String namefull = name1 + campaignNewName + "']";
		By editCampaign = By.cssSelector(namefull + "[id='productEditModal']");

		type(driver, searchField, campaignNewName);
		click(driver, iconSearch);

		findSuccessElementByStringAndClick(driver, campaignLogo, campaignNewName, editCampaign);
		System.out.println("campaignNewName  " + campaignNewName);

		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makeCardPrimary);
		click(driver, creditCard);
		click(driver, stripe);
		type(driver, supportURL, URL);
		scrollPageToBottom(driver);

		click(driver, membIntegrDisable);
		click(driver, saveBtn);
		boolean message = driver.findElements(welDoneMessage).size() != 0;
		if (message)
			;
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

	}

}
