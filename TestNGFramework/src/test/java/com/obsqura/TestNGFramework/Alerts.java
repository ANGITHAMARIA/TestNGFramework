package com.obsqura.TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Alerts extends Base{
	
	@Test
	public void simpleAlert()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickMeButton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickMeButton.click();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();	
	}

}
