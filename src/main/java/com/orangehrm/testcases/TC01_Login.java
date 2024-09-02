package com.orangehrm.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.orangehrm.pageclassess.LoginPage;
import com.orangehrm_Basemethods.Basemethods;



public class TC01_Login extends Basemethods {
	
@BeforeTest
public void setData() {
	testCaseName ="TC_01_Login";
	testCaseDescription ="To verify the Login functionality";
	author ="Vijayakumar S";
	category ="Smoke Test";
	
}

@Test
public void login_HRM() {
	
	LoginPage lp = new LoginPage();
	lp.enterusername();
	lp.enterpassword();
	lp.clickbtn();
	
}
	
	
	

}
