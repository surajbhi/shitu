package Priority0;

import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.ThirdPage;


 /*
 * This Class is used to validate Login Process is working fine or not.
 */

public class P0_LoginModule_Test extends BaseClasss{



	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method is common for all the methods in this class.
		 * */

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

	}

	//====================================================================================================================================//

	@Test(priority = 1)
	public void loginPageTest() throws InterruptedException, Throwable {


		/*
		 * This method is used to validate Login page is visible or not after fresh installaton.
		 * */


		commonCode();

		/*Enter Mobile Number Page*/
		/* "HELLO title is visible or not*/

		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		logg.info(emnp.getLoginTextMobNum().getText());
	}

	//====================================================================================================================================//

	@Test(dependsOnMethods = "loginPageTest" , priority = 2)
	public void backToLoginPageTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to validate Edit mobile number in OTP page and Return back to Enter mobile number page or not.
		 * By passing a parameter of mobile number
		 * */

		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		EnterOtpPage eop = new EnterOtpPage(driver);
		eop.getOtpSentTo().click();
				
		/*Enter Mobile Number Page*/
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		logg.info("Mobile number successfully entered");
	}
	//====================================================================================================================================//


	@Test(dependsOnMethods = "loginPageTest" ,priority = 3)
	public void continueDisableMobNumTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to validate Enter mobile num page, check continue button is enable to click at mob num enterd less than 10 digits.
		 * */


		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("ASSERTION", 10, 1);
		driver.hideKeyboard();
		emnp.getContinueButton().click();
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		logg.info(emnp.getLoginTextMobNum().getText());
		logg.info("Continue Button is Disabled");
	}
	//====================================================================================================================================//


	@Test(dependsOnMethods = "loginPageTest" ,priority = 4)
	public void wrongOtpTest() throws InterruptedException, Throwable{

		/*
		 * This method is used for validate OTP Screen with Wrong OTP.
		 * */


		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	
		/*Invalid OTP*/
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 1, 3);
		eop.getContinueButton().click();
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 2), eop.getIncorrectOtpText());
		logg.warn(eop.getIncorrectOtpText().getText());
	}
	//====================================================================================================================================//


	@Test(dependsOnMethods = "loginPageTest" ,priority = 5)
	public void continueDisableOtpTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to validate Enter OTP page, check continue button is enable to click at OTP enterd less than 6 digits.
		 * */


		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	
		/*Invalid OTP*/
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("ASSERTION", 11, 1);
		eop.getContinueButton().click();
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		logg.info("Continue Button is Disabled");
	}
	//====================================================================================================================================//


	@Test(dependsOnMethods = "loginPageTest" ,priority = 6)
	public void resendOtpEnableAfter30Second() throws InterruptedException, Throwable {

		/*
		 * This methd is used to check Resend Button is Enabled After 30sec once we hit send OTP
		 * */


		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	
		/*Invalid OTP*/
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		logg.info(eop.getDetectingOtp().getText());

		for (int i = 0; i < 200; i++) {

			String resendOtp = eop.getResendOtpButton().getText();

			if(resendOtp.equals("Resend OTP (in 00:00s)")) {

				eop.getSendKeyButton("MobileNumbers", 1, 1);
				eop.getContinueButton().click();
				logg.info("OTP successfully entered");
				break;
			}
		}
		//Enter your Display name.	
		EnterDisplayNamePage ednp = new EnterDisplayNamePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 6, 1), ednp.getTitleText());
		logg.info(ednp.getTitleText().getText()+" From Display name page");
	}
	//====================================================================================================================================//


























}
