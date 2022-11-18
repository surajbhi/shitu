package BrowserStack;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClassForBrowserStack;
import com.android.objectRepositaryLib.AboutCameraPage;
import com.android.objectRepositaryLib.AddDevicePage;
import com.android.objectRepositaryLib.AddDeviceWithSerialNumPage;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraAddedPage;
import com.android.objectRepositaryLib.CameraFunctionsPage;
import com.android.objectRepositaryLib.CustomCameraNamePage;
import com.android.objectRepositaryLib.DeleteCameraPage;
import com.android.objectRepositaryLib.DetetctionZonePage;
import com.android.objectRepositaryLib.GetNotificationForPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.MotionAlarmSoundPage;
import com.android.objectRepositaryLib.MotionDetectionSensitivityPage;
import com.android.objectRepositaryLib.SettingsEventPage;
import com.android.objectRepositaryLib.SettingsNotificationPage;
import com.android.objectRepositaryLib.SettingsPage;
import com.android.objectRepositaryLib.VerificationCodePage;
import com.android.objectRepositaryLib.VideoQualityPage;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class BS_Sanity extends BaseClassForBrowserStack {
	
	@Test(priority = 1, groups = "Sanity")
	public void validLoginTest() throws Throwable {

		//Common wait Statement
		wLib.waitUntilPageLoad(driver);

		try {

			//Verification Code Page
			VerificationCodePage vcp = new VerificationCodePage(driver);
			aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
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
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
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

		} catch (Exception e) {
			logg.info("");
		}

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());

		try {
			hp.getAddDevice().click();
		} catch (Exception e2) {
			aLib.touchAction(driver, 300, 370, 300, 900);
			hp.getAddDevice().click();
		}


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

	}


	@Test(priority = 2, groups = "Sanity")
	public void camFunctionsTest() throws Throwable {

		//Verification Code Page - for enter incorrect verification code Testing
		VerificationCodePage vcp = new VerificationCodePage(driver);
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 3, 2);
		driver.hideKeyboard();
		logg.warn(vcp.getiValidCodeError().getText());
		vcp.getSkipForNow().click();

		//Valid Verification Code
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
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
		cfp.getCancelButton().click();


		try {
			wLib.waitAndClick1(cfp.getRecordButton());
			logg.info("Record-play");


		} catch (Exception e) {
			cfp.getPlayPauseButton().click();
		}

		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-on");

		cfp.getPhotoButton().click();
		logg.info("Photo clicked");

		wLib.waitAndClick1(cfp.getRecordButton());
		logg.info("Record-paused");

		//File Manager
		List<String> lsArgs = Arrays.asList("/sdcard/Pictures/");
		Map<String, Object> lsCmd = ImmutableMap.of("command", "ls","args", lsArgs);
		String lsOutput = ((String) driver.executeScript("mobile: shell", lsCmd));
		if (lsOutput.contains("AirtelXSafe")) {
			logg.info("YES AirtelXsafe Folder is there Pictures folder");
			List<String> rmArgss = Arrays.asList("/sdcard/Pictures/AirtelXSafe/");
			Map<String, Object> lsCmdd = ImmutableMap.of("command", "rm -r","args", rmArgss);
			driver.executeScript("mobile: shell", lsCmdd);
		}else {
			logg.info("NO AirtelXsafe Folder is not present");
		}

		//Video player
		List<String> lsArgsvid = Arrays.asList("/sdcard/Movies/");
		Map<String, Object> lsCmdvid = ImmutableMap.of("command", "ls","args", lsArgsvid);
		String lsOutputvid = ((String) driver.executeScript("mobile: shell", lsCmdvid));
		if (lsOutputvid.contains("AirtelXSafe")) {
			logg.info("YES AirtelXsafe Folder is there in Movies folder");
			List<String> rmArgss = Arrays.asList("/sdcard/Movies/AirtelXSafe/");
			Map<String, Object> lsCmdd = ImmutableMap.of("command", "rm -r","args", rmArgss);
			driver.executeScript("mobile: shell", lsCmdd);
		}else {
			logg.info("NO AirtelXsafe Folder is not present");
		}
		logg.info("Videos deleted");

		//AirtelXsafe
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


		cfp.getQualityButton().click();
		VideoQualityPage vqp = new VideoQualityPage(driver);
		vqp.getMediumButton().click();   

		//File Manager
		List<String> lsArgsf = Arrays.asList("/sdcard/Pictures/");
		Map<String, Object> lsCmdf = ImmutableMap.of("command", "ls","args", lsArgsf);
		String lsOutputf = ((String) driver.executeScript("mobile: shell", lsCmdf));
		String[] listOutputf = lsOutputf.split("\n");
		logg.info("listOutputf Size = "+listOutputf.length);

		if (lsOutputf.contains("AirtelXSafe")) {
			logg.info("YES AirtelXsafe Folder is there in Pictures folder");
			List<String> lsArgss = Arrays.asList("/sdcard/Pictures/AirtelXSafe/*.*");
			Map<String, Object> lsCmdd = ImmutableMap.of("command", "ls","args", lsArgss);

			String lsOutputt = ((String) driver.executeScript("mobile: shell", lsCmdd));
			String[] listOutputt = lsOutputt.split("\n");
			int size = listOutputt.length;
			logg.info("listOutput Size = "+listOutputt.length);

			if (size==0) {
				logg.error("There is no PHOTO in AirtelXsafe folder");
				Assert.assertEquals(false, true);
			}
		}else {
			logg.info("NO AirtelXsafe Folder is not present");
		}

		//video Player
		List<String> lsArgsv = Arrays.asList("/sdcard/Movies/");
		Map<String, Object> lsCmdv = ImmutableMap.of("command", "ls","args", lsArgsv);

		String lsOutputv = ((String) driver.executeScript("mobile: shell", lsCmdv));
		String[] listOutputv = lsOutputv.split("\n");
		logg.info("listOutputv Size = "+listOutputv.length);

		if (lsOutputv.contains("AirtelXSafe")) {
			logg.info("YES Airtel Xsafe Folder is there in Movies folder");
			List<String> lsArgss = Arrays.asList("/sdcard/Movies/AirtelXSafe/*.*");
			Map<String, Object> lsCmdd = ImmutableMap.of("command", "ls","args", lsArgss);

			String lsOutputt = ((String) driver.executeScript("mobile: shell", lsCmdd));
			String[] listOutputt = lsOutputt.split("\n");
			logg.info("lsOutputt = "+lsOutputt);
			int size = listOutputt.length;
			logg.info("listOutput Size = "+listOutputt.length);

			if (size==0) {
				logg.error("There is no VIDEO in AirtelXsafe folder");
				Assert.assertEquals(false, true);
			}
		}else {
			logg.info("NO Airtel Xsafe Folder is not present");
		}
	}

	//=======================================================================================================================================================//

	@Test(priority = 3, groups = "Sanity")
	public void cameraSettingsTest() throws Throwable {


		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));

		//Verification Code Page
		VerificationCodePage vcp = new VerificationCodePage(driver);
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
		wLib.waitAndGetText(sp.getCameraName());
		wLib.waitAndClick(sp.getStatusLight());
		wLib.waitAndClick(sp.getNightVisionMode());
		wLib.waitAndClick(sp.getFlipCamera());
		wLib.waitAndClick(sp.getStatusLight());
		wLib.waitAndClick(sp.getNightVisionMode());
		wLib.waitAndClick(sp.getFlipCamera());
		wLib.waitAndClick(sp.getAboutCamera());

		//About Camera Page
		AboutCameraPage acp = new AboutCameraPage(driver);
		logg.info(acp.getCameraModelTitle().getText());
		logg.info(acp.getFirmWare().getText());
		logg.info(acp.getSerialNo().getText());
		logg.info(acp.getCameraModel().getText());
		acp.getDoneButton().click();

		sp.getEventLink().click();

		//Event Page in Settings 
		SettingsEventPage sep = new SettingsEventPage(driver);
		wLib.waitAndClick(sep.getMotionDetectionSensitivity());
		aLib.tapByCoordinates(driver, 534, 1183);
		MotionDetectionSensitivityPage  mdsp = new MotionDetectionSensitivityPage(driver);
		logg.info(mdsp.getLevelNum().getText());
		mdsp.getCancelButton().click();

		sep.getDetectionZone().click();
		Buttons btn = new Buttons(driver);
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
		wLib.waitAndClick500(sep.getNotificationsLink());


		//Notifications Page in Settings
		SettingsNotificationPage snp = new SettingsNotificationPage(driver);

		String onoff = snp.getNotificationsStatus().getText();

		if(onoff.equals("On")) {
			logg.info("Get Notification is ON");
		}else {
			snp.getNotificationsButton().click();
		}

		wLib.waitAndClick(snp.getEventDetectionLink());

		GetNotificationForPage gnfp = new GetNotificationForPage(driver);
		gnfp.getPersonDetection().click();
		gnfp.getMotionDetection().click();
		gnfp.getCloseButton().click();

	}

	//=======================================================================================================================================================//



}
