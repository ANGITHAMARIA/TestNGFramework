package com.obsqura.TestNGFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Menu {
	
	
	public void toSelectMenuOptions(String requestedMenu,WebDriver driver)
	{
		List <WebElement> menuOptions=driver.findElements(By.xpath("//li[@class='list-group-item']"));
		for(WebElement options:menuOptions)
		{
			String selectOptions=options.getText();
			if(selectOptions.equals(requestedMenu))
					{
						options.click();
						break;
					}
		}
	
	}

}
