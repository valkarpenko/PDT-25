package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;


public class TestBase {
    protected static ApplicationManager app;
    
	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	  }

	@DataProvider	
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 4; i++) {
			ContactData contact = new ContactData()
			  .withFirstname(generateRandomString())
			  .withLastname(generateRandomString())
			  .withAddress(generateRandomString())
			  .withHome(generateRandomString())
		      .withMobile(generateRandomString())
		      .withWork(generateRandomString())
		      .withEmail(generateRandomString())
		      .withEmail2(generateRandomString())
		      .withBday(generateRandomString())
		      .withBmonth(generateRandomString())
		      .withByear(generateRandomString())
		      .withAddress1(generateRandomString())
		      .withAddress2(generateRandomString())
		      .withPhone2(generateRandomString());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}
	
	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
			
	    }
    }
	public String generateRandomPhone() {
		Random rnd = new Random();
		String randomNumbers = RandomStringUtils.randomNumeric(9);
		String phone = 79+randomNumbers;
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return phone;
			
	    }
    }
	
	
	public String generateRandomFirstName() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0) {
			return "";
		} else {
			return "Evgeniy" + rnd.nextInt();
			
	    }
    }
	
	public String generateRandomLastName() {
		Random rnd = new Random();
		if (rnd.nextInt(2) == 0) {
			return "";
		} else {
			return "Petrosyan" + rnd.nextInt();
			
	    }
    }
	
	public String generateRandomEmail() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt() + "@test.ru";
			
	    }
    }
		
	public String generateRandomDay(){
        Random rd = new Random();	     
        int randomDay = 1 + rd.nextInt(30);
        String strDay = Integer.toString(randomDay);
        if(rd.nextInt(3) == 0) {
            return  "-";
        } else {
            return strDay;
        }
    }
	
    public String generateRandomMonth() {
        Random rd = new Random();
        String[] month = new String[]{ "January", "February", "March", "April", "May", "June", "July", "August","September", "November", "October", "December"};
        if (rd.nextInt(3) == 0) {
            return "-";
        } else {
            return month[rd.nextInt(month.length)];
        }
    }
    
    public String generateRandomYear() {
        Random rd = new Random();
        int randomYear = 1915 + rd.nextInt(100);
        String strYear = Integer.toString(randomYear);
        if (rd.nextInt(3) == 0) {
            return "-";
        } else {
            return strYear;
        }
    }
	
	@DataProvider	
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group : groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	

}
