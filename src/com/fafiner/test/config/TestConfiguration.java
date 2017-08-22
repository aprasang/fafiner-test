package com.fafiner.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fafiner.utils.GetData;

public class TestConfiguration 
{
	public static WebDriver createDriverInstance()
	{
		WebDriver driver = null;
		String browser = GetData.fromProperties("configuration", "browser");
		String url = GetData.fromProperties("configuration", "url");
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.marionette",
					"./browser-drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"./browser-drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			System.err.print("Invalid browser option");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}



