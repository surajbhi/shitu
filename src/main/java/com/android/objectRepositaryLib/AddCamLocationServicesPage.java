package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddCamLocationServicesPage {
	
	AppiumDriver<WebElement> driver;
	public AddCamLocationServicesPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(id= "com.airtel.xsafe:id/indicator")
	private WebElement indicatorBar;

	public WebElement getIndicatorBar() {
		return indicatorBar;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement locationServicesTitle;

	public WebElement getLocationServicesTitle() {
		return locationServicesTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement locationServicesText;

	public WebElement getLocationServicesText() {
		return locationServicesText;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Turn on Location Service']")
	private WebElement turnLocationOnButton;

	public WebElement getTurnLocationOnButton() {
		return turnLocationOnButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	//LOcation Page In Mobile Device
	@FindBy(id= "android:id/checkbox")
	private WebElement checkBox;

	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.Button']")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
