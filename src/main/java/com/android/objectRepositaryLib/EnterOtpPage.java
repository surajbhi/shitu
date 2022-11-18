package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class EnterOtpPage extends BaseClasss{

	AppiumDriver<WebElement> driver;
	public EnterOtpPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_detectingOtp")
	private WebElement detectingOtp;

	public WebElement getDetectingOtp() {
		return detectingOtp;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement otpSentTo;

	public WebElement getOtpSentTo() throws InterruptedException {
		Thread.sleep(1000);
		return otpSentTo;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/til")
	private WebElement otpText;

	public WebElement getOtpText() {
		return otpText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/textinput_placeholder")
	private WebElement enterOtpPlaceHolder;

	public WebElement getEnterOtpPlaceHolder() {
		return enterOtpPlaceHolder;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton(String sheetName, int rowNum, int cellValue) throws Throwable {
		sendKeyButton.sendKeys(eLib.getDataFromExcel(sheetName, rowNum, cellValue));
		return sendKeyButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/text_input_end_icon")
	private WebElement textEraseIcon;

	public WebElement getTextEraseIcon() {
		return textEraseIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_continue")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_resend_otp")
	private WebElement resendOtpButton;

	public WebElement getResendOtpButton() {
		return resendOtpButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/til_error")
	private WebElement incorrectOtpText;

	public WebElement getIncorrectOtpText() {
		return incorrectOtpText;
	}



























}
