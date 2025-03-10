package com.test.base;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {

  public static	ChromeDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	  
	  
			
		  System.setProperty("webdriver.chrome.driver",
		  "C:\\Users\\SRI\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();  
		   driver.get("https://practicetestautomation.com/practice-test-login/"); 
		  

  }

  @AfterMethod
  public void afterMethod() {
	  

	  
	  driver.quit();
	  
	  
  }
}




 
