package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.AdminPage;
import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_04_Admin_Creation extends Basemethods {

	@BeforeTest
	public void Setdata() {
		testCaseName ="TC_04_Admin_Creation";
		testCaseDescription ="To verify the Admin Tab Should Create the EMployee name";
		author ="QA Team";
		category ="Smoke Test";
	}
	@Test
	public void Admin_Creation() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.Click_AdminTab();
		
		
		AdminPage ap = new AdminPage();
		ap.Click_Addbutton();
		ap.create_Select_Userrole();
		ap.create_Employeename();
		ap.create_Employee_Status();
		ap.create_Username();
		ap.create_Password();
		ap.create_Confirm_Password();
		ap.create_Admin_Savebutton();
		
	}
	
	
	
}
