package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class SelectPlanPage {

	AppiumDriver<WebElement> driver;
	public SelectPlanPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id= "com.airtel.xsafe:id/iv_back")
	private WebElement backButton;

	public WebElement getBackButton() {
		return backButton;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_title")
	private WebElement selectPlanTitle;

	public WebElement getSelectPlanTitle() {
		return selectPlanTitle;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_plan_benefits")
	private WebElement allPlanText;

	public WebElement getAllPlanText() {
		return allPlanText;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Monthly']")
	private WebElement monthlyText;

	public WebElement getMonthlyText() {
		return monthlyText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[2]")
	private WebElement monthlyPlanAmount;

	public WebElement getMonthlyPlanAmount() {
		return monthlyPlanAmount;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[3]")
	private WebElement monthlyValidTillText;

	public WebElement getMonthlyValidTillText() {
		return monthlyValidTillText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[4]")
	private WebElement monthlyForDevicesText;

	public WebElement getMonthlyForDevicesText() {
		return monthlyForDevicesText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private WebElement monthlyPriceBreakText;

	public WebElement getMonthlyPriceBreakText() {
		return monthlyPriceBreakText;
	}
	
	@FindBy(xpath= "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.Button")
	private WebElement monthlyPayNow;

	public WebElement getMonthlyPayNow() {
		return monthlyPayNow;
	}
	
	@FindBy(xpath= "//android.widget.TextView[@text='Annual']")
	private WebElement annualText;

	public WebElement getAnnualText() {
		return annualText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_final_price")
			private WebElement annualPlanAmmount;

	public WebElement getAnnualPlanAmmount() {
		return annualPlanAmmount;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_validity")
	private WebElement annualValidTillText;

	public WebElement getAnnualValidTillText() {
		return annualValidTillText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_devices_list")
			private WebElement annualForDevicesText;

	public WebElement getAnnualForDevicesText() {
		return annualForDevicesText;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_price_breakup")
			private WebElement annualPriceBreakText;

	public WebElement getAnnualPriceBreakText() {
		return annualPriceBreakText;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Pay Now']")
	private WebElement annualPayNow;

	public WebElement getAnnualPayNow() {
		return annualPayNow;
	}
	
	@FindBy(id= "com.airtel.xsafe:id/tv_term_con")
	private WebElement privacyPolicyText;

	public WebElement getPrivacyPolicyText() {
		return privacyPolicyText;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
