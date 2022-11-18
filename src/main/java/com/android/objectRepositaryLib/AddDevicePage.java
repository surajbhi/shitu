package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDevicePage {

	AppiumDriver<WebElement> driver;
	public AddDevicePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath= "//android.widget.TextView[@text='ADD A DEVICE']")
	private WebElement addDeviceTitle;

	public WebElement getAddDeviceTitle() {
		return addDeviceTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/scan_device")
	private WebElement scanDevicesQrCodeText;

	public WebElement getScanDevicesQrCodeText() {
		return scanDevicesQrCodeText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Locate QR code']")
	private WebElement locateQrCodeText;

	public WebElement getLocateQrCodeText() {
		return locateQrCodeText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='on your device or startup guide and scan it']")
	private WebElement qrCodeGuideText;

	public WebElement getQrCodeGuideText() {
		return qrCodeGuideText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Enter serial no.']")
	private WebElement enterSerialNoText;

	public WebElement getEnterSerialNoText() {
		return enterSerialNoText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='if the QR code is not available']")
	private WebElement qrCodeNotAvailableText;

	public WebElement getQrCodeNotAvailableText() {
		return qrCodeNotAvailableText;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/btn_start_scan")
	private WebElement startScanButton;

	public WebElement getStartScanButton() {
		return startScanButton;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
