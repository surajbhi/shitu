package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class EnterMobNumPage extends BaseClasss {

	AppiumDriver<WebElement> driver;
	public EnterMobNumPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement helloTitle;

	public WebElement getHelloTitle() {
		return helloTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement loginTextMobNum;

	public WebElement getLoginTextMobNum() {
		return loginTextMobNum;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/til")
	private WebElement mobileNO;

	public WebElement getMobileNO() {
		return mobileNO;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/textinput_placeholder")
	private WebElement enterMobNumPlaceHolder;

	public WebElement getEnterMobNumPlaceHolder() {
		return enterMobNumPlaceHolder;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton(String sheetName, int rowNum, int cellValue) throws Throwable {
		sendKeyButton.sendKeys(eLib.getDataFromExcel(sheetName, rowNum, cellValue));
		return sendKeyButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton1;

	public WebElement getSendKeyButton1() throws Throwable {
		
		return sendKeyButton1;
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
