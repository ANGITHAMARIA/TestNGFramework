package com.obsqura.TestNGFramework;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class JavaScriptExecutorSample extends Base {

@Test
public void javaScriptExecutorSample()
{
	String input="Hello";
	String expectedYourMessageTxtValue="Your Message : "+input;
	WebElement singleinputtextfield=driver.findElement(By.xpath("//input[@id='single-input-field']"));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("arguments[0].value='Hello';", singleinputtextfield);
	
	WebElement showmessagebtn=driver.findElement(By.xpath("//button[@id='button-one']"));
	
	js.executeScript("arguments[0].click();", showmessagebtn);
	WebElement yourmessagetxt=driver.findElement(By.xpath("//div[@id='message-one']"));
	String yourMessageTxtValue= yourmessagetxt.getText();
	assertEquals(expectedYourMessageTxtValue,yourMessageTxtValue,"Message generated is not same after entering text on single input field");
}
}
