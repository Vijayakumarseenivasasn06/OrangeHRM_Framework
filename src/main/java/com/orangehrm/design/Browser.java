package com.orangehrm.design;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

public interface Browser {
	
/**
 * This method will launch the Browser
 * Maximise the Browser
 * And need to wait for 30 seconds
 * Use Implicitly wait
 * @param url- the URL
 * @throws MalformedURLException 
 */	
	public void startApp(String url);
	
	
	/**
	 * This method will launch the Browser
	 * Maximize the Browser
	 * Need to wait for 30 seconds Using Implicitly wait
	 * @param url - load the URL
	 * @param browser -  load the Browser
	 * @throws MalformedURLException
	 */	
	public void startApp(String browser, String url);
	
	
	/**
	 * This method will locate the element by using given Locator
	 * @param locatorType - The locator by which the element to be found
	 * @param  value - The locator value by which the element to be found
	 * @throws NoSuchElementException
	 * @return The first matching element on the current context.
	 */	
	public WebElement locateElement(String locatorType, String value);	
	
	/**
	 * This method will locate the element by using id
	 * @param  value - The locator value by which the element to be found
	 * @throws NoSuchElementException
	 * @return The first matching element on the current context.
	 */	
	public WebElement locateElement(String value);
	
	
	
	/**
	 * This method will locate the element by using given Locator
	 * @param locatorType - The locator by which the element to be found
	 * @param  value - The locator value by which the element to be found
	 * @return A list of all WebElements, or an empty list if nothing matches.
	 */	
	public List<WebElement> locateElements(String type, String value);	
	
	
	
	/**
	 * This method will switch to the Alert
	 * 
	 * @return NoAlertPresentException
	 */
	public Alert switchToAlert();

	/**
	 * This method will accept the alert opened
	 * 
	 * @throws NoAlertPresentException
	 */
	public void acceptAlert();
	
	/**
	 * This method will dismiss the alert opened
	 * 
	 * @throws NoAlertPresentException
	 */
	public void dismissAlert();
	
	
	/**
	 * This method will return the text of the alert
	 * 
	 * @throws NoAlertPresentException
	 */
	public String getAlertText();
	
	/**
	 * This method will enter the value in the alert
	 * 
	 * @param data- the data to be entered in alert
	 * @throws NoAlertPresentException
	*/
	public void typeAlert(String data);
	
	
	/**
	 * This method will switch to the Window of interest
	 * @param index The window index to be switched to. 0 -> first window 
	 * 
	 * @throws NoSuchWindowException
	 */
	public void switchToWindow(int index);
	
	/**
	 * This method will switch to the Window of interest using its title
	 * @param title The window title to be switched to first window 
	 * 
	 * @throws NoSuchWindowException
	 */
	public void switchToWindow(String title);
	
	/**
	 * This method will switch to the specific frame using index
	 * @param index   - The int (frame) to be switched
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(int index);	
	
	
	/**
	 * This method will switch to the specific frame
	 * @param ele   - The Webelement (frame) to be switched
	 * 
	 * @throws NoSuchFrameException, StaleElementReferenceException 
	 */
	public void switchToFrame(WebElement ele);
	
	
	/**
	 * This method will switch to the specific frame using Id (or) Name
	 * @param idOrName   - The String (frame) to be switched
	 * 
	 * @throws NoSuchFrameException 
	 */
	public void switchToFrame(String idOrName);
	
	
	
	/**
	 * This method will switch to the first frame on the page
	 * 
	 * @return This driver focused on the top window/first frame.
	 */
	public void defaultContent();
	
	
	/**
	 * This method will verify browser actual url with expected
	 * @param url   - The url to be checked
	 * 
	 * @return true if the given object represents a String equivalent to this url, false otherwise
	 */
	public boolean verifyUrl(String url);
	
	/**
	 * This method will verify browser actual title with expected
	 * @param title - The expected title of the browser
	 * 
	 * @return true if the given object represents a String equivalent to this title, false otherwise
	 */
	public boolean verifyTitle(String title);
	
	
	/**
	 * This method will close the active browser
	 * 
	 */
	public void closeBrowser();
	
	
	/**
	 * This method will close all the browsers
	 * 
	 */
	public void closeAllBrowsers();
	
	

}
