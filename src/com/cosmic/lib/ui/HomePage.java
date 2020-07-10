package com.cosmic.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
WebDriver driver; 
public HomePage(WebDriver driver)
{
	this.driver = driver; 
}
public WebElement getLogoutButton()
{
	try
	{
		return driver.findElement(By.id("logoutLink"));
	}
	catch (Exception e)
	{
		return null;
	}
}
public void waitForHomePageToLoad()
{
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(getLogoutButton()));
}
}
