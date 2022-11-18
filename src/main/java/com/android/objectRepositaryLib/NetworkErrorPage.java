package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class NetworkErrorPage {
	
	
	public NetworkErrorPage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement notConnectedTitle;

	public WebElement getNotConnectedTitle() throws InterruptedException {
		Thread.sleep(2000);
		return notConnectedTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement retryButton;

	public WebElement getRetryButton() {
		return retryButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_error")
	private WebElement errorIcon;

	public WebElement getErrorIcon() {
		return errorIcon;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
