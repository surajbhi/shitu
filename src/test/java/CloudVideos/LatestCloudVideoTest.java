package CloudVideos;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CameraFunctionsPage;
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

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class LatestCloudVideoTest extends BaseClasss {

	@Test
	public void latestVideoTest() throws InterruptedException, Throwable {

		/*
		 * This method is used to play/pause live stream and download Latest cloud video
		 * and play that video and check.
		 */

		wLib.waitUntilPageLoad(driver);

		// Next
		FirstPage fp = new FirstPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 1, 1), fp.getCloudStorageText());
		fp.getNextButton().click();

		SecondPage secp = new SecondPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 2, 1), secp.getCloudStorageText());
		secp.getNextButton().click();

		ThirdPage tp = new ThirdPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 3, 1), tp.getCloudStorageText());
		tp.getNextButton().click();

		// Enter your Mobile Number.
		EnterMobNumPage emnp = new EnterMobNumPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 4, 1), emnp.getHelloTitle());
		emnp.getSendKeyButton("MobileNumbers", 3, 0);
		driver.hideKeyboard();
		emnp.getContinueButton().click();

		// Enter OTP
		EnterOtpPage eop = new EnterOtpPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 5, 1), eop.getDetectingOtp());
		eop.getSendKeyButton("MobileNumbers", 1, 1);
		eop.getContinueButton().click();

		// Enter your Display name.
		EnterDisplayNamePage ednp = new EnterDisplayNamePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 6, 1), ednp.getTitleText());
		ednp.getSendKeyButton("MobileNumbers", 1, 2);
		ednp.getContinueButton().click();

		// Skip for Now
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSkipForNow().click();

		// Cancel
		Buttons btn = new Buttons(driver);
		wLib.waitAndClick(btn.getCancelButton());
		wLib.waitAndClick(btn.getCancelButton());

		// Home Page

		HomePage hp = new HomePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 8, 1), hp.getCamerasTitle());
		try {
			hp.getVerticalCamButton().click();
		} catch (Exception e) {
			logg.warn("Vertical Camera List Element not there in Home page");
		}

		aLib.findScrollable(driver, eLib.getDataFromExcel("CameraNames", 4, 0));
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		String cam = vcp.getSunayana().getText();
		if (cam.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {
			vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		} else {
			logg.warn("Camera Not found");
		}
		vcp.getVerifyNow().click();
		wLib.waitAndClick500(hp.getLiveCamera());// Live Stream starts

		// Camera Functions Page
		CameraFunctionsPage cfp = new CameraFunctionsPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 10, 1), cfp.getTitle());
		cfp.getCancelButton().click();
		wLib.waitAndClick(cfp.getPhotoButton());
		wLib.waitAndClick1(btn.getPermissionAllowButton());
		long startTime = System.nanoTime();

		try {
			if (cfp.getFullScreen().isEnabled() == true) {

				for (int i = 0; i < 30; i++) {
					Thread.sleep(10000);
					cfp.getPhotoButton().click();//Live streaming
				}

				cfp.getBackButton().click();
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				logg.info("Live stream Time is : " + timeElapsed / 1000000 / 1000 / 60 + " Minutes");

			}
		} catch (Exception e) {
			cfp.getPlayPauseButton().click();
			if (cfp.getFullScreen().isEnabled() == true) {
				for (int i = 0; i < 30; i++) {
					Thread.sleep(7000);
					cfp.getPhotoButton().click();
				}

				cfp.getBackButton().click();
				long endTime = System.nanoTime();
				long timeElapsed = endTime - startTime;
				logg.info("Live stream Time is : " + timeElapsed / 1000000 / 1000 / 60 + " Minutes");

			} else {

				logg.error("Live video is not Streaming");
				Assert.assertEquals(true, false);
			}
		}

		// video player
		aLib.startActivity((AndroidDriver<WebElement>) driver, fLib.getPropertyKeyValue("VideoPalyerAppPackage"),fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		VideoPlayerAppPage vpap = new VideoPlayerAppPage(driver);
		try {
			aLib.findScrollableGetText(driver, eLib.getDataFromExcel("VideoPlayer", 1, 0));
			vpap.getMenu().click();
			vpap.getDelete().click();
			vpap.getOk().click();

		} catch (Exception e) {
			System.out.print("");
		}

		// AirtelXsafe
		aLib.startActivity((AndroidDriver<WebElement>) driver, fLib.getPropertyKeyValue("XsafeAppPackage"),fLib.getPropertyKeyValue("XsafeAppActivity"));
		wLib.waitAndClick(hp.getVideosFragment());

		// Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		// Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Date and total videos
		Thread.sleep(2000);
		logg.info("Today Date is                         : "+vfp.getTodayDate().getText());
		Thread.sleep(2000);
		logg.info("Total Videos form app is              : "+vfp.getTodayVideoCount().getText());

		/*Download latest cloud video*/
		//Details of that latest video
		logg.info("Latest cloud video time is            : "+vfp.getLatestVideoTime().getText());
		String durationXsafe = vfp.getLatestVideoDuration().getText();
		logg.info("Latest cloud video duration is        : "+vfp.getLatestVideoDuration().getText());
		vfp.getDownloadVideo().click();

		//Download and share Option page
		CloudVideoDownPage cvdp= new CloudVideoDownPage(driver);
		cvdp.getDownloadButton().click();
		long T1 = System.currentTimeMillis();
		try {
			aLib.toastAssert(driver, eLib.getDataFromExcel("ASSERTION", 36, 4));
			long T2 = System.currentTimeMillis();
			((AndroidDriver<WebElement>) driver).openNotifications();
			Thread.sleep(2000);
			driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Video Downloaded\").instance(0))")).click();
			logg.info("Time taken for download this video is : "+(T2-T1)/1000+" Sec");

		} catch (Exception e) {
			((AndroidDriver<WebElement>) driver).openNotifications();
			logg.error("Cloud video is not able to download");	
			Assert.assertEquals(true, false);

		} 

		Thread.sleep(5000);
		aLib.tapByCoordinates(driver, 350, 1000);
		String durationVidPlayer = driver.findElementById("uplayer.video.player:id/player_overlay_length").getText();
		logg.info("Downloaded cloud video duration is     : "+durationVidPlayer);

		/*Validation of duration time between xsafe app and video player*/
		
		if(durationXsafe.charAt(1)=='0') {

			String appC = durationXsafe.substring(1);

			if (durationVidPlayer.equals(appC)) {
				logg.info("Duration of Video form xsafe app "+durationXsafe+" and Video player "+durationVidPlayer+" is same");
			}else{
				logg.warn("Duration of Video form xsafe app "+durationXsafe+" and Video player "+durationVidPlayer+" is not same");
			}

		}else if(durationXsafe.charAt(1)!='0'){
			String appC = durationXsafe.substring(1);
			if (durationVidPlayer.equals(appC)) {
				logg.info("Duration of Video form xsafe app "+durationXsafe+" and Video player "+durationVidPlayer+" is same");
			}else if(durationXsafe.equals(durationVidPlayer)) {
				logg.info("Duration of Video form xsafe app "+durationXsafe+" and Video player "+durationVidPlayer+" is same");
			}else {
				logg.warn("Duration of Video form xsafe app "+durationXsafe+" and Video player "+durationVidPlayer+" is not same");
			}
		}else {
			System.out.println("");
		}









































	}
}
