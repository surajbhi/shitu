package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class MotionAlarmSoundPage {

	AppiumDriver<WebElement> driver;
	public MotionAlarmSoundPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement motionAlarmTitle;

	public WebElement getMotionAlarmTitle() {
		return motionAlarmTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/tv_level")
	private WebElement levelText;

	public WebElement getLevelText() {
		return levelText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
