package com.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.BaseTest;

public class Loginwithinvalidusername extends BaseTest{

	
	 @Test
	  

	  public void logininvalidusername()  {
		    
		    System.out.println("-------------Login with  invalid username invalid Password--------------");
		    driver.findElement(By.id("username")).sendKeys("Student");
		    driver.findElement(By.id("password")).sendKeys("Password123");
		    driver.findElement(By.id("submit")).click();
		    WebElement e4 =driver.findElement(By.id("error"));
		    String s4= e4.getText();
		    System.out.println(s4);
		    }

	}


