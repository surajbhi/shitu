package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CameraAddedPage {

	AppiumDriver<WebElement> driver;
	public CameraAddedPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement cameraAddedTitle;

	public WebElement getCameraAddedTitle() {
		return cameraAddedTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_select_camName")
	private WebElement cameraNameTitle;

	public WebElement getCameraNameTitle() {
		return cameraNameTitle;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='+']")
	private WebElement pluseIcon;

	public WebElement getPluseIcon() {
		return pluseIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() throws InterruptedException {
		Thread.sleep(3000);
		return doneButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
