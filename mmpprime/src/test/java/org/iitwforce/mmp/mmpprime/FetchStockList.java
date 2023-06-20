package org.iitwforce.mmp.mmpprime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchStockList {
	@Test
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		String stockDetails[]= {"TV18 Broadcast","Varun Beverages Ltd."};
		SoftAssert sa = new SoftAssert();
		boolean result = false;
		for(int i=0 ;i < stockDetails.length;i++)
		{
			System.out.println("stock Name" + stockDetails[i]);
			try 
			{
				result =driver.findElement(By.xpath("//table[@class='dataTable']//a[contains(.,'"+stockDetails[i]+"')]")).isDisplayed();
				if(result)
				{
					System.out.println("Stock is available in the table::" + stockDetails[i] );
					sa.assertTrue(result);
				}
			}
			catch(Exception e)
			{
				result = false;
				sa.assertTrue(result);
				System.out.println("Stock is not available in the table" + stockDetails[i]);
			}
			 
		}
		sa.assertAll();

	}	

}
