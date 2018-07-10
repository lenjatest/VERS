package com.paykickstart.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paykickstart.common.WebDriverUtility;

public class CheckoutPage extends WebDriverUtility {

	public static String currentWindow;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By inputFirstName = By.cssSelector("input#first_name");
	By inputSecondName = By.cssSelector("input#last_name");

	String firstName = "Autoname";
	String secondName = "Autosurname";

	By email = By.cssSelector("input#email");
	String emailString = randomAlphaNumeric(7) + "@yahoo.com";
	By paypal = By.cssSelector(".fa-paypal");
	By buyNow = By.xpath("//button[@id='action-button']");
	By emailPayPal = By.cssSelector(".fieldWrapper #email");
	String LenjaEmail = "lenjatest@gmail.com";
	By passPayPal = By.cssSelector(".fieldWrapper #password");
	String LenjaPass = "Lenjatest123#";
	By btnLogin = By.cssSelector("#btnLogin");

	By creditCardName = By.cssSelector("input#cc_holder_name");
	String cardName = "Jared Leto";
	By ccNum = By.cssSelector("input#ccNum");
	String cardNum = "4242424242424242";
	String cardNumDisputes = "4000000000000259";
	By titleYear = By.xpath("//button[@title='2018']//span[contains(text(), '2018')]");
	By year = By.cssSelector(".open>div>ul>li[data-original-index='4']");
	By cvv = By.cssSelector("input#ccCSV");
	String codeCVV = "123";
	String successTitlePage = "Thank You";
	By splitPay = By.cssSelector("#split-payment-2");
	By nextBtn = By.cssSelector(".actions #btnNext");
	By continueButton = By.cssSelector(".reviewButton .continueButton");

	public void checkoutCreditCard(Boolean split) throws InterruptedException {
		type(driver, email, emailString);
		type(driver, inputSecondName, secondName);
		type(driver, inputFirstName, firstName);
		if (split) {
			click(driver, splitPay);
		}
		// click(driver, creditCardBtn);
		type(driver, creditCardName, cardName);
		type(driver, ccNum, cardNum);
		click(driver, titleYear);
		click(driver, year);
		type(driver, cvv, codeCVV);
		click(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}

	public void checkoutCreditCard() throws InterruptedException {
		checkoutCreditCard(false);
	}

	public void checkoutCreditCardSplitPay() throws InterruptedException {
		checkoutCreditCard(true);

	}

	public void checkoutPayPal() throws InterruptedException {
		payPal(false);
	}

	public void checkoutPayPalSplitPay() throws InterruptedException {
		payPal(true);
	}

	public void payPal(Boolean split) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		click(driver, paypal);
		if (split) {
			click(driver, splitPay);
		}
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		type(driver, emailPayPal, LenjaEmail);
		click(driver, nextBtn);
		type(driver, passPayPal, LenjaPass);
		click(driver, btnLogin);
		click(driver, continueButton);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	By proceedBraintree = By.xpath("//a[contains(text(), 'Proceed with Sandbox Purchase')]");

	// String firstNameGen = randomAlphaNumeric(8);
	public void payPalBraintree(Boolean split) throws InterruptedException {

		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		click(driver, paypal);
		if (split) {
			click(driver, splitPay);
		}
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		click(driver, proceedBraintree);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	public void checkoutPayPalBraintree() throws InterruptedException {
		payPalBraintree(false);
	}

	public void checkoutPayPalBraintreeSplit() throws InterruptedException {
		payPalBraintree(true);
	}

	public void createDisputeTransaction() throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		// click(driver, creditCardBtn);
		type(driver, creditCardName, cardName);
		type(driver, ccNum, cardNumDisputes);
		click(driver, titleYear);
		click(driver, year);
		type(driver, cvv, codeCVV);
		click(driver, buyNow);
		compareTitle(driver, successTitlePage);
	}

	String expectedDisputeStatus = "Dispute Opened";
	By detailsIcon = By.cssSelector("i[data-original-title='Details']");
	By status = By.cssSelector("td>.status_content");

	public void checkIsDisputed(String campaign) throws InterruptedException {

		String name1 = "//h5[@class='campaign-title'][contains(text(), '";
		String campaignFullName1 = name1 + campaign + "')]";
		By findCampaignInTransactionList1 = By.xpath(campaignFullName1);

		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList1, campaign, detailsIcon);

		String actualStatus = driver.findElement(status).getText();
		System.out.println("refund actual status " + actualStatus);
		assertEquals(actualStatus, expectedDisputeStatus);
	}

	By couponField = By.xpath("//input[@id='coupon_code']");

	By dropCurrency = By.cssSelector("[data-id='base_currency_select']>[class='filter-option pull-left']");
	By inputSearchField = By.className("#base_currency .bs-searchbox input.form-control");
	String usd = "usd";
	By usdCurrency = By.xpath("//span[contains(text(), 'United States Dollar (USD)')]");
	By applyCouponIcon = By.cssSelector(".fa-chevron-circle-right");
	By creditCardBtn = By.xpath("//small[contains(text(), 'Credit Card')]");

	public void checkoutCreditCardWithValidCoupon(String coupon) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);

		type(driver, couponField, coupon);
		click(driver, applyCouponIcon);
		// click(driver, creditCardBtn);
		type(driver, creditCardName, cardName);
		type(driver, ccNum, cardNum);
		click(driver, titleYear);
		click(driver, year);
		type(driver, cvv, codeCVV);

		click(driver, dropCurrency);
		click(driver, usdCurrency);

		click(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}

	public void checkoutStripeCouponSplitPay(String coupon) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);

		type(driver, couponField, coupon);
		click(driver, applyCouponIcon);
		click(driver, onePaymentSplit);
		// click(driver, creditCardBtn);
		type(driver, creditCardName, cardName);

		type(driver, ccNum, cardNum);
		click(driver, titleYear);
		click(driver, year);
		type(driver, cvv, codeCVV);

		click(driver, dropCurrency);
		click(driver, usdCurrency);

		click(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}

	public void payPalWithCoupon(String coupon) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		type(driver, couponField, coupon);
		click(driver, applyCouponIcon);
		click(driver, paypal);
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		type(driver, emailPayPal, LenjaEmail);
		click(driver, nextBtn);
		type(driver, passPayPal, LenjaPass);
		click(driver, btnLogin);
		click(driver, continueButton);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	By onePaymentSplit = By.xpath("//div[@id='split-payment-1']");

	public void payPalSplitWithCoupon(String coupon) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		type(driver, couponField, coupon);
		click(driver, applyCouponIcon);
		click(driver, paypal);
		click(driver, onePaymentSplit);
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		type(driver, emailPayPal, LenjaEmail);
		click(driver, nextBtn);
		type(driver, passPayPal, LenjaPass);
		click(driver, btnLogin);
		click(driver, continueButton);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	public void payPalBraintreeSplitPayCoupon(String coupon) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		type(driver, couponField, coupon);
		click(driver, applyCouponIcon);
		click(driver, paypal);
		click(driver, onePaymentSplit);
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		click(driver, proceedBraintree);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	By amountBy = By.xpath("//td[@class='trans_amount'][contains(text(), '')]");

	public void checkExpectedTransactionAmount(String campaign, String expectedAmount) throws InterruptedException {

		String name1 = "//h5[@class='campaign-title'][contains(text(), '";
		String campaignFullName1 = name1 + campaign + "')]";
		By findCampaignInTransactionList1 = By.xpath(campaignFullName1);
		refreshPage(driver, detailsIcon);
		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList1, campaign, detailsIcon);
		String actualAmount = driver.findElement(amountBy).getText().substring(1, 5);
		System.out.println("Actual Amount : " + actualAmount);
		assertEquals(actualAmount, expectedAmount);
	}

	public void checkoutNoPayment() throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		click(driver, buyNow);
	}

	By titleYear1 = By.xpath("//select[@name='ccExpireYear']");
	By year1 = By.xpath("//option[contains(text(), '2025')]");

	public void checkoutCreditCardPrettyPress(Boolean split) throws InterruptedException {
		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);
		if (split) {
			click(driver, splitPay);
		}
		type(driver, creditCardName, cardName);
		type(driver, ccNum, cardNum);
		click(driver, titleYear1);
		selectOptionFromDropDownList(driver, titleYear1, "2025");
		type(driver, cvv, codeCVV);
		click(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}

	public void checkoutCreditCardPrettyPressSplitPay() throws InterruptedException {
		checkoutCreditCardPrettyPress(true);
	}

	public void checkoutCreditCardPrettyPressOrForest() throws InterruptedException {
		checkoutCreditCardPrettyPress(false);
	}

	public void payPalBraintreeOfficial() throws InterruptedException {

		type(driver, inputFirstName, firstName);
		type(driver, inputSecondName, secondName);
		type(driver, inputFirstName, firstName);
		type(driver, email, emailString);
		click(driver, paypal);
		currentWindow = driver.getWindowHandle();
		click(driver, buyNow);
		click(driver, proceedBraintree);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);
	}

	public void checkoutCreditCardOther() throws InterruptedException {
		click(driver, inputFirstName);
		click(driver, inputFirstName);
		type(driver, inputFirstName, firstName);

		type(driver, inputSecondName, secondName);
		type(driver, email, emailString);

		// click(driver, creditCardBtn);
		type(driver, creditCardName, cardName);

		type(driver, ccNum, cardNum);
		click(driver, titleYear);
		click(driver, year);
		type(driver, cvv, codeCVV);
		click(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}

	By warning = By.xpath("//b[contains(text(), 'Warning')]/parent::div/parent::div//button[contains(text(), 'Ok')]");

	public void checkIsWarningPresent() {
		boolean warning = driver.findElements(this.warning).size() != 0;
		assertTrue(warning);
	}

	public void closeDuplicateWarning() throws InterruptedException {
		click(driver, warning);
	}

	public void checkoutCreditDistinct() throws InterruptedException {
		doubleClick(driver, inputFirstName);
		type(driver, inputFirstName, firstName);
		doubleClick(driver, inputSecondName);
		type(driver, inputSecondName, secondName);
		doubleClick(driver, email);
		type(driver, email, emailString);
		doubleClick(driver, creditCardName);
		type(driver, creditCardName, cardName);
		doubleClick(driver, ccNum);
		type(driver, ccNum, cardNum);
		doubleClick(driver, titleYear1);
		selectOptionFromDropDownList(driver, titleYear1, "2025");
		doubleClick(driver, cvv);
		type(driver, cvv, codeCVV);
		doubleClick(driver, buyNow);
		compareTitle(driver, successTitlePage);

	}
}
