package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTests extends TestBase{
	@Test
	public void deletesomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(1);
	    app.getGroupHelper().returnToGroupsPage();

	}

}
