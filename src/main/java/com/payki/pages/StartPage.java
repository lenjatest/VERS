package com.paykickstart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.User;

public class StartPage extends WebDriverUtility {

	WebDriver driver;
	WebElement element;
	String successPage = new String("Success Page");

	By emailAddress = By.cssSelector("#username");
	By password = By.cssSelector("#password");

	Object inputEmailAddress = "lenjatest@gmail.com";
	Object inputPassword = "XXXXXXXXXXXXx";

	By loginButton = By.cssSelector(".btn-lg");
	By closeModal = By.cssSelector(".fa-times");
	By closeModal1 = By.cssSelector(".btn.btn-primary");

	By campaignMainMenu = By.xpath("//a[@data-original-title='Campaigns']");
	By campaignSubMenu = By.cssSelector("ul[class='collapse open in']>li>a[data-original-title='Campaigns']");

	public StartPage(WebDriver driver) {
		this.driver = driver;
	}

	By closeDevconsole = By.cssSelector(".phpdebugbar-close-btn");

	public StartPage login() throws InterruptedException {
		type(this.driver, emailAddress, inputEmailAddress);
		type(this.driver, password, inputPassword);
		click(this.driver, loginButton);

		// try {
		// if (driver.findElements(closeDevconsole).size() != 0) {
		//
		// click(driver, closeDevconsole);
		// }
		//
		// } catch (Exception e) {
		//
		// }

		return new StartPage(driver);

	}

	public StartPage loginUser(User user) throws InterruptedException {
		type(this.driver, emailAddress, user.email);
		type(this.driver, password, user.password);
		click(this.driver, loginButton);
		// try {
		// if (driver.findElements(closeDevconsole).size() != 0) {
		//
		// click(driver, closeDevconsole);
		// }
		//
		// } catch (Exception e) {
		//
		// }

		return new StartPage(driver);

	}

	By logoutButton = By.xpath("//a[contains(text(), 'Sign Out')]");
	By avatar = By.xpath("//img[@class='avatar']");

	public void logOut() throws InterruptedException {
		click(driver, avatar);
		click(this.driver, logoutButton);

	}

	By reqToPromote = By.xpath("//span[contains(text(), 'Request to Promote')]");
	By username = By.xpath("//input[@name='username']");
	By pass = By.xpath("//span[@class='input input--fumi input--filled']//input[@name='password']");
	By loginBtn = By.xpath("//button[contains(text(), 'Login to PayKickstart')]");

	public void loginVendor(User user) throws InterruptedException {
		type(this.driver, username, user.email);
		type(this.driver, pass, user.password);
		click(this.driver, loginBtn);
		try {
			click(driver, closeDevconsole);

		} catch (Exception e) {

		}

	}

	public void requestToPromote() throws InterruptedException {
		click(driver, reqToPromote);
	}

	By requestCount = By.xpath("//span[@id='request_count']/parent::li/a");
	By approveInstant = By.xpath("//span[contains(text(), 'Approve (Instant)')]");

	public void approveRequest(String sameCampaign) throws InterruptedException {
		click(driver, requestCount);
		By hoverElem = By.xpath("//div[contains(text(), '" + sameCampaign + "')]");
		System.out.println("hoverElem: " + hoverElem);
		By approveInstant = By.xpath("//div[contains(text(), '" + sameCampaign
				+ "')]/parent::div/parent::div/parent::div//div[@class='notification-action']//span[contains(text(), 'Approve (Instant)')]");
		System.out.println("approveInstant: " + approveInstant);
		clickInvisibleSelectElement(driver, hoverElem, approveInstant);

	}

	By affiilateMainMenu = By.xpath("//a[@data-original-title='Affiliate']");
	By linksSubMenu = By.xpath("//a[@data-original-title='Links']");

	public void openLinksPage() throws InterruptedException {
		click(driver, affiilateMainMenu);
		click(driver, linksSubMenu);

	}

	By affiliatesSubMenu = By.xpath("//a[@data-original-title='Affiliates']");

	public void openAffiliatesPage() throws InterruptedException {
		click(driver, affiilateMainMenu);
		click(driver, affiliatesSubMenu);

	}

	By affiliateLinks = By.xpath("//a[@data-original-title='Affiliate Links']");

	public void openaffiliateLinksPage() throws InterruptedException {
		click(driver, affiliateLinks);

	}

}
