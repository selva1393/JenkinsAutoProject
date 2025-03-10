package com.test.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.BaseTest;

public class Loginwithinvalidpassword extends BaseTest {


	 @Test
	  

	  public void logininvalidpassword()  {
		    
		    System.out.println("-------------Login with  invalid username invalid Password--------------");
		    driver.findElement(By.id("username")).sendKeys("student");
		    driver.findElement(By.id("password")).sendKeys("Password12345");
		    driver.findElement(By.id("submit")).click();
		    WebElement e4 =driver.findElement(By.id("error"));
		    String s4= e4.getText();
		    System.out.println(s4);
		    }

	}

	


