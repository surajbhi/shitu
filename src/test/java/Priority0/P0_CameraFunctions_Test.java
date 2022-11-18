package Priority0;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraFunctionsPage;
import com.android.objectRepositaryLib.CoachMarkPage;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FileManagerPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.SettingsPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;
import com.android.objectRepositaryLib.VideoPlayerAppPage;
import com.android.objectRepositaryLib.VideoQualityPage;

import io.appium.java_client.android.AndroidDriver;

/*
 * In this below class we are going to test Functions of cameras are working well or not.
 * */

public class P0_CameraFunctions_Test extends BaseClasss {


	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This Method contains all the common codes for this class
		 * */

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
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 3, 1);
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

		//Cancel coach mark 
		CoachMarkPage cmp= new CoachMarkPage(driver);
		wLib.waitAndClick(cmp.getCancelButton());
		wLib.waitAndClick(cmp.getCancelButton());


		//vertical cam list.
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.warn("Vertical Camera List Element not there in Home page");
		}


	}


	//====================================================================================================================================//

	@Test(priority = 1)
	public void invalidVerificationCodeTest() throws InterruptedException, Throwable {

		/*
		 * This method is validate incorrect verification code for camera serial number.
		 * */

		commonCode();

		//Select Camera for Validate 

		VerificationCodePage vcp = new VerificationCodePage(driver);
		if(true) {

			String actual = aLib.findScrollableGetText(driver, eLib.getDataFromExcel("CameraNames", 4, 0));

			if(actual.equals(eLib.getDataFromExcel("CameraNames", 4, 0))) {
				aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
				vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 7, 2);
				driver.hideKeyboard();
				logg.info(vcp.getiValidCodeError().getText());

			}
			else {
				aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 2, 0));
				vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 3, 2);
				driver.hideKeyboard();
				logg.info(vcp.getiValidCodeError().getText());
			}
		}
		logg.info("Invalid Verification Code Testing is done");

	}

	//====================================================================================================================================//


	@Test(priority = 2)
	public void cameraControlsTest() throws InterruptedException, Throwable {


		/*
		 * This method is used for validate all the controls of our camera in camera functions page.
		 * */

		commonCode();		

		//Select camera for Do functions
		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		
		String cam =vcp.getSunayana().getText();
		if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		}else {
			logg.warn("Camera Not found");
		}
		vcp.getVerifyNow().click();

		//Home Page
		HomePage hp = new HomePage(driver);
		hp.getLiveCamera().click();

		//Camera Functions page
		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 1), cfp.getTitle());
		cfp.getCancelButton().click();

		//Record the video and click the photo for add video and photo to delete in local memory
		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-play");
		Buttons btn=  new Buttons(driver);
		wLib.waitAndClick(btn.getPermissionAllowButton());
		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-on");
		cfp.getPhotoButton().click();
		logg.info("Photo clicked");
		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-paused");


		/*Local memory Deletion Process According to our App*/
		//FileManager
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("FileManagerAppPackage"), fLib.getPropertyKeyValue("FileManagerAppActivity"));
		aLib.findScrollable(driver, eLib.getDataFromExcel("FileManager", 2, 0));

		FileManagerPage fmp = new FileManagerPage(driver);
		fmp.getAirtelXsafeFolder().click();
		fmp.getEdit().click();
		fmp.getSelectAll().click();
		fmp.getDelete().click();
		fmp.getDeleteConformation().click();

		//video player
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("VideoPalyerAppPackage"), fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		String airtel = aLib.findScrollableGetText(driver,eLib.getDataFromExcel("VideoPlayer", 1, 0));
		VideoPlayerAppPage vpap= new  VideoPlayerAppPage(driver);
		if (airtel.equals(eLib.getDataFromExcel("VideoPlayer", 1, 0))) {
			vpap.getMenu().click();
			vpap.getDelete().click();
			vpap.getOk().click();
		}
		logg.info("Videos deleted");

		/*Again capture the video and photo from our app*/

		//AirtelXsafe
		aLib.startActivity((AndroidDriver<WebElement>) driver, fLib.getPropertyKeyValue("XsafeAppPackage"), fLib.getPropertyKeyValue("XsafeAppActivity"));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		hp.getLiveCamera().click();

		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record on");

		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record pause");

		cfp.getPhotoButton().click();
		logg.info("Photo clicked");

		cfp.getSoundButton().click();
		logg.info("Sound off/on");

		cfp.getMicButton().click();
		logg.info("Mic on/off");

		btn.getPermissionAllowButton().click();

		cfp.getQualityButton().click();
		VideoQualityPage vqp = new VideoQualityPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 32, 1), vqp.getVideoQualityTitle());
		vqp.getMediumButton().click();   

		/*Check whether our Recorded video and clicked photo is there or not*/
		//FileManager
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("FileManagerAppPackage"), fLib.getPropertyKeyValue("FileManagerAppActivity"));
		aLib.findScrollable(driver, eLib.getDataFromExcel("FileManager", 2, 0));
		fmp.getAirtelXsafeFolder().click();		
		logg.info("Title of picture is                      : "+fmp.getTitle().getText());
		logg.info("Details of picture is                    : "+fmp.getFileDetails().getText());

		//video player
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("VideoPalyerAppPackage"), fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		aLib.findScrollable(driver,eLib.getDataFromExcel("VideoPlayer", 1, 0));
		logg.info("Title of video is                        : "+vpap.getTitle().getText());
		logg.info("All the functions and controls in our camera is working fine");

	}
	//====================================================================================================================================//


	@Test(priority = 3)
	public void sleepModeTest() throws InterruptedException, Throwable {

		/*
		 * This method is for check sleep mode and privacy mode is working fine or not.
		 * */

		commonCode();

		//Select camera for Do functions
		VerificationCodePage vcp = new VerificationCodePage(driver);
		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		String cam =vcp.getSunayana().getText();
		if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		}else {
			logg.info("Camera Not found");
		}
		vcp.getVerifyNow().click();

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.waitAndClick(hp.getLiveCamera());

		//Camera Functions Page
		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		cfp.getSettingsButton().click();

		//Setting page
		SettingsPage sp = new  SettingsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 11, 1), sp.getTitleSettings());
		String mode = sp.getSleepModeTxt().getText();
		if(mode.equals("Sleep")) {
			sp.getSleepModeButton().click();
			wLib.waitAndClick(sp.getBackButton());
			logg.info("This Camera Has Sleep Mode in settings page");
		}else if(mode.equals("Privacy Mode")) {
			sp.getSleepModeButton().click();
			wLib.waitAndClick(sp.getBackButton());
			logg.info("This Camera Has Privacy Mode in settings page");
		}else {
			logg.info("This camera has no sleep mode and privacy mode");
		}

		//check whether display shows Wake Up or not
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 2), cfp.getWakeUpText());
		logg.info("Camera is in sleep/privacy mode");
		cfp.getWakeUpText().click();
		logg.info("Sucessfully sleep/privacy mode got tested");

		try {
			//Privacy Mode Testing
			cfp.getPrivacyOff().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 2), cfp.getWakeUpText());
			logg.info("Camera is in sleep mode");
			cfp.getWakeUpText().click();
			logg.info("Sucessfully Privacy mode got tested");
		} catch (Exception e) {
			logg.warn("This camera has no Privacy mode");
		}

	}
	//====================================================================================================================================//


	@Test(priority = 4)
	public void flipCameraTest() throws InterruptedException, Throwable {

		/*
		 * This method is to check that Flip camera optoin is working fine or not, with toaster message.
		 * */

		commonCode();

		//Select camera for Do functions
		VerificationCodePage vcp = new VerificationCodePage(driver);
		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		String cam =vcp.getSunayana().getText();
		if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		}else {
			logg.info("Camera Not found");
		}
		vcp.getVerifyNow().click();
		HomePage hp = new HomePage(driver);
		hp.getLiveCamera().click();

		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		cfp.getSettingsButton().click();


		//Setting page
		SettingsPage sp = new  SettingsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 11, 1), sp.getTitleSettings());

		wLib.waitAndClick(sp.getFlipCamera());
		logg.info("Fliped");
		String toastMessage=sp.getFlipCameraToast().getText();
		Assert.assertEquals(eLib.getDataFromExcel("ASSERTION", 11, 2), toastMessage);
		logg.info(toastMessage);
		wLib.waitAndClick(sp.getFlipCamera());
	}
	//====================================================================================================================================//




































}




















