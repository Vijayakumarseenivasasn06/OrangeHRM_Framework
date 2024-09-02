package com.orangehrm.pageclassess;

import org.openqa.selenium.By;

import com.orangehrm_Basemethods.Basemethods;

public class AdminPage extends Basemethods {

	
	
	public AdminPage Click_Addbutton() {
		click(locateElement("xpath", "//button[text()=' Add ']"));
		waits(3);
		return this;
	}

	public AdminPage create_Select_Userrole() {
		click(locateElement("xpath","//div[text()='-- Select --']"));
		click(locateElement("xpath", "(//span[text()='Admin'])[2]"));
		waits(3);
		return this;
	}

	public AdminPage create_Employeename() {
		clearAndType(locateElement("xpath", "//input[@placeholder='Type for hints...']"), "vijay");
		click(locateElement("xpath", "//span[text()='vijayakumar  s']"));
		waits(3);
		return this;
	}

	public AdminPage create_Employee_Status() {
		click(locateElement("xpath", "(//div[@class='oxd-select-wrapper'])[2]"));
		click(locateElement("xpath", "//span[text()='Enabled']"));
		waits(3);
		return this;
	}

	public AdminPage create_Username() {
		
		clearAndType(locateElement("xpath", "(//input[@class='oxd-input oxd-input--active'])[2]"), "Vijay");
		waits(3);
		return this;
	}

	public AdminPage create_Password() {
		
		clearAndType(locateElement("xpath", "(//input[@type='password'])[1]"), "Vijay@1");
		return this;
	}

	public AdminPage create_Confirm_Password() {
		
		clearAndType(locateElement("xpath", "(//input[@type='password'])[2]"), "Vijay@1");
		return this;
	}

	public AdminPage create_Admin_Savebutton() {

		click(locateElement("xpath", "//button[text()=' Save ']"));
		waits(10);
		return this;
	}

	public AdminPage Search_Username() {

		clearAndType(locateElement("xpath", "(//input[@class='oxd-input oxd-input--active'])[2]"), "vijay");
		return this;
	}

//	public AdminPage Search_Userrole() {
//
//		click(locateElement("xpath", "//div[text()='-- Select --']"));
//		click(locateElement("xpath", "(//span[text()='Admin'])[2]"));
//		waits(3);
//		return this;
//	}

	public AdminPage Search_Employeename() {

		clearAndType(locateElement("xpath", "//input[@placeholder='Type for hints...']"), "vijay");
		click(locateElement("xpath", "//span[text()='vijayakumar  s']"));
		waits(3);
		return this;
	}

//	public AdminPage Search_StatusofEmployee() {
//		click(locateElement("xpath", "(//div[@class='oxd-select-text-input'])[2]"));
//		click(locateElement("xpath", "//span[text()='Enabled']"));
//		waits(3);
//		return this;
//	}

	public AdminPage Search_Searchbutton() {

		click(locateElement("xpath", "//button[text()=' Search ']"));
		waits(3);
		return this;
	}

	public AdminPage Delete_Employee() {

		click(locateElement("xpath", "(//div[@class='oxd-table-card-cell-checkbox'])"));
		click(locateElement("xpath", "(//i[@class='oxd-icon bi-trash'])"));
		click(locateElement("xpath", "//button[text()=' Yes, Delete ']"));
		waits(3);
		return this;
	}

}
