package com.obsqura.TestNGFramework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Base 
	
	{
		public WebDriver driver;
		
		@BeforeMethod
	    public void initializeBrowser()
	    {
	    	System.setProperty("webdriver.chrome.driver","C:\\javanewwork\\TestNGFramework\\src\\test\\resources\\chromedriver.exe" );
	        driver =new ChromeDriver();
	        
	        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	    }
	    public void driverClose()
	    {
	        driver.close();
	    }
	    
	 //   @AfterMethodSe
	    public void driverQuit()
	    {
	        driver.quit();
	    }
	   
	    
	 
	    
	}

	

