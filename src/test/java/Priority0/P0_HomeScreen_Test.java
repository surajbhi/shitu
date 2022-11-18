package Priority0;

import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.AboutCameraPage;
import com.android.objectRepositaryLib.AddDevicePage;
import com.android.objectRepositaryLib.AddDeviceWithSerialNumPage;
import com.android.objectRepositaryLib.CameraAddedPage;
import com.android.objectRepositaryLib.CameraFunctionsPage;
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
 * This Class We are going to validate Home Screen of our App.
 * */
public class P0_HomeScreen_Test extends BaseClasss {



	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method is common for all the methods in this class.
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


	}

	//====================================================================================================================================//

	@Test(priority = 1)
	public void loginPageTest() throws InterruptedException, Throwable {

		/*
		 * This method is test for Home Screen and validate when user press "+"icon it will enter to ADD A DEVICE PAGE or not.   
		 */

		commonCode();

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		wLib.waitAndClick(hp.getAddDevice());
		logg.info("+ Clicked");

		//ADD A DEVICE page
		AddDevicePage adp = new AddDevicePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 9, 1), adp.getAddDeviceTitle());
		logg.info(adp.getAddDeviceTitle().getText()+" Page is Displayed Successfully");
	}
	//====================================================================================================================================//


	@Test(priority = 2)
	public void gridPauseStateTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to validate Play/Pause button is visible in 'Pause State' after camera onboarded.
		 * */

		commonCode();

		//vertical cam list.
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());

		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.info("Element not there");
		}

		boolean Actual=	hp.getPlayPauseButton().isEnabled();
		logg.info(Actual);
		if(Actual==true) {
			logg.info("Play/Pause Button is Enabled True Before Camera OnBoarded");
		}
		else {
			logg.info("Play/Pause Button is Enabled False Before Camera OnBoarded");
		}

		try {


			//Camera Delete Process
			aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
			VerificationCodePage vcp = new VerificationCodePage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
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
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
			logg.info("Camera Onboarded Successfully");

			//Home Page
			boolean Actual1=	hp.getPlayPauseButton().isEnabled();
			logg.info(Actual1);
			if(Actual1==true) {
				logg.info("Play/Pause Button is Enabled True After Camera OnBoarded");
			}
			else {
				logg.info("Play/Pause Button is Enabled False After Camera OnBoarded");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//====================================================================================================================================//




























}
