package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class VideoPlayerAppPage {
	
	AppiumDriver<WebElement> driver;
	public VideoPlayerAppPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	


	@FindBy(id= "uplayer.video.player:id/img_menu")
	private WebElement menu;

	public WebElement getMenu() {
		return menu;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Delete']")
	private WebElement delete;

	public WebElement getDelete() {
		return delete;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='OK']")
	private WebElement ok;

	public WebElement getOk() {
		return ok;
	}
	
	@FindBy(id= "uplayer.video.player:id/txt_title")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "uplayer.video.player:id/txt_size")
	private WebElement size;

	public WebElement getSize() {
		return size;
	}
	
	@FindBy(id= "uplayer.video.player:id/txt_resolution")
	private WebElement resolution;

	public WebElement getResolution() {
		return resolution;
	}
	
	@FindBy(id= "uplayer.video.player:id/txt_duration")
	private WebElement duration;

	public WebElement getDuration() {
		return duration;
	}
	
	@FindBy(id= "uplayer.video.player:id/txt_count")
	private WebElement textCount;

	public WebElement getTextCount() {
		return textCount;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
