package com.orangehrm.pageclassess;

import org.openqa.selenium.By;

import com.orangehrm_Basemethods.Basemethods;

public class PIMPage extends Basemethods {

	
	public PIMPage Add_Employee() {
		click(locateElement("xpath", "//button[text()=' Add ']"));
		return this;
	}

	public PIMPage Firstname() {
		clearAndType(locateElement("xpath", "//input[@name='firstName']"), "vijayakumar");
		return this;
	}

	public PIMPage Lastname() {

		clearAndType(locateElement("xpath", "//input[@name='lastName']"), "s");
		return this;
	}

	public PIMPage PIM_Savebutton() {
		click(locateElement("xpath", "//button[text()=' Save ']"));
		return this;
	}

	public PIMPage PIM_Search_Employeename() {

		clearAndType(locateElement("xpath", "//input[@placeholder='Type for hints...']"), "vijay");
		click(locateElement("xpath", "//span[text()='vijayakumar  s']"));
		return this;
	}

	public PIMPage PIM_Search_Button() {

		click(locateElement("xpath", "//button[text()=' Search ']"));
		waits(3);
		return this;
	}

	public PIMPage PIM_Delete_Employee() {

		click(locateElement("xpath", "//div[@class='oxd-table-card-cell-checkbox']"));
		click(locateElement("xpath", "//i[@class='oxd-icon bi-trash']"));
		click(locateElement("xpath", "//button[text()=' Yes, Delete ']"));
		waits(3);
		return this;
	}

}
