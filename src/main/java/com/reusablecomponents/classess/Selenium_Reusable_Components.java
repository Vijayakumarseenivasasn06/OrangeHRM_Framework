package com.reusablecomponents.classess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.orangeHrm_Reporter_Library.Reporter;
import com.orangehrm.design.Browser;
import com.orangehrm.design.Elements;

public class Selenium_Reusable_Components   extends Reporter implements Browser, Elements {

		public int i = 1;
		public static RemoteWebDriver driver;
		public static Properties prop;

		public void loadObjects() {
			prop = new Properties();
			try {
				prop.load(new FileInputStream(new File("./objects/english.properties")));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void unloadObjects() {
			prop = null;
		}

		public void startApp(String browser, String url) {
			try {
				if (browser.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				}
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				reportStep("The browser: " + browser + " launched successfully", "PASS");
			} catch (WebDriverException e) {
				reportStep("The browser: " + browser + " could not be launched", "FAIL");
			}
		}

		public void startApp(String url) {
			try {
				driver = new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				reportStep("The browser: Chrome launched successfully", "PASS");
			} catch (WebDriverException e) {
				reportStep("The browser: Chrome could not be launched", "FAIL");
			}
		}

		public WebElement locateElement(String locator, String locValue) {
			try {
				switch (locator) {
				case "id":
					return driver.findElement(By.id(locValue));
				case "class":
					return driver.findElement(By.className(locValue));
				case "name":
					return driver.findElement(By.name(locValue));
				case "link":
					return driver.findElement(By.linkText(locValue));
				case "partialLink":
					return driver.findElement(By.partialLinkText(locValue));
				case "tagname":
					return driver.findElement(By.tagName(locValue));
				case "xpath":
					return driver.findElement(By.xpath(locValue));
				case "cssSelect":
					return driver.findElement(By.cssSelector(locValue));
				}
			} catch (NoSuchElementException e) {
				reportStep("The element with locator " + locator + " not found.", "FAIL");
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while finding " + locator + " with the value " + locValue,
						"FAIL");
			}
			return null;
		}

		public WebElement locateElement(String locValue) {
			return driver.findElement(By.id(locValue));
		}

		public List<WebElement> locateElements(String type, String locValue) {
			try {
				switch (type) {
				case "id":
					return driver.findElements(By.id(locValue));
				case "class":
					return driver.findElements(By.className(locValue));
				case "name":
					return driver.findElements(By.name(locValue));
				case "link":
					return driver.findElements(By.linkText(locValue));
				case "partialLink":
					return driver.findElements(By.partialLinkText(locValue));
				case "tagname":
					return driver.findElements(By.tagName(locValue));
				case "xpath":
					return driver.findElements(By.xpath(locValue));
				case "cssSelect":
					return driver.findElements(By.cssSelector(locValue));
				}
			} catch (NoSuchElementException e) {
				reportStep("The element with locator " + type + " not found.", "FAIL");
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while finding " + type + " with the value " + locValue, "FAIL");
			}
			return null;
		}

		public void clearAndType(WebElement ele, String data) {
			try {
				ele.clear();
				ele.sendKeys(data);
				reportStep("The data: " + data + " entered successfully in the field :" + ele, "PASS");
			} catch (InvalidElementStateException e) {
				reportStep("The data: " + data + " could not be entered in the field :" + ele, "FAIL");
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while entering " + data + " in the field :" + ele, "FAIL");
			}
		}

		public void clickWithNoSnap(WebElement ele) {
			String text = "";
			try {
				ele.click();
				reportStep("The element :" + text + "  is clicked.", "PASS", false);
			} catch (InvalidElementStateException e) {
				reportStep("The element: " + text + " could not be clicked", "FAIL", false);
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while clicking in the field :", "FAIL", false);
			}
		}

		public void click(WebElement ele) {
			String text = "";
			try {
				ele.click();
				reportStep("The element " + text + " is clicked", "PASS");
			} catch (InvalidElementStateException e) {
				reportStep("The element: " + text + " could not be clicked", "FAIL");
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while clicking in the field :", "FAIL");
			}
		}

		public String getTitle() {
			String bReturn = "";
			try {
				bReturn = driver.getTitle();
			} catch (WebDriverException e) {
				reportStep("Unknown Exception Occured While fetching Title", "FAIL");
			}
			return bReturn;
		}

		public void selectDropDownUsingText(WebElement ele, String value) {
			try {
				new Select(ele).selectByVisibleText(value);
				reportStep("The dropdown is selected with text " + value, "PASS");
			} catch (WebDriverException e) {
				reportStep("The element: " + ele + " could not be found.", "FAIL");
			}
		}

		public void selectDropDownUsingIndex(WebElement ele, int index) {
			try {
				new Select(ele).selectByIndex(index);
				reportStep("The dropdown is selected with index " + index, "PASS");
			} catch (WebDriverException e) {
				reportStep("The element: " + ele + " could not be found.", "FAIL");
			}
		}

		public void selectDropDownUsingValue(WebElement ele, String value) {
			try {
				new Select(ele).selectByValue(value);
				reportStep("The dropdown is selected with text " + value, "PASS");
			} catch (WebDriverException e) {
				reportStep("The element: " + ele + " could not be found.", "FAIL");
			}
		}

		public boolean verifyTitle(String title) {
			boolean bReturn = false;
			try {
				if (getTitle().equals(title)) {
					reportStep("The title of the page matches with the value :" + title, "PASS");
					bReturn = true;
				} else {
					reportStep("The title of the page:" + driver.getTitle() + " did not match with the value :" + title,
							"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while verifying the title", "FAIL");
			}
			return bReturn;
		}

		public boolean verifyExactText(WebElement ele, String expectedText) {
			try {
				if (getElementText(ele).equals(expectedText)) {
					reportStep("The text: " + getElementText(ele) + " matches with the value :" + expectedText, "PASS");
				} else {
					reportStep("The text " + getElementText(ele) + " doesn't matches the actual " + expectedText,
							"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while verifying the Text", "FAIL");
			}
			return false;
		}

		public boolean verifyPartialText(WebElement ele, String expectedText) {
			try {
				if (getElementText(ele).contains(expectedText)) {
					reportStep("The expected text contains the actual " + expectedText, "PASS");
					return true;
				} else {
					reportStep("The expected text doesn't contain the actual " + expectedText, "FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while verifying the Text", "FAIL");
			}
			return false;
		}

		public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
			try {
				if (getTypedText(ele, attribute).equals(value)) {
					reportStep("The expected attribute :" + attribute + " value matches the actual " + value, "PASS");
					return true;
				} else {
					reportStep("The expected attribute :" + attribute + " value does not matches the actual " + value,
							"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
			}
			return false;
		}

		public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
			try {
				if (getTypedText(ele, attribute).contains(value)) {
					reportStep("The expected attribute :" + attribute + " value contains the actual " + value, "PASS");
				} else {
					reportStep("The expected attribute :" + attribute + " value does not contains the actual " + value,
							"FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("Unknown exception occured while verifying the Attribute Text", "FAIL");
			}
		}

		public void verifySelected(WebElement ele) {
			try {
				if (ele.isSelected()) {
					reportStep("The element " + ele + " is selected", "PASS");
				} else {
					reportStep("The element " + ele + " is not selected", "FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
		}

		public boolean verifyDisplayed(WebElement ele) {
			try {
				if (ele.isDisplayed()) {
					reportStep("The element " + ele + " is visible", "PASS");
					return true;
				} else {
					reportStep("The element " + ele + " is not visible", "FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "f");
			}
			return false;
		}

		public void switchToWindow(int index) {
			try {
				Set<String> allWindowHandles = driver.getWindowHandles();
				List<String> allHandles = new ArrayList<>();
				allHandles.addAll(allWindowHandles);
				driver.switchTo().window(allHandles.get(index));
			} catch (NoSuchWindowException e) {
				reportStep("The driver could not move to the given window by index " + index, "PASS");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
		}

		public void switchToFrame(WebElement ele) {
			try {
				driver.switchTo().frame(ele);
				reportStep("switch In to the Frame " + ele, "PASS");
			} catch (NoSuchFrameException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
		}

		public void switchToFrame(int index) {
			try {
				driver.switchTo().frame(index);
				reportStep("switch In to the Frame " + index, "PASS");
			} catch (NoSuchFrameException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
		}

		public void switchToFrame(String idOrName) {
			try {
				driver.switchTo().frame(idOrName);
				reportStep("switch In to the Frame " + idOrName, "PASS");
			} catch (NoSuchFrameException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}

		}

		public void acceptAlert() {
			String text = "";
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
				alert.accept();
				reportStep("The alert " + text + " is accepted.", "PASS", false);
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.", "FAIL", false);
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL", false);
			}
		}

		public void dismissAlert() {
			String text = "";
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
				alert.dismiss();
				reportStep("The alert " + text + " is dismissed.", "PASS", false);
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.", "FAIL", false);
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL", false);
			}
		}

		public String getAlertText() {
			String text = "";
			try {
				Alert alert = driver.switchTo().alert();
				text = alert.getText();
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.", "FAIL", false);
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL", false);
			}
			return text;
		}

		public long takeSnap() {
			long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
			try {
				FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/" + number + ".png"));
			} catch (WebDriverException e) {
				System.out.println("The browser has been closed.");
			} catch (IOException e) {
				System.out.println("The snapshot could not be taken");
			}
			return number;
		}

		public void closeBrowser() {
			try {
				driver.close();
				reportStep("The browser is closed", "PASS", false);
			} catch (Exception e) {
				reportStep("The browser could not be closed", "FAIL", false);
			}
		}

		public void closeAllBrowsers() {
			try {
				driver.quit();
				reportStep("The opened browsers are closed", "PASS", false);
			} catch (Exception e) {
				reportStep("Unexpected error occured in Browser", "FAIL", false);
			}
		}

		public void append(WebElement ele, String data) {
			try {
				ele.sendKeys(data);
				reportStep("The Data :" + data + " entered Successfully", "PASS");
			} catch (ElementNotInteractableException e) {
				reportStep("The Element " + ele + " is not Interactable", "FAIL");
			}
		}

		public void clear(WebElement ele) {
			try {
				ele.clear();
				reportStep("The field is cleared Successfully", "PASS");
			} catch (ElementNotInteractableException e) {
				reportStep("The field is not Interactable", "FAIL");
			}
		}

		public String getElementText(WebElement ele) {
			String bReturn = "";
			try {
				bReturn = ele.getText();
			} catch (WebDriverException e) {
				reportStep("The element: " + ele + " could not be found.", "FAIL");
			}
			return bReturn;
		}

		public String getBackgroundColor(WebElement ele, String prop) {
			String cssValue = "";
			try {
				cssValue = ele.getCssValue("color");
				reportStep("The Element " + ele + "returns color", "PASS");
			} catch (Exception e) {
				reportStep("The Element " + ele + "returns color", "FAIL");
			}
			return cssValue;

		}

		public String getTypedText(WebElement ele, String attribute) {
			String bReturn = "";
			try {
				bReturn = ele.getAttribute(attribute);
			} catch (WebDriverException e) {
				reportStep("The element: " + ele + " could not be found.", "FAIL");
			}
			return bReturn;
		}

		public boolean verifyDisappeared(WebElement ele) {
			try {
				if (ele.isDisplayed()) {
					reportStep("The element " + ele + " is Displayed", "PASS");
					return true;
				} else {
					reportStep("The element " + ele + " is not Displayed", "FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
			return false;
		}

		public boolean verifyEnabled(WebElement ele) {
			try {
				if (ele.isEnabled()) {
					reportStep("The element " + ele + " is Enabled", "PASS");
					return true;
				} else {
					reportStep("The element " + ele + " is not Enabled", "FAIL");
				}
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
			return false;
		}

		public Alert switchToAlert() {
			Alert alert = null;
			try {
				alert = driver.switchTo().alert();
				reportStep("The alert is switched successfully.", "PASS");
				return alert;
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.", "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}
			return alert;
		}

		public void typeAlert(String data) {
			try {
				Alert alert = driver.switchTo().alert();
				alert.sendKeys(data);
				alert.accept();
				reportStep("The alert " + data + " is accepted.", "PASS");
			} catch (NoAlertPresentException e) {
				reportStep("There is no alert present.", "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}

		}

		public void switchToWindow(String title) {
			try {
				Set<String> allWindows = driver.getWindowHandles();
				for (String eachWindow : allWindows) {
					driver.switchTo().window(eachWindow);
					if (driver.getTitle().equals(title)) {
						break;
					}
					reportStep("The Window With Title :" + title + " is switched", "PASS");
				}
			} catch (NoSuchWindowException e) {
				reportStep("\"The Window With Title: " + title + " not found", "FAIL");
			} catch (WebDriverException e) {
				reportStep("WebDriverException : " + e.getMessage(), "FAIL");
			}

		}

		public void defaultContent() {
			try {
				driver.switchTo().defaultContent();
			} catch (Exception e) {
			}

		}

		public boolean verifyUrl(String url) {
			if (driver.getCurrentUrl().equals(url)) {
				reportStep("The url: " + url + " matched successfully", "PASS");
				return true;
			} else {
				reportStep("The url: " + url + " not matched", "FAIL");
			}
			return false;
		}

		public void waits(int count) {
			for (int i = 1; i <= count; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}


