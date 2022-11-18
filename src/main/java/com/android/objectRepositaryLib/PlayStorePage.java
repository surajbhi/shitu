package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class PlayStorePage extends BaseClasss{


	public PlayStorePage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}




	@FindBy(xpath= "//android.widget.EditText[@text='Search for apps & games']")
	private WebElement sendKeys;

	public WebElement getSendKeys(String sheetName, int rowNum, int cellValue) throws Throwable {
		sendKeys.sendKeys(eLib.getDataFromExcel(sheetName, rowNum, cellValue));
		return sendKeys;
	}

	@FindBy(xpath= "//android.widget.TextView[@text='Airtel Xsafe']")
	private WebElement appClick;

	public WebElement getAppClick() {
		appClick.click();
		return appClick;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Install']")
	private WebElement installButton;

	public WebElement getInstallButton() {
		installButton.click();
		return installButton;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Open']")
	private WebElement openApp;

	public WebElement getOpenApp() {
		openApp.click();
		return openApp;
	}
	
	
	

























}
