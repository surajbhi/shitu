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

import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClassForBrowserStack {

	public static String userName = "sumitkumar95";
	public static String accessKey = "6Ry66KbswRx3aQpid1Ap";

	/*Creating Logger */
	protected Logger logg= Logger.getLogger(BaseClassForSanityTest.class);

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

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserstack.user", "sumitkumar95");
		caps.setCapability("browserstack.key", "6Ry66KbswRx3aQpid1Ap");

		caps.setCapability("app", "bs://26767da7f43ec7b086a69dd4d0c4a342f9d12f13");

		caps.setCapability("device", "Samsung Galaxy S8 Plus");
		caps.setCapability("os_version", "7.0");

		caps.setCapability("project", "My First Project");
		caps.setCapability("build", "My First Build");
		caps.setCapability("name", "Bstack-[Java] Sample Test");


		driver = new AndroidDriver<WebElement>(new URL("https://hub.browserstack.com/wd/hub"), caps);


		wLib.waitUntilPageLoad(driver);
		logg.info("Server started successfully");

		/*	//UnInstall The App
		driver.removeApp(fLib.getPropertyKeyValue("XsafeAppPackage"));
		logg.info("App uninstalled");

		//Install app
		driver.installApp(fLib.getPropertyKeyValue("XsafeAPP"));
		 */  logg.info("App Installed Successfully");

	}

	@BeforeMethod
	public void configBM() throws Throwable {

		//Launch App
		driver.launchApp();
		logg.info("Application Launched Successfully");

		wLib.waitUntilPageLoad(driver);

		//Next		
		FirstPage fp= new FirstPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 1, 1), fp.getCloudStorageText());
		fp.getNextButton().click();

		SecondPage secp = new SecondPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 2, 1), secp.getCloudStorageText());
		secp.getNextButton().click();

		ThirdPage tp = new ThirdPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 3, 1), tp.getCloudStorageText());
		tp.getNextButton().click();

		//Enter your Mobile Number.
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();
		logg.info("Mobile number successfully entered");

		//Enter OTP	
		/*Invalid OTP*/
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 1, 3);
		eop.getContinueButton().click();
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 2), eop.getIncorrectOtpText());
		logg.warn(eop.getIncorrectOtpText().getText());
		eop.getResendOtpButton().click();

		//valid OTP
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 1, 1);
		eop.getContinueButton().click();
		logg.info("OTP successfully entered");

		//Enter your Display name.	
		EnterDisplayNamePage ednp = new EnterDisplayNamePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 6, 1), ednp.getTitleText());
		ednp.getSendKeyButton("MobileNumbers", 1, 2);
		ednp.getContinueButton().click();
		logg.info("Display name entered");

		//Skip for Now
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSkipForNow().click();

		//Cancel 
		Buttons btn = new Buttons(driver);
		wLib.waitAndClick(btn.getCancelButton());
		wLib.waitAndClick(btn.getCancelButton());

		//camera vertical list
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.warn("Vertical Camera List Element not there in Home page");
		}

	}

	@AfterMethod
	public void configAM() throws Throwable {
		logg.info("Logout Successfully");
		System.out.println("=========================================================================================================================================================");
	}

	@AfterClass
	public void configAC() {
		driver.quit();
		stopServer();
		logg.info("Closing the server and driver");
	}

	@AfterSuite
	public void configAS() {
		logg.info("======close DB======");
	}

	/**
	 * This method will take screenshot of failed test case
	 * @return 
	 */
	public static void getScreenshot(String s) throws IOException {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./"+ "/Screenshots/"+s+".png"); 
		FileUtils.copyFile(src, dest);
		System.out.println("Sucessfully captured!!!");

	}



}
