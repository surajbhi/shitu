package Priority1;

import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.AboutCameraPage;
import com.android.objectRepositaryLib.AddDevicePage;
import com.android.objectRepositaryLib.AddDeviceQrCamScanPage;
import com.android.objectRepositaryLib.AddDeviceWithSerialNumPage;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraAddedPage;
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
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.SettingsPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;

/*
 * This class is for validate Camera OnBoarding.
 * */

public class P1_OnBoarding_Test extends BaseClasss{


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

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		wLib.waitAndClick(hp.getAddDevice());
	}


	//====================================================================================================================================//

	@Test(priority = 1)
	public void qrAndSerialTest() throws InterruptedException, Throwable {

		/*
		 * This method is vallidate User should be able to see Scan QR code and Enter serial number options and both should work as expected
		 * */

		commonCode();

		/*QR code validation*/
		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();

		/*Serial number validation*/
		//Add a Device page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		logg.info("User can able to enter Device Serial No page");	
	}

	//====================================================================================================================================//


	@Test(priority = 2)
	public void cancellationPopupTest() throws InterruptedException, Throwable {

		/*
		 * This method is vallidate cancellation pop up when clicked on cross icon throughout the process.
		 * */

		commonCode();

		/*QR code validation*/
		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();
		adp.getCloseButton().click();

		//Cancel this process page
		CancelThisProcessPage ctpp= new CancelThisProcessPage(driver);
		wLib.waitAndClick(ctpp.getYesCancelButton());

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		logg.info("On boarding through qr code process is cancelled successfully");
	}

	//====================================================================================================================================//

	@Test(priority = 3)
	public void dontCancelProcessTest() throws InterruptedException, Throwable {

		/*
		 * This method is vallidate "Don�t cancel Process" will continue with camera scanning User should be able to continue with onboarding process.
		 * */

		commonCode();

		/*QR code validation*/
		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();


		//Add device with QR cam scan page
		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open in Sticky cam");
		adqrcsp.getCloseButton().click();

		//Cancel this process page
		CancelThisProcessPage ctpp= new CancelThisProcessPage(driver);

		ctpp.getDontCancelButton().click();

		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("Don�t cancel Process will continue with camera scanning User should be able to continue with onboarding process");
	}

	//====================================================================================================================================//

	@Test(priority = 4)
	public void rescanCameraTest() throws InterruptedException, Throwable {

		/*
		 * This method is validate when scan fails User should be able to re scan camera or enter serial number.
		 * */

		commonCode();


		/*QR code validation*/
		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();



		//Add device with QR cam scan page
		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open in Sticky cam");

		//ScanFailed, ScanAgain, EnterSerialNum is verified
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 2), adqrcsp.getScanFailedText());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 3), adqrcsp.getEnterSerialNoButton());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 4), adqrcsp.getScanAgainButton());
		logg.info("ScanAgain, EnterSerialNo is appeard once qr getting failed scan");

	}


	//====================================================================================================================================//

	@Test(priority = 5)
	public void flashLightOnTest() throws InterruptedException, Throwable {

		/*
		 * This method is vallidate whether flash light is turn on while qr scan is on.
		 * */

		commonCode();


		/*QR code validation*/
		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getStartScanButton().click();
		Buttons btn = new Buttons(driver);
		btn.getPermissionAllowButton().click();

		//Add device with QR cam scan page
		AddDeviceQrCamScanPage adqrcsp= new AddDeviceQrCamScanPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 19, 1), adqrcsp.getPointCameraAtQrText());
		logg.info("QR Scanner is Successfully Open in Sticky cam");
		Object Expected = wLib.takeExpectedScreenshot(adqrcsp.getFlashLightButton());
		adqrcsp.getFlashLightButton().click();
		wLib.screenshotComparision(adqrcsp.getFlashLightButton(), Expected, "icon2");
		logg.info("Flash light is turned on while QR scanning");
		adqrcsp.getFlashLightButton().click();
		logg.info("Flash light is turned off after QR scanning");
	}

	//====================================================================================================================================//


	/*This below methods based on Enter Serial Number page Actions according to Add devices */


	//====================================================================================================================================//

	@Test(priority = 6)
	public void enterDeviceVerficationCodeTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to check Enter Serial Number_Validate User should be able to Enter Device Verification code in given format.
		 * */


		commonCode();

		//Add a Device page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		adp.getEnterSerialNoText().click();

		//Valid camera Serial number
		AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
		addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 1));
		logg.info("Serial number enterd successfully");

		//Enter Alphanumerics in Verification code Text box
		addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 1, 5));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 3), addSerial.getVerificationCodeTextBox());
		logg.info("Verification code Can Accept Both Alphabets and Numerical values");

	}
	//====================================================================================================================================//


	@Test(priority = 7)
	public void serNoAndVcPairMatchTest() throws InterruptedException, Throwable {

		/*
		 * This method is for Enter Serial Number_Validate Device serial number and Verification code pair should match.
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

			/*Valid serial and Invalid vc are going to test vice versa*/

			//Valid Camera Serial Number
			AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 1));

			//Invalid Verifivation code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 7, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 4), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Invalid Camera Serial Number
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 14, 1));

			//Valid Verification code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 6, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 5), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Valid camera Serial number
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

			/*Valid serial and Invalid vc are going to test vice versa*/

			//Valid Camera Serial Number
			AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 1));

			//Invalid Verifivation code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 7, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 4), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Invalid Camera Serial Number
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 14, 1));

			//Valid Verification code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 6, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 5), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Valid camera Serial number
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


	@Test(priority = 8)
	public void invalidSerNoTest() throws InterruptedException, Throwable {

		/*
		 * This method is to validate Enter Serial Number_Validate Incorrect Device serial number and verification code should give error message.
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

			/*InValid serial and Invalid vc are going to test vice versa*/

			//InValid Camera Serial Number
			AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 14, 1));

			//Invalid Verifivation code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 7, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 5), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Valid camera Serial number
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

			/*InValid serial and Invalid vc are going to test vice versa*/

			//InValid Camera Serial Number
			AddDeviceWithSerialNumPage addSerial = new AddDeviceWithSerialNumPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 1), addSerial.getDeviceSerialNoTitle());
			addSerial.getSerialNumPlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 14, 1));

			//Invalid Verifivation code
			addSerial.getVerificationCodePlaceHolder().sendKeys(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 7, 2));
			addSerial.getDoneButton().click();
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 14, 5), addSerial.getInvalidVerificationCodeText());
			addSerial.getCancelButton().click();
			adp.getEnterSerialNoText().click();

			//Valid camera Serial number
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















}
