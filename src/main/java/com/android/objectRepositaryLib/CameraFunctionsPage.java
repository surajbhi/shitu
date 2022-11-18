package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CameraFunctionsPage {

	AppiumDriver<WebElement> driver;
	public CameraFunctionsPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cancel")
	private WebElement cancelButton;

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_setting")
	private WebElement settingsButton;

	public WebElement getSettingsButton() {
		return settingsButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/surface_live")
	private WebElement liveScreen;

	public WebElement getLiveScreen() {
		return liveScreen;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/mcv_player")
	private WebElement liveScreen1;

	public WebElement getLiveScreen1() {
		return liveScreen1;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/dragId")
	private WebElement dateTime;

	public WebElement getDateTime() {
		return dateTime;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/progressBar")
	private WebElement progressBar;

	public WebElement getProgressBar() {
		return progressBar;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/fl_enter_full")
	private WebElement fullScreen;

	public WebElement getFullScreen() throws InterruptedException {
		Thread.sleep(2000);
		return fullScreen;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_mode")
	private WebElement modeIcon;

	public WebElement getModeIcon() {
		return modeIcon;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_play_pause")
	private WebElement playPauseButton;

	public WebElement getPlayPauseButton() {
		return playPauseButton;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_record")
	private WebElement recordButton;

	public WebElement getRecordButton() {
		return recordButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_photo")
	private WebElement photoButton;

	public WebElement getPhotoButton() {
		return photoButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_mic")
	private WebElement micButton;

	public WebElement getMicButton() {
		return micButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_sound")
	private WebElement soundButton;

	public WebElement getSoundButton() {
		return soundButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_other")
	private WebElement privacyOff;

	public WebElement getPrivacyOff() {
		return privacyOff;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_tracking")
	private WebElement trackingOff;

	public WebElement getTrackingOff() {
		return trackingOff;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_quality")
	private WebElement qualityButton;

	public WebElement getQualityButton() {
		return qualityButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_today_title")
	private WebElement todayTitle;

	public WebElement getTodayTitle() {
		return todayTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_today_no")
	private WebElement todayTitleNum;

	public WebElement getTodayTitleNum() {
		return todayTitleNum;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Wake Up']")
	private WebElement wakeUpText;

	public WebElement getWakeUpText() {
		return wakeUpText;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
