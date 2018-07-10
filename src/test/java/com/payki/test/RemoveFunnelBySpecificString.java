package com.paykickstart.test;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;
import com.paykickstart.pages.FunnelPage;
import com.paykickstart.pages.StartPage;

public class RemoveFunnelBySpecificString extends WebDriverUtility {

	String successPage = new String("PayKickstart");

	@Test(invocationCount = 1)
	public void verifyRemoveFunnelBySpecificString() throws MalformedURLException, InterruptedException {
		start();

		StartPage log = new StartPage(driver);
		log.login();
		FunnelPage funnelPage = new FunnelPage(driver);
		funnelPage.removeFunnelsBySpecificString();
		driver.quit();
	}

}
