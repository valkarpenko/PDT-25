package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.ContactData;

public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
		type(By.name("lastname"),contact.lastname);
		type(By.name("address"),contact.address);
		type(By.name("home"),contact.home);
		type(By.name("mobile"),contact.mobile);
		type(By.name("work"),contact.work);
		type(By.name("email"),contact.email);
		type(By.name("email2"),contact.email2);
	    selectByText(By.name("bday"),contact.bday);
	    selectByText(By.name("bmonth"),contact.bmonth);
		type(By.name("byear"),contact.byear);
//	    selectByText(By.name("new group"),"group 1");
		type(By.name("address2"),contact.address2);
		type(By.name("phone2"),contact.phone2);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	private void selectContactByIndex(int index) {
		click(By.xpath("//tr[@name='entry'][" + index + "]/td/a/img[@title='Edit']"));
			}

   public void deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("//input[@name='update'][@value='Delete']"));
	}
	
	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void initContactModification(int index) {
		selectContactByIndex(index);
	}
	
	public void submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
	}


}
