package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreation extends TestBase{

  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
	gotoContactPage();
    fillContactForm(new ContactData("Filippov", "Pavel", "SPb", "5656666", "79115856699", "8888888", "filippov@ya.ru", "filippov2@ya.ru", "21", "February", "1985", "Saint-Petersburg", "Moscow", "9999999"));
    submitContactCreation();
  }



}
