package com.cosmic.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver
{
public static WebDriver getBrowserInstance()
{
	WebDriver driver = null; 
	String browser = 
				DataHandlers.getDataFromProperties("configuration", "browser").toLowerCase();
	String url = 
			DataHandlers.getDataFromProperties("configuration", "url").toLowerCase();

	if(browser.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	else if(browser.equals("firefox"))
	{
		System.setProperty("webdriver.chrome.driver", "./browser-servers/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	else if(browser.equals("ie"))
	{
		System.setProperty("webdriver.chrome.driver", "./browser-servers/iedriver.exe");
		driver = new InternetExplorerDriver();
	}
	
	else
	{
		System.err.print
		("!!!!!Invalid browser option.Please check Configuration.properties file!!!!");
		return driver;
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	if (url.equals("prod"))
	{
		driver.get("https://demo.actitime.com/login.do");
	}
	else
	{
		driver.get("http://localhost");
	}
	return driver; 
}
	
}
