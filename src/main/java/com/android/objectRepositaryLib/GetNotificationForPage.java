package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class GetNotificationForPage {

	
	AppiumDriver<WebElement> driver;
	public GetNotificationForPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(xpath= "//android.widget.RadioButton[@text='Person Detection']")
	private WebElement personDetection;

	public WebElement getPersonDetection() {
		return personDetection;
	}
	
	@FindBy(xpath= "//android.widget.RadioButton[@text='Motion Detection']")
	private WebElement motionDetection;

	public WebElement getMotionDetection() {
		return motionDetection;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() {
		return doneButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
