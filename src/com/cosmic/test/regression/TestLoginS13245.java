package com.cosmic.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cosmic.lib.ui.HomePage;
import com.cosmic.lib.ui.LoginPage;
import com.cosmic.lib.utils.CreateDriver;
import com.cosmic.lib.utils.DataHandlers;

public class TestLoginS13245
{
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	@BeforeMethod
	public void preCondition()
	{
		driver = CreateDriver.getBrowserInstance();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
	@Test
	public void testValidUserLoginTC13467()
	{
		String un = DataHandlers.getDataFromExcel("S13245", "TC13467", 1, 0);
		String pwd = DataHandlers.getDataFromExcel("S13245", "TC13467", 1, 1);
		String expectedTitle = DataHandlers.getDataFromExcel("S13245", "TC13467", 1, 2);
		// Go to Login Page
		loginPage.waitForLoginPageToLoad();
		// Enter valid UN and PWD
		loginPage.getUsernameTextbox().sendKeys(un);
		loginPage.getPasswordTextbox().sendKeys(pwd);
		// Click on Login button
		loginPage.getLoginButton().click();
		// Verify Home Page
		homePage.waitForHomePageToLoad();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		boolean status = homePage.getLogoutButton().isEnabled();
		Assert.assertTrue(status);
		homePage.getLogoutButton().click();
		loginPage.waitForLoginPageToLoad();
	}
}
