package com.example.fw;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class HelperBase {

	protected ApplicationManager manager;
	public boolean acceptNextAlert = true;
	protected WebDriver driver;

	protected HelperBase (ApplicationManager manager) {
		this.manager = manager;
		this.driver = manager.driver;

		
	}
	protected boolean isElementPresent(By by) {
	    try {
	    manager.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	protected String closeAlertAndGetItsText() {
	    try {
	      Alert alert = manager.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	protected void type(By locator, String text) {
		if (text != null) {
		  driver.findElement(locator).clear();
	  	  driver.findElement(locator).sendKeys(text);
		}
	}
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text != null) {
		new Select(driver.findElement(locator)).selectByVisibleText(text);
		}
	}

}
