package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SettingsEventPage {
	
	
	AppiumDriver<WebElement> driver;
	public SettingsEventPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_event_detection")
	private WebElement eventDetectionTxt;

	public WebElement getEventDetectionTxt() {
		return eventDetectionTxt;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_settings_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Motion Detection Sensitivity']")
	private WebElement motionDetectionSensitivity;

	public WebElement getMotionDetectionSensitivity() {
		return motionDetectionSensitivity;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Detection Zone']")
	private WebElement detectionZone;

	public WebElement getDetectionZone() {
		return detectionZone;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_motion_alarm")
	private WebElement motionAlarmTxt;

	public WebElement getMotionAlarmTxt() {
		return motionAlarmTxt;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Motion Alarm Sound']")
	private WebElement motionAlarmSound;

	public WebElement getMotionAlarmSound() {
		return motionAlarmSound;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Notifications']")
	private WebElement notificationsLink;

	public WebElement getNotificationsLink() {
		return notificationsLink;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
