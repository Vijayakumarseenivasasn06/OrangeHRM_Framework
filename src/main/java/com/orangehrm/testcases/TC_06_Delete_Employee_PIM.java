package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm.pageclassess.PIMPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_06_Delete_Employee_PIM extends Basemethods {

	
	@BeforeTest
	public void setdata() {
		
		testCaseName ="TC_06_Delete_Employee_PIM";
		testCaseDescription ="To verify the Employee Delete functionality in PIM tab";
		author ="QA Team";
		category ="Smoke Test";
		
	}
	
	@Test
	public void Delete_Employees() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.click_PIMTab();
		
		
		PIMPage ppd = new PIMPage();
		ppd.PIM_Search_Employeename();
		ppd.PIM_Search_Button();
		ppd.PIM_Delete_Employee();
		
	}
	
}
