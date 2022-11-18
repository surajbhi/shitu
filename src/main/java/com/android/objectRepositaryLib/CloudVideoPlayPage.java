package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class CloudVideoPlayPage {

	
	
	AppiumDriver<WebElement> driver;
	public CloudVideoPlayPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement dateTitle;

	public WebElement getDateTitle() throws InterruptedException {
		Thread.sleep(1000);
		return dateTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement videoPlayingIcon;

	public WebElement getVideoPlayingIcon() {
		return videoPlayingIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_play_pause")
	private WebElement playPauseButton;

	public WebElement getPlayPauseButton() {
		return playPauseButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_next")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_prev")
	private WebElement previousButton;

	public WebElement getPreviousButton() {
		return previousButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_more")
	private WebElement moreOPtion;

	public WebElement getMoreOPtion() {
		return moreOPtion;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	private WebElement firstVideo;

	public WebElement getFirstVideo() {
		return firstVideo;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]n")
	private WebElement secondVideo;

	public WebElement getSecondVideo() {
		return secondVideo;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.TextView")
	private WebElement videoDuration;

	public WebElement getVideoDuration() throws InterruptedException {
		Thread.sleep(1000);
		return videoDuration;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_c_duration")
	private WebElement actualDuration;

	public WebElement getActualDuration() {
		return actualDuration;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_t_duration")
	private WebElement expectedDuration;

	public WebElement getExpectedDuration() {
		return expectedDuration;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
