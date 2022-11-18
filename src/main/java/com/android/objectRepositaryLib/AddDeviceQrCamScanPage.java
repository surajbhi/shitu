package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDeviceQrCamScanPage {

	
	
	AppiumDriver<WebElement> driver;
	public AddDeviceQrCamScanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='Point the camera at the QR Code']")
	private WebElement pointCameraAtQrText;

	public WebElement getPointCameraAtQrText() {
		return pointCameraAtQrText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Scan failed!']")
	private WebElement scanFailedText;

	public WebElement getScanFailedText() {
		return scanFailedText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Could not read the QR code']")
	private WebElement couldNotReadText;

	public WebElement getCouldNotReadText() {
		return couldNotReadText;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Enter serial no.']")
	private WebElement enterSerialNoButton;

	public WebElement getEnterSerialNoButton() {
		return enterSerialNoButton;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Scan again']")
	private WebElement scanAgainButton;

	public WebElement getScanAgainButton() {
		return scanAgainButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/cb_flash")
	private WebElement flashLightButton;

	public WebElement getFlashLightButton() {
		return flashLightButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
