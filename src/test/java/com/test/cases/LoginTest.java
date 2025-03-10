package com.test.cases;

import org.testng.annotations.Test;

import com.test.base.BaseTest;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseTest {
  @Test
  

  public void logintest(){	
	  System.out.println("-------------Login with Valid Password--------------");
	  driver.findElement(By.id("username")).sendKeys("student");
	  driver.findElement(By.id("password")).sendKeys("Password123");
	  driver.findElement(By.id("submit")).click();
	  WebElement e1 =driver.findElement(By.xpath("//strong[text()='Congratulations student. You successfully logged in!']"));
	  e1.getText();
	  System.out.println(e1.getText());
	  driver.findElement(By.xpath("//a[text()= 'Log out']")).click();
	  }
  }



