package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class FilterCameraPage {

	
	AppiumDriver<WebElement> driver;
	public FilterCameraPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement filterTitle;

	public WebElement getFilterTitle() {
		return filterTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/indicator")
	private WebElement indicatorIcon;

	public WebElement getIndicatorIcon() {
		return indicatorIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_camera_name")
	private WebElement cameraText;

	public WebElement getCameraText() {
		return cameraText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_clear")
	private WebElement clearAll;

	public WebElement getClearAll() {
		return clearAll;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement applyButton;

	public WebElement getApplyButton() {
		return applyButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
