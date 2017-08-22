package com.fafiner.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fafiner.test.config.TestConfiguration;
import com.fafiner.ui.LoginPage;
import com.fafiner.utils.GetData;

public class TestLoginUS13 {
	WebDriver driver;
	LoginPage login;

	@BeforeMethod
	public void preTest() {
		driver = TestConfiguration.createDriverInstance();
		login = new LoginPage(driver);
	}

	@Test
	public void testLoginErrorTC102() {
		//GetData.fromExcel("test-data", "Sheet1", 1, 1);
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("gadkhfvkha");
		login.getLoginButton().click();
		String actualErrorMsg = login.getErrorMsg().getText();
		String expectedErrorMsg = "The email address or phone number that you've entered doesn't match any account. Sign up for an account.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}

	@AfterMethod
	public void postTest() {
		driver.close();
	}
}
