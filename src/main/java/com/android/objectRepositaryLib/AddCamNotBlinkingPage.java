package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddCamNotBlinkingPage {

	AppiumDriver<WebElement> driver;
	public AddCamNotBlinkingPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/indicator")
	private WebElement indicatorBar;

	public WebElement getIndicatorBar() {
		return indicatorBar;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement blueLightNotBlinkTitle;

	public WebElement getBlueLightNotBlinkTitle() {
		return blueLightNotBlinkTitle;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Light OFF?']")
	private WebElement lightOffButton;

	public WebElement getLightOffButton() {
		return lightOffButton;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Red light ON?']")
	private WebElement redLightOnButton;

	public WebElement getRedLightOnButton() {
		return redLightOnButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
