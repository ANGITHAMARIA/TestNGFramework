package com.obsqura.TestNGFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Iframe extends Base {

	@Test
	public void iframeSample()
	{
		driver.navigate().to("https://demo.guru99.com/test/guru99home/");
		driver.switchTo().frame("a077aa5e");
		WebElement iFrame=driver.findElement(By.xpath("//a[@href='https://www.guru99.com/live-selenium-project.html']"));
		iFrame.click();
		driver.switchTo().defaultContent();
	}
	
}
