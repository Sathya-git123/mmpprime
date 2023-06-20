package org.mmp.patientmodule.tests;

import java.util.HashMap;

import org.mmp.methods.BaseClass;
import org.mmp.methods.HelperClass;
import org.mmp.methods.MMPUtil;
import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointmentTests extends BaseClass {

	MMPUtil mmpUtil ;
	ScheduleAppointmentPage sPage;
		
	@BeforeMethod
	public void preRequisite()
	{
		mmpUtil = new MMPUtil(driver);
		mmpUtil.lauchBrowser(pro.getProperty("patientURL"));
		HelperClass helperObj = new HelperClass(driver);
		helperObj.login(pro.getProperty("patientUsername"), pro.getProperty("patientPassword"));
		sPage = new ScheduleAppointmentPage(driver);
	}
	@Parameters({"drName"})
	@Test
	public void TC_001_validateScheduleAppointment(String drName)
	{
 
		HashMap<String,String> expectedHMap = sPage.bookAppointment(drName);
		HashMap<String,String> actualHMap = sPage.fetchPatientData();
		Assert.assertEquals(actualHMap, expectedHMap);
	}
	 
	@Parameters({"drName"})
	@Test
	public void TC_003_validateScheduleAppointment(String drName)
	{
		System.out.println("TC_003_validateScheduleAppointment");
		HashMap<String,String> expectedHMap = sPage.bookAppointment(drName,10);
		HashMap<String,String> actualHMap = sPage.fetchPatientData();
		Assert.assertEquals(actualHMap, expectedHMap);
		 
	}
	
	 
}














