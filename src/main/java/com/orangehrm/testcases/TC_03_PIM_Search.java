package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm.pageclassess.PIMPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_03_PIM_Search extends Basemethods{

	
	@BeforeTest
	public void Setdata() {
		
		testCaseName ="TC_03_Login";
		testCaseDescription ="To verify the Search functionality in PIM Tab";
		author ="QA Team";
		category ="Smoke Test";
		
	}
	
	@Test
	public void PIMSearch() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.click_PIMTab();
		
		PIMPage pps = new PIMPage();
		pps.PIM_Search_Employeename();
		pps.PIM_Search_Button();
		
	}
	
}
