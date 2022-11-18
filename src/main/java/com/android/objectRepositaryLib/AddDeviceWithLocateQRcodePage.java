package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AddDeviceWithLocateQRcodePage {

	AppiumDriver<WebElement> driver;
	public AddDeviceWithLocateQRcodePage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement locateQrCodeTitle;

	public WebElement getLocateQrCodeTitle() {
		return locateQrCodeTitle;
	}


	@FindBy(id= "com.airtel.xsafe:id/sub_title")
	private WebElement selectYourDeviceText;

	public WebElement getSelectYourDeviceText() {
		return selectYourDeviceText;
	}


	@FindBy(id= "com.airtel.xsafe:id/camera_rcv")
	private WebElement cameraModelImages;

	public WebElement getCameraModelImages() {
		return cameraModelImages;
	}

	@FindBy(id= "com.airtel.xsafe:id/cancel")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView")
	private WebElement stickyCam;

	public WebElement getStickyCam() {
		return stickyCam;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.ImageView")
	private WebElement threeSixtyCam;

	public WebElement getThreeSixtyCam() {
		return threeSixtyCam;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.ImageView")
	private WebElement activeDefenceCam;

	public WebElement getActiveDefenceCam() {
		return activeDefenceCam;
	}
	
	





























}
