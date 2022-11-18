package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class EnterDisplayNamePage extends BaseClasss {

	AppiumDriver<WebElement> driver;
	public EnterDisplayNamePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement titleText;

	public WebElement getTitleText() {
		return titleText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/til")
	private WebElement displayName;

	public WebElement getDisplayName() {
		return displayName;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/textinput_placeholder")
	private WebElement enterOtpPlaceHolder;

	public WebElement getEnterOtpPlaceHolder() {
		return enterOtpPlaceHolder;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_hint")
	private WebElement hintText;

	public WebElement getHintText() {
		return hintText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton(String sheetName, int rowNum, int cellValue) throws Throwable{
		Thread.sleep(2000);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
