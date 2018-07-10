package com.paykickstart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.paykickstart.common.WebDriverUtility;

public class DimondCheckoutPage extends WebDriverUtility {

	public DimondCheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.xpath("//input[@id='field_email']");
	String testEmail = randomAlphaNumeric(5) + "@test.com";
	By firstName = By.xpath("//input[@id='field_first_name']");
	String fNameStr = randomAlphaNumeric(7);
	By lastName = By.xpath("//input[@id='field_last_name']");
	String lNameStr = randomAlphaNumeric(7);
	By pass = By.xpath("//section[@id='user-form-data']//input[@id='field_password']");
	String passStr = "<script>alert('I am password from Diamond checkout');</script>";
	By passConfirm = By.xpath("//input[@id='field_password_confirmation']");
	By cc = By.xpath("//a[@data-gateway-type='cc']");
	By nameOnCard = By.xpath("//input[@id='cc_holder_name']");
	By cardNumber = By.xpath("//input[@id='field_card_number']");
	By expire = By.xpath("//input[@id='field_card_exp']");
	String expireStr = "09 / 29";
	By csv = By.xpath("//input[@id='field_card_cvv']");
	String csvStr = "123";
	By checkBoxAgree = By.xpath("//input[@id='field_agree']/parent::div//label");
	By createMyAccountBtn = By.xpath("//button[contains(text(), 'create')]");

	String successTitlePage = "Thank You";

	public void dimondCheckoutCC() throws InterruptedException {
		type(driver, email, testEmail);
		click(driver, firstName);
		type(driver, firstName, fNameStr);
		type(driver, lastName, lNameStr);
		type(driver, pass, passStr);
		type(driver, passConfirm, passStr);
		click(driver, cc);
		type(driver, nameOnCard, randomAlphaNumeric(7) + randomAlphaNumeric(7));
		type(driver, cardNumber, randomCCNUmber());
		type(driver, expire, expireStr);
		type(driver, csv, csvStr);
		click(driver, checkBoxAgree);
		click(driver, createMyAccountBtn);
		compareTitle(driver, successTitlePage);

	}
	
	public void dimondCheckoutCCExistingVendor() throws InterruptedException {
		type(driver, email, testLenjaEmail);
		click(driver, firstName);
		type(driver, password, lenjaPassStr);
		click(driver, btnUpgrade);

		compareTitle(driver, successTitlePage);
	}


	public static String currentWindow;
	By pp = By.xpath("//a[@data-gateway-type='pp']");
	By buyNow = By.cssSelector(".checkout-footer-action #action-button");
	By proceedBraintree = By.xpath("//a[contains(text(), 'Proceed with Sandbox Purchase')]");
	String testLenjaEmail = "lenjatest@gmail.com";
	String lenjaPassStr = "Test123";

	public void dimondCheckoutPayPal() throws InterruptedException {

		type(driver, email, testEmail);
		click(driver, firstName);
		type(driver, firstName, fNameStr);
		type(driver, lastName, lNameStr);
		type(driver, pass, passStr);
		type(driver, passConfirm, passStr);

		click(driver, pp);
		currentWindow = driver.getWindowHandle();
		click(driver, checkBoxAgree);
		click(driver, createMyAccountBtn);
		click(driver, proceedBraintree);
		driver.switchTo().window(currentWindow);
		compareTitle(driver, successTitlePage);

		compareTitle(driver, successTitlePage);

	}

	By password = By.xpath("//section[@id='user-login']//input[@id='field_password']");
	By btnUpgrade = By.xpath("//button[contains(text(), 'Upgrade')]");
	public void dimondCheckoutPayPalExistingVendor() throws InterruptedException {
		type(driver, email, testLenjaEmail);
		click(driver, firstName);
		type(driver, password, lenjaPassStr);
		click(driver, btnUpgrade);

		compareTitle(driver, successTitlePage);
	}

}
