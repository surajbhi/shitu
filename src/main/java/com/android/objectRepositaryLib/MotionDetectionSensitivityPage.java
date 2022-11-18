package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class MotionDetectionSensitivityPage {

	AppiumDriver<WebElement> driver;
	public MotionDetectionSensitivityPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/tv_level")
	private WebElement levelNum;

	public WebElement getLevelNum() {
		return levelNum;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_low")
	private WebElement lowLevel;

	public WebElement getLowLevel() {
		return lowLevel;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_high")
	private WebElement highLevel;

	public WebElement getHighLevel() {
		return highLevel;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
