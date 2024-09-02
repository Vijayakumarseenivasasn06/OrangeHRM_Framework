package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.AdminPage;
import com.orangehrm.pageclassess.DashboardPage;
import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm.pageclassess.PIMPage;
import com.orangehrm_Basemethods.Basemethods;

public class TC_07_delete_Employee_Admin extends Basemethods {

	
	@BeforeTest
	public void setdata() {
		
		testCaseName ="TC_07_Delete_Employee_Admin";
		testCaseDescription ="To verify the Employee Delete functionality in Admin tab";
		author ="QA Team";
		category ="Smoke Test";
	}
	
	@Test
	public void Delete_Employee_Admin() {
		
		LoginPage lp = new LoginPage();
		lp.enterusername();
		lp.enterpassword();
		lp.clickbtn();
		
		DashboardPage dp = new DashboardPage();
		dp.click_PIMTab();
		
		PIMPage ppd = new PIMPage();
		ppd.Add_Employee();
		ppd.Firstname();
		ppd.Lastname();
		ppd.PIM_Savebutton();
		
		
		dp.Click_AdminTab();
		AdminPage apd = new AdminPage();
		apd.Click_Addbutton();
		apd.create_Select_Userrole();
		apd.create_Employeename();
		apd.create_Employee_Status();
		apd.create_Username();
		apd.create_Password();
		apd.create_Confirm_Password();
		apd.create_Admin_Savebutton();
		
		apd.Search_Employeename();
		apd.Search_Username();
		apd.Search_Searchbutton();
		apd.Delete_Employee();
		
		
		
		
	}
}
