package com.android.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClasss {


	/*Creating Logger */
	protected static Logger logg= Logger.getLogger(BaseClasss.class);

	public static AppiumDriver<WebElement> driver;

	/*Object Creation for Genric Utils*/
	public JavaUtility          jLib = new JavaUtility();
	public WebDriverUtility     wLib = new WebDriverUtility();
	public AndroidDriverUtility aLib = new AndroidDriverUtility();
	public FileUtility          fLib = new FileUtility();
	public ExcelUtility         eLib = new ExcelUtility();


	public boolean checkIfServerIsRunning(int port) {
		boolean isServerIsRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (Exception e) {

			isServerIsRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerIsRunning;
	}

	public void startServer() {
		org.apache.commons.exec.CommandLine cmd= new org.apache.commons.exec.CommandLine("C:\\\\Program Files\\\\nodejs\\\\node.exe");
		cmd.addArgument("C:\\Users\\A1Q5SAYJ\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");

		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executer= new DefaultExecutor();
		executer.setExitValue(1);

		try {
			executer.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void stopServer() {
		Runtime runtime= Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void configBS() {
		logg.info("======connect to DB======");
	}

	@BeforeClass
	public void configBC() throws Throwable {

		//Common Desired capabilities of our device.
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,        eLib.getDataFromExcel("DesiredCapabilities", 1, 1));
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,      eLib.getDataFromExcel("DesiredCapabilities", 2, 1));	
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,      eLib.getDataFromExcel("DesiredCapabilities", 3, 1));
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,      eLib.getDataFromExcel("DesiredCapabilities", 4, 1));
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,    eLib.getDataFromExcel("DesiredCapabilities", 5, 1));
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,eLib.getDataFromExcelNum("DesiredCapabilities", 6, 1));
		dc.setCapability(MobileCapabilityType.NO_RESET,           eLib.getDataFromExcelBoolean("DesiredCapabilities", 7, 1));
		dc.setCapability(MobileCapabilityType.FULL_RESET,         eLib.getDataFromExcelBoolean("DesiredCapabilities", 8, 1));
		dc.setCapability("autoGrantPermissions","true");
		
		/*Xsafe App package and App Activity*/
		dc.setCapability("appPackage",fLib.getPropertyKeyValue("XsafeAppPackage"));
		dc.setCapability("appActivity",fLib.getPropertyKeyValue("XsafeAppActivity"));

		if(checkIfServerIsRunning(4723)) {
			stopServer();		
		}
		startServer();
		driver= new AndroidDriver<WebElement>(new URL(fLib.getPropertyKeyValue("XsafeURL")),dc);
		wLib.waitUntilPageLoad(driver);
		logg.info("Server started successfully");

	/*	//  UnInstall The App
		driver.removeApp(fLib.getPropertyKeyValue("XsafeAppPackage"));
		logg.info("App uninstalled");

		//Install app
		driver.installApp(fLib.getPropertyKeyValue("XsafeAPP"));
	*/	logg.info("App Installed Successfully");

	}

	@BeforeMethod
	public void configBM() throws Throwable {

		//Launch App
		driver.launchApp();
		logg.info("Application Launched Successfully");
		
	}

	@AfterMethod
	public void configAM() throws Throwable {
		
		logg.info("Logout Successfully");
		System.out.println("=============================================================================================================================================================");

	}

	@AfterClass
	public void configAC() throws Exception {
		//driver.quit();
		//stopServer();
		logg.info("Closing the server and driver");
		
		
	}

	@AfterSuite
	public void configAS() {
		logg.info("======close DB======");
	}

	/**
	 * This method will take screenshot of failed test case
	 * @return 
	 * @return 
	 */
	public static String getScreenshot(String s) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./"+ "/Screenshots/"+s+".png"); 
		FileUtils.copyFile(src, dest);
		logg.info("Screenshot Sucessfully captured!!!");
		return s;

	}

}
