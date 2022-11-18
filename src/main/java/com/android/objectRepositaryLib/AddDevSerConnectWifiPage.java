package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevSerConnectWifiPage {
	
	
	AppiumDriver<WebElement> driver;
	public AddDevSerConnectWifiPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='Connect with your WiFi']")
	private WebElement connectWifiText;

	public WebElement getConnectWifiText() {
		return connectWifiText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/no_tie")
	private WebElement wifiPlaceHolder;

	public WebElement getWifiPlaceHolder() {
		return wifiPlaceHolder;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement wifiPswdPlaceHolder;

	public WebElement getWifiPswdPlaceHolder() {
		return wifiPswdPlaceHolder;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_2_4_title")
	private WebElement selectGHzText;

	public WebElement getSelectGHzText() {
		return selectGHzText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_wifi1")
	private WebElement haveMultiText;

	public WebElement getHaveMultiText() {
		return haveMultiText;
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
