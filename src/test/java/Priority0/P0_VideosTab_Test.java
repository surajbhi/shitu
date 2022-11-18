package Priority0;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.android.genericLibrary.BaseClasss;
import com.android.objectRepositaryLib.Buttons;
import com.android.objectRepositaryLib.CloudVideoDownPage;
import com.android.objectRepositaryLib.CloudVideoPlayPage;
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

import io.appium.java_client.android.AndroidDriver;



/*
 * This class is for test all the actions in video fragment tab.
 * */


public class P0_VideosTab_Test extends BaseClasss {

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
	public void noVideoRecordedTest() throws InterruptedException, Throwable {

		/*
		 * This method is verify that video tab displays "No Recorded Videos" is there or not.
		 * */

		commonCode();


		//Video Tap Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		
		try {
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
			aLib.touchAction(driver, 115, 313, 640, 313);
			wLib.waitAndClick1(vfp.getDateAndDaySelect());
			logg.info(vfp.getNoVideoRecText().getText());
			logg.info("No video Recorded Text is Successfully visibile");
		} catch (Exception e) {
			aLib.touchAction(driver, 115, 313, 640, 313);
			wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
			wLib.waitAndClick1(vfp.getDateAndDaySelect());
			logg.info(vfp.getNoVideoRecText().getText());
			logg.info("No video Recorded Text is Successfully visibile");
		}
		
		
	}
	//====================================================================================================================================//


	@Test(priority = 2)
	public void videoDisplayByDateTest() throws InterruptedException, Throwable {


		/*
		 * This method is for verify videos is displayed by tap the dates.
		 * */


		commonCode();


		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getDate().click();
		logg.info(vfp.getTodayDate().getText());
		String test = vfp.getTodayVideoCount().getText(); 
		test = test.replaceAll("\\p{P}","");
		logg.info("Total Videos- "+test);

		int totalvideos=Integer.parseInt(test);

		if(totalvideos==0) {
			aLib.touchAction(driver, 250, 318, 300, 318);
			vfp.getDate().click();
			logg.info(vfp.getTodayDate().getText());
			String test1 = vfp.getTodayVideoCount().getText(); 
			test1 = test1.replaceAll("\\p{P}","");
			logg.info("Total Videos- "+test);
		}else {
			System.out.println("");
		}
	}
	//====================================================================================================================================//


	@Test(priority = 3)
	public void videoPlayTest() throws InterruptedException, Throwable {


		/*
		 * This method is for user should be able to navigate to video screen and video should be played
		 * */

		commonCode();


		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getVideoPlay().click();
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		vcp.getVerifyNow().click();

		//Cloud Video Playing Page
		CloudVideoPlayPage cvpp= new CloudVideoPlayPage(driver);
		logg.info(cvpp.getDateTitle().getText());
		boolean actual = cvpp.getVideoPlayingIcon().isEnabled();
		if(actual==true) {
			logg.info("Cloud Video Is Playing Successfully");
		}
		else {
			logg.info("Cloud Video Is Not Playing");
		}	
	}
	//====================================================================================================================================//


	@Test(priority = 4)
	public void nextVideoPlayTest() throws InterruptedException, Throwable {

		/*
		 * This method is for By tapping on next icon, next video from the list will be played.
		 * */


		commonCode();



		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getVideoPlay().click();
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		vcp.getVerifyNow().click();

		//Cloud Video Playing Page
		CloudVideoPlayPage cvpp= new CloudVideoPlayPage(driver);
		logg.info("Today is- "+cvpp.getDateTitle().getText());
		String FirtsVideoDuration = cvpp.getVideoDuration().getText();
		logg.info("Duration Of First Video Is "+FirtsVideoDuration);

		for (int i= 2; i < 5; i++) {
			wLib.waitAndClick(cvpp.getNextButton());
			Thread.sleep(3000);
			String nextVideoDuration = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[\""+i+"\"]/android.view.ViewGroup[1]/android.widget.TextView").getText();
			logg.info("Duration Of Next Video Is "+nextVideoDuration);

			if(FirtsVideoDuration.equals(nextVideoDuration)) {
				wLib.waitAndClick(cvpp.getNextButton());
				continue;
			}
			else {
				break;
			}
		}
		logg.info("Next Button is Tapped Successfully and Video is played");

	}
	//====================================================================================================================================//


	@Test(priority = 5)
	public void previousIconTest() throws  InterruptedException, Throwable {

		/*
		 * This method is for check previous icon is dissable for firts video and visible on next video.
		 * */

		commonCode();



		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getVideoPlay().click();
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		vcp.getVerifyNow().click();

		//Cloud Video Playing Page
		CloudVideoPlayPage cvpp= new CloudVideoPlayPage(driver);
		logg.info("Today is- "+cvpp.getDateTitle().getText());

		cvpp.getPreviousButton();

		//To verify that Element is Enabled At First Video
		Boolean before = cvpp.getPreviousButton().isEnabled();

		if(before) {
			logg.info(" Yes ! Element is Present");
		}
		else {
			logg.info(" NO ! Element is not Present");
		}


		wLib.waitAndClick500(cvpp.getNextButton());

		//To verify that Element is Enabled After clicked next Video
		Boolean after =	cvpp.getPreviousButton().isEnabled();

		if(after) {
			logg.info(" Yes ! Element is Present");
		}
		else {
			logg.info(" NO ! Element is not Present");
		}
	}
	//====================================================================================================================================//


	@Test(priority = 6)
	public void shareDownloadTest() throws InterruptedException, Throwable {

		/*
		 * This method is verify that share and download cloud video option is available or not.
		 * */

		commonCode();


		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getVideoPlay().click();
		VerificationCodePage vcp = new VerificationCodePage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 7, 1), vcp.getVcTitle());
		vcp.getSendKeyButton("CamSerialNumAndVerificationCode", 8, 2);
		vcp.getVerifyNow().click();

		//Cloud Video Playing Page
		CloudVideoPlayPage cvpp= new CloudVideoPlayPage(driver);
		logg.info("Today is- "+cvpp.getDateTitle().getText());
		cvpp.getMoreOPtion().click();

		//Download and share Option page
		CloudVideoDownPage cvdp= new CloudVideoDownPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 36, 1), cvdp.getCameraName());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 36, 2), cvdp.getDownloadAndShareButton());
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 36, 3), cvdp.getDownloadButton());

		logg.info("Download and Share Option is Available");
	}
	//====================================================================================================================================//


	@Test(priority = 7)
	public void durationTest() throws InterruptedException, Throwable {

		/*
		 * This method is for validate Stored cloud video duration is same as downloaded cloud video by some video player app.
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

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getVideoPlay().click();

		//Cloud Video Playing Page
		CloudVideoPlayPage cvpp= new CloudVideoPlayPage(driver);
		logg.info("Today is- "+cvpp.getDateTitle().getText());
		cvpp.getMoreOPtion().click();

		//Download and share Option page
		CloudVideoDownPage cvdp= new CloudVideoDownPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 36, 1), cvdp.getCameraName());
		String durationFromApp = cvdp.getVideoDuration().getText();//00:22
		cvdp.getDownloadButton().click();
		btn.getPermissionAllowButton().click();

		aLib.toastAssert(driver, eLib.getDataFromExcel("ASSERTION", 36, 4));
		
		logg.info("Video Downloaded Successfully");

		//video player
		aLib.startActivity((AndroidDriver<WebElement>) driver,fLib.getPropertyKeyValue("VideoPalyerAppPackage"), fLib.getPropertyKeyValue("VideoPalyerAppActivity"));
		aLib.findScrollable(driver,eLib.getDataFromExcel("VideoPlayer", 1, 0));	
		logg.info("Title of video is                 : "+vpap.getTitle().getText());
		logg.info("Size of video is                  : "+vpap.getSize().getText());
		logg.info("Resolution of video is            : "+vpap.getResolution().getText());
		logg.info("Duration of video in video player : "+vpap.getDuration().getText());
		logg.info("Duration of video in Xsafe app    : "+durationFromApp);

		String durationVidPlayer = vpap.getDuration().getText();
		char firstChar = durationFromApp.charAt(0);

		if(firstChar=='0') {
			String firstRemove = durationFromApp.substring(1);
			if(firstRemove.equals(durationVidPlayer)) {
				logg.info("Duration of Video in App and Duration Of Video in VideoPlayer is same");
			}

		}else if (durationFromApp.equals(durationVidPlayer)) {
			logg.info("Duration of Video in App and Duration Of Video in VideoPlayer is same");
		}
		else {
			logg.warn("Durations Not matching");
		}
	}
	//====================================================================================================================================//


	@Test(priority = 8)
	public void filterRemovelTest() throws InterruptedException, Throwable {

		/*
		 * This mthod is for validate Once filter of camera name is removed by clicking on cross icon, Filters should be reflected accordingly
		 * And Video list should reflect as per the filters added/removed
		 * Once filter is slected and tapped on Apply, user shuld be able to see videos as per filter
		 * */



		commonCode();


		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		fcp.getApplyButton().click();

		//Video Fragment Page
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		String actual = vfp.getListOfVideosCamName().getText();
		//String actual = driver.findElementById("com.airtel.xsafe:id/tv_cam_name").getText();
		System.out.println(actual);
		System.out.println(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		if(actual.equals(eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0))) {

			logg.info("Filterd camera is same as list of videos in videos page");	
		}
		else {
			logg.info("Filterd camera is not same as list of videos in videos page");
		}
	}
	//====================================================================================================================================//


	@Test(priority = 9)
	public void clearAllFilterTest() throws InterruptedException, Throwable {

		/*
		 * This method is for validate by Clear All option in filter and it is disable when any of the filter is deselected.
		 * */

		commonCode();

		//Video Fragment Page
		VideosFragmentPage vfp= new VideosFragmentPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 34, 1), vfp.getVideosTitle());
		vfp.getFilter().click();

		//Filter Camera Page
		FilterCameraPage fcp = new FilterCameraPage(driver);
		wLib.assertion(eLib.getDataFromExcel("ASSERTION", 35, 1), fcp.getFilterTitle());
		wLib.elementPresentOrNot(fcp.getClearAll(), "Element Available", "Element Not Available");
		aLib.findScrollable(driver, eLib.getDataFromExcel("CamSerialNumAndVerificationCode", 8, 0));
		wLib.elementPresentOrNot(fcp.getClearAll(), "Element Available", "Element Not Available");
	}
	//====================================================================================================================================//











}




