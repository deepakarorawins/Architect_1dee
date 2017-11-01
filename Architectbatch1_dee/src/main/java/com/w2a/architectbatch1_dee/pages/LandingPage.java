package com.w2a.architectbatch1_dee.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	@FindBy(xpath="//input[@name='firstName']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	public static WebElement lastName;
	
	public void doLoginWithValidDetails()
	{
		lastName.sendKeys("");
		
	}
	
	public void doLoginWithInValidDetails()
	{
		
	}
	public void doLoginWithoutuserName()
	{
		
	}

}
