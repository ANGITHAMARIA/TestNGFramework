package com.obsqura.TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButton extends Base{
	
	@Test
	public void radioButton()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleRadioButton.click();
		
	}

}
