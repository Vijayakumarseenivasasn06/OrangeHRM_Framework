package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.orangehrm.pageclassess.AdminPage;
import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_05_Admin_Search extends Basemethods {

	@BeforeTest
	public void Setdata() {
		
		testCaseName ="TC_02_PIMCreation";
		testCaseDescription ="To verify the Employee Creation functionality in PIM tab";
		author ="QA Team";
		category ="Smoke Test";
		
	}
	
	@Test
	public void Admin_search() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.Click_AdminTab();
		
		AdminPage aps = new AdminPage();
		aps.Search_Username();
//		aps.Search_Userrole();
		aps.Search_Employeename();
//		aps.Search_StatusofEmployee();
		aps.Search_Searchbutton();
		
		
		
		
	}
	
	
}
