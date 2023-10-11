package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DecodeUtils;

public final class UpdatePage extends BasePage{


	private final By login = By.xpath("//a[@id='login_Layer']");
	private final By textboxUsername = By.xpath("//div[@class='form-row'][1]/child::input");
	private final By textboxPassword = By.xpath("//div[@class='form-row'][2]/child::input");
	private final By buttonLogin = By.xpath("//button[@type='submit']");
	private final By menuOptions = By.xpath("//div[@class='nI-gNb-drawer']");
	private final By viewProfile = By.xpath("//a[@class='nI-gNb-info__sub-link']");
	private final By popupClose = By.xpath("//div[@class='crossIcon chatBot chatBot-ic-cross']");
	private final By resumeUpdate = By.xpath("//input[@id='attachCV']");
	private final By updatedOn = By.xpath("//div[@class='updateOn typ-14Regular']");
	private final By text=By.xpath("//div[@class='cnt']/child::p[1]");
	private final By resumeHeadlineEditBtn = By.xpath("//span[text()='Resume headline']/following-sibling::span");
	private final By saveResumeHeadline = By.xpath("//button[text()='Save']");
	
	public UpdatePage clickLogin() {
		click(login, WaitStrategy.PRESENCE, "Login Button");
		return this;
	}
	public UpdatePage enterUserName(String username) {
		sendKeys(textboxUsername, username, WaitStrategy.CLICKABLE,"Username");
		return this;
	}

	public UpdatePage enterPassWord(String password) {
		sendKeys(textboxPassword, DecodeUtils.getDecodedString(password), WaitStrategy.PRESENCE,"Password");
		return this;
	}
	public UpdatePage clickLoginButton() {
		click(buttonLogin, WaitStrategy.CLICKABLE, "Login Button");
		return this;
	}
	public UpdatePage clickProfile() {
		click(menuOptions, WaitStrategy.CLICKABLE, "click Menu Option");
		return this;
	}
	public UpdatePage viewProfile() {
		click(viewProfile, WaitStrategy.CLICKABLE, "click viewProfile Option");
		try {
			click(popupClose, WaitStrategy.PRESENCE, "click Popup Close button");
		}catch(Exception e) {
			
		}
		return this;
	}
	
	public UpdatePage clickEditResumeHeadline() {
		click(resumeHeadlineEditBtn,WaitStrategy.CLICKABLE, "Clickig Resume Headline button" );
		return this;
	}
	
	public UpdatePage saveResumeHeadline() {
		click(saveResumeHeadline,WaitStrategy.CLICKABLE, "Saving Resume Headline......" );
		return this;
	}
	
	
	 public UpdatePage updatingResume(String resume) { 
		 sendKeys(resumeUpdate,resume, WaitStrategy.PRESENCE,"Resume"); 
		
	 return	this; 
	 }
	 
	public String getDate() {
		return getElementText(updatedOn, WaitStrategy.PRESENCE,"date");
	}
	
	public String getText() {
		return getElementText(text, WaitStrategy.PRESENCE,"success message");
	}
	

}
