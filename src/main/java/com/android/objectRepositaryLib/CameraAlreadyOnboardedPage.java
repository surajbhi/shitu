package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CameraAlreadyOnboardedPage {

	AppiumDriver<WebElement> driver;
	public CameraAlreadyOnboardedPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}





	@FindBy(id= "com.airtel.xsafe:id/iv_error")
	private WebElement errorIcon;

	public WebElement getErrorIcon() {
		return errorIcon;
	}

	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement cameraAlreadyOnboardedTitle;

	public WebElement getCameraAlreadyOnboardedTitle() {
		return cameraAlreadyOnboardedTitle;
	}

	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement cameraAlreadyOnboardedText;

	public WebElement getCameraAlreadyOnboardedText() {
		return cameraAlreadyOnboardedText;
	}

	@FindBy(xpath= "//android.widget.Button[@text='Scan another Camera']")
	private WebElement scanAnotherCamButton;

	public WebElement getScanAnotherCamButton() {
		return scanAnotherCamButton;
	}

	@FindBy(xpath= "//android.widget.Button[@text='Go to Home']")
	private WebElement goToHomeButton;

	public WebElement getGoToHomeButton() {
		return goToHomeButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

}
