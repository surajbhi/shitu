package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CloudVideoDownPage {

	
	AppiumDriver<WebElement> driver;
	public CloudVideoDownPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement cameraName;

	public WebElement getCameraName() {
		return cameraName;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_status")
	private WebElement cloudIcon;

	public WebElement getCloudIcon() {
		return cloudIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_duration")
	private WebElement videoDuration;

	public WebElement getVideoDuration() {
		return videoDuration;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/cl_video_preview")
	private WebElement videoPreview;

	public WebElement getVideoPreview() {
		return videoPreview;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_timeStamp")
	private WebElement timeStamp;

	public WebElement getTimeStamp() {
		return timeStamp;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_share")
	private WebElement shareIcon;

	public WebElement getShareIcon() {
		return shareIcon;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Download & Share']")
	private WebElement downloadAndShareButton;

	public WebElement getDownloadAndShareButton() {
		return downloadAndShareButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_download")
	private WebElement downloadIcon;

	public WebElement getDownloadIcon() {
		return downloadIcon;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Download']")
	private WebElement downloadButton;

	public WebElement getDownloadButton() {
		return downloadButton;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
