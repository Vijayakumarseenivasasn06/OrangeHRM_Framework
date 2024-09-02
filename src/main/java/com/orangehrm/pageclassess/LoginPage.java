package com.orangehrm.pageclassess;

import com.orangehrm_Basemethods.Basemethods;

public class LoginPage extends Basemethods {

	public LoginPage enterusername() {

		clearAndType(locateElement("xpath", "//input[@name='username']"), "Admin");
		return this;
	}

	public LoginPage enterpassword() {
		clearAndType(locateElement("xpath", "//input[@name='password']"), "admin123");
		return this;
	}

	public DashboardPage clickbtn() {
		click(locateElement("xpath", "//button[@type='submit']"));
		waits(3);
		return new DashboardPage();
	}

}
