
package com.android.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

/**
 * This class contains webDriver specific generic methods 
 * @author A1Q5SAYJ(PRAKASH)
 */

public class WebDriverUtility {
	
	Logger logg= Logger.getLogger(WebDriverUtility.class);

	/**
	 * This Method wait for 50 sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	/**
	 * This Method wait for the element to visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This Method wait for the element to be clicked, its custom wait created to avoid elementInterceptable Exception
	 * @param element
	 * @throws InterruptedException 
	 * @throws throwable
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<1000) {
			try {
				element.click();
				break;
			} catch (Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}
	}

	/**
	 * This Method eneable user to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void select(WebElement element, String option) {
		Select select= new Select(element);
		select.selectByVisibleText(option);
	}

	/**
	 * This Method eneable user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select select= new Select(element);
		select.selectByIndex(index);
	}


	/**
	 * This Method eneable user to handle dropdown using value
	 * @param element
	 * @param value
	 */
	public void selectValue(WebElement element, String value) {
		Select select= new Select(element);
		select.selectByValue(value);
	}

	/**
	 * This Method used to take schreenshot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable 
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest= new File("/screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}



	/**
	 * This Method wait for the element to be clicked, its custom wait created to avoid elementInterceptable Exception
	 * @param element
	 * @throws InterruptedException 
	 * @throws throwable
	 */
	public void waitAndClick1(WebElement element) throws InterruptedException {
		Thread.sleep(10000);
		int count=0;
		while (count<=10000) {

			if (count==10000) {
				try {

					element.click();
				}
				catch (Exception e) {

					e.printStackTrace();
				}
			}
			count++;

		}
	}
	
	
	/**
	 * This Method wait for the element to be clicked, its custom wait created to avoid elementInterceptable Exception
	 * @param element
	 * @throws InterruptedException 
	 * @throws throwable
	 */
	public void waitAndClick500(WebElement element) throws InterruptedException {
		Thread.sleep(10000);
		int count=0;
		while (count<=1000) {

			if (count==1000) {
				try {

					element.click();
				}
				catch (Exception e) {

					e.printStackTrace();
				}
			}
			count++;

		}
	}
	
	
	
	/**
	 * This Method wait for the element to be find, its custom wait created to avoid staleElementReferenceException Exception
	 * @param element
	 * @param key
	 * @throws InterruptedException 
	 * @throws throwable
	 */
	public void waitAndSendKeys(WebElement element, String key) throws InterruptedException {
		Thread.sleep(1000);
		int count=0;
		while (count<=10000) {

			if (count==10000) {
				try {

					element.sendKeys(key);
				}
				catch (Exception e) {

					e.printStackTrace();
				}
			}
			count++;

		}
	}

	/**
	 * This Method wait for the element to be select and get that exact text of that element.
	 * @param element
	 * @return 
	 * @throws InterruptedException 
	 */
	public void waitAndGetText(WebElement element) throws InterruptedException {
		Thread.sleep(10000);
		int count=0;
		while (count<=1000) {

			if (count==1000) {
				try {

					logg.info(element.getText());
					
				}
				catch (Exception e) {

					e.printStackTrace();
				}
			}
			count++;

		}
		
	}
	
	/**
	 * This Method is used for wait and assert the element with actual text of that element.
	 * @param element
	 * @throws InterruptedException 
	 */
	public void assertion(String Actual, WebElement ExpectedElement) throws InterruptedException {
		
	Thread.sleep(5000);	
	Assert.assertEquals(Actual, ExpectedElement.getText());
	
	}


	/**
	 * This Method is used for validate element is present in that page or not
	 * @param element
	 */
	public void elementPresentOrNot( WebElement element, String Yes, String No) {
		
		
		try {
			element.isEnabled();
			logg.info(Yes);
			
		} catch (Exception e) {
			logg.info(No);
		}
		
	}

	/**
	 * This Method is used for Take the screenshot.
	 * @param element
	 * @return Expected
	 * @throws IOException 
	 */
	public Object takeExpectedScreenshot(WebElement ExpectedElement ) throws IOException {
		
		
		File Expected = ExpectedElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Expected, new File("./AshotImages/icon1.png"));
		return Expected;
		
	}

	/**
	 * This Method is used for compare the screenshots
	 * @param element
	 * @throws IOException 
	 */
	
	public void screenshotComparision( WebElement ActualElement,  Object expected, String ssname) throws IOException {
		
		
		File Actual = ActualElement.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Actual, new File("./AshotImages/"+ssname+".png"));
		
		if(Actual.equals(expected)) {
			logg.info("Same Icon");
		}else {
			
			logg.info("Icon is Not Same ");
		}	
	}


	

	






























}
