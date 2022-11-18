package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevSerConfiguringPage {

	
	AppiumDriver<WebElement> driver;
	public AddDevSerConfiguringPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='Configuring…']")
	private WebElement configuringText;

	public WebElement getConfiguringText() {
		return configuringText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement sitBackText;

	public WebElement getSitBackText() {
		return sitBackText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
