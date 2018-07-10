package com.paykickstart.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import com.paykickstart.common.WebDriverUtility;

public class RefundPage extends WebDriverUtility {

	WebDriver driver;

	public RefundPage(WebDriver driver) {
		this.driver = driver;
	}

	By payments = By.cssSelector(".fa-credit-card");
	By transactions = By.cssSelector("[data-original-title='Transactions']");
	By refundIcon = By.cssSelector(".refund-transaction-trigger");
	By refundInputField = By.cssSelector("#refundTransaction [name='refund-confirm']");
	String refund = "REFUND";
	By refundBtn = By.cssSelector("#refundTransaction .refund_transaction_btn");

	By closeDevconsole = By.cssSelector(".phpdebugbar-close-btn");
	By status = By.cssSelector("td>.status_content");
	String expectedStatus = "Refunded";
	By detailsIcon = By.cssSelector("i[data-original-title='Details']");

	public void openRefundPage() throws InterruptedException {
		String url = "https://dev.paykickstart.com";
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		driver.get(url);
		click(driver, payments);
		click(driver, transactions);

	}

	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");
	By closeIcon = By.xpath("//div[@id='cancelSubscription']//button[@class='close']//span");

	public void refund(String campaign) throws InterruptedException {

		// click(driver, closeDevconsole);

		// type(driver, searchField, campaign);
		// click(driver, iconSearch);

		// h5[@class='campaign-title'][contains(text(), 'autotest0.7497577580744632')]
		String name = "//h5[@class='campaign-title'][contains(text(), '";
		String campaignFullName = name + campaign + "')]";
		By findCampaignInTransactionList = By.xpath(campaignFullName);
		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList, campaign, refundIcon);
		type(driver, refundInputField, refund);
		try {
			click(driver, refundBtn);
			click(driver, closeIcon);
		} catch (StaleElementReferenceException e) {

		} finally {
			waitForPageLoaded(driver);

		}

	}

	By iconInvoice = By.cssSelector("i[data-original-title='Invoice']");

	public void checkIsRefund(String campaign) throws InterruptedException {
		refreshPage(driver, detailsIcon);
		By findCampaignInTransactionList1 = By
				.xpath("//h5[@class='campaign-title'][contains(text(), '" + campaign + "')]");
		By detailIcon = By.xpath("//h5[@class='campaign-title'][contains(text(), '" + campaign
				+ "')]/parent::a/parent::div/parent::li//i[@data-original-title='Details']");

		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList1, campaign, detailIcon);

		String actualStatus = driver.findElement(status).getText();
		System.out.println("refund actual status " + actualStatus);
		assertEquals(actualStatus, expectedStatus);
	}

	String expectedDisputeStatus = "Dispute Opened";

	public void checkIsDisputed(String campaign) throws InterruptedException {

		String name1 = "//h5[@class='campaign-title'][contains(text(), '";
		String campaignFullName1 = name1 + campaign + "')]";
		By findCampaignInTransactionList1 = By.xpath(campaignFullName1);

		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList1, campaign, detailsIcon);

		String actualStatus = driver.findElement(status).getText();
		System.out.println("Dispute status " + actualStatus);
		assertEquals(actualStatus, expectedDisputeStatus);
	}

	By trial = By.xpath("//td[@class='trans_pay_gateway']");
	String expectedFreeTrial = "Freetrial";

	public void checkIsFreeTrial() throws InterruptedException {

		String actualStatus = driver.findElement(trial).getText();
		System.out.println("Freetrial: " + actualStatus);
		assertEquals(actualStatus.substring(0, 9), expectedFreeTrial);
	}

}
