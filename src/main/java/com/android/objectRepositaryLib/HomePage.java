package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class HomePage {

	
	public HomePage(AppiumDriver<WebElement> driver) {
		PageFactory.initElements(driver, this);
	}


	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement xsafeLogo;

	public WebElement getXsafeLogo() {
		return xsafeLogo;
	}


	@FindBy(id= "com.airtel.xsafe:id/iv_add_device")
	private WebElement addDevice;

	public WebElement getAddDevice() {
		return addDevice;
	}


	@FindBy(id= "com.airtel.xsafe:id/toolbar_title")
	private WebElement camerasTitle;

	public WebElement getCamerasTitle() {
		return camerasTitle;
	}


	@FindBy(id= "com.airtel.xsafe:id/switch_layout")
	private WebElement verticalCamButton;

	public WebElement getVerticalCamButton() {
		return verticalCamButton;
	}


	@FindBy(id= "com.airtel.xsafe:id/play_pause")
	private WebElement playPauseButton;

	public WebElement getPlayPauseButton() {
		return playPauseButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_full")
	private WebElement fullScreenIcon;

	public WebElement getFullScreenIcon() {
		return fullScreenIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_bg")
	private WebElement liveCamera;

	public WebElement getLiveCamera() {
		return liveCamera;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/homeFragment")
	private WebElement homeFragment;

	public WebElement getHomeFragment() {
		return homeFragment;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/videosFragment")
	private WebElement videosFragment;

	public WebElement getVideosFragment() {
		return videosFragment;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/accountFragment")
	private WebElement accountFragment;

	public WebElement getAccountFragment() {
		return accountFragment;
	}
























}
