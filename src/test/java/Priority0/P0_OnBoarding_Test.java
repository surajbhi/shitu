package Priority0;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.AboutCameraPage;
import com.android.objectRepositaryLib.AddDevSerCamBlinkingPage;
import com.android.objectRepositaryLib.AddDevSerConfiguringPage;
import com.android.objectRepositaryLib.AddDevSerConnectNetworkPage;
import com.android.objectRepositaryLib.AddDevSerConnectWifiPage;
import com.android.objectRepositaryLib.AddDevSerSwitchPage;
import com.android.objectRepositaryLib.AddDevicePage;
import com.android.objectRepositaryLib.AddDeviceQrCamScanPage;
import com.android.objectRepositaryLib.AddDeviceWithSerialNumPage;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraAddedPage;
import com.android.objectRepositaryLib.CameraAlreadyOnboardedPage;
import com.android.objectRepositaryLib.CameraFunctionsPage;
import com.android.objectRepositaryLib.CancelThisProcessPage;
import com.android.objectRepositaryLib.CoachMarkPage;
import com.android.objectRepositaryLib.CustomCameraNamePage;
import com.android.objectRepositaryLib.DeleteCameraPage;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.NetworkErrorPage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.SettingsPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;
import io.appium.java_client.android.AndroidDriver;

/*
 * This class is for validate Camera OnBoarding.
 * @author A1Q5SAYJ(PRAKASH)
 * */

public class P0_OnBoarding_Test extends BaseClasss {

	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method is common for all below written methods.
		 * */

		try {

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

			//Cancel coach mark 
			CoachMarkPage cmp= new CoachMarkPage(driver);
			wLib.waitAndClick(cmp.getCancelButton());
			wLib.waitAndClick(cmp.getCancelButton());

			//Home Page
			HomePage hp = new HomePage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
			wLib.waitAndClick(hp.getAddDevice());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//=================================================================================================================================//


	/*This below methods based on QR Scanning page Actions according to Add devices */


	@Test(priority = 1)
	public void allowPermissionTest() throws InterruptedException, Throwable {

		/*
		 * This method is for check add camera with QR Code after user give Permission allow.
		 * */

		commonCode();

		//Click Add device by QR scan method
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();

		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open after Giving Permission");

	}



	//====================================================================================================================================//


	@Test(priority = 2)
	public void scanFailedErrorTest() throws InterruptedException, Throwable {

		/*
		 * This method is for check whether Scan failed error along with Re-scan option and Enter serial num optoin when Qr scan got failure
		 * */

		commonCode();

		//Click Add device by QR scan method
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();

		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open after Giving Permission");

		//ScanFailed, ScanAgain, EnterSerialNum is verified
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 2), adqrcsp.getScanFailedText());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 3), adqrcsp.getEnterSerialNoButton());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 4), adqrcsp.getScanAgainButton());
		logg.info("ScanAgain, EnterSerialNo is appeard once qr getting failed scan");
	}
	//====================================================================================================================================//


	@Test(priority = 3)
	public void backToHomeTest() throws InterruptedException, Throwable {


		/*
		 * This method is for check add camera and cancel it and validate i returns back to home page or not.
		 * */

		commonCode();

		//Click Add device by QR scan method
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getCloseButton().click();

		CancelThisProcessPage ctpp = new CancelThisProcessPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 20, 1), ctpp.getCancelThisProcessText());
		ctpp.getYesCancelButton().click();
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		logg.info("Once cancel the process of Add device it returns back to Home page");
	}
	//====================================================================================================================================//


	@Test(priority = 4)
	public void withoutWifiScanTest() throws InterruptedException, Throwable {

		/*
		 * This method is for check add camera with QR Code without wifi connection.
		 * */

		commonCode();

		//Click Add device by QR scan method
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();

		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open after Giving Permission");

		((AndroidDriver<WebElement>) driver).toggleWifi();//wifi off
		NetworkErrorPage nep= new NetworkErrorPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 21, 1), nep.getNotConnectedTitle());
		wLib.waitAndGetText(nep.getNotConnectedTitle());

		((AndroidDriver<WebElement>) driver).toggleWifi();//wifi on
		wLib.waitAndClick(nep.getRetryButton());
		try {
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
			logg.info("QR Scanning is giving error when wifi get turn off and again come to scan page when wifi turns on");

		} catch (Exception e) {
			btn.getBackButton().click();
			adp.getStartScanButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
			logg.info("QR Scanning is giving error when wifi get turn off and again come to scan page when wifi turns on");

		}

	}
	//====================================================================================================================================//

	/*This below methods based on Enter Serial Number page Actions according to Add devices */

	@Test(priority = 5)
	public void enterSerialNUmDidplayTest() throws InterruptedException, Throwable {


		/*
		 * This method is used for check whether Enter serial number page is displayed when we hit "Enter Serial no." button
		 * */


		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		logg.info("User can able to enter Device Serial No page");	
	}
	//====================================================================================================================================//


	@Test(priority = 6)
	public void numericValuesTest() throws InterruptedException, Throwable {

		/*
		 * This method is used "Serial number field should only take numeric characters and VC field should only take Alphabets."
		 * */


		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());

		//Enter Alphanumerics in Serial no Text box
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 1, 5));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 2), addSerial.getSerialNumTextBox());
		logg.info("Serial num only Accept numerical values");

		//Enter Alphanumerics in Verification code Text box
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 1, 5));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 3), addSerial.getVerificationCodeTextBox());
		logg.info("Verification code Can Accept Both Alphabets and Numerical values");
	}
	//====================================================================================================================================//

	@Test(priority = 7)
	public void errorMessageCamTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to check error message is get when we onboard already cam in another account.
		 * */


		commonCode();


		//Add Device Page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 2, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 2, 2));
		addSerial.getDoneButton().click();

		CameraAlreadyOnboardedPage caop = new CameraAlreadyOnboardedPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 22, 1), caop.getCameraAlreadyOnboardedTitle());
		caop.getGoToHomeButton().click();

		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());

		logg.info("Getting Error message when cam onboard from another camera in another account");
	}
	//====================================================================================================================================//


	@Test(priority = 8)
	public void cameraDeleteAndOnboadrTest() throws InterruptedException, Throwable {

		/*
		 * This method is for Delete the camera and again onboard that same camera in same account.
		 * */

		try {

			commonCode();

			AddDevicePage adp = new AddDevicePage(driver);
			adp.getCloseButton().click();
			CancelThisProcessPage ctpp = new CancelThisProcessPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 20, 1), ctpp.getCancelThisProcessText());
			ctpp.getYesCancelButton().click();

			//Camera Delete Process
			HomePage hp = new HomePage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
			try {
				hp.getVerticalCamButton().click();
			} catch (Exception e1) {
				logg.info("Element not there");
			}
			aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
			VerificationCodePage vcp = new VerificationCodePage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
			Buttons btn = new Buttons(driver);
			btn.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
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
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
			logg.info("Camera Onboarded Successfully once Delete from Account");

		} catch (Exception e) {

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
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
			logg.info("Camera Onboarded Successfully once Delete from Account");
		}

	}
	//====================================================================================================================================//


	@Test(priority = 9)
	public void navigateBlinkingPageTest() throws InterruptedException, Throwable {

		/*
		 * This method is to validate camera blinking screen should be displayed after Doing Add serial number flow.
		 * */

		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		adssp.getContinueButton().click();

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		logg.info("Is the Camera Blinking Blue page is Displayed Successfully");
	}
	//====================================================================================================================================//


	/*This below methods are based on "Configuaration of camera" */

	@Test(priority = 10)
	public void sitRelaxVisibleTest() throws InterruptedException, Throwable {

		/*
		 * This method is verify the Configuring, Sit back and Relax message should be displayed after enter serial num.
		 * */

		commonCode();


		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		adssp.getContinueButton().click();

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		adscbp.getYesBlinkingButton().click();
		Buttons btn= new Buttons(driver);
		btn.getPermissionAllowButton().click();

		//Connect With Your Wifi page
		AddDevSerConnectWifiPage adscwp= new AddDevSerConnectWifiPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 29, 1), adscwp.getConnectWifiText());
		adscwp.getWifiPswdPlaceHolder().sendKeys(eLib.getDataFromExcel("WIFI", 1, 1));
		adscwp.getContinueButton().click();

		//Connect with Network Page
		AddDevSerConnectNetworkPage adscnp= new AddDevSerConnectNetworkPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 30, 1), adscnp.getTitle());
		adscnp.getContinueButton().click();

		//Configuring page
		AddDevSerConfiguringPage adscp = new AddDevSerConfiguringPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 31, 1), adscp.getConfiguringText());
		logg.info(adscp.getSitBackText().getText());
	}
	//====================================================================================================================================//


	@Test(priority = 11)
	public void killAppTest() throws InterruptedException, Throwable {

		/*
		 * This method is for if app is killed from background in between configuration, user will have to reinitiate the process
		 * */

		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		adssp.getContinueButton().click();

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		adscbp.getYesBlinkingButton().click();
		Buttons btn= new Buttons(driver);
		btn.getPermissionAllowButton().click();

		//Connect With Your Wifi page
		AddDevSerConnectWifiPage adscwp= new AddDevSerConnectWifiPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 29, 1), adscwp.getConnectWifiText());
		adscwp.getWifiPswdPlaceHolder().sendKeys(eLib.getDataFromExcel("WIFI", 1, 1));
		adscwp.getContinueButton().click();

		//Connect with Network Page
		AddDevSerConnectNetworkPage adscnp= new AddDevSerConnectNetworkPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 30, 1), adscnp.getTitle());
		adscnp.getContinueButton().click();
		driver.terminateApp(fLib.getPropertyKeyValue("XsafeAppPackage"));
		driver.launchApp();

		//Next		
		FirstPage fp= new FirstPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 1, 1), fp.getCloudStorageText());
		logg.info("App Killed and Restarted Freshly for Configuration");
	}
	//====================================================================================================================================//


	@Test(priority = 12)
	public void progressBarTest() throws InterruptedException, Throwable {

		/*
		 * This method is to validate Progress bar is getting update for each and every process of camera onboarding.
		 * */

		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		Object Expected = wLib.takeExpectedScreenshot(adp.getProgressBar());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		wLib.screenshotComparision(adssp.getProgressBar(), Expected, "icon2");
		adssp.getContinueButton().click();

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		wLib.screenshotComparision(adscbp.getProgressBar(), Expected, "icon3");
		adscbp.getYesBlinkingButton().click();
		Buttons btn= new Buttons(driver);
		btn.getPermissionAllowButton().click();

		//Connect With Your Wifi page
		AddDevSerConnectWifiPage adscwp= new AddDevSerConnectWifiPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 29, 1), adscwp.getConnectWifiText());
		wLib.screenshotComparision(adscwp.getProgressBar(), Expected, "icon4");
		adscwp.getWifiPswdPlaceHolder().sendKeys(eLib.getDataFromExcel("WIFI", 1, 1));
		adscwp.getContinueButton().click();

		//Connect with Network Page
		AddDevSerConnectNetworkPage adscnp= new AddDevSerConnectNetworkPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 30, 1), adscnp.getTitle());
		wLib.screenshotComparision(adscnp.getProgressBar(), Expected, "icon5");
		adscnp.getContinueButton().click();
	}
	//====================================================================================================================================//

	@Test(priority = 13)
	public void errrorMessageTest() throws InterruptedException, Throwable {

		/*
		 * Error message screens should be displayed when configuration is interrupted.
		 * */


		commonCode();


		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		adssp.getContinueButton().click();

		((AndroidDriver<WebElement>) driver).toggleWifi();//wifi off

		NetworkErrorPage nep= new NetworkErrorPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 21, 1), nep.getNotConnectedTitle());

		((AndroidDriver<WebElement>) driver).toggleWifi();//wifi on
		wLib.waitAndClick(nep.getRetryButton());

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		logg.info("Enter Serial Num is giving error when wifi get turn off and again came to Blinking page when wifi turns on");
	}
	//====================================================================================================================================//

	@Test(priority = 14)
	public void cofigureNotExitTest() throws InterruptedException, Throwable {


		/*
		 * User Cannot exit configuration process User should not be able to press the back button from the process.
		 * */

		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getEnterSlNoAndVerficationCodeText().click();

		//Valid camera Serial number
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 1));

		//Valid Verification code
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 3, 2));
		addSerial.getDoneButton().click();

		//Switch on the Device page
		AddDevSerSwitchPage adssp = new AddDevSerSwitchPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 25, 1), adssp.getTitle());
		adssp.getContinueButton().click();

		//Camera Blinling Blue page
		AddDevSerCamBlinkingPage adscbp= new AddDevSerCamBlinkingPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 26, 1), adscbp.getTitle());
		adscbp.getYesBlinkingButton().click();
		Buttons btn= new Buttons(driver);
		btn.getPermissionAllowButton().click();

		//Connect With Your Wifi page
		AddDevSerConnectWifiPage adscwp= new AddDevSerConnectWifiPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 29, 1), adscwp.getConnectWifiText());
		adscwp.getWifiPswdPlaceHolder().sendKeys(eLib.getDataFromExcel("WIFI", 1, 1));
		adscwp.getContinueButton().click();

		//Connect with Network Page
		AddDevSerConnectNetworkPage adscnp= new AddDevSerConnectNetworkPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 30, 1), adscnp.getTitle());
		adscnp.getContinueButton().click();

		//Configuring page
		AddDevSerConfiguringPage adscp = new AddDevSerConfiguringPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 31, 1), adscp.getConfiguringText());
		logg.info(adscp.getSitBackText().getText());

		try {
			adscp.getBackButton().click();
			adscp.getContinueButton().click();
			logg.info("Continue and Back buttons are Pressent");
			Assert.assertEquals(false, true);
		} catch (Exception e) {
			logg.info("Continue and Back buttons are Not Pressent");
		}
	}
	//====================================================================================================================================//



}




















