package com.android.genericLibrary;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/**
 * This class contains AndroidDriver specific generic methods 
 * @author A1Q5SAYJ(PRAKASH)
 */

public class AndroidDriverUtility {

	/**
	 * This Method for scroll and find the element and click that element.
	 * @param element
	 * @param driver
	 * @param exactText
	 * @return exactText
	 */
	public String findScrollable(AppiumDriver<WebElement> driver, String exactText) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""+exactText+"\").instance(0))")).click();
		return exactText;
	}

	/**
	 * This Method for scroll and find the element and send the given text from user.
	 * @param element
	 * @param driver
	 * @param exactText
	 * @return exactText
	 */
	public String findScrollableGetText(AppiumDriver<WebElement> driver, String exactText) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\""+exactText+"\").instance(0))")).getText();
		return exactText;
	}

	/**
	 * This Method for jump the app to app.
	 * @param element
	 * @param driver
	 * @param appPackage
	 * @param appActivity
	 */
	public void startActivity(AndroidDriver<WebElement> driver, String appPackage, String appActivity) {
		Activity activity = new Activity(appPackage,appActivity);
		driver.startActivity(activity);
	}

	/**
	 * This Method for scroll/swipe the element.
	 * @param element
	 * @param driver
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("rawtypes")
	public void touchAction(AppiumDriver<WebElement> driver, int startx, int starty, int endx, int endy) throws InterruptedException {
		TouchAction t= new TouchAction(driver);	
		Thread.sleep(5000);
		t.press(PointOption.point(startx, starty))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(endx, endy))
		.release().perform();
	}

	/**
	 * This Method for single tap the element by its coordinates.
	 * @param element
	 * @param driver
	 * @param x
	 * @param y
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("rawtypes")
	public void tapByCoordinates(AppiumDriver<WebElement> driver, int x, int y) throws InterruptedException {
		TouchAction t= new TouchAction(driver);	
		Thread.sleep(2000);
		t.tap(PointOption.point(x,y)).perform();
	}

	/**
	 * This Method for Assert the toast messages we get i our app.
	 * @param expectText
	 * @param driver
	 */
	public void toastAssert(AppiumDriver<WebElement> driver, String expectText) {
		
		String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		Assert.assertEquals(expectText, toastMessage);//Actual validation
	}




























}