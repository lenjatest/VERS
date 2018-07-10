package com.paykickstart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.ValidCreditCardNumbers;

public class BillingPage extends WebDriverUtility implements ValidCreditCardNumbers {

	WebDriver driver;

	public BillingPage(WebDriver driver) {
		this.driver = driver;
	}

	By avatar = By.xpath("//img[@class='avatar']");
	By billing = By.xpath("//a[contains(text(), 'Billing')]");
	By update = By.cssSelector(".updatePaymentMethod");
	By creditCard = By.xpath("//small[contains(text(), 'Credit Card')]");
	By ccHolderName = By.xpath("//input[@id='ccHolderName']");
	String ccHolderNewNameRandom = randomAlphaNumeric(7);
	By ccNum = By.xpath("//input[@id='ccNum']");
	String strCCNum = "4000000000000259";
	String srtCCNumRandom = randomCCNUmber();
	By expireMonth = By.xpath("//select[@id='ccExpireMonth']");
	By optionMonth = By.xpath("//select[@id='ccExpireMonth']//option");
	By expireYear = By.xpath("//select[@id='ccExpireYear']");
	By optionYear = By.xpath("//select[@id='ccExpireYear']//option[@value='2028']");
	By csv = By.xpath("//input[@id='ccCSV']");
	String cvv = "123";
	By btnUpdateBill = By.xpath("//button[contains(text(), ' UPDATE MY BILLING')]");
	String expectedString = "Billing details have been updated successfully";
	By ccHoldNameEelem = By.xpath("//span[contains(text(), '" + ccHolderNewNameRandom + "')]");

	public void updateCreditCardDetails() throws InterruptedException {
		click(driver, avatar);
		click(driver, billing);
		click(driver, update);
		click(driver, creditCard);
		type(driver, ccHolderName, ccHolderNewNameRandom);
		type(driver, ccNum, srtCCNumRandom);
		click(driver, expireMonth);
		selectRandomItems(driver, optionMonth);
		click(driver, expireYear);
		clickInvisibleSelectElement(driver, optionYear, optionYear);
		click(driver, csv);
		type(driver, csv, cvv);
		click(driver, btnUpdateBill);
		compareElementsByText(driver, ccHoldNameEelem, ccHolderNewNameRandom);

	}

}
