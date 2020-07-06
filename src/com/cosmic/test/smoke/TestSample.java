package com.cosmic.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cosmic.lib.utils.CreateDriver;



public class TestSample 
{
WebDriver driver;

@BeforeMethod
public void preCondition()
{
	driver = CreateDriver.getBrowserInstance();
}
@AfterMethod
public void postCondition()
{
	driver.close();
}
@Test
public void testSample()
{
	String actualTitle = driver.getTitle();
	String expectedTitle = "actiTIME - Login";
	Assert.assertEquals(actualTitle, expectedTitle);
}
}
