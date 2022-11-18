package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AboutCameraPage {

	AppiumDriver<WebElement> driver;
	public AboutCameraPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	private WebElement cameraModelTitle;

	public WebElement getCameraModelTitle() {
		return cameraModelTitle;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Verification Code']")
	private WebElement verificationCode;

	public WebElement getVerificationCode() {
		return verificationCode;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_cb")
	private WebElement showVerificationCode;

	public WebElement getShowVerificationCode() {
		return showVerificationCode;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_firm_version")
	private WebElement firmWare;

	public WebElement getFirmWare() {
		return firmWare;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_update")
	private WebElement firmWareUpdate;

	public WebElement getFirmWareUpdate() {
		return firmWareUpdate;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_serial_version")
	private WebElement serialNo;

	public WebElement getSerialNo() {
		return serialNo;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_model_version")
	private WebElement cameraModel;

	public WebElement getCameraModel() {
		return cameraModel;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_delete")
	private WebElement deleteDevice;

	public WebElement getDeleteDevice() {
		return deleteDevice;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() {
		return doneButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
