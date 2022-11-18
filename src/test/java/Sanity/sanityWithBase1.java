package Sanity;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClass1;
import com.android.objectRepositaryLib.AboutCameraPage;
import com.android.objectRepositaryLib.AccountTabPage;
import com.android.objectRepositaryLib.AddDevicePage;
import com.android.objectRepositaryLib.AddDeviceWithSerialNumPage;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraAddedPage;
import com.android.objectRepositaryLib.CameraFunctionsPage;
import com.android.objectRepositaryLib.CustomCameraNamePage;
import com.android.objectRepositaryLib.DeleteCameraPage;
import com.android.objectRepositaryLib.DetetctionZonePage;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.GetNotificationForPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.MotionAlarmSoundPage;
import com.android.objectRepositaryLib.MotionDetectionSensitivityPage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.SettingsEventPage;
import com.android.objectRepositaryLib.SettingsNotificationPage;
import com.android.objectRepositaryLib.SettingsPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;
import com.android.objectRepositaryLib.VideoQualityPage;

import io.appium.java_client.android.AndroidDriver;

/*
 * This class is used to test the Sanity Testing for PlayStore Build
 * */

public class sanityWithBase1 extends BaseClass1 {

	@Test
	public void sanityTest() throws Throwable {

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

		//Camera Delete Process form Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.warn("Vertical Camera List Element not there in Home page");
		}

		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		String cam =vcp.getSunayana().getText();
		if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		}else {
			logg.warn("Camera Not found");
		}
		vcp.getVerifyNow().click();
		hp.getLiveCamera().click();

		//Camera Functions Page
		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 1), cfp.getTitle());
		cfp.getSettingsButton().click();

		//Settings Page
		SettingsPage sp = new SettingsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 11, 1), sp.getTitleSettings());
		sp.getAboutCamera().click();

		//About Camera Page
		AboutCameraPage acp = new AboutCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 12, 1), acp.getCameraModelTitle());
		acp.getDeleteDevice().click();

		//Delete Camera Page
		DeleteCameraPage dcm = new DeleteCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 13, 1), dcm.getTitleDeleteCamera());
		dcm.getPositiveButton().click();

		//Home Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		hp.getAddDevice().click();

		//Add Device Page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 2));
		addSerial.getDoneButton().click();

		//Valid Camera Name
		CameraAddedPage cap = new CameraAddedPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 15, 1), cap.getCameraAddedTitle());
		wLib.waitAndClick(cap.getPluseIcon());

		//Customer Camera Name Page
		CustomCameraNamePage ccnp = new CustomCameraNamePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 16, 1), ccnp.getCustomCameraTitle());
		ccnp.getSendKeyButton().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		ccnp.getSaveButton().click();
		cap.getDoneButton().click();
		logg.info("Camera Onboarded Successfully");



		try {
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());

		} catch (Exception e) {
			driver.launchApp();
			//Again Login
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 1, 1), fp.getCloudStorageText());
			fp.getNextButton().click();

			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 2, 1), secp.getCloudStorageText());
			secp.getNextButton().click();

			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 3, 1), tp.getCloudStorageText());
			tp.getNextButton().click();

			//Enter your Mobile Number.
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
			emnp.getSendKeyButton("MobileNumbers", 1, 0);
			driver.hideKeyboard();
			emnp.getContinueButton().click();
			logg.info("Mobile number successfully entered");

			//Enter OTP	
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
			eop.getSendKeyButton("MobileNumbers", 1, 1);
			eop.getContinueButton().click();
			logg.info("OTP successfully entered");

			//Enter your Display name.	
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 6, 1), ednp.getTitleText());
			ednp.getSendKeyButton("MobileNumbers", 1, 2);
			ednp.getContinueButton().click();
			logg.info("Display name entered");

			//Skip for Now
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
			vcp.getSkipForNow().click();

			//Cancel 
			wLib.waitAndClick(btn.getCancelButton());
			wLib.waitAndClick(btn.getCancelButton());

			//Home Page - for enter incorrect verification code Testing
			aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 3, 2);
			driver.hideKeyboard();
			logg.warn(vcp.getiValidCodeError().getText());
			vcp.getSkipForNow().click();
			aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
			if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
				vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
			}else {
				logg.warn("Camera Not found");
			}
			vcp.getVerifyNow().click();

		}

		hp.getLiveCamera().click();
		//Camera Functions page Testing
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 1), cfp.getTitle());
		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-play");
		wLib.waitAndClick(btn.getPermissionAllowButton());
		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record on");

		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record pause");

		cfp.getPhotoButton().click();
		logg.info("Photo clicked");

		cfp.getSoundButton().click();
		logg.info("Sound off/on");

		cfp.getMicButton().click();
		wLib.waitAndClick(btn.getPermissionAllowButton());
		logg.info("Mic on/off");

		cfp.getQualityButton().click();
		VideoQualityPage vqp = new VideoQualityPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 32, 1), vqp.getVideoQualityTitle());
		vqp.getMediumButton().click();   
		logg.info("All the controls of this camera is validated");
		cfp.getSettingsButton().click();

		/*Sleep/Privacy Mode Testing*/
		//Setting page
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
			logg.info("Camera is in privacy mode");
			cfp.getWakeUpText().click();
			logg.info("Sucessfully Privacy mode got tested");
		} catch (Exception e) {
			logg.warn("This camera has no Privacy mode");
		}

		/*Flip camera Testing*/
		cfp.getSettingsButton().click();

		//Setting page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 11, 1), sp.getTitleSettings());
		wLib.waitAndClick(sp.getFlipCamera());
		logg.info("Fliped");
		String toastMessage=sp.getFlipCameraToast().getText();
		Assert.assertEquals(eLib.getDataFromExcel("ASSERTION", 11, 2), toastMessage);
		logg.info(toastMessage);

		//All other Setings Validation


		wLib.waitAndGetText(sp.getCameraName());
		wLib.waitAndClick(sp.getStatusLight());
		wLib.waitAndClick(sp.getNightVisionMode());
		wLib.waitAndClick(sp.getFlipCamera());
		wLib.waitAndClick(sp.getStatusLight());
		wLib.waitAndClick(sp.getNightVisionMode());
		wLib.waitAndClick(sp.getFlipCamera());
		wLib.waitAndClick(sp.getAboutCamera());

		logg.info(acp.getCameraModelTitle().getText());
		logg.info(acp.getFirmWare().getText());
		logg.info(acp.getSerialNo().getText());
		logg.info(acp.getCameraModel().getText());
		acp.getDoneButton().click();

		sp.getEventLink().click();

		SettingsEventPage sep = new SettingsEventPage(driver);
		wLib.waitAndClick(sep.getMotionDetectionSensitivity());
		MotionDetectionSensitivityPage  mdsp = new MotionDetectionSensitivityPage(driver);
		aLib.tapByCoordinates(driver, 534, 1183);
		logg.info(mdsp.getLevelNum().getText());
		mdsp.getCancelButton().click();

		sep.getDetectionZone().click();
		btn.getCancelButton().click();

		DetetctionZonePage dzp = new DetetctionZonePage(driver);
		dzp.getCustomZone().click();
		aLib.touchAction((AndroidDriver<WebElement>) driver, 440, 1049, 560, 1049);
		aLib.touchAction((AndroidDriver<WebElement>) driver, 281, 1049, 140, 1049);
		dzp.getSaveButton().click();
		wLib.waitAndClick(sep.getDetectionZone());
		dzp.getEntireScreen().click();
		dzp.getSaveButton().click();

		sep.getMotionAlarmSound().click();
		MotionAlarmSoundPage masp = new MotionAlarmSoundPage(driver);
		logg.info(masp.getLevelText().getText());
		aLib.touchAction((AndroidDriver<WebElement>) driver, 360, 1188, 644, 1188);
		masp.getCancelButton().click();

		sep.getNotificationsLink().click();

		SettingsNotificationPage snp = new SettingsNotificationPage(driver);
		wLib.waitAndClick(snp.getEventDetectionLink());

		GetNotificationForPage gnfp = new GetNotificationForPage(driver);
		gnfp.getPersonDetection().click();
		gnfp.getMotionDetection().click();
		gnfp.getCloseButton().click();
		sp.getBackButton().click();
		cfp.getBackButton().click();

		/*Login Page Should Appear After Successfull Logout*/
		//Account Fragment Page
		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("ExpectedElement", 3, 0));

		//Enter Mobile Number Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 1, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();
		logg.info("Mobile number successfully entered");
		logg.info("Login Page Should Appear After Successfull Logout");

		//Enter OTP page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 1, 1);
		eop.getContinueButton().click();
		logg.info("OTP successfully entered");

		//Enter your Display name.		
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 6, 1), ednp.getTitleText());
		ednp.getSendKeyButton("MobileNumbers", 1, 2);
		ednp.getContinueButton().click();
		logg.info("Display name entered");

		//Skip for Now
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSkipForNow().click();







































	}



}



























