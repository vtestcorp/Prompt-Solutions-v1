package com.PS.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.PS.base.Base;
import com.PS.util.Utility;

public class login extends Base{
	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement LoginBtn;
	
	@FindBy(xpath = "//h4[contains(text(),'Log in to get started or')]")
	public WebElement lheader;
	public login() {
		// TODO Auto-generated constructor stub
	 
		PageFactory.initElements(driver, this);
	}
	public void login(String username,String pass)
	{
		Assert.assertEquals(lheader.isDisplayed(), true,"No login screen found");
		email.sendKeys(username);
		password.sendKeys(pass);
		LoginBtn.click();
			
	//	Assert.assertEquals(lheader.isDisplayed(), false,"Not logged in");
	}
}
