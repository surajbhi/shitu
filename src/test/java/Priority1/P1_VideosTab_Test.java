package Priority1;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CloudVideoDownPage;
import com.android.objectRepositaryLib.EnterDisplayNamePage;
import com.android.objectRepositaryLib.EnterMobNumPage;
import com.android.objectRepositaryLib.EnterOtpPage;
import com.android.objectRepositaryLib.FilterCameraPage;
import com.android.objectRepositaryLib.FirstPage;
import com.android.objectRepositaryLib.HomePage;
import com.android.objectRepositaryLib.SecondPage;
import com.android.objectRepositaryLib.ThirdPage;
import com.android.objectRepositaryLib.VerificationCodePage;
import com.android.objectRepositaryLib.VideoPlayerAppPage;
import com.android.objectRepositaryLib.VideosFragmentPage;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/*
 * This class is for test all the actions in video fragment tab.
 * */

public class P1_VideosTab_Test extends BaseClasss{

	public void commonCode() throws InterruptedException, Throwable {

		/*
		 * This method contains all the commonly writen codes for this class.
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
		hp.getVideosFragment().click();

	}

	//===============================================================================================================================//

	@Test(priority = 1)
	public void videosDisplayScrollBarTest() throws InterruptedException, Throwable {

		/*
		 * This method is verify that video tab displays current date and last seven days videos.
		 * PRE REQUEST- That Video Player app has empty videos in airtel xsafe folder.
		 * */

		wLib.waitUntilPageLoad(driver);

		//video player
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("VideoPalyerAppPackage"), fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		VideoPlayerAppPage vpap= new  VideoPlayerAppPage(driver);
		try {
			aLib.findScrollableGetText(driver,eLib.getDataFromExcel("VideoPlayer", 1, 0));	
			vpap.getMenu().click();
			vpap.getDelete().click();
			vpap.getOk().click();
			logg.info("Videos deleted");
		} catch (Exception e) {
			logg.info("There is no Folder of Airtel Xsafe");
		}

		//AirtelXsafe
		aLib.startActivity((AndroidDriver<WebElement>) driver, fLib.getPropertyKeyValue("XsafeAppPackage"), fLib.getPropertyKeyValue("XsafeAppActivity"));

		commonCode();

		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.waitAndClick(vfp.getHomeFragment());

		//Home Page
		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.info("Element not there");
		}

		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		Buttons btn = new Buttons(driver);
		btn.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		vcp.getVerifyNow().click();
		hp.getVideosFragment().click();

		/*Current date test*/
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		String number = vfp.getTodayDate().getText();//Date in App
		String str = StringUtils.getDigits(number);//Extract number from string
		int todayDate = Integer.parseInt(str);//Convert string to int
		Object value = jLib.onlyDate("dd");//Date from system
		int systemDate = Integer.parseInt(value.toString());//Convert object to int

		
		if (todayDate==systemDate) {
			logg.info("Today date is "+systemDate+" , Date form our app is "+todayDate+" , Both are same");;
		}else {
			Assert.assertEquals(false, true);
			logg.info("App date is not same as system date");
		}


		//Seven days video test
		logg.info("Last seven days cloud videos Download process start");
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());

		for(int i = 0; i<8; i++) {

			vfp.getDate().click();
			String date = vfp.getDateText().getText();
			String day = vfp.getDayText().getText();
			int date2=Integer.parseInt(date); 

			@SuppressWarnings("rawtypes")
			TouchAction t = new TouchAction(driver);
			if(date2==date2) {
				t.press(PointOption.point(250, 318))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(300, 318)).release().perform();
			}
			t.press(PointOption.point(250, 318))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(350, 318)).release().perform();

			String totalvideo = vfp.getTodayVideoCount().getText();
			String test = totalvideo; 
			test = test.replaceAll("\\p{P}","");
			logg.info("DATE- "+date+" DAY- "+day+" TOTAL VIDEOS IS- "+test);
			int totalvideos=Integer.parseInt(test);

			if(totalvideos>0) {
				vfp.getDownloadVideo().click();

				//Cloud video download page
				CloudVideoDownPage cvdp= new CloudVideoDownPage(driver);
				cvdp.getDownloadButton().click();
				try {
					btn.getPermissionAllowButton().click();
				} catch (Exception e) {
					continue;
				}

				try {
					aLib.toastAssert(driver, eLib.getDataFromExcel("ASSERTION", 36, 4));
				} catch (Exception e) {
					logg.info("Video is not downloaded in this Date");
				}
			}
			else {
				continue;
			}
		}

		//video player
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("VideoPalyerAppPackage"), fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 39, 1), vpap.getTitle());
		logg.info(vpap.getTitle().getText()+" has "+vpap.getTextCount().getText());
	}

	//===============================================================================================================================//



































}
