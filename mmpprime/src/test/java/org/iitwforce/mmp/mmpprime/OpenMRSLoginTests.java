package org.iitwforce.mmp.mmpprime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMRSLoginTests {
	
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.id("username")).sendKeys("Admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		String actual = driver.findElement(By.xpath("//h4[normalize-space()='Logged in as Team RC (admin) at Inpatient Ward.']")).getText();
		String expected="Logged in as Team RC (admin) at Inpatient Ward.";
		Assert.assertEquals(actual.trim(), expected);
		driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
		 
	}

}
