package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevSerConnectNetworkPage {
	
	AppiumDriver<WebElement> driver;
	public AddDevSerConnectNetworkPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='Connect with network']")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_wifi")
	private WebElement tapContinueText;

	public WebElement getTapContinueText() {
		return tapContinueText;
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
