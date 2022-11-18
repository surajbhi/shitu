package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class ThirdPage {
	
	
	AppiumDriver<WebElement> driver;
	public ThirdPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement cloudStorageText;

	public WebElement getCloudStorageText() {
		return cloudStorageText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_submit")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}

}

















