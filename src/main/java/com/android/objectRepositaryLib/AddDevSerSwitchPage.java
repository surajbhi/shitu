package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevSerSwitchPage {
	

	AppiumDriver<WebElement> driver;
	public AddDevSerSwitchPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Switch on the device']")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/item_sub_title_1")
	private WebElement keepTheCamText;

	public WebElement getKeepTheCamText() {
		return keepTheCamText;
	}

	@FindBy(id= "com.airtel.xsafe:id/item_sub_title_2")
	private WebElement removeAnyText;

	public WebElement getRemoveAnyText() {
		return removeAnyText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
