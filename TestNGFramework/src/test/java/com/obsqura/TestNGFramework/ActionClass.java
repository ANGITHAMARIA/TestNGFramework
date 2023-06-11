package com.obsqura.TestNGFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionClass extends Base {

	
@Test
public void dragAndDropUsingActionsClass()
{
	Actions action = new Actions(driver);
	driver.navigate().to("https://selenium.obsqurazone.com/drag-drop.php");
	WebElement draggableItem1=driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
	action.moveToElement(draggableItem1).build().perform();
	action.doubleClick(draggableItem1).perform();
	action.contextClick(draggableItem1).perform();
	WebElement destinationElement=driver.findElement(By.xpath("//div[@id='mydropzone']"));
	action.dragAndDrop(draggableItem1, destinationElement);
}
}
