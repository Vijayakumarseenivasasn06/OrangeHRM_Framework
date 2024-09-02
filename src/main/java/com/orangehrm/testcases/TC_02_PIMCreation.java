package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm.pageclassess.PIMPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_02_PIMCreation extends Basemethods{

	@BeforeTest
	public  void Set_Data() {
		testCaseName ="TC_02_PIMCreation";
		testCaseDescription ="To verify the Employee Creation functionality in PIM tab";
		author ="QA Team";
		category ="Smoke Test";
		
		
	}
	@Test
	public void PimCreation() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.click_PIMTab();
		
		PIMPage pp = new PIMPage();
		pp.Add_Employee();
		pp.Firstname();
		pp.Lastname();
		pp.PIM_Savebutton();
		
		
	}
}
