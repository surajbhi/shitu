package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PreLoginpage {

	AppiumDriver<WebElement> driver;
	public PreLoginpage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	@FindBy(id= "com.airtel.xsafe:id/iv_icon")
	private WebElement cloudIcon;

	public WebElement getCloudIcon() {
		return cloudIcon;
	}
		

	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement cloudStorageTitle;

	public WebElement getCloudStorageTitle() {
		return cloudStorageTitle;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/tv_sub_title")
	private WebElement cloudStorageText;

	public WebElement getCloudStorageText() {
		return cloudStorageText;
	}
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_tutorial")
	private WebElement image;

	public WebElement getImage() {
		return image;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_submit")
	private WebElement nextBtn;

	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	



















}
