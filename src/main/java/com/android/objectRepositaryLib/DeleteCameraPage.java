package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class DeleteCameraPage {

	AppiumDriver<WebElement> driver;
	public DeleteCameraPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement titleDeleteCamera;

	public WebElement getTitleDeleteCamera() {
		return titleDeleteCamera;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_error")
	private WebElement errorIcon;

	public WebElement getErrorIcon() {
		return errorIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement texts;

	public WebElement getTexts() {
		return texts;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Don't Delete']")
	private WebElement dontDelete;

	public WebElement getDontDelete() {
		return dontDelete;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Delete']")
	private WebElement delete;

	public WebElement getDelete() {
		return delete;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_negative")
	private WebElement negativeButton;

	public WebElement getNegativeButton() {
		return negativeButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement positiveButton;

	public WebElement getPositiveButton() {
		return positiveButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
