package org.iitwforce.mmp.mmpprime;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MRSDataParameterization {
	public WebDriver driver;
	String url = "https://demo.openmrs.org/openmrs/login.htm";

	@BeforeClass
	public void launchBrowser() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(chromeOptions);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	@DataProvider(name="loginData")
	public String[][] feedDP() throws Exception
	{
		String data[][] = ExcelDataProvider.readExcelData("OpenMRs.xlsx","TestData");
		return data;
	}

	@Test(dataProvider="loginData")
	public void loginUname(String uname,String pwd) throws Exception {
		driver.findElement(By.id("username")).sendKeys(uname);//using a avariable for xpath with the above statement
		driver.findElement(By.id("password")).sendKeys(pwd);//using a avariable for xpath with the above statement
		driver.findElement(By.xpath("//li[@id='Inpatient Ward']")).click();
		driver.findElement(By.id("loginButton")).click();
		boolean result =driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).
						isDisplayed();
		driver.findElement(By.partialLinkText("Logout")).click();
		Assert.assertTrue(result);
	 
	}

	@AfterClass
	public void closeBrowser() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
}