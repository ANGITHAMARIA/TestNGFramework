package com.obsqura.TestNGFramework;

import static org.testng.Assert.assertEquals;

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

public class RadioButton extends Base{
	
	@BeforeMethod
	public void toNavigateToRadioButtonDemoPage()
	{
		Menu menu=new Menu();
		menu.toSelectMenuOptions("Radio Buttons Demo", driver);
	}
	
	@Test
	public void radioButton()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/radio-button-demo.php");
		WebElement femaleRadioButton=driver.findElement(By.xpath("//input[@id='inlineRadio2']"));
		femaleRadioButton.click();
		
	}

	@Test
	public void verifyWhetherTheSelectedRadioButtonValueIsDisplayedOnClickingShowSelectedValueButton()
	{
		String expectedDisplayedMessageText="Radio button 'Male' is checked";
		WebElement maleRadioButton=driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		maleRadioButton.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(maleRadioButton));
		WebElement showSelectedValueButton=driver.findElement(By.xpath("//button[@id='button-one']"));
		showSelectedValueButton.click();	
		WebElement displayedMessage=driver.findElement(By.xpath("//div[@id='message-one']"));
		wait.until(ExpectedConditions.textToBePresentInElement(displayedMessage, expectedDisplayedMessageText));
		String displayedMessageText=displayedMessage.getText();
		assertEquals(expectedDisplayedMessageText,displayedMessageText,"Selected Radiobutton value and  displayed value is not matching");
		
	}
	
	@Test
	public void verifyWhetherTheSelectedRadioButtonsValueIsDisplayedOnClickingGetResultsButton()
	{
		String expectedGetResultsButtonValue="Gender : Male \nAge group: 19 to 44";
		WebElement patientGenderRadioButton=driver.findElement(By.xpath("//input[@id='inlineRadio11']"));
		patientGenderRadioButton.click();
		WebElement patientsAgeGroupRadioButton=driver.findElement(By.xpath("//input[@id='inlineRadio23']"));
		patientsAgeGroupRadioButton.click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeSelected(patientsAgeGroupRadioButton));
		WebElement getResultsButton=driver.findElement(By.xpath("//button[@id='button-two']"));
		getResultsButton.click();
	//	fluentWait.until(ExpectedConditions.textToBePresentInElement(getResultsButton, expectedGetResultsButtonValue));
		WebElement getResultsButtonText=driver.findElement(By.xpath("//div[@id='message-two']"));
		String getResultsButtonTextValue= getResultsButtonText.getText();
		assertEquals(expectedGetResultsButtonValue,getResultsButtonTextValue,"Selected Radiobutton values and  displayed values are not matching");
	}
}
