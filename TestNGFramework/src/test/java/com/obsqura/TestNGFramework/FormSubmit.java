package com.obsqura.TestNGFramework;

import org.testng.annotations.Test;

public class FormSubmit extends Base{

	@Test
	public void formSubmitSample()
	{
		Menu menu=new Menu();
		menu.toSelectMenuOptions("Form Submit", driver);
	}
}
