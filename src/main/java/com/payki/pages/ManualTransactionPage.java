package com.paykickstart.pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;

public class ManualTransactionPage extends WebDriverUtility {

	WebDriver driver;

	public ManualTransactionPage(WebDriver driver) {
		this.driver = driver;
	}

	By utilities = By.xpath("//span[contains(text(), 'Utilities')]");
	By manualTransactions = By.xpath("//a[@data-original-title='Manual Transactions']");
	By campaign = By.xpath("//span[contains(text(), 'Select Campaign')]");
	By product = By.xpath("//span[contains(text(), 'Nothing selected')]");
	By productDrop = By.xpath("//a[@class='product_name product-td']//span[1]");
	By nextStep = By.xpath("//a[@class='next-step step-button js-next-first-step btn-default']//i");
	By buyerEmail = By.xpath("//input[@id='buyerEmail']");
	String buyEmail = "testPay@mailinator.com";
	By buyer = By.xpath("//td[@class='buyer']");
	By nothingFound = By.xpath("//td[contains(text(), 'Nothing found, sorry.')]");
	By secondStep = By.xpath("//a[@class='next-step step-button js-next-second-step btn-default']//i");
	By affName = By.xpath("//input[@name='affiliate_name']");
	String emailAff = "test2pay@mailinator.com";
	By name = By.xpath("//input[@name='first_name']");
	String aname = "Lenja";
	By lastName = By.xpath("//input[@name='last_name']");
	String lName = "Test";
	By thirdStep = By.xpath("//a[@class='next-step step-button btn-default']//i");
	By freeAccess = By.xpath("//span[contains(text(), 'Free Access')][@class='filter-option pull-left']");
	By ccPayment = By.xpath("//a[@class='cc-payment']//span[1]");
	By oneTime = By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'One-Time')]");
	By recurring = By.xpath("//span[contains(text(), 'Recurring')]");
	By recFreq = By.xpath("//button[@title='3']//span[contains(text(), '3')]");

	By ofPayments = By.cssSelector("[id='total_cycles']");
	String three = "3";
	By refund = By.cssSelector("input[name='refund_period']");
	String ref = "59";
	By price = By.xpath("//div[@class='form-group js-price-wrapper addon-left']//input[@type='number']");
	String priceValue = "31";

	By cardHoldName = By.xpath("//input[@name='cc_holder_name']");
	String cardName = "Jared ManualTrans";
	By cc = By.cssSelector("input#ccNum");
	String cardNum = "4242424242424242";
	By cv = By.cssSelector("input[name='ccCSV']");
	String codeCVV = "123";
	By selectYear = By.cssSelector("[title='Select Year'] .pull-left");
	By inputYear = By.cssSelector(".js-ccExpireYear input[aria-label='Search']");
	String year = "2025";
	By selectMonth = By.xpath("//span[@class='filter-option pull-left'][contains(text(), 'Select Month')]");
	By month = By.xpath("//span[contains(text(), 'December')]");
	By btnCreateTransaction = By.xpath("//button[@class='next-step step-button pull-left finishBtn']//i");
	String expectedTitle = "Transaction Successfully Completed.";
	By transSuccesCompl = By.xpath("//h3[contains(text(), '" + expectedTitle + "')]");
	String mnth = "December";

	public void manualTransaction(String sameCampaign) throws InterruptedException {
		click(driver, utilities);
		click(driver, manualTransactions);
		click(driver, campaign);
		By campaignDrop = By.xpath("//span[contains(text(), '" + sameCampaign + "')]");
		findSuccessElementByStringAndClick(driver, campaignDrop, sameCampaign, campaignDrop);
		click(driver, product);
		click(driver, productDrop);
		click(driver, nextStep);
//		click(driver, nextStep);
		type(driver, buyerEmail, buyEmail);
		type(driver, name, aname);
		type(driver, lastName, lName);
		
		if (driver.findElements(buyer).size() != 0) {
			click(driver, buyer);			
		} else {
			click(driver, nothingFound);
		}

		click(driver, secondStep);

		type(driver, affName, emailAff);
		click(driver, thirdStep);
		click(driver, freeAccess);
		click(driver, ccPayment);

		type(driver, price, priceValue);
		click(driver, oneTime);
		click(driver, recurring);

		// click(driver, recFreq);
		// enter(driver, recFreq);
		// type(driver, ofPayments, three);
		type(driver, cardHoldName, cardName);
		type(driver, cc, cardNum);
		type(driver, cv, codeCVV);
		click(driver, selectMonth);
		click(driver, month);
		click(driver, selectYear);
		type(driver, inputYear, year);
		pressEnter(driver, inputYear);
		click(driver, btnCreateTransaction);
		boolean actualTitle = driver.findElements(transSuccesCompl).size() != 0;
		System.out.println(actualTitle);
		assertTrue(actualTitle);
		compareElementsByText(driver, transSuccesCompl, expectedTitle);

	}

}
