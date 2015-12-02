package com.example.tests;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;
import com.example.tests.GroupDataGenerator;

public class GroupCreationTests extends TestBase{
	
	@DataProvider	
	public Iterator<Object[]> groupsFromFile() throws Exception{
		return wrapGroupsForDataProvider(GroupDataGenerator.loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
	}

@Test(dataProvider = "groupsFromFile")
  public void testGroupCreationwithValidData(GroupData group) throws Exception {
	// save old state
	 SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	
	//actions	
    app.getGroupHelper().createGroup(group);

  //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();

  //compare states	
    assertThat(newList, equalTo(oldList.withAdded(group)));

  }	
}
