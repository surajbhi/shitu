package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PermissionAllowAndDenyPage {

	AppiumDriver<WebElement> driver;
	public PermissionAllowAndDenyPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.android.packageinstaller:id/permission_allow_button")
	private WebElement permissionAllowButton;

	public WebElement getPermissionAllowButton() {
		return permissionAllowButton;
	}
	
	@FindBy(id= "com.android.packageinstaller:id/permission_deny_button")
	private WebElement permissionDenyButton;

	public WebElement getPermissionDenyButton() {
		return permissionDenyButton;
	}
	
	@FindBy(id= "com.android.packageinstaller:id/permission_message")
	private WebElement permissionText;

	public WebElement getPermissionText() {
		return permissionText;
	}
	
	@FindBy(id= "com.android.packageinstaller:id/permission_icon")
	private WebElement permissionIcon;

	public WebElement getPermissionIcon() {
		return permissionIcon;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
