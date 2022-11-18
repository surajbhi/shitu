package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class VideoQualityPage {

	AppiumDriver<WebElement> driver;
	public VideoQualityPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath= "//android.widget.RadioButton[@text='Auto (set automatically)']")
	private WebElement autoButton;

	public WebElement getAutoButton() {
		return autoButton;
	}

	@FindBy(xpath= "//android.widget.RadioButton[@text='Low (SD)']")
	private WebElement lowButton;

	public WebElement getLowButton() {
		return lowButton;
	}

	@FindBy(xpath= "//android.widget.RadioButton[@text='Medium (HD)']")
	private WebElement mediumButton;

	public WebElement getMediumButton() {
		return mediumButton;
	}

	@FindBy(xpath= "//android.widget.RadioButton[@text='High (UHD)']")
	private WebElement highButton;

	public WebElement getHighButton() {
		return highButton;
	}

	@FindBy(xpath= "//android.widget.TextView[@text='Video Quality']")
	private WebElement videoQualityTitle;

	public WebElement getVideoQualityTitle() {
		return videoQualityTitle;
	}



	public String radioButton(AppiumDriver<WebElement> driver, String quality) {

		driver.findElementByXPath("//android.widget.RadioButton[@text='\""+quality+"\"']").click();
		return quality;

	}

}















