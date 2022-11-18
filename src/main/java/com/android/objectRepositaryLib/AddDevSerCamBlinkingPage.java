package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevSerCamBlinkingPage {


	AppiumDriver<WebElement> driver;
	public AddDevSerCamBlinkingPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Is the camera blinking blue?']")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Not blinking']")
	private WebElement notBlinkingButton;

	public WebElement getNotBlinkingButton() {
		return notBlinkingButton;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Yes, its blinking']")
	private WebElement yesBlinkingButton;

	public WebElement getYesBlinkingButton() {
		return yesBlinkingButton;
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
