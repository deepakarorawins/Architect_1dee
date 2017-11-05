package com.w2a.architectbatch1_dee.basesetup;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.w2a.architectbatch1_dee.testutils.DriverFactory;
import com.w2a.architectbatch1_dee.testutils.ExcelReader;
import com.w2a.architectbatch1_dee.testutils.ExtentManager;
import com.w2a.architectbatch1_dee.testutils.PropertyFileManager;

public class TestSetup {
	
	protected static Properties  configProperty; //why protectected and static ?
	public ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\simple.xlsx");
	public static ExtentReports extent; //extent report will be used before suite because there will be one report for the whole suite.
	public static ThreadLocal parentTest = new ThreadLocal();
	public static ThreadLocal test = new ThreadLocal();
	
	protected WebDriver driver;
		
	
	/*@Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
		  System.out.println("dataProvider call");
	  }*/
	  
	  @BeforeMethod
	  public void beforeMethod(Method method) {
		  System.out.println("beforeMethod");
		  System.out.println("Driver-->" + driver);
		  
		  //WebDriver driver = null; //thdi der ke liye ise bahar rakh lete hae taki afterMethod hum is quit kar paye. 
		  //ise local isliye rakha hai taki jo bhi thread ise call karegi ye us ke liye local rahega
		  //static variable class level par shared properties hoti hai hume ise shared nahi rakhna hai.
		  //static property ko read karne me problem nahi hai but agar hum write karna start karenge to problem aayege agar multiple threads ek hi property par write karna start kare dengi.
		  //isliye ise static nahi bana kar local banaya hai kyuki driver write bhi karta hai like sendkeys.To ye har method se pahle new driver banayega, yaha hum har test ke liye browser open kar rahe hai
		  //har test me browser open and close karna chahiye
		  if (driver==null) {
			  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe" );
			  driver = new FirefoxDriver();
			  configProperty=PropertyFileManager.createConfigFileProperty();
		  }
		  
		  ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
		  test.set(child);
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod");
		  driver.quit();
		  driver=null; // this is jugad, we'll not use this
		  extent.flush();
	  }

	 /* @DataProvider
	  public Object[][] dp() {
		  System.out.println("DataProvider");
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }*/
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("beforeClass");
		  ExtentTest parent = extent.createTest(getClass().getName());
		  parentTest.set(parent);
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  System.out.println("afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("beforeTest");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("beforeSuite");
		  PropertyFileManager.setConfigFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\propertyfiles\\config.properties");
		  DriverFactory.setChromedriverFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		  DriverFactory.setGeckodriverFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
		  DriverFactory.setIEDriverFilePath(System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\IEDriverServer.exe");
		  extent = ExtentManager.GetExtent();
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("afterSuite");
	  }

}
