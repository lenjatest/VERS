package com.paykickstart.test;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import com.paykickstart.common.WebDriverUtility;

public class KillallChromeDriverInstances extends WebDriverUtility {

	String successPage = new String("PayKickstart");

	@Test(priority = 1)
	public void killAllChromeDrivers() throws MalformedURLException, InterruptedException {
		try {

			killChromeDriverProcess();
		} catch (IOException e) {
			System.out.println("No running chromedriver instances found");
			e.printStackTrace();
		}

	}

}
