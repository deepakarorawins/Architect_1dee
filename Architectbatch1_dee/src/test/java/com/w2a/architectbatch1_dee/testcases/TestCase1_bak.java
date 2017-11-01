package com.w2a.architectbatch1_dee.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.w2a.architectbatch1_dee.pages.LandingPage;

public class TestCase1_bak {
	
	@Test
	public void tc_01()
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.gotomeeting.com");
		PageFactory.initElements(driver, LandingPage.class);
		
		LandingPage.firstName.sendKeys("fName");
		LandingPage.lastName.sendKeys("lName");
	}

}
