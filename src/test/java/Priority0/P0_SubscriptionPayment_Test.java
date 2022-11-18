package Priority0;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.AccountTabPage;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.SelectPlanPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;


/*
 * This class is for check the details of subscription and payment details of camera
 * */

public class P0_SubscriptionPayment_Test extends BaseClasss {




	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method have common code have all the below methods
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

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		hp.getAccountFragment().click();

	}

	//===========================================================================================================================//

	@Test
	public void monthlySubscription() throws InterruptedException, Throwable {

		/*
		 * This method is for check the "MONTHLY" subscription and payment option is working fine or not.
		 * */

		commonCode();

		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("ExpectedElement", 2, 0));	
		try {
			String toastMessage=atp.getpaymentInToastMsg().getText();
			Assert.assertEquals(eLib.getDataFromExcel("ASSERTION", 23, 2), toastMessage);
			logg.info(toastMessage);
			driver.closeApp();
		} catch (Exception e) {

			//Select plan page
			SelectPlanPage spp = new SelectPlanPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 24, 1), spp.getSelectPlanTitle());

			/*This try catch block is for "Monthly" Subscription Paln*/
			try {

				if(spp.getMonthlyText().getText().equals("Monthly")) {

					spp.getMonthlyPayNow().click();
					String toastMessage=driver.findElement(By.xpath("//*[@text='Installation Incomplete for Devices']")).getText();
					Assert.assertEquals("Installation Incomplete for Devices", toastMessage);
					logg.info(toastMessage);
					logg.info("This Camera has no mapping with this Account");
				}
			} catch (Exception e1) {
				logg.info("This Account Has No Monthly Subscription");
			}
		}
	}
	//====================================================================================================================================//


	@Test
	public void yearSubscription() throws InterruptedException, Throwable {

		/*
		 * This method is for check the "YEARLY" subscription and payment option is working fine or not.
		 * */

		commonCode();

		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("ExpectedElement", 2, 0));	
		try {
			String toastMessage=atp.getpaymentInToastMsg().getText();
			Assert.assertEquals(eLib.getDataFromExcel("ASSERTION", 23, 2), toastMessage);
			logg.info(toastMessage);
			driver.closeApp();
		} catch (Exception e) {


			//Select plan page
			SelectPlanPage spp = new SelectPlanPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 24, 1), spp.getSelectPlanTitle());


			/*This try catch block is for "Annual" Subscription Paln*/
			try {

				if(spp.getAnnualText().getText().equals("Annual")) {
					spp.getAnnualPayNow().click();
					String toastMessage=driver.findElement(By.xpath("//*[@text='Installation Incomplete for Devices']")).getText();
					Assert.assertEquals("Installation Incomplete for Devices", toastMessage);
					logg.info(toastMessage);
					logg.info("This Camera has no mapping with this Account");

				}
			} catch (Exception e1) {
				logg.info("This Account Has No Annual Subscription");
			}
		}
	}
	//====================================================================================================================================//



}





















