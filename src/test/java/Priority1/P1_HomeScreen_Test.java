package Priority1;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.AccountTabPage;
import com.android.objectRepositaryLib.CameraFunctionsPage;
import com.android.objectRepositaryLib.CoachMarkPage;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;

public class P1_HomeScreen_Test extends BaseClasss{

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




	}

	//====================================================================================================================================//

	@Test(priority = 1)
	public void homeScreenTest() throws InterruptedException, Throwable {

		/*
		 * This method is test for after giving all valid credentials, user able to see Home screen.  
		 */

		commonCode();

		//Cancel coach mark 
		CoachMarkPage cmp= new CoachMarkPage(driver);
		wLib.waitAndClick(cmp.getCancelButton());
		wLib.waitAndClick(cmp.getCancelButton());

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		logg.info("Home screen validated successfully");
	}

	//====================================================================================================================================//

	@Test(priority = 2)
	public void coachMark1Test() throws InterruptedException, Throwable {

		/*
		 * This method is test for It should show the Coach Mark for 'Add a device' in the UI overlapping in the 'Home' screen.  
		 */

		commonCode();

		// Coach Mark page 1
		CoachMarkPage cmp= new CoachMarkPage(driver);
		Assert.assertEquals(true, cmp.getCoachMarkpage().isDisplayed());
		wLib.waitAndClick(cmp.getCancelButton());
		logg.info("Coach Mark for Add a Device page is successfully displayed");
	}
	//====================================================================================================================================//


	@Test(priority = 3)
	public void coachMark2Test() throws InterruptedException, Throwable {

		/*
		 * This method is test for It should show the Coach Mark for 'See Live Feed' in the UI overlapping in the 'Home' screen.  
		 */

		commonCode();

		// Coach Mark page 1
		CoachMarkPage cmp= new CoachMarkPage(driver);
		Assert.assertEquals(true, cmp.getCoachMarkpage().isDisplayed());
		wLib.waitAndClick(cmp.getCancelButton());

		// Coach Mark page 2
		Assert.assertEquals(true, cmp.getCoachMarkpage().isDisplayed());
		wLib.waitAndClick(cmp.getCancelButton());

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		logg.info("Coach Mark for See Live Feed page is successfully displayed");
	}
	//====================================================================================================================================//

	@Test(priority = 4)
	public void expanderIconTest() throws InterruptedException, Throwable {

		/*
		 * This method is test fornExpander' Icon(<->)' should only come once the Camera Grid is in "Live view'
		 */

		commonCode();

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
		hp.getLiveCamera().click();

		//Camera Functions page
		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 1), cfp.getTitle());
		cfp.getCancelButton().click();

		boolean bef = cfp.getFullScreen().isEnabled();
		Assert.assertEquals(true, bef);
		logg.info("Expander is Enabled at live feed is in play state");

		wLib.waitAndClick(cfp.getPlayPauseButton());

		try {
			boolean aft = cfp.getFullScreen().isEnabled();
			Assert.assertEquals(true, aft);
			logg.info("Expander is Enabled at live feed is in pause state");
		} catch (Exception e) {
			logg.info("Expander is Disabled at live feed is in pause state");
		}

	}
	//====================================================================================================================================//

	@Test(priority = 5)
	public void listGridTest() throws InterruptedException, Throwable {

		/*
		 * This method is for Grid should be visible when 2 or more camera is there in account and it is not visible when camera is less than 2.
		 */

		commonCode();

		//Cancel coach mark 
		CoachMarkPage cmp= new CoachMarkPage(driver);
		wLib.waitAndClick(cmp.getCancelButton());
		wLib.waitAndClick(cmp.getCancelButton());

		//Home page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		hp.getAccountFragment().click();

		//Account tab
		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		aLib.touchAction(driver, 340, 1300, 340, 240);
		
		//Extract values(num) form strings and convert string into int.
		String numOfDev = atp.getNumOfDevices().getText();
		System.out.println(numOfDev);
		String values = StringUtils.getDigits(numOfDev);
		System.out.println(values);
/*		int i=Integer.parseInt(values);  
		
		logg.info("There are "+numOfDev+" in this account");
		atp.getHomeFragment().click();

		//Home page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());

		//vertical cam list.
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			if(i>2) {
			hp.getVerticalCamButton().click();
			logg.info("Vertical Camera List Element is there in Home page Because There are "+numOfDev+" in this account");
			}
		} catch (Exception e) {
			if(i<=2) {
			logg.warn("Vertical Camera List Element not there in Home page Because There are "+numOfDev+" in this account");
			}
		}
		
		*/
	}

	//====================================================================================================================================//

		




























































































}
