package com.obsqura.TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBox extends Base {
	
	@Test
	public void checkBox()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement singleCheckBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		singleCheckBox.click();
		boolean checkBoxIsSelected=singleCheckBox.isSelected();
	}

	
}
