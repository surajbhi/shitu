package Priority1;

import org.testng.Assert;
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

public class P1_LoginModule_Test extends BaseClasss{


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
	public void copyPasteMobNumTest() throws InterruptedException, Throwable {

		/*
		 * This method is for copy mobile num and place that in mobile number place holder, and check working properly or not.
		 * */

		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		String copyText=emnp.getSendKeyButton1().getText();
		logg.info(copyText);
		emnp.getTextEraseIcon().click();
		emnp.getSendKeyButton1().sendKeys(copyText);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		logg.info("Mobile number successfully copied and pasted on place holder");

	}

	//====================================================================================================================================//


	@Test(priority = 2)
	public void fieldVisibleTest() throws InterruptedException, Throwable {

		/*
		 * This method is for All the fields like 'OTP Field', Edit Mobile Number,Resend button and timer should be visible.
		 * */

		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	Page
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		logg.info("OTP field is visible");

		//Edit mobile number feild
		eop.getOtpSentTo().click();
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getTextEraseIcon().click();
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		logg.info("Edit Mobile number feild is working fine");

		/*Invalid OTP*/
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


	@Test(priority = 3)
	public void otpValidationTest() throws InterruptedException, Throwable {

		/*
		 * This method is for "Resend OTP should be 'enabled' and 'Continue' button should be 'Enabled' .

		 * */

		commonCode();

		/*Enter Mobile Number Page*/
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		//Enter OTP	Page
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());

		/*Before entering OTP*/
		boolean resendOTP = eop.getResendOtpButton().isEnabled();
		boolean continueBtn = eop.getContinueButton().isEnabled();
		logg.info(resendOTP);
		logg.info(continueBtn);
		Assert.assertEquals(false, resendOTP);
		Assert.assertEquals(false, continueBtn);
		logg.info("Resend otp and continue button is disabled");
		
		eop.getSendKeyButton("MobileNumbers", 1, 1);

		/*After entering OTP*/
		boolean resendOTP1 = eop.getResendOtpButton().isEnabled();
		boolean continueBtn1 = eop.getContinueButton().isEnabled();
		logg.info(resendOTP1);
		logg.info(continueBtn1);
		Assert.assertEquals(true, resendOTP1);
		Assert.assertEquals(true, continueBtn1);

		logg.info("Resend otp and continue button is enabled");

	}

	//====================================================================================================================================//
























}
