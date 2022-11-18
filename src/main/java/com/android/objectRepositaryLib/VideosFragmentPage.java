package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class VideosFragmentPage {

	AppiumDriver<WebElement> driver;
	public VideosFragmentPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement videosTitle;

	public WebElement getVideosTitle() {
		return videosTitle;
	}

	@FindBy(id= "com.airtel.xsafe:id/iv_filter")
	private WebElement filter;

	public WebElement getFilter() {
		return filter;
	}

	@FindBy(id= "com.airtel.xsafe:id/cg_filter")
	private WebElement filteredCamera;

	public WebElement getFilteredCamera() {
		return filteredCamera;
	}

	@FindBy(id= "com.airtel.xsafe:id/fl_more_data")
	private WebElement moreData;

	public WebElement getMoreData() {
		return moreData;
	}

	@FindBy(id= "com.airtel.xsafe:id/tv_today_title")
	private WebElement todayDate;

	public WebElement getTodayDate() {
		return todayDate;
	}

	@FindBy(id= "com.airtel.xsafe:id/tv_today_no")
	private WebElement todayVideoCount;

	public WebElement getTodayVideoCount() {
		return todayVideoCount;
	}

	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]")
	private WebElement date;

	public WebElement getDate() {
		return date;
	}

	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView[2]" )
	private WebElement dateText;

	public WebElement getDateText() {
		return dateText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView[1]")
	private WebElement dayText;

	public WebElement getDayText() {
		return dayText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView"  )
	private WebElement downloadVideo;

	public WebElement getDownloadVideo() {
		return downloadVideo;
	}

	@FindBy(xpath= "//android.widget.TextView[@text='No Videos recorded']")
	private WebElement noVideoRecText;

	public WebElement getNoVideoRecText() throws InterruptedException {
		Thread.sleep(2000);
		return noVideoRecText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
	private WebElement dateAndDaySelect;

	public WebElement getDateAndDaySelect() {
		return dateAndDaySelect;
	}

	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup")
	private WebElement videoPlay;

	public WebElement getVideoPlay() {
		return videoPlay;
	}

	@FindBy(id= "com.airtel.xsafe:id/tv_cam_name")
	private WebElement listOfVideosCamName;

	public WebElement getListOfVideosCamName() {
		return listOfVideosCamName;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/homeFragment")
	private WebElement homeFragment;

	public WebElement getHomeFragment() {
		return homeFragment;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/accountFragment")
	private WebElement accountFragment;

	public WebElement getAccountFragment() {
		return accountFragment;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView[1]")
	private WebElement latestVideoTime;

	public WebElement getLatestVideoTime() {
		return latestVideoTime;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
	private WebElement latestVideoDuration;

	public WebElement getLatestVideoDuration() {
		return latestVideoDuration;
	}

	































}
