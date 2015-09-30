package com.example.fw;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase{

	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}
	
    private SortedListOf<ContactData> cachedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
	    return cachedContacts;
	}
	
	private void rebuildCache() {
		SortedListOf<ContactData> cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().groupsPage();
	    List<WebElement> checkboxes =  driver.findElements(By.name("entry"));

	       for (WebElement checkbox : checkboxes){
	          List<WebElement> columns =checkbox.findElements(By.tagName("td"));
	           ContactData contact = new ContactData();
	           contact.email=columns.get(3).getText();
	           cachedContacts.add(contact);
	       }
	}

	public ContactHelper createContact(ContactData contact) {
		initContactCreation();	
		fillContactForm(contact, CREATION);
		submitContactCreation();
		returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact, ContactHelper.MODIFICATION);
		submitContactModification();
	    returnToHomePage();
	    rebuildCache();
	    return this;
	}
	
	public ContactHelper deleteContact(int index, ContactData contact) {
		deleteContact(index);
	    returnToHomePage();
	    rebuildCache();
        return this;
	}
	//---------------------------------------------------------------------------------------------------------
	
	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact, boolean formType) {
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
		if (formType == CREATION) {
            //	    selectByText(By.name("new group"),"group 1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exist in contact modification form");
			}
		}
	}
	
	public void returnToHomePage() {
		click(By.linkText("home page"));
	}
	
	private void selectContactByIndex(int index) {
		click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]/td/a/img[@title='Edit']"));
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
