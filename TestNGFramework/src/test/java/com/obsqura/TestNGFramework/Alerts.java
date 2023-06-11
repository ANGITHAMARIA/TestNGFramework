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
import org.testng.annotations.Test;

public class Alerts extends Base{
	
	@Test
	public void simpleAlert()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickMeButton=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickMeButton.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();	
	}
	
	@Test
	public void toClickCancelOnConfirmationAlert()
	{
		String expectedMessage="You pressed Cancel!";
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickMeButton=driver.findElement(By.xpath("//button[@class='btn btn-warning']"));
		clickMeButton.click();
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(20))
		        .pollingEvery(Duration.ofSeconds(5))
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		WebElement messageAfterButtonClick=driver.findElement(By.xpath("//p[@id='confirm-demo']"));
		String messageValueAfterButtonClick=messageAfterButtonClick.getText();
		assertEquals(expectedMessage,messageValueAfterButtonClick,"Cancel Button is not clicked as expected");
	}
	
	@Test
	public void toEnterNameInPromptAlert()
	{
		String input="Angitha";
		String expectedMessage="You have entered '"+input+"' !";
		System.out.println(expectedMessage);
		driver.navigate().to("https://selenium.obsqurazone.com/javascript-alert.php");
		WebElement clickMeButton=driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		clickMeButton.click();
		driver.switchTo().alert().sendKeys(input);
		driver.switchTo().alert().accept();
		WebElement messageAfterButtonClick=driver.findElement(By.xpath("//p[@id='prompt-demo']"));
		String messageValueAfterButtonClick=messageAfterButtonClick.getText();
		System.out.println(messageValueAfterButtonClick);
		assertEquals(expectedMessage,messageValueAfterButtonClick,"Entered input is not showing in message");
	}

}
