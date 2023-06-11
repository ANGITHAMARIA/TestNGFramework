package com.obsqura.TestNGFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class Asserts extends Base {

	@Test
	public void assertEqualsSample()
	{
		String input="Hello";
		String expectedYourMessageTxtValue="Your Message : "+input;
		WebElement singleinputtextfield=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		singleinputtextfield.sendKeys(input);
		WebElement showmessagebtn=driver.findElement(By.xpath("//button[@id='button-one']"));
		showmessagebtn.click();
		WebElement yourmessagetxt=driver.findElement(By.xpath("//div[@id='message-one']"));
		String yourMessageTxtValue= yourmessagetxt.getText();
		assertEquals(expectedYourMessageTxtValue,yourMessageTxtValue,"Message generated is not same after entering text on single input field");
	}
	
	@Test
	public void assertNotEqualsSample()
	{
		String expectedValue="123";
		String actualValue="345";
		assertNotEquals(expectedValue,actualValue,"Expected and actuals values are same");
	}
	
	@Test
	public void assertTrueSample()
	{
		WebElement singleinputtextfield=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		boolean singleinputtextfieldIsDisplayed=singleinputtextfield.isDisplayed();
		assertTrue(singleinputtextfieldIsDisplayed,"Single Input Field is not displayed");
	}
	@Test
	public void verifyTheBackGroundColorOfShowMessageButton()
	{
		String expectedShowMessageButtonBackgroundColorHexValue="#007bff";
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		String showMessageButtonBackgroundColor=showMessageButton.getCssValue("background-color");		
		String showMessageButtonBackgroundColorHexValue=Color.fromString(showMessageButtonBackgroundColor).asHex();
		assertEquals(expectedShowMessageButtonBackgroundColorHexValue,showMessageButtonBackgroundColorHexValue,"Show Message Button background color is not matching with the expected design");
	}
	
	@Test
	public void verifyTheWidthOfShowMessageButton()
	{
		int expectedShowMessageButtonWidth=136;
		WebElement showMessageButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		Dimension showMessageButtonSize = showMessageButton.getSize();
		int showMessageButtonWidth = showMessageButtonSize.getWidth();
		assertEquals(expectedShowMessageButtonWidth,showMessageButtonWidth,"Width of Show Message button is not matching with the expected design");
	}
	
	@Test
	public void verifyWhetherTheGetTotalButtonIsDisplayed()
	{
		WebElement getTotalButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		boolean getTotalButtonIsDisplayed=getTotalButton.isDisplayed();
		assertTrue(getTotalButtonIsDisplayed,"Get Total is not displayed as expected");
	}
	
	@Test
	public void assertFalseSample()
	{
		boolean flag=false;
		assertFalse(flag,"Flag is true");
	}
	
	@Test
	public void assertNullSample()
	{
		String value=null;
		assertNull(value,"Value is not null");
	}
	
	@Test
	public void assertNotNullSample()
	{
		String value="test";
		assertNotNull(value,"Value is null");
	}
	
}
