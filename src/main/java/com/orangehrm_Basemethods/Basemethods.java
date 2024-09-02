package com.orangehrm_Basemethods;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.orangeHrm_Reporter_Library.Datalibrary;
import com.reusablecomponents.classess.Selenium_Reusable_Components;



public class Basemethods extends Selenium_Reusable_Components {
	
public String dataSheetName;
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		eachNode = test.createNode(testCaseName);
		startApp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

//	@AfterMethod
//	public void afterMethod() {
//		closeBrowser();
//	}

	@DataProvider(name = "fetchData")
	public Object[][] fetchData() throws IOException {
		return Datalibrary.readExcelData(dataSheetName);
	}	
	
	
	
	
}
