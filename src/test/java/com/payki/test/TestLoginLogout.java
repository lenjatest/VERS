package com.paykickstart.test;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.items.User;
import com.paykickstart.pages.StartPage;

public class TestLoginLogout extends WebDriverUtility {

	String loginToPkPage = new String("Login to PayKickstart");

	User affiliate = new User("testPay@mailinator.com", "XXXXXXXXXXXxx");
	User admin = new User("administrators@digitalkickstart.com", "XXXXXXXXXx");
	User lenjaVendor = new User("lenjatest@gmail.com", "XXXXXXXXXXx");
	User hugo = new User("hugo@test.com", "XXXXXXXXXXxx");
	User devsPk = new User("devs@paykickstart.com", "XXXXXXXXXXXXx");

	@BeforeMethod
	private void login() throws MalformedURLException {
		start();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { affiliate }, { admin }, { lenjaVendor } };
	}

	@Test(dataProvider = "getData")
	public void verifyLoginLogout(User user) throws InterruptedException {
		StartPage startPage = new StartPage(driver);
		startPage.loginUser(user);
		System.out.println("Before login : " + driver.getTitle());
		startPage.logOut();
		System.out.println("After logout : " + driver.getTitle());
		compareTitle(driver, loginToPkPage);
		driver.quit();
	}
}
