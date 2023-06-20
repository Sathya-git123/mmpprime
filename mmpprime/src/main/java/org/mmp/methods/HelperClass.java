package org.mmp.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HelperClass {
	
	WebDriver driver;
	
	//Page Object model
	private By usernameID = By.id("username"); 
	
	
	//Page Factory
	@FindBy(how=How.ID,using="password")
	private WebElement passwordID; // driver.findElement(By.id("password"))
	
	
	
	public HelperClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String username,String password)
	{

		driver.findElement(usernameID).sendKeys(username);
		passwordID.sendKeys(password);
		driver.findElement(By.name("submit")).click();
		
	}
}