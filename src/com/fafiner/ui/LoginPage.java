package com.fafiner.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void waitforLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
		visibilityOfAllElementsLocatedBy(By.name("Facebook- log in or sign up")));
	}
	public WebElement getUsernameTextbox()
	{
		WebElement elenent = 
				driver.findElement(By.name("email"));
		return elenent;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pass"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.xpath("//input[@id='u_0_0']"));
	}  
	public WebElement getErrorMsg()
	{
		return driver.findElement(
				By.xpath("//div[contains(text(),'The email address or phone number')]"));
	}
}
