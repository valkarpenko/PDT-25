package com.example.tests;

import org.testng.annotations.Test;

public class AlsoGroupCreation extends TestBase{

  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openManePage();
	gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData("group 1", "header 1", "footer 1");
	group.name = "group name 1";
    group.header = "header 1";
	group.footer = "footer 1";			
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }
  
  @Test
  public void testEmptyGroupCreation() throws Exception {
	openManePage();
	gotoGroupsPage();
    initGroupCreation();
    fillGroupForm(new GroupData("", "", ""));
    submitGroupCreation();
    returnToGroupsPage();
  }

}
