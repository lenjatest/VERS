package com.paykickstart.common;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.paykickstart.items.ValidCreditCardNumbers;

public class WebDriverUtility implements ValidCreditCardNumbers {

	protected WebDriver driver;

	public void start() throws MalformedURLException {

		final ChromeOptions options = new ChromeOptions();
		// options.setBinary("/usr/bin/google-chrome-stable");
		options.addArguments("--no-sandbox");
//		options.addArguments("--headless");
		options.addArguments("--no-default-browser-check"); /* #Overrides default choices */
		options.addArguments("--no-first-run");
		options.addArguments("--disable-default-apps");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("window-size=1920x1080");

		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

		driver = new ChromeDriver(options);
		driver.get("https://dev.paykickstart.com/admin/login");
		/*
		 * URL serverurl = new URL("http://jenkins.paykickstart.com:4444/wd/hub");
		 * driver = new RemoteWebDriver(serverurl, options);
		 * 
		 * /* driver.get("https://app.paykickstart.com/admin/login");
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public void killChromeDriverProcess() throws IOException {
		Process p = Runtime.getRuntime().exec("killall chromedriver");
		Runtime.getRuntime().exec("killall chrome");
		System.out.println(p);
	}

	public void printAllPid() {
		try {
			String line;
			Process p = Runtime.getRuntime().exec("ps -e");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) {
				System.out.println(line); // <-- Parse data here.
			}
			input.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public void startForTest(String URL) throws MalformedURLException {

		final ChromeOptions options = new ChromeOptions();
		// options.setBinary("/usr/bin/google-chrome-stable");
		options.addArguments("--no-sandbox");
		options.addArguments("--headless");
		options.addArguments("--no-default-browser-check"); /* #Overrides default choices */
		options.addArguments("--no-first-run");
		options.addArguments("--disable-default-apps");
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("window-size=1920x1080");

		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		options.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

		driver = new ChromeDriver(options);
		driver.get(URL);
		/*
		 * URL serverurl = new URL("http://jenkins.paykickstart.com:4444/wd/hub");
		 * driver = new RemoteWebDriver(serverurl, options);
		 * 
		 * /* driver.get("https://app.paykickstart.com/admin/login");
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	public final static int TIMEOUT = 300;
	public final static int TIMING = 3;

	public boolean isTestElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static String randomCCNUmber() {
		ArrayList<String> listCC = new ArrayList<>();
		Random randomGenerator = new Random();

		listCC.add(visa);
		listCC.add(visaDebit);
		listCC.add(mastercard);
		listCC.add(mastercardTwoSeries);
		listCC.add(mastercardDebit);
		listCC.add(mastercardPrepaid);
		listCC.add(americanExpress);
		listCC.add(americanExpress1);
		listCC.add(discover);
		listCC.add(discover1);
		listCC.add(dinersClub);
		listCC.add(dinersClub1);
		listCC.add(JCB);
		listCC.add(UnionPay);
		int index = randomGenerator.nextInt(listCC.size());
		String randomNumber = listCC.get(index);

		return randomNumber;
	}

	public static WebElement findElement(WebDriver driver, By locator) {
		By cssLocator = locator;
		waitForElement(driver, cssLocator, TIMEOUT);
		WebElement element = driver.findElement(cssLocator);
		return element;
	}

	public static WebElement findElementBy(WebDriver driver, By locator, int TIMEOUT) {
		By cssLocator = locator;
		waitForElement(driver, cssLocator, TIMEOUT);
		WebElement element = driver.findElement(cssLocator);
		return element;
	}

	public static String createNewName(String name) {
		String result = "";
		result = name + Math.random();
		/* result = name; */
		ArrayList<String> names = new ArrayList<String>();
		names.add(name);
		System.out.println("campaign name : " + result);
		return result;

	}

	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijkklmnopqrstuvxyz";

	public static String randomAlphaNumeric(int count) {

		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());

			builder.append(ALPHA_NUMERIC_STRING.charAt(character));

		}

		return builder.toString();

	}

	private static final String NUMERIC_STRING = "41234567890123";

	public static String randomNumeric(int count) {

		StringBuilder builder = new StringBuilder();

		while (count-- != 0) {

			int character = (int) (Math.random() * NUMERIC_STRING.length());

			builder.append(NUMERIC_STRING.charAt(character));

		}

		return builder.toString();

	}

	public void testWebAlert() throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {

		}
	}

	public void compareTitle(WebDriver driver, String expectedTitle) throws InterruptedException {
		waitForPageLoaded(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.titleContains(expectedTitle));
			assertEquals(driver.getTitle(), expectedTitle);
			System.out.println("actualTitle:  " + driver.getTitle());
			System.out.println("expectedTitle:  " + expectedTitle);
		} catch (Exception e) {
			Assert.fail("Title not found :" + expectedTitle);
			System.out.println("Title not found");
		}

	}

	public void compareElement(WebDriver driver, By locator, String expectedString) throws InterruptedException {
		waitForPageLoaded(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedString));
			System.out.println("element   " + expectedString);
			String actualElement = driver.findElement(locator).getText().substring(0, 9);
			System.out.println("element   " + actualElement);
			assertEquals(actualElement, expectedString);
		} catch (Exception e) {
			Assert.fail("Title not found: " + expectedString);
		}
	}

	public void compareElementsByText(WebDriver driver, By locator, String expectedElement)
			throws InterruptedException {
		waitForPageLoaded(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedElement));
			String actualElement = driver.findElement(locator).getText();
			System.out.println("actualElement   " + actualElement);
			System.out.println("expectedElement   " + expectedElement);
			assertEquals(actualElement, expectedElement);
		} catch (Exception e) {
			Assert.fail("Title not found: " + expectedElement);
		}
	}

	public void compareElementsByTextSubstring(WebDriver driver, By locator, String expectedElement)
			throws InterruptedException {
		waitForPageLoaded(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedElement));
			String actualElement = driver.findElement(locator).getText().substring(13, 15);
			System.out.println("actualElement   " + actualElement);
			System.out.println("expectedElement   " + expectedElement);
			assertEquals(actualElement, expectedElement);
		} catch (Exception e) {
			Assert.fail("Title not found: " + expectedElement);
		}
	}

	public void getScriptOnPage(WebDriver driver, String expectedString) throws InterruptedException {
		waitForPageLoaded(driver);
		// WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		// wait.until(ExpectedConditions.driver
		boolean actualString = driver.getPageSource().contains(expectedString);
		System.out.println("Checking by String that user is on correct page after an action :  " + actualString);
		waitForPageLoaded(driver);
		assertTrue(actualString);

	}

	public void checkNoScriptOnPage(WebDriver driver, String expectedString) throws InterruptedException {
		waitForPageLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.titleContains(driver.getTitle()));
		boolean actualString = driver.getPageSource().contains(expectedString);
		assertNull(actualString);
		System.out.println("Checking by String that page no longer contains removed string :  " + actualString);

	}

	public String findSuccessElementOnPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement,
			By removeLocator, By deleteCampaignButton) throws InterruptedException {
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		while (iter.hasNext()) {
			campaign = iter.next().getText().substring(0, 2);
			System.out.println("campaign  :" + campaign);
			if (campaign.equals(expectedTextElement)) {
				System.out.println("expectedTextElement  " + expectedTextElement);
				click(driver, removeLocator);
				click(driver, deleteCampaignButton);

			}

		}
		return result;
	}

	public String findSuccessStringRemove(WebDriver driver, By expectedLocatorElement, String expectedTextElement,
			By removeLocator, By deleteCampaignButton) throws InterruptedException {
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		while (iter.hasNext()) {
			campaign = iter.next().getAttribute("data-product-name").substring(0, 2);
			if (campaign.startsWith(expectedTextElement)) {
				System.out.println("gotfromAttribute:  " + campaign);
				System.out.println("expectedTextElement  " + expectedTextElement);
				click(driver, removeLocator);
				click(driver, deleteCampaignButton);
			}

		}
		return campaign;
	}

	public String findExpectedStringByAttribute(WebDriver driver, By expectedLocatorElement, String attribute,
			String expectedTextElement) throws InterruptedException {
		waitForPageLoaded(driver);
		String campaign = "";
		String result = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		while (iter.hasNext()) {
			campaign = iter.next().getAttribute(attribute).substring(0, 2);
			if (campaign.startsWith(expectedTextElement)) {
				System.out.println("gotfromAttribute:  " + campaign);
				System.out.println("expectedTextElement  " + expectedTextElement);
				result = campaign;

			}

		}
		return result;
	}

	public String getExpectedStringByAttribute(WebDriver driver, By expectedLocatorElement, String attribute,
			String expectedTextElement) throws InterruptedException {
		waitForPageLoaded(driver);
		String campaign = "";
		String result = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		while (iter.hasNext()) {
			campaign = iter.next().getAttribute(attribute);
			if (campaign.equals(expectedTextElement)) {
				System.out.println("gotfromAttribute:  " + campaign);
				System.out.println("expectedTextElement  " + expectedTextElement);
				result = campaign;

			}

		}
		return result;
	}

	public String getStringByAttribute(WebDriver driver, By expectedLocatorElement, String expectedTextElement)
			throws InterruptedException {
		waitForPageLoaded(driver);
		String campaign = "";
		String result = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		while (iter.hasNext()) {
			campaign = iter.next().getAttribute("data-clipboard-text");
			if (campaign.equals(expectedTextElement)) {
				System.out.println("gotfromAttribute:  " + campaign);
				System.out.println("expectedTextElement  " + expectedTextElement);
				result = campaign;

			}

		}
		return result;
	}

	public String findSuccessString(WebDriver driver, By expectedLocatorElement, String expectedPrefix)
			throws InterruptedException {
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();

		first: while (iter.hasNext()) {
			campaign = iter.next().getAttribute("data-product-name");
			if (campaign.startsWith(expectedPrefix))
				break first;
		}
		return campaign;
	}

	public String findAndRemoveElementOnPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement,
			By removeLocator, By deleteCampaignButton) throws InterruptedException {
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			try {
				campaign = iter.next().getText().substring(0, 2);
				System.out.println("campaign  :" + campaign);
				if (campaign.equalsIgnoreCase(expectedTextElement)) {
					System.out.println("expectedTextElement  " + expectedTextElement);
					click(driver, removeLocator);
					click(driver, deleteCampaignButton);
					// driver.navigate().refresh();
					// driver.manage().deleteAllCookies();

				}

			} catch (StaleElementReferenceException e) {
				System.err.println("ExceptionLenja : " + e.getMessage());
				e.printStackTrace();
			}

		}
		return result;
	}

	public String findAndRemoveElemFromPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement,
			By removeLocator, By deleteCampaignButton) throws InterruptedException {
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			try {
				campaign = iter.next().getText();
				System.out.println("campaign  :" + campaign);
				if (campaign.equalsIgnoreCase(expectedTextElement)) {
					System.out.println("expectedTextElement  " + expectedTextElement);
					click(driver, removeLocator);
					click(driver, deleteCampaignButton);
					// driver.navigate().refresh();
					// driver.manage().deleteAllCookies();

				}

			} catch (StaleElementReferenceException e) {
				System.err.println("ExceptionLenja : " + e.getMessage());
				e.printStackTrace();
			}

		}
		return campaign;
	}

	public String findAndRemoveFunnelOnPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement,
			By removeLocator, By deleteCampaignButton) throws InterruptedException {
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			try {
				campaign = iter.next().getText();
				System.out.println("campaign  :" + campaign);
				if (campaign.equalsIgnoreCase(expectedTextElement)) {
					System.out.println("expectedTextElement  " + expectedTextElement);
					click(driver, removeLocator);
					click(driver, deleteCampaignButton);
					// driver.navigate().refresh();
					// driver.manage().deleteAllCookies();

				}

			} catch (StaleElementReferenceException e) {
				System.err.println("ExceptionLenja : " + e.getMessage());
				e.printStackTrace();
			}

		}
		return campaign;
	}

	public List<WebElement> findAllWebElementsOnPage(WebDriver driver, By totalLocatorElement,
			String expectedTextElement) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(totalLocatorElement));
		List<WebElement> listOfElements = driver.findElements(totalLocatorElement);

		return listOfElements;
	}

	public String findNoStringOnPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement)
			throws InterruptedException {
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			campaign = iter.next().getText();
			if (campaign.equalsIgnoreCase(expectedTextElement)) {
				result = campaign;
				System.out.println("CampaignIsRemoved?   :" + result);
				assertNull(result);

			}
		}

		return result;
	}

	public String findStringOnPage1(WebDriver driver, By expectedLocatorElement) throws InterruptedException {
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			campaign = iter.next().getText();
			System.out.println("campaign  :" + campaign);

		}
		return campaign;
	}

	public String findStringOnPage(WebDriver driver, By expectedLocatorElement, String expectedTextElement)
			throws InterruptedException {
		waitForPageLoaded(driver);
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		while (iter.hasNext()) {
			campaign = iter.next().getText();
			System.out.println("string  :" + campaign);
			if (campaign.equalsIgnoreCase(expectedTextElement)) {
				result = campaign;
				System.out.println("values   :" + result);
				assertEquals(result, expectedTextElement);
			}

		}
		return result;
	}

	public String findSuccessElementByStringAndClick(WebDriver driver, By expectedLocatorElement, String names,
			By editCampaign) throws InterruptedException {
		waitForPageLoaded(driver);
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		// wait.until(ExpectedConditions.elementToBeClickable(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		try {
			while (iter.hasNext()) {
				campaign = iter.next().getText();
				System.out.println("succesString " + campaign);
				System.out.println("names " + names);
				if (campaign.equalsIgnoreCase(names)) {
					click(driver, editCampaign);
					result = campaign;
					System.out.println("values   :" + result);
					assertEquals(result, names);
				}

			}

			waitForPageLoaded(driver);
		} catch (Exception e) {
		}
		return result;
	}

	public String findSuccessElementByStringAndClick2(WebDriver driver, By expectedLocatorElement, String names,
			By editCampaign) throws InterruptedException {
		waitForPageLoaded(driver);
		String result = "";
		String campaign = "";
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(expectedLocatorElement));
		// wait.until(ExpectedConditions.elementToBeClickable(expectedLocatorElement));
		List<WebElement> listOfElements = driver.findElements(expectedLocatorElement);
		Iterator<WebElement> iter = listOfElements.iterator();
		try {
			while (iter.hasNext()) {
				campaign = iter.next().getText();
				System.out.println("succesString " + campaign);
				System.out.println("names " + names);
				if (campaign.equalsIgnoreCase(names)) {
					WebElement element = driver.findElement(editCampaign);
					wait.until(ExpectedConditions.presenceOfElementLocated(editCampaign));
					wait.until(ExpectedConditions.elementToBeClickable(editCampaign));
					Actions action = new Actions(driver);
					action.moveToElement(element).build().perform();
					action.click(element).build().perform();
					// click(driver, editCampaign);
					result = campaign;
					System.out.println("values   :" + result);
					assertEquals(result, names);
				}

			}

			waitForPageLoaded(driver);
		} catch (Exception e) {
		}
		return result;
	}

	public void refreshPage(WebDriver driver, By by) throws InterruptedException {
		waitForPageLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.navigate().refresh();
	}

	public By closeModalPopUp(WebDriver driver, By closeModal) throws InterruptedException {
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 15);
		 * wait.until(ExpectedConditions.presenceOfElementLocated(closeModal));
		 */
		System.out.println("closeModal   " + closeModal);
		if (driver.findElement(closeModal) != null) {
			click(driver, closeModal);

		}
		return closeModal;

	}

	public void selectRandomItems(WebDriver driver, By randomElement) throws InterruptedException {
		WebElement element = waitForElement(driver, randomElement, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(randomElement));
			List<WebElement> list = driver.findElements(randomElement);
			System.out.println("listOfRandomElements:  " + list);
			Random random = new Random();
			int randomValue = random.nextInt(list.size());
			list.get(randomValue).click();
		} catch (Exception e) {
			Assert.fail("random element not found: " + randomElement);
			System.out.println("element not found");
		}
	}

	public void randomize(WebDriver driver, By by) {
		WebElement[] array = new WebElement[52];
		array[0] = driver.findElement(By.xpath("//*[contains(text(),'Quick View')]"));
		for (int i = 0; i < array.length; i++) {
			driver.findElements(by);
			System.out.println(array.toString());

		}
	}

	public void compareTitle2(WebDriver driver, String expectedTitle) throws InterruptedException {
		String successPage = expectedTitle;
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.titleContains(successPage));
		assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("actualTitle  " + driver.getTitle());
		System.out.println("expectedTitle  " + expectedTitle);

	}

	protected static void waitForPageLoaded(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		for (int i = 0; i < tabs.size(); i++) {
			driver.switchTo().window(tabs.get(i));
			ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				}
			};
			org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(driver, TIMEOUT);
			try {
				wait.until(expectation);
			} catch (Throwable error) {
			}
		}
	}

	protected WebElement getElement(WebDriver driver, Object obj) {
		// System.out.println(driver + " driver");
		// System.out.println(obj + " object");
		if (obj.getClass().getName().contains(By.class.getName())) {
			return waitForElement(driver, (By) obj, 30);
		}
		return (WebElement) obj;
	}

	protected void click(WebDriver driver, By by) throws InterruptedException {
		WebElement element = waitForElement(driver, by, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			action.click(element).build().perform();
			System.out.println("element is clicked  " + by);
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + by);
			System.out.println("element not found");
		}
	}

	protected void doubleClick(WebDriver driver, By by) throws InterruptedException {
		WebElement element = waitForElement(driver, by, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			action.doubleClick(element).build().perform();
			System.out.println("element is doubleclicked  " + by);
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + by);
			System.out.println("element not found");
		}
	}

	protected void enter(WebDriver driver, By by) throws InterruptedException {
		WebElement element = waitForElement(driver, by, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			action.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
			action.build().perform();
			System.out.println("element is clicked  " + by);
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + by);
			System.out.println("element not found");
		}
	}

	protected void pressEnter(WebDriver driver, By by) throws InterruptedException {
		WebElement element = waitForElement(driver, by, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeClickable(by));
			action.sendKeys(Keys.ENTER);
			action.build().perform();
			System.out.println("element is clicked  " + by);
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + by);
			System.out.println("element not found");
		}
	}

	protected void clickInvisibleSelectElement(WebDriver driver, By hover, By clickable) throws InterruptedException {
		waitForPageLoaded(driver);
		try {
			WebElement hoverElement = driver.findElement(hover);
			Actions action = new Actions(driver);
			action.moveToElement(hoverElement).build().perform();
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated(clickable));
			wait.until(ExpectedConditions.elementToBeClickable(clickable));
			driver.findElement(clickable).click();
			System.out.println("element is clicked  " + clickable);
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + clickable);
		}
	}

	protected void type(WebDriver driver, By by, Object text) throws InterruptedException {
		waitForElement(driver, by, TIMEOUT);
		WebElement element = driver.findElement(by);
		text = String.valueOf(text);
		// String str = text.toString();
		// CharSequence ch = str;
		System.out.println(
				"Filling a text '" + text + "' into the field '" + by + "' on page '" + driver.getCurrentUrl() + "'");
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		wait.until(ExpectedConditions.elementToBeClickable(by));
		element.clear();
		action.sendKeys(element, " ").build().perform();
		element.clear();
		element.sendKeys((String) text);
	}

	protected void switchFrame(WebDriver driver, By by) {
		driver.switchTo().frame(driver.findElement(by));
	}

	protected void switchDefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void pressEnterButton(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(Keys.ENTER);
	}

	protected void selectMultipleOptionsFromDropDownList(WebDriver driver, By quantity, String value)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfElementLocated(quantity));
		Select select = new Select(driver.findElement(quantity));
		// select.deselectAll();
		select.selectByVisibleText(value);
	}

	protected void selectOptionFromDropDownList(WebDriver driver, By by, String value) throws InterruptedException {
		waitForPageLoaded(driver);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		Select select = new Select(driver.findElement(by));
		// select.deselectAll();
		select.selectByVisibleText(value);
	}

	public static WebElement waitForElement(WebDriver driver, final By by, int timeout) {
		org.openqa.selenium.support.ui.Wait<WebDriver> wait = new WebDriverWait(driver, timeout);

		driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);

		ExpectedCondition<WebElement> expectation = new ExpectedCondition<WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		};

		try {
			return wait.until(expectation);
		} catch (Throwable error) {
			return null;
		}
	}

	public void scrollPageToBottom(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPageToTop(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
	}

	public void scrollToElement(WebDriver driver, By by) {
		WebElement element = driver.findElement(by);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	protected void moveToElement2(WebDriver driver, By by) throws InterruptedException {
		WebElement element = waitForElement(driver, by, TIMEOUT);
		waitForPageLoaded(driver);
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			waitForPageLoaded(driver);
		} catch (Exception e) {
			Assert.fail("element not found: " + by);
			System.out.println("element not found");
		}
	}

}
