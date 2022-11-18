package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CancelThisProcessPage {
	
	
	AppiumDriver<WebElement> driver;
	public CancelThisProcessPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='Cancel this process?']")
	private WebElement cancelThisProcessText;

	public WebElement getCancelThisProcessText() {
		return cancelThisProcessText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_negative")
	private WebElement dontCancelButton;

	public WebElement getDontCancelButton() {
		return dontCancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement yesCancelButton;

	public WebElement getYesCancelButton() {
		return yesCancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
