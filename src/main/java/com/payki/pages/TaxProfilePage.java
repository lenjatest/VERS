package com.paykickstart.pages;

import static org.testng.Assert.assertNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;

public class TaxProfilePage extends WebDriverUtility {

	WebDriver driver;

	By campaignMainMenu = By.xpath("//a[@data-original-title='Campaigns']");
	By taxProfileSubMenu = By.xpath("//a[@data-original-title='Tax Profiles']");
	By newProfile = By.cssSelector("a[class='builder-button btn btn-custom']");
	By taxName = By.cssSelector("input#name");
	String nameTaxString = createNewName("TaxForAutotest");
	By taxType = By.cssSelector("button[data-id='taxType']");
	By vatTax = By.xpath("//span[@class='text'][contains(text(), 'VAT Tax')]");
	By addCountry = By.cssSelector(".add-country");
	By selectCountry = By.cssSelector("button[title='Selected Country'] .pull-left");
	By inputContryField = By.cssSelector(".bs-searchbox .form-control");
	String taxCountry = "Ukraine";
	By ukraine = By.xpath("//span[@class='text'][contains(text(), 'Ukraine')]");
	By vatTaxRate = By.cssSelector("input.js-country-rate");
	public String taxRateValueTo = "15";
	public double taxRateValue = Integer.parseInt(taxRateValueTo);
	By addTaxCountry = By.cssSelector(".js-add-tax-country");
	By saveProfile = By.cssSelector(".pk-page-header .js-store-tax");
	By dropCountryOpen = By.cssSelector(".js-select-tax-country.open");
	By background = By.cssSelector("js-add-country-modal");

	public TaxProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public String createVATTaxProfile() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, taxProfileSubMenu);
		click(driver, newProfile);
		type(driver, taxName, nameTaxString);
		click(driver, taxType);
		click(driver, vatTax);
		click(driver, saveProfile);
		return nameTaxString;
	}

	By customTax = By.xpath("//span[@class='text'][contains(text(), 'Custom')]");

	public String createCustomTaxProfile() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, taxProfileSubMenu);
		click(driver, newProfile);
		type(driver, taxName, nameTaxString);
		click(driver, taxType);
		click(driver, customTax);
		click(driver, addCountry);
		click(driver, selectCountry);
		type(driver, inputContryField, taxCountry);
		click(driver, ukraine);
		click(driver, dropCountryOpen);
		type(driver, vatTaxRate, taxRateValue);
		click(driver, addTaxCountry);
		click(driver, saveProfile);
		return nameTaxString;

	}

	By salesTax = By.xpath("//span[@class='text'][contains(text(), 'Sales Tax')]");
	By salesTaxValue = By.cssSelector("input#tax_rate");

	public String createSalesTaxProfile() throws InterruptedException {
		click(driver, campaignMainMenu);
		click(driver, taxProfileSubMenu);
		click(driver, newProfile);
		type(driver, taxName, nameTaxString);
		click(driver, taxType);
		click(driver, salesTax);
		type(driver, salesTaxValue, taxRateValue);
		click(driver, saveProfile);
		return nameTaxString;
	}

	public String taxProfile;
	By searchField = By.cssSelector("[name='q']");
	By iconSearch = By.cssSelector(".icon.search");

	public String checkIsTaxProfileCreated() throws InterruptedException {
		type(driver, searchField, nameTaxString);
		click(driver, iconSearch);
		String profileName = "//a[contains(text(), '";
		String couponFullName1 = profileName + nameTaxString + "')]";
		By findProfileInProfileList = By.xpath(couponFullName1);
		taxProfile = findStringOnPage(driver, findProfileInProfileList, nameTaxString);
		System.out.println("taxProfile:  " + taxProfile);
		return taxProfile;

	}

	By removeTaxIcon = By.xpath("//a[@data-original-title='Delete Tax Profile']");

	public void removeAllTaxProfiles() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, taxProfileSubMenu);

		try {
			do {
				click(driver, removeTaxIcon);
			} while (driver.findElements(removeTaxIcon).size() != 0);
		} catch (Exception e) {
			assertNull(removeTaxIcon);
		} finally {
			System.out.println("No funnels with pointed funnel name left in the list");
		}
	}

}
