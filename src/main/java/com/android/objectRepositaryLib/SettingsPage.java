package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SettingsPage {


	AppiumDriver<WebElement> driver;
	public SettingsPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_setting_tab_title")
	private WebElement titleSettings;

	public WebElement getTitleSettings() {
		return titleSettings;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_settings_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Device']")
	private WebElement deviceLink;

	public WebElement getDeviceLink() {
		return deviceLink;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Event']")
	private WebElement eventLink;

	public WebElement getEventLink() {
		return eventLink;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Notifications']")
	private WebElement notificationsLink;

	public WebElement getNotificationsLink() {
		return notificationsLink;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_d_camera_name")
	private WebElement cameraName;

	public WebElement getCameraName() {
		return cameraName;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_d_power")
	private WebElement sleepModeTxt;

	public WebElement getSleepModeTxt() {
		return sleepModeTxt;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tgb_d_power")
	private WebElement sleepModeButton;

	public WebElement getSleepModeButton() {
		return sleepModeButton;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Status Light']")
	private WebElement statusLight;

	public WebElement getStatusLight() {
		return statusLight;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Night Vision Mode']")
	private WebElement nightVisionMode;

	public WebElement getNightVisionMode() {
		return nightVisionMode;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Flip Camera']")
	private WebElement flipCamera;

	public WebElement getFlipCamera() {
		return flipCamera;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='SD Card']")
	private WebElement sdCard;

	public WebElement getSdCard() {
		return sdCard;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='About Camera']")
	private WebElement aboutCamera;

	public WebElement getAboutCamera() {
		return aboutCamera;
	}
	
	@FindBy(xpath= "//*[@text='Camera Flipped Successfully']")
	private WebElement flipCameraToast;

	public WebElement getFlipCameraToast() {
		return flipCameraToast;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
