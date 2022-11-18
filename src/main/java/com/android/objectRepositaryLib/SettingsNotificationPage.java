package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SettingsNotificationPage {

	
	
	AppiumDriver<WebElement> driver;
	public SettingsNotificationPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_settings_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_s_notification")
	private WebElement notificationsTitle;

	public WebElement getNotificationsTitle() {
		return notificationsTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement notificationsButton;

	public WebElement getNotificationsButton() {
		return notificationsButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_sub_title")
	private WebElement notificationsStatus;

	public WebElement getNotificationsStatus() throws InterruptedException {
		Thread.sleep(2000);
		return notificationsStatus;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_notification_when")
	private WebElement notificationsForText;

	public WebElement getNotificationsForText() {
		return notificationsForText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Event Detection']")
	private WebElement eventDetectionLink;

	public WebElement getEventDetectionLink() {
		return eventDetectionLink;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Camera goes offline']")
	private WebElement cameraGoesOffline;

	public WebElement getCameraGoesOffline() {
		return cameraGoesOffline;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
