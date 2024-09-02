package com.orangehrm.pageclassess;

import org.openqa.selenium.By;

import com.orangehrm_Basemethods.Basemethods;

public class DashboardPage extends Basemethods {
	
	public PIMPage click_PIMTab() {
//		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		click(locateElement("xpath","//span[text()='PIM']"));
		waits(3);
		return new PIMPage();
	}

	public AdminPage Click_AdminTab() {
		click(locateElement("xpath", "//span[text()='Admin']"));
		waits(3);
		return new AdminPage();
	}
	
}
