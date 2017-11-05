package com.w2a.architectbatch1_dee.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tc_01 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.gotomeeting.com");
		WebElement firstName=driver.findElement(By.xpath("//input[@name='firstName']"));
		firstName.sendKeys("Rahul");
		//adding a test comment
		//adding a test comment2
		//adding a test comment3
		//adding a test comment3

	}

}
