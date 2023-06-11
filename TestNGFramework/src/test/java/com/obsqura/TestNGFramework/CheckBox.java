package com.obsqura.TestNGFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBox extends Base {
	
	@BeforeMethod
	public void toNavigateToCheckBoxDemoPage()
	{
		Menu menu=new Menu();
		menu.toSelectMenuOptions("Checkbox Demo",driver);
	}
	
	@Test
	public void checkBox()
	{
		
		WebElement singleCheckBox=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		singleCheckBox.click();
		boolean checkBoxIsSelected=singleCheckBox.isSelected();
	}
	
	@Test
	public void verifyWhetherFirstAndSecondOptionsInMultipleCheckBoxIsSelectedOnSelectingCheckBox()
	{
		
		
		WebElement checkBoxOne=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(checkBoxOne));
		checkBoxOne.click();
		WebElement checkBoxTwo=driver.findElement(By.xpath("//input[@id='check-box-two']"));
		wait.until(ExpectedConditions.elementToBeClickable(checkBoxTwo));
		checkBoxTwo.click();
		boolean checkBoxOneIsSelected=checkBoxOne.isSelected();
		boolean checkBoxTwoIsSelected=checkBoxTwo.isSelected();
		assertTrue(checkBoxOneIsSelected,"CheckBox One is not selected");
		assertTrue(checkBoxTwoIsSelected,"CheckBox Two is not selected");
		
	}
	
	@Test
	public void verifyWhetherAllOptionsAreCheckedAfterClickingSelectAllButton()
	{
		
	//	String expectedselectAllButtonValue="Unselect All";
		WebElement selectAllButton=driver.findElement(By.xpath("//input[@id='button-two']"));
		selectAllButton.click();
//		String selectAllButtonValue=selectAllButton.getText();
//		assertEquals(expectedselectAllButtonValue,selectAllButtonValue,"All Options are not selected");
		WebElement checkBoxOne=driver.findElement(By.xpath("//input[@id='check-box-one']"));
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(checkBoxOne));
		WebElement checkBoxTwo=driver.findElement(By.xpath("//input[@id='check-box-two']"));
		WebElement checkBoxThree=driver.findElement(By.xpath("//input[@id='check-box-three']"));
		WebElement checkBoxFour=driver.findElement(By.xpath("//input[@id='check-box-four']"));
		boolean checkBoxOneIsSelected=checkBoxOne.isSelected();
		boolean checkBoxTwoIsSelected=checkBoxTwo.isSelected();
		boolean checkBoxThreeIsSelected=checkBoxThree.isSelected();
		boolean checkBoxFourIsSelected=checkBoxFour.isSelected();
		assertTrue(checkBoxOneIsSelected,"CheckBox One is not selected");
		assertTrue(checkBoxTwoIsSelected,"CheckBox Two is not selected");
		assertTrue(checkBoxThreeIsSelected,"CheckBox Three is not selected");
		assertTrue(checkBoxFourIsSelected,"CheckBox Four is not selected");
	}
	

	
}
