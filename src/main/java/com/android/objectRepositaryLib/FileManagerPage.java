package com.android.objectRepositaryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class FileManagerPage {

	AppiumDriver<WebElement> driver;
	public FileManagerPage(AppiumDriver<WebElement> driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	


	@FindBy(xpath= "//android.widget.TextView[@text='AirtelXSafe']")
	private WebElement airtelXsafeFolder;

	public WebElement getAirtelXsafeFolder() {
		return airtelXsafeFolder;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Edit']")
	private WebElement edit;

	public WebElement getEdit() {
		return edit;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Select all']")
	private WebElement selectAll;

	public WebElement getSelectAll() {
		return selectAll;
	}
	
	@FindBy(id= "com.android.filemanager:id/delete")
	private WebElement delete;

	public WebElement getDelete() {
		return delete;
	}
	
	@FindBy(xpath= "//android.widget.Button[@text='Delete']")
	private WebElement deleteConformation;

	public WebElement getDeleteConformation() {
		return deleteConformation;
	}
	
	@FindBy(id= "com.android.filemanager:id/fileName")
	private WebElement title;

	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(id= "com.android.filemanager:id/fileDetail")
	private WebElement fileDetails;

	public WebElement getFileDetails() {
		return fileDetails;
	}

	
	
	//New File Manager
	@FindBy(id= "com.rhmsoft.fm:id/check_box")
	private WebElement picCheckBox;

	public WebElement getPicCheckBox() {
		return picCheckBox;
	}

	@FindBy(xpath= "//android.widget.TextView[@content-desc=\"Select All/Unselect All\"]")
	private WebElement selectAllPics;

	public WebElement getSelectAllPics() {
		return selectAllPics;
	}
	
	
	@FindBy(id= "//android.widget.TextView[@text='Delete']")
	private WebElement deletePics;

	public WebElement getDeletePics() {
		return deletePics;
	}
	
	@FindBy(id= "android:id/button1")
	private WebElement deletePicsConfirm;

	public WebElement getDeletePicsConfirm() {
		return deletePicsConfirm;
	}
	
	
	
	
	
	
	
	
	
	
	
}
