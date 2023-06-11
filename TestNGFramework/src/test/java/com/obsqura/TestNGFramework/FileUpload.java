package com.obsqura.TestNGFramework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload extends Base{

	@Test
	public void pdfUploadUsingAutoIt() throws IOException
	{
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement selectPdfFileButton=driver.findElement(By.xpath("//a[@class='uploader__btn tooltip--left active']"));
		selectPdfFileButton.click();
		Runtime.getRuntime().exec("C:\\Users\\angit\\OneDrive\\Documents\\File Upload.exe");
		
	}
	
	@Test
	public void fileUploadUsingSendKeys()
	{
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement selectFileButton=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
		selectFileButton.sendKeys("C:\\Users\\angit\\Downloads\\Desktop\\visa extension docs\\1005_IMM5710ApplicationforWPExtension_06_2018_.pdf");
		
	}
}
