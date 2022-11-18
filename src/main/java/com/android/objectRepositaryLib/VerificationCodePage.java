package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class VerificationCodePage extends BaseClasss{

	public VerificationCodePage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement vcTitle;

	public WebElement getVcTitle() {
		return vcTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton(String sheetName, int rowNum, int cellValue) throws Throwable{
		Thread.sleep(1000);
		sendKeyButton.sendKeys(eLib.getDataFromExcel(sheetName, rowNum, cellValue));
		return sendKeyButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement verifyNow;

	public WebElement getVerifyNow() {
		return verifyNow;
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Skip for Now']")
	private WebElement skipForNow;

	public WebElement getSkipForNow() {
		return skipForNow;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Suja Sticky']")
	private WebElement stickySuja;

	public WebElement getStickySuja() {
		return stickySuja;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Sunayana']")
	private WebElement sunayana;

	public WebElement getSunayana() {
		return sunayana;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/til_error")
	private WebElement ivalidCodeError;

	public WebElement getiValidCodeError() {
		return ivalidCodeError;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
