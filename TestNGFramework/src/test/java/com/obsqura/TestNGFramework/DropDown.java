package com.obsqura.TestNGFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DropDown extends Base {

	@Test
	public void dropDownSample()
	{
//		Menu menu=new Menu();
//		menu.toSelectMenuOptions("Select Input", driver);
		driver.navigate().to("https://selenium.obsqurazone.com/select-input.php");
		WebElement colourDropDown=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select=new Select(colourDropDown);
		select.selectByIndex(1);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementSelectionStateToBe(colourDropDown,true));
	//	select.selectByValue("Yellow");
	//	select.selectByVisibleText("Green");
		List <WebElement> options=select.getOptions();
	}
	
	@Test
	public void toChangeLanguageInSeleniumDevPage()
	{
		String preferedLanguage="Português (Brasileiro)";
		driver.navigate().to("https://www.selenium.dev/");
		WebElement languageDropDownButton=driver.findElement(By.xpath("//li[@class='nav-item dropdown d-none d-lg-block']"));
		languageDropDownButton.click();
		List <WebElement> options=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//child::a"));
		for(WebElement languageOptions:options)
		{
			String language=languageOptions.getText();
			if(language.equals(preferedLanguage))
			{
				languageOptions.click();
			}
		}
	}
}
