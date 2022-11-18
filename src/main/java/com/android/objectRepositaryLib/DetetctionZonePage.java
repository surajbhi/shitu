package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class DetetctionZonePage {

	AppiumDriver<WebElement> driver;
	public DetetctionZonePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement detectionZoneTitle;

	public WebElement getDetectionZoneTitle() {
		return detectionZoneTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/event_title")
	private WebElement detectEventText;

	public WebElement getDetectEventText() {
		return detectEventText;
	}
	
	@FindBy(xpath= "//android.widget.RadioButton[@text='Entire Screen']")
	private WebElement entireScreen;

	public WebElement getEntireScreen() {
		return entireScreen;
	}
	
	@FindBy(xpath= "//android.widget.RadioButton[@text='Custom Zone']")
	private WebElement customZone;

	public WebElement getCustomZone() {
		return customZone;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_custom")
	private WebElement customZoneText;

	public WebElement getCustomZoneText() {
		return customZoneText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_reset")
	private WebElement resetButton;

	public WebElement getResetButton() {
		return resetButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_camera_preview")
	private WebElement cameraPreview;

	public WebElement getCameraPreview() {
		return cameraPreview;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
