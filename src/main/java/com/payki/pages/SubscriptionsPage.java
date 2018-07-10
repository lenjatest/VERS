package com.paykickstart.pages;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.paykickstart.common.WebDriverUtility;

public class SubscriptionsPage extends WebDriverUtility {

	WebDriver driver;

	public SubscriptionsPage(WebDriver driver) {
		this.driver = driver;
	}

	By subcrPane = By.xpath("//a[@data-original-title='Subscriptions']");
	By payments = By.cssSelector(".fa-credit-card");
	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");
	By detailsIcon = By.xpath("//i[@data-original-title='Details']");
	By subscrStatus = By.xpath("//td[@class='sub_type'][contains(text(), '')]");
	String expectedStatus = "$31.00 today, then $31.00 for each 3 days for 2 payments";

	public void checkSubscriptionStatus(String sameCampaign) throws InterruptedException {
		String url = "https://dev.paykickstart.com";
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0)); // switches to new tab
		driver.get(url);
		click(driver, payments);
		click(driver, subcrPane);
		type(driver, searchField, sameCampaign);
		click(driver, iconSearch);
		click(driver, detailsIcon);
		String actualSatus = driver.findElement(subscrStatus).getText();
		System.out.println("actualSatus : " + actualSatus);
		assertEquals(actualSatus, expectedStatus);
	}
}
