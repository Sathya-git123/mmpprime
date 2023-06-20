package org.mmp.methods;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MMPUtil {

	WebDriver driver;

	public MMPUtil(WebDriver driver)
	{
		this.driver=driver;
	}

	public void lauchBrowser(String url)
	{
		driver.get(url);
	}
 
	public HashMap<String, String> bookAppointment(String drName)
	{
		HashMap<String,String> sHMap = new HashMap<String,String>();

		driver.findElement(By.linkText("Schedule Appointment")).click();
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();
		sHMap.put("doctor", drName);
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+drName+"']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.linkText("Next")).click();
		driver.findElement(By.linkText("20")).click();
		sHMap.put("date", driver.findElement(By.id("datepicker")).getAttribute("value"));
		driver.findElement(By.id("time")).click();
		{
			WebElement dropdown = driver.findElement(By.id("time"));
			dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();
		}
		sHMap.put("time", driver.findElement(By.id("time")).getAttribute("value"));
//	
//		//Explicit Wait
//		Duration d = Duration.ofSeconds(30);
//		WebDriverWait wait = new WebDriverWait(driver,d);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName")));
//		
		By okStatus = By.id("status");
		WebElement okMessage = explicitTimeOut(driver,30,okStatus);
		System.out.println("message in the pop-up " + okMessage.getText());
		
		By continueButton = By.id("ChangeHeatName");
		WebElement continueWE = explicitTimeOut(driver,30,continueButton);
		continueWE.click();
	
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).click();
		driver.findElement(By.id("sym")).sendKeys("Chest pain");
		sHMap.put("sym", driver.findElement(By.id("sym")).getAttribute("value"));
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		return sHMap;
	}
	public HashMap<String,String> bookAppointment(String drName,int noofDays)
	{
		HashMap<String,String> sHMap = new HashMap<String,String>();
		driver.findElement(By.linkText("Schedule Appointment")).click();
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();	
		String expectedDrName = drName;
		driver.findElement(By.xpath("//h4[normalize-space()='Dr."+expectedDrName+"']/ancestor::ul/following-sibling::button")).click();
		sHMap.put("doctor", drName);
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();
		String result = JavaUtility.getFutureDate(noofDays,"MMMM/dd/yyyy");
		String dateArr[]=result.split("/");
		String expectedYear=dateArr[2];
		String expectedMonth = dateArr[0];//Aug
		String expectedDay = dateArr[1];

		String actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();//June
		while(!(expectedYear.equals(actualYear)))
		{
			driver.findElement(By.linkText("Next")).click();
			actualYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
		}
		String actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();//June
		while(!(expectedMonth.equals(actualMonth)))
		{
			driver.findElement(By.linkText("Next")).click();
			actualMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
		}

		driver.findElement(By.linkText(expectedDay)).click();
		String expectedDate   = driver.findElement(By.id("datepicker")).getAttribute("value");
		sHMap.put("date", expectedDate);
		driver.findElement(By.id("time")).click();
		{
			WebElement dropdown = driver.findElement(By.id("time"));
			dropdown.findElement(By.xpath("//option[. = '12Pm']")).click();
		}
		String expectedTime=driver.findElement(By.id("time")).getAttribute("value");
		sHMap.put("time", expectedTime);
		
		By okStatus = By.id("status");
		WebElement okMessage = explicitTimeOut(driver,30,okStatus);
		System.out.println("message in the pop-up " + okMessage.getText());
		
		By continueButton = By.id("ChangeHeatName");
		WebElement continueWE = explicitTimeOut(driver,30,continueButton);
		continueWE.click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.id("sym")).click();
		driver.findElement(By.id("sym")).sendKeys("Chest pain");
		String expectedSym =    driver.findElement(By.id("sym")).getAttribute("value");
		sHMap.put("sym", expectedSym);
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		return sHMap;
	}
	public HashMap<String, String> fetchPatientData()
	{
		HashMap<String,String> pHMap = new HashMap<String,String>();
		pHMap.put("doctor", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(4)")).getText());
		pHMap.put("date", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(1)")).getText());
		pHMap.put("time", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText());
		pHMap.put("sym", driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(3)")).getText());
		return pHMap;

	}
	 
	public static WebElement explicitTimeOut(WebDriver driver, int timeinSecs,By locator)
	{
		//Explicit Wait
		Duration d = Duration.ofSeconds(timeinSecs);
		WebDriverWait wait = new WebDriverWait(driver,d);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return e;
	}
}
























