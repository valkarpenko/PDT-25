package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test
	public void modifysomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(2);
		ContactData contact = new ContactData();
		contact.lastname = "Kotov";
		app.getContactHelper().fillContactForm(contact);
		app.getContactHelper().submitContactModification();
	    app.getContactHelper().returnToHomePage();
	}

}
