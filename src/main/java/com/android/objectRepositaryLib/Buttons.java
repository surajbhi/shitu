package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.android.genericLibrary.BaseClasss;

import io.appium.java_client.AppiumDriver;

public class Buttons extends BaseClasss{

	AppiumDriver<WebElement> driver;
	public Buttons(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(id= "com.airtel.xsafe:id/btn_submit")
	private WebElement submitButton;

	public WebElement getSubmitButton() {
		return submitButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/tie")
	private WebElement sendKeyButton;

	public WebElement getSendKeyButton(String sheetName, int rowNum, int cellValue) throws Throwable{
		sendKeyButton.sendKeys(eLib.getDataFromExcel(sheetName, rowNum, cellValue));
		return sendKeyButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/btn_continue")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/btn_negative")
	private WebElement negativeButton;

	public WebElement getNegativeButton() {
		negativeButton.click();
		return negativeButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement positiveButton;

	public WebElement getPositiveButton() {
		positiveButton.click();
		return positiveButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/switch_layout")
	private WebElement verticalCamButton;

	public WebElement getVerticalCamButton() {
		verticalCamButton.click();
		return verticalCamButton;
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


	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() {
		doneButton.click();
		return doneButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/btn_save")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		saveButton.click();
		return saveButton;
	}
	
	@FindBy(id= "com.android.systemui:id/btn_dismiss")
	private WebElement dismissButton;

	public WebElement getDismissButton() {
		return dismissButton;
	}

	@FindBy(id= "com.android.packageinstaller:id/permission_allow_button")
	private WebElement permissionAllowButton;

	public WebElement getPermissionAllowButton() {
		return permissionAllowButton;
	}

	@FindBy(id= "com.android.packageinstaller:id/permission_deny_button")
	private WebElement permissionDenyButton;

	public WebElement getPermissionDenyButton() {
		permissionDenyButton.click();
		return permissionDenyButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/iv_bg")
	private WebElement liveCamera;

	public WebElement getLiveCamera() {
		liveCamera.click();
		return liveCamera;
	}










}
