package com.paykickstart.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;

public class ProductPage extends WebDriverUtility {

	WebDriver driver;
	By campaignMainMenu = By.cssSelector(".fa-list-alt");
	By campaignSubMenu = By.xpath("//a[@data-original-title='Campaigns'][@class=' sidebar-tooltip']");

	By createCampaignBtn = By.cssSelector("a[class='btn btn-custom green create-campaign-btn']");
	By campaignName = By.cssSelector(
			"div[class='modal-dialog center-modal']>form[class='productEditForm']>div[class='modal-content']>div[class='modal-body']>div[class='form-group']>input");
	By saveCampaignName = By.cssSelector("div>button[id='save-campaign-btn']");
	By saveCampaign = By.cssSelector("btn btn-custom green update-product-btn1 builder-button");
	By enableMarketCat = By.cssSelector(".pk-settings-input .blocked-is_marketplace .btn-group .active");
	By marketplace = By.cssSelector(".js-marketplace-list .btn-group .btn");
	By category = By.cssSelector(".opt");
	By paypal = By.cssSelector(".blocked-pp_gateway .btn-group .notActive");
	By creditCard = By.cssSelector(".notActive[data-toggle='cc_gateway']");
	By stripe = By.cssSelector("[for='cc_gateway_stripe_0']");

	By hover = By.cssSelector(
			"div[class='btn-group bootstrap-select show-tick form-control js-marketplace-category dropup open']>div[class='dropdown-menu open']");
	By closeDevconsole = By.cssSelector(".phpdebugbar-close-btn");
	By makePrimaryOnCheckoutRadioButton = By.cssSelector(".blocked-pp_gateway-list input[name='primary-checkout']");
	By makeCardPrimary = By.cssSelector(".blocked-cc_gateway-list>[name='primary-checkout']");

	By expectedElement = By.cssSelector(".campaign-logo");

	public String campaignNewName = createNewName("autotest");

	String expectedCampaignName = "autotest";

	By iconRemoveCampaign = By.cssSelector("[class='btn btn-danger btn-xs has-tooltip productDeleteModal']");
	By deleteCampaignButton = By.cssSelector(".modal-footer .delete_submit");
	By supportURL = By.cssSelector("input[name='support_url']");
	String URL = "http://test.support.ca";
	// By saveBtnCampaign = By.cssSelector(".btn-group .btn-custom .icon");
	By saveBtnCampaign = By.xpath("//button[@type='submit']//i[@class='icon save']");
	By iconGoBack = By.cssSelector(".gobackto");
	/* By editCampaign = By.cssSelector("[class='icon edit']"); */
	By productCreate = By.xpath("//a[@data-product-name='autotest0.7056418337026475']/parent::div/div/a");
	By addProductcss = By.xpath(
			"//a[@data-product-name='autotest0.23346331947053534']/parent::div/div/div/div/div/div/a[@class='btn btn-xs btn-success']");

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	By payPalAccount = By.xpath("//label[@for='pp_gateway_paypalmarketplace_1']");
	By upsell = By.xpath("//a[@data-toggle='upsell'][contains(text(), 'Enable')]");

	public String createCampaignMain(Boolean enableUpsell) throws InterruptedException {
		// try {
		// click(driver, closeDevconsole);
		//
		// } catch (Exception e) {
		//
		// }
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);

		click(driver, payPalAccount);
		click(driver, makeCardPrimary);
		click(driver, creditCard);
		click(driver, stripe);
		click(driver, marketplace);
		selectRandomItems(driver, category);
		if (enableUpsell) {
			click(driver, upsell);
		}
		type(driver, supportURL, URL);
		click(driver, saveBtnCampaign);
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);
		return campaignNewName;

	}

	public String createCampaign() throws InterruptedException {
		return createCampaignMain(false);
	}

	public void createCampaignUpsell() throws InterruptedException {
		createCampaignMain(true);
	}

	By braintree = By.xpath("//label[@for='pp_gateway_braintree_0']");

	public void createCampaignBraintree() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		// try {
		// click(driver, closeDevconsole);
		//
		// } catch (Exception e) {
		//
		// }
		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		click(driver, braintree);
		click(driver, makeCardPrimary);
		click(driver, creditCard);
		click(driver, stripe);
		type(driver, supportURL, URL);
		click(driver, saveBtnCampaign);
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

	}

	By braintreeCC = By.xpath("//label[@for='cc_gateway_braintree_0']");

	public void createCampaignBraintreeCC() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		// try {
		// click(driver, closeDevconsole);
		//
		// } catch (Exception e) {
		//
		// }
		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		click(driver, braintree);
		click(driver, makeCardPrimary);
		click(driver, creditCard);

		click(driver, braintreeCC);
		type(driver, supportURL, URL);
		click(driver, saveBtnCampaign);
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

	}

	By authorizeNet = By.xpath("//label[@for='cc_gateway_authnet_0']");

	public void createCampaignAuthNet() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		click(this.driver, createCampaignBtn);
		type(driver, campaignName, campaignNewName);
		click(driver, saveCampaignName);
		// try {
		// click(driver, closeDevconsole);
		//
		// } catch (Exception e) {
		//
		// }
		click(driver, marketplace);
		selectRandomItems(driver, category);
		click(driver, makePrimaryOnCheckoutRadioButton);
		click(driver, paypal);
		selectRandomItems(driver, payPalAccount);
		click(driver, makeCardPrimary);
		click(driver, creditCard);
		click(driver, authorizeNet);
		type(driver, supportURL, URL);
		click(driver, saveBtnCampaign);
		click(driver, iconGoBack);
		getScriptOnPage(driver, campaignNewName);

	}

	String name1 = "//a[@data-product-name='";
	String namefullCreateProduct = name1 + campaignNewName + "']/parent::div/div/a";
	By product = By.xpath(namefullCreateProduct);

	String name2 = "//a[@data-product-name='";
	String namefullAddProduct = name2 + campaignNewName
			+ "']/parent::div/div/div/div/div/div/a[@class='btn btn-xs btn-success']";
	By addProduct = By.xpath(namefullAddProduct);

	By productName = By.cssSelector(".plan_name_input");
	String nameOfProduct = "product for autotest campaign";
	By source = By.xpath("//a[@id='cke_17']");
	String bodyText = "This description came from automation test: !@#$%^&*()_+{}?/   <script>alert('666');</script> ";

	By bodyDiv = By
			.xpath("//div[@class='cke_1 cke cke_reset cke_chrome cke_editor_email_text cke_ltr cke_browser_webkit']");
	By body = By.cssSelector("body.cke_editable");
	By iframe = By.cssSelector(".cke_wysiwyg_frame");

	By landingURL = By.xpath("//input[@name='landing_url']");
	String urlForLanding = "https://www.lanouvelleecoledecreativite.com/sortir-de-soi-landing";
	By price = By.xpath("//input[@name='price']");
	public String priceValueTo = "31";
	public double priceValue = Integer.parseInt(priceValueTo);

	By BtnEnableTax = By.cssSelector(".tax_services_enabled>div>.notActive");
	By dropDownMenuTax = By.cssSelector("button[data-id='tax_service']");

	By saveButton = By.xpath("//a[@class='next-step save-product-without-exit builder-button']");

	String checkTemplatePage = "Checkout Page";
	By upgradeAccount = By.cssSelector(".upgrade-account-btn");
	By premium = By.cssSelector("#monthly [data-package='Premium']");
	By buttonChangePackageConfirm = By.cssSelector("button.change-package-confirm-button");

	public String sameCampaign;

	By splitBtnEnable = By.xpath("//a[@data-toggle='has_split_pay'][contains(text(), 'Enable')]");
	By splitRefFreq = By.xpath("//div[@class='form-group showSpilitOption']//div//button[@title='1']");
	By splitreqFreqValue = By.xpath(
			"//div[@class='bs-container btn-group bootstrap-select 2 dropup open']//li[@data-original-index='2']//a");
	By days = By.xpath("//div[@class='form-group showSpilitOption']//button[@title='Day(s)']");
	By months = By.cssSelector(".bs-container>.open>.inner>li[data-original-index='1']>a>.text");
	By totalInstallments = By.xpath("//input[@id='total_installments']");
	By splitPayCycles = By.xpath("//input[@id='split_pay_cycles']");
	String installmentsValue = "3";
	By perInstPrice = By.xpath("//input[@name='price_per_installment']");
	public String pricePerInstallment = "10.33";

	public void createProductMain(Boolean split) throws InterruptedException {
		sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);

		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, product);
		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, addProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		if (split) {
			click(driver, splitBtnEnable);
			click(driver, splitRefFreq);
			enter(driver, splitRefFreq);
			click(driver, days);
			click(driver, months);
			type(driver, splitPayCycles, installmentsValue);
			type(driver, perInstPrice, pricePerInstallment);

		}
		// click(driver, BtnEnableTax);
		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

	public void createProduct() throws InterruptedException {
		createProductMain(false);
	}

	public void createProductSplitPay() throws InterruptedException {
		createProductMain(true);
	}

	By Bylink = By.xpath("//a[@class='url-link copy_button']");
	String attributeValue = "data-clipboard-text";

	public String copyAffiliateRequestURL(String sameCampaign) throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, campaignSubMenu);
		this.sameCampaign = campaignNewName;
		type(driver, searchField, this.sameCampaign);
		click(driver, iconSearch);
		String affReqURL = driver.findElement(Bylink).getAttribute(attributeValue);
		System.out.println("from method : " + affReqURL);
		return affReqURL;

	}

	By affReqBtn = By.xpath("//span[contains(text(), 'Send Affiliate Request to Vendor')]");

	public void openAffReqURLByAffiliate(String affReqURL) throws InterruptedException {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		driver.get(affReqURL);
		click(driver, affReqBtn);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(0)); // switches to new tab
		driver.get("https://dev.paykickstart.com/admin/login");
	}

	By oneTime = By.xpath("//span[contains(text(), 'One-Time')]");
	By recurring = By.xpath("//span[contains(text(), 'Recurring')]");
	By recFreq = By.xpath(
			"//div[@id='req_freq']//div//div//div//button//span[@class='filter-option pull-left'][contains(text(), '1')]");
	By recFreqValueThree = By.xpath(
			"//div[@class='bs-container btn-group bootstrap-select 2 dropup open']//div//ul//li[@data-original-index='2']//span[contains(text(), '3')]");
	By ofPayments = By.cssSelector("[id='total_cycles']");
	String three = "3";
	By refund = By.cssSelector("input[name='refund_period']");
	String ref = "59";

	public void createRecurringProductMain(Boolean trial) throws InterruptedException {
		sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);

		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, product);
		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, addProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		click(driver, oneTime);
		click(driver, recurring);
		type(driver, ofPayments, three);
		click(driver, recFreq);
		enter(driver, recFreq);
		if (trial) {
			enableTrial();
		}
		type(driver, refund, ref);
		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

	public void createRecurringProduct() throws InterruptedException {
		createRecurringProductMain(false);
	}

	public void createTrialRecurringProduct() throws InterruptedException {
		createRecurringProductMain(true);
	}

	By saveBtn = By.xpath("//button[@type='submit']//i[@class='icon save']");

	public void createLeadProduct(String leadCamp) throws InterruptedException {
		type(driver, searchField, leadCamp);
		click(driver, iconSearch);
		String leadNameCamp = leadCamp;
		By leadProduct = By.xpath("//a[@data-product-name='" + leadCamp + "']/parent::div/div/a");
		By addLeadProduct = By.xpath("//a[@data-product-name='" + leadCamp
				+ "']/parent::div/div/div/div/div/div/a[@class='btn btn-xs btn-success']");

		System.out.println("leadNameCamp :" + leadNameCamp);
		findSuccessElementByStringAndClick(driver, expectedElement, leadNameCamp, leadProduct);
		findSuccessElementByStringAndClick(driver, expectedElement, leadNameCamp, addLeadProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		click(driver, BtnEnableTax);
		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");

	public void createProductWithTaxProfile(String taxProfile) throws InterruptedException {

		sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);
		sameCampaign = findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, product);
		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, addProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		click(driver, BtnEnableTax);
		type(driver, refund, ref);
		click(driver, dropDownMenuTax);
		By droUpTaxForAutotest = By.xpath("//span[contains(text(), '" + taxProfile + "')]");
		findSuccessElementByStringAndClick(driver, droUpTaxForAutotest, taxProfile, droUpTaxForAutotest);

		// click(driver, droUpTaxForAutotest);

		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

	By template = By.cssSelector("div[id='1-stepCarousel']>div>a[data-template-id='1']");
	By enableLegal = By.cssSelector("[data-section='show_legal_notice'][class='btn btn-primary btn-sm active']");
	By popUpSure = By
			.cssSelector("a[data-section='checkout_exit_popup_is_enabled'][class='btn btn-primary btn-sm active']");
	By nextStepThree = By.cssSelector(".next-step-3");
	By buttonSave = By.xpath("//a[@data-title='Save Settings']//i[@class='icon save']");
	By btnLive = By.xpath("//h5[@data-toggle='dropdown']//span[contains(text(), 'Live')]");
	By productDetails = By.xpath("//p[contains(text(), 'Product Details')]");

	public void selectTemplate(By template, Boolean noPopUps) throws InterruptedException {
		click(driver, template);
		click(driver, enableLegal);
		// click(driver, popUpSure);

		if (noPopUps) {
			disablePopUps();
		}
		// click(driver, nextStepThree);
		// click(driver, btnLive);
		scrollPageToTop(driver);
		click(driver, productDetails);
		click(driver, buttonSave);

	}

	public void selectTemplate(By template) throws InterruptedException {
		selectTemplate(template, true);
	}

	public void selectTemplateWithPopUps(By template) throws InterruptedException {
		selectTemplate(template, false);
	}

	By disableExitPopUp = By.xpath("//a[@data-toggle='checkout_exit_popup_is_enabled'][contains(text(), 'Disable')]");
	By duplicatePopUp = By.xpath("//a[@data-toggle='warning_popup_is_enabled'][contains(text(), 'Disable')]");

	public void disablePopUps() throws InterruptedException {
		click(driver, disableExitPopUp);
		click(driver, duplicatePopUp);
	}

	public void selectDefaultTemplate() throws InterruptedException {

	}

	By enableTrialBtn = By.xpath("//a[@data-toggle='has_trial'][contains(text(), 'Enable')]");
	By inputTrialDays = By.xpath("//input[@id='trial_days']");
	String trialDays = "2";
	By chargeTrialAmmount = By.xpath("//input[@id='trial_amount']");
	public static String trialAmmount = "0.00";
	By collectPaymentMethod = By.xpath("//input[@class='trial_save_payment_method']");

	public void enableTrial() throws InterruptedException {
		click(driver, enableTrialBtn);
		type(driver, inputTrialDays, trialDays);
		type(driver, chargeTrialAmmount, trialAmmount);
		click(driver, collectPaymentMethod);

	}

	public void enableTrialNoPaymentCollected() throws InterruptedException {
		click(driver, enableTrialBtn);
		type(driver, inputTrialDays, trialDays);
		type(driver, chargeTrialAmmount, trialAmmount);

	}

	public void createRecurrProdTrialNoPay() throws InterruptedException {
		sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);

		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, product);
		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, addProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		click(driver, oneTime);
		click(driver, recurring);
		type(driver, ofPayments, three);
		click(driver, recFreq);
		enter(driver, recFreq);
		enableTrialNoPaymentCollected();
		type(driver, refund, ref);
		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

	public String trialAmmountCharge = "5.00";
	public double trialAmount = Double.parseDouble(trialAmmountCharge);

	public void enableTrialCharge() throws InterruptedException {
		click(driver, enableTrialBtn);
		type(driver, inputTrialDays, trialDays);
		type(driver, chargeTrialAmmount, trialAmmountCharge);

	}

	public void createRecurrProdTrialCharge() throws InterruptedException {
		sameCampaign = campaignNewName;
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);

		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, product);
		findSuccessElementByStringAndClick(driver, expectedElement, campaignNewName, addProduct);

		type(driver, productName, nameOfProduct);
		switchFrame(driver, iframe);
		type(driver, body, bodyText);
		switchDefault(driver);
		type(driver, landingURL, urlForLanding);
		type(driver, price, priceValue);
		click(driver, oneTime);
		click(driver, recurring);
		type(driver, ofPayments, three);
		click(driver, recFreq);
		enter(driver, recFreq);
		enableTrialCharge();
		type(driver, refund, ref);
		click(driver, saveButton);
		getScriptOnPage(driver, checkTemplatePage);

	}

}
