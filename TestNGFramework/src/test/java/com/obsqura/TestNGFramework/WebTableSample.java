package com.obsqura.TestNGFramework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableSample extends Base{
	
	@BeforeMethod
	public void navigateToTablePaginationPage()
	{
		driver.navigate().to("https://selenium.obsqurazone.com/table-pagination.php");
	}

	@Test
	public void toGetHeaderValuesInWebTable()
	{
		List <WebElement> tableHeaders=driver.findElements(By.xpath("//th[@class='th-sm sorting_disabled']"));
		List <String> headerValuesList=new ArrayList<String>();	
		for(WebElement header:tableHeaders)
		{
			String headerValue=header.getText();
			headerValuesList.add(headerValue);
		}
		//System.out.println(headerValuesList);
	}
	
	@Test
	public void toFindNumberOfRowsInWebTable()
	{
		List<WebElement> rows=driver.findElements(By.xpath("//tr[@class='odd' or @class='even']"));
		int rowCount=rows.size();
	}
	
	@Test
	public void toFindNumberOfColumnsInWebTable()
	{
		List <WebElement> columns=driver.findElements(By.xpath("(//tr[@class='odd'])[1]//child::td"));
		int columnCount=columns.size();
	}
	
	@Test
	public void toFindANameInWebTable()
	{
		int count=0;
		String expectedName="Ashton Cox";
		boolean flag = false;
		List <WebElement> namesInTable=driver.findElements(By.xpath("//tr[@class='odd' or @class='even']//child::td[1]"));
		for(WebElement name:namesInTable)
		{
			count=count+1;
			String nameValue=name.getText();
			if(expectedName.equals(nameValue))
			{
				System.out.println("Expected name:'"+expectedName+"' found in row no:"+count);
				flag=true;
				break;
			}
		}
		if(flag==false)
		{
			System.out.println("Expected name:'"+expectedName+"' not found in table");
		}
	}
	
	
}
