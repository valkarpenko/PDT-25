package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests  extends TestBase{
	@Test
	public void deletesomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().deleteContact(1);
	    app.getContactHelper().returnToHomePage();

	}
	
}