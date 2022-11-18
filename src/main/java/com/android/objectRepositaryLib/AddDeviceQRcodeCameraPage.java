package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDeviceQRcodeCameraPage {

	AppiumDriver<WebElement> driver;
	public AddDeviceQRcodeCameraPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement cameraTitle;

	public WebElement getCameraTitle() {
		return cameraTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_start_scan")
	private WebElement startScanningButton;

	public WebElement getStartScanningButton() {
		return startScanningButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	
}
