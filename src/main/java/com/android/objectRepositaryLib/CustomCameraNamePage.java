package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CustomCameraNamePage {

	AppiumDriver<WebElement> driver;
	public CustomCameraNamePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement customCameraTitle;

	public WebElement getCustomCameraTitle() {
		return customCameraTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton() {
		return sendKeyButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
