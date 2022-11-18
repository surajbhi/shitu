package com.android.objectRepositaryLib;

import java.awt.image.BufferedImage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class AccountTabPage {
	
	AppiumDriver<WebElement> driver;
	public AccountTabPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/title")
	private WebElement accountTitle;

	public WebElement getAccountTitle() {
		return accountTitle;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Subscription Expired']")
	private WebElement subscriptionExpText;

	public WebElement getSubscriptionExpText() {
		return subscriptionExpText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Get a Subscription']")
	private WebElement getSubsText;

	public WebElement getGetSubsText() {
		return getSubsText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_other_info")
	private WebElement yourVideoText;

	public WebElement getYourVideoText() {
		return yourVideoText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_app_version")
	private WebElement versionText;

	public WebElement getVersionText() {
		return versionText;
	}
	
	@FindBy(xpath= "//*[@text='Payment in progress. Please try again after sometime']")
	private WebElement paymentInToastMsg;

	public WebElement getpaymentInToastMsg() {
		return paymentInToastMsg;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")
	private WebElement numOfDevices;

	public WebElement getNumOfDevices() {
		return numOfDevices;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/homeFragment")
	private WebElement homeFragment;

	public WebElement getHomeFragment() {
		return homeFragment;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_cam")
	private WebElement camIcon;

	public BufferedImage getCamIcon() {
		return (BufferedImage) camIcon;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/iv_more")
	private WebElement ManageSubDot;

	public WebElement getManageSubDot() {
		return ManageSubDot;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/btn_positive")
	private WebElement ManageSubButton;

	public WebElement getManageSubButton() {
		return ManageSubButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement ManageSubHeader;

	public WebElement getManageSubHeader() {
		return ManageSubHeader;
	}

	
	@FindBy(id= "com.airtel.xsafe:id/tv_plan_benefits_title")
	private WebElement ManageSubPlanBenefits;

	public WebElement getManageSubPlanBenefits() {
		return ManageSubPlanBenefits;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
