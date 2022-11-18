package Priority0;

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
 * This class is for Test Account Tab activites and validate the prices.
 * */

public class P0_AccountTab_Test extends BaseClasss {

	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method has all the common code used in this class. 
		 * */

		wLib.waitUntilPageLoad(driver);
		//Next		
		FirstPage fp= new FirstPage(driver);
		//wLib.assertion(eLib.getDataFromExcel("ASSERTION", 1, 1), fp.getCloudStorageText());
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

	//==========================================================================================================================================//

	@Test(priority = 1)
	public void priceForPlans() throws InterruptedException, Throwable {

		/*
		 * This method is to validate plan amount for monthly and annualy subscriptions.
		 * */

		commonCode();

		//Account tab Subscription page
		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("ExpectedElement", 2, 0));	
		try {
			String toastMessage=atp.getpaymentInToastMsg().getText();
			Assert.assertEquals(eLib.getDataFromExcel("ASSERTION", 23, 2), toastMessage);
			logg.info(toastMessage);
			driver.closeApp();
		} catch (Exception e) {



			//Select Plan Page
			SelectPlanPage spp = new SelectPlanPage(driver);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 24, 1), spp.getSelectPlanTitle());

			/*This try catch block is for Annual Subscription Paln*/
			try {

				if(spp.getAnnualText().getText().equals("Annual")) {

					logg.info("Amount For "+spp.getAnnualText().getText()+" Plan is "+spp.getAnnualPlanAmmount().getText()+" "+spp.getAnnualForDevicesText().getText()+" "+spp.getAnnualValidTillText().getText());

				}
			} catch (Exception e1) {
				logg.warn("This Account Has No Annual Subscription");

			}


			/*This try catch block is for Monthly Subscription Paln*/
			try {

				if(spp.getMonthlyText().getText().equals("Monthly")) {

					logg.info("Amount For "+spp.getMonthlyText().getText()+" Plan is "+spp.getMonthlyPlanAmount().getText()+" "+spp.getMonthlyForDevicesText().getText()+" "+spp.getMonthlyValidTillText().getText());

				}
			} catch (Exception e2) {
				logg.warn("This Account Has No Monthly Subscription");
			}
		}

	}

	//==========================================================================================================================================//

	@Test(priority = 2)
	public void appVersionTest() throws InterruptedException, Throwable {


		/*
		 * This method is check the app version form account tab .
		 * */


		commonCode();

		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.touchAction(driver, 340, 1300, 340, 240);
		
		try {
			boolean version = atp.getVersionText().isEnabled();
			logg.info(version);
			Assert.assertEquals(true, version);
		} catch (Exception e) {
			aLib.touchAction(driver, 340, 1300, 340, 240);
			boolean version = atp.getVersionText().isEnabled();
			logg.info(version);
			Assert.assertEquals(true, version);
		}

		logg.info(atp.getVersionText().getText());
		logg.info("User can able to see the Xsafe App Version");

	}
	//==========================================================================================================================================//

}


















