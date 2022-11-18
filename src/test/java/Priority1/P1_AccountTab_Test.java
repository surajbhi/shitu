package Priority1;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;
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
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;

import ru.yandex.qatools.ashot.comparison.ImageDiffer;


/*
 * This class is for Test Account Tab activites and validate the prices.
 * */

public class P1_AccountTab_Test extends BaseClasss{

	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method has all the common code used in this class. 
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

	//==========================================================================================================================================//


	@Test
	public void camImageTest() throws InterruptedException, Throwable {

		/*
		 * This method is  Validate Subscription Section with Correct Device Image and Subscription details.
		 * */

		commonCode();

		//Account tab Subscription page
		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());


		BufferedImage expected = ImageIO.read(new File(".//ExpectedImages//360camIcon.png"));

		// Object expected = wLib.takeExpectedScreenshot(atp.getCamIcon());
		
		//wLib.screenshotComparisionBuffer(atp.getCamIcon(), expected, "360camIconActual");

	    ImageDiffer imageDiffer = new ImageDiffer();
	    imageDiffer.makeDiff(expected,  atp.getCamIcon());



	}
 



	@Test
	public void manageSubscription() throws InterruptedException, Throwable {

		/*
		 * This method is  Validate Manage Subscription Section Validation in UI.
		 * */

		commonCode();  
        
		AccountTabPage atp = new AccountTabPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 1), atp.getAccountTitle());
		System.out.println("Account Apgae Alnded Successfully");
         
		atp.getManageSubDot().click();
		Thread.sleep(2000);
		atp.getManageSubButton().click();
		Thread.sleep(2000);

		String Val = atp.getManageSubHeader().getText();		
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 3), atp.getManageSubHeader());
		logg.info("Manage Subscription Successfully Opned");
	    
	    String Val2 = atp.getManageSubPlanBenefits().getText();
	    System.out.println("*****************"+Val2+"**************"); 
	    wLib.assertion(eLib.getDataFromExcel("ASSERTION", 23, 4), atp.getManageSubPlanBenefits());
	    logg.info("Manage Subscription screen is having 'Plan Benefits' section");
	    
	    
	}



}


























