package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDeviceWithSerialNumPage {

	AppiumDriver<WebElement> driver;
	public AddDeviceWithSerialNumPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id= "com.airtel.xsafe:id/device_progress")
	private WebElement deviceProgressBar;

	public WebElement getDeviceProgressBar() {
		return deviceProgressBar;
	}

	@FindBy(id= "com.airtel.xsafe:id/img_section")
	private WebElement imageSectionIcon;

	public WebElement getImageSectionIcon() {
		return imageSectionIcon;
	}


	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement deviceSerialNoTitle;

	public WebElement getDeviceSerialNoTitle() {
		return deviceSerialNoTitle;
	}

	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement enterSlNoAndVerficationCodeText;

	public WebElement getEnterSlNoAndVerficationCodeText() {
		return enterSlNoAndVerficationCodeText;
	}

	@FindBy(xpath= "//android.widget.EditText[@text='Serial No.']")
	private WebElement serialNumPlaceHolder;

	public WebElement getSerialNumPlaceHolder() {
		return serialNumPlaceHolder;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement serialNumTextBox;

	public WebElement getSerialNumTextBox() {
		return serialNumTextBox;
	}
	
	@FindBy(xpath= "//android.widget.EditText[@text='Verification Code']")
	private WebElement verificationCodePlaceHolder;

	public WebElement getVerificationCodePlaceHolder() {
		return verificationCodePlaceHolder;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement verificationCodeTextBox;

	public WebElement getVerificationCodeTextBox() {
		return verificationCodeTextBox;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() {
		return doneButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/til_error")
	private WebElement invalidVerificationCodeText;

	public WebElement getInvalidVerificationCodeText() {
		return invalidVerificationCodeText;
	}

	@FindBy(id= "com.airtel.xsafe:id/cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}

























}
