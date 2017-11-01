package com.w2a.architectbatch1_dee.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().to("http://way2automation.com/");
		driver.findElement(By.linkText("Member Login")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		
	}

}
