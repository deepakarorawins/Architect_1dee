package com.w2a.architectbatch1_dee.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.architectbatch1_dee.basesetup.TestSetup;
import com.w2a.architectbatch1_dee.testutils.PropertyFileManager;

public class TestCase1 extends TestSetup {

	@Test
	public void tc_01() {
		System.out.println("tc_01");
		driver.get(configProperty.getProperty("application.url.w2a"));
		driver.findElement(By.linkText("MEMBER LOGIN")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void tc_03() {
		System.out.println("tc_02");
		driver.get("http://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("uit");
		driver.findElement(By.name("pass")).sendKeys("iut");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
