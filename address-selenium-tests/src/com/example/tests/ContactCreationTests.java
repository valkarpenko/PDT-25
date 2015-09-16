package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData("firstname", "lastname", "address", "home", "mobile", "work", "email", "email2", "bday", "bmonth", "byear", "address1", "address2", "phone2");
    contact.firstname = "Filippov";
    contact.lastname = "Pavel";
    contact.address = "SPb";
    contact.home = "5656666";
    contact.mobile = "79115856699";
    contact.work = "8888888";
    contact.email = "filippov@ya.ru";
    contact.email2 = "filippov2@ya.ru";
    contact.bday = "21";
    contact.bmonth = "February";
    contact.byear = "1985";
    contact.address1 = "Saint-Petersburg";
    contact.address2 = "Moscow";
    contact.phone2 = "9999999";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
	}
  
  @Test
  public void testEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("", "", "", "", "", "", "", "", "-", "-", "-", "", "", ""));
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
	}
  
}
