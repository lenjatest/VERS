package com.paykickstart.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.paykickstart.common.WebDriverUtility;

public class CouponPage extends WebDriverUtility {

	WebDriver driver;

	By campaignMainMenu = By.xpath("//a[@data-original-title='Campaigns']");
	By couponSubMenu = By.cssSelector(".collapse [data-original-title='Coupons']");
	By createCoupon = By.cssSelector(".btn-group .coupon-create");

	public CouponPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openCouponPage() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, couponSubMenu);
		click(driver, createCoupon);
	}

	By campaignDropDownList = By
			.xpath("//button[@data-id='create_coupon_campaign_dropdown']//span[contains(text(), 'Select Campaign')]");
	String lenjaCoupon = createNewName("LenjaCouponDiscount");
	By couponName = By.cssSelector("#couponCreate #coupon_name");
	By couponCode = By.cssSelector("#couponCreate #coupon_code");
	public String couponString = createNewName("discount29.99%");
	By couponStartDate = By.xpath(".//div[@id='couponCreate']//input[@id='coupon_start_date']/parent::div/span/span");
	String startDate = "06/12/2018";
	By productDropdown = By.cssSelector("#couponCreate .product_dropdown .btn-default");
	// By productSelectFromDropDown = By
	// .cssSelector("#couponCreate
	// .product_dropdown>div>ul>li[data-original-index='1']>a> .text");
	By productSelectFromDropDown = By.cssSelector("#couponCreate .product_dropdown [class='dropdown-menu inner']");

	By redemption = By.cssSelector("#couponCreate #coupon_max_redemption");
	String redemptionValue = "100";
	By discountPricePercentage = By.cssSelector("#couponCreate #coupon_value");
	String discountPricePercentageValue = "29.99";
	String discountPercentage = "100";
	By couponEndDateClick = By.xpath(".//div[@id='couponCreate']//input[@id='coupon_end_date']/parent::div/span/span");

	By inputStartDate = By.cssSelector("#couponCreate .input-group> #coupon_start_date");
	By couponEndDateType = By.cssSelector("#couponCreate .input-group> #coupon_end_date");
	String couponEndDateString = "05/02/2025";
	By modalFooter = By.cssSelector("#couponCreate .modal-footer");
	By createCouponBtn = By.xpath("//button[contains(text(),'Create')]");

	public void fillUpCouponPage(String campaign, Boolean hundreed) throws InterruptedException {
		By findCampaignInCampaignList = By.xpath(
				"//div[@class ='btn-group bootstrap-select form-control open']//div//ul//li//span[@class='text'][contains(text(), '"
						+ campaign + "')]");

		click(driver, campaignDropDownList);
		findSuccessElementByStringAndClick(driver, findCampaignInCampaignList, campaign, findCampaignInCampaignList);
		type(driver, couponName, lenjaCoupon);
		type(driver, couponCode, couponString);
		// click(driver, couponStartDate);
		type(driver, inputStartDate, startDate);
		click(driver, productDropdown);
		click(driver, productSelectFromDropDown);
		click(driver, productDropdown);
		type(driver, redemption, redemptionValue);
		if (hundreed) {

			type(driver, discountPricePercentage, discountPercentage);
		} else {

			type(driver, discountPricePercentage, discountPricePercentageValue);
		}

		type(driver, couponEndDateType, couponEndDateString);
		click(driver, couponEndDateType);
		click(driver, createCouponBtn);

	}

	public void fillUpCouponPage(String campaign) throws InterruptedException {
		fillUpCouponPage(campaign, false);
	}

	public void fillUpCouponHundreedPercent(String campaign) throws InterruptedException {
		fillUpCouponPage(campaign, true);
	}

	public String couponDiscount;

	public String checkIsCouponCreated() throws InterruptedException {
		String couponName = "//a[contains(text(), '";
		String couponFullName1 = couponName + couponString + "')]";
		By findCampaignInCampaignList = By.xpath(couponFullName1);
		couponDiscount = findStringOnPage(driver, findCampaignInCampaignList, couponString);
		System.out.println("couponDiscount:  " + couponDiscount);
		return couponDiscount;

	}

	String coupDisc = "30";
	public double coupDiscInt = Integer.parseInt(coupDisc);
	By amountBy = By.xpath("//td[@class='trans_amount'][contains(text(), '')]");
	By detailsIcon = By.cssSelector("i[data-original-title='Details']");

	public void checkTransactionWithCouponIsSucessfull(String campaign, String expectedAmount)
			throws InterruptedException {

		String name1 = "//h5[@class='campaign-title'][contains(text(), '";
		String campaignFullName1 = name1 + campaign + "')]";
		By findCampaignInTransactionList1 = By.xpath(campaignFullName1);
		refreshPage(driver, detailsIcon);
		findSuccessElementByStringAndClick(driver, findCampaignInTransactionList1, campaign, detailsIcon);
		String actualAmount = driver.findElement(amountBy).getText().substring(1, 5);
		double num = Double.parseDouble(actualAmount);
		System.out.println("num : " + num);
		double numFormat = Double.parseDouble(String.format("%.1f", num));
		String actualAmFinal = String.valueOf(numFormat);
		System.out.println("Actual Amount : " + actualAmFinal);
		assertEquals(actualAmFinal, expectedAmount);
	}

	By deleteCouponIcon = By.xpath("//a[@class='coupon-delete']");
	By deleteCouponButton = By.cssSelector(".delete_coupon_modal");

	public void deleteCoupon() throws InterruptedException {
		click(this.driver, campaignMainMenu);
		click(this.driver, couponSubMenu);
		try {
			do {
				click(driver, deleteCouponIcon);
				click(driver, deleteCouponButton);

			} while (driver.findElements(deleteCouponIcon).size() != 0);

		} catch (NoSuchElementException e) {

		}
		try {

			Boolean elem = driver.findElements(deleteCouponIcon).size() != 0;
			assertFalse(elem);
			System.out.println("elem :" + elem);
		} catch (Exception e) {

		}

	}

}
