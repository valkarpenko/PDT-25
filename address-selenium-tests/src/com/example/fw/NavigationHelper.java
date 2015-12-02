package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase{

	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if (! onMainPage()) {
          click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (driver.getCurrentUrl().contains("/groups.php") && driver.findElements(By.name("new")).size() > 0);
	}

	public void groupsPage() {
		if (! onGroupsPage()) {
		  click(By.linkText("groups"));
		}
	}

	private boolean onGroupsPage() {
		if (driver.getCurrentUrl().contains("/groups.php")
			&& driver.findElements(By.name("new")).size() > 0) {
			return true;
		} else {

		return false;
	}
  }
	
	public void Page() {
		if (! onGroupsPage()) {
		  click(By.linkText("groups"));
		}
	}
	
}
