package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.tmb.enums.LogType.PASS;
import static com.tmb.enums.LogType.CONSOLE;
import static com.tmb.reports.FrameworkLogger.log;

public class BasePage {

	/**
	 * Locates element by given wait strategy, performs the clicking operation on webelement and
	 * writes the pass even to the extent report.
	 * @author Thrinath K
	 * Jan 22, 2023
	 * @param by By Locator of the webelement
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		log(PASS,elementname+" is clicked");
		log(CONSOLE,elementname+" is clicked");
	}

	/**
	 * Locates element by given wait strategy, sends the value to located webelement and
	 * writes the pass even to the extent report.
	 * @author Thrinath K
	 * Jan 22, 2023
	 * @param by By Locator of the webelement
	 * @param value value to be send the text box
	 * @param waitstrategy Strategy to find webelement. Known  strategies {@link com.tmb.enums.WaitStrategy}
	 * @param elementname Name of the element that needs to be logged in the report.
	 */
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		if(elementname=="Password") {
			log(PASS,elementname +" is entered successfully in "+elementname);
			log(CONSOLE,elementname +" is entered successfully in "+elementname);
		}
		else {
			log(PASS,value +" is entered successfully in "+elementname);
			log(CONSOLE,value +" is entered successfully in "+elementname);
		}
	}
	
	/**
	 * Return page title of webpage in String
	 * 
	 * @author Thrinath K
	 * Jan 22, 2023
	 * @return Page title of the webpage where the selenium is currently interacting.
	 */
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	
	protected String getElementText(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		log(PASS, "getting text of the "+ elementname);
		log(CONSOLE, "getting text of the "+ elementname);
		return element.getText();		
	}

	
}
