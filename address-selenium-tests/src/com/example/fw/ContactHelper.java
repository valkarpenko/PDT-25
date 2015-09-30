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
	           String email=columns.get(3).getText();
	           cachedContacts.add(new ContactData().withEmail(email));
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
		fillContactForm(contact, MODIFICATION);
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
		type(By.name("firstname"),contact.getFirstname());
		type(By.name("lastname"),contact.getLastname());
		type(By.name("address"),contact.getAddress());
		type(By.name("home"),contact.getHome());
		type(By.name("mobile"),contact.getMobile());
		type(By.name("work"),contact.getWork());
		type(By.name("email"),contact.getEmail());
		type(By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"),contact.getBday());
	    selectByText(By.name("bmonth"),contact.getBmonth());
		type(By.name("byear"),contact.getByear());
		if (formType == CREATION) {
            //	    selectByText(By.name("new group"),"group 1");
		} else {
			if (driver.findElements(By.name("new_group")).size() != 0) {
				throw new Error("Group selector exist in contact modification form");
			}
		}
	}
	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}
	
	private ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//tr[@name='entry'][" + (index + 1) + "]/td/a/img[@title='Edit']"));
		return this;
	}
	
   public ContactHelper deleteContact(int index) {
		selectContactByIndex(index);
		click(By.xpath("//input[@name='update'][@value='Delete']"));
		return this;
	}
	
	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper initContactModification(int index) {
		selectContactByIndex(index);
		return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@name='update'][@value='Update']"));
		return this;
	}

}
