package com.w2a.architectbatch1_dee.testutils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory { //use to create browser instance
	
	private static String geckodriverFilePath;
	private static String chromedriverFilePath;
	private static String IEDriverFilePath;
	
	public static void createDriverInstance(String browser)
	{
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckodriverFilePath());
			driver = new FirefoxDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
		}
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckodriverFilePath());
			driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
		}
		
		if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", DriverFactory.getIEDriverFilePath());
			driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.maximizeBrowser(DriverManager.getDriver());
		}
	}

	public static String getGeckodriverFilePath() {
		return geckodriverFilePath;
	}

	public static void setGeckodriverFilePath(String geckodriverFilePath) {
		DriverFactory.geckodriverFilePath = geckodriverFilePath;
	}

	public static String getChromedriverFilePath() {
		return chromedriverFilePath;
	}

	public static void setChromedriverFilePath(String chromedriverFilePath) {
		DriverFactory.chromedriverFilePath = chromedriverFilePath;
	}

	public static String getIEDriverFilePath() {
		return IEDriverFilePath;
	}

	public static void setIEDriverFilePath(String iEDriverFilePath) {
		IEDriverFilePath = iEDriverFilePath;
	}

}
