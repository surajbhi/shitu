package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SelectDevSubscPage {



	AppiumDriver<WebElement> driver;
	public SelectDevSubscPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}




	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement selectDevTitle;

	public WebElement getSelectDevTitle() {
		return selectDevTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_close")
	private WebElement closeButton;

	public WebElement getCloseButton() {
		return closeButton;
	}

	@FindBy(id= "com.airtel.xsafe:id/btn_done")
	private WebElement doneButton;

	public WebElement getDoneButton() {
		return doneButton;
	}

































}
