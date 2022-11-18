package CloudVideos;

import java.net.MalformedURLException;

import java.net.ServerSocket;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class allCloudVidosDownload {
	
	
	/*
	 * This class script helps to download all the cloud videos from a single date by giving date at first.
	 * **/
	
	public AndroidDriver<MobileElement> driver;

	public boolean checkIfServerIsRunning(int port) {
		boolean isServerIsRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (Exception e) {

			isServerIsRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerIsRunning;
	}

	public void startServer() {
		org.apache.commons.exec.CommandLine cmd= new org.apache.commons.exec.CommandLine("C:\\\\Program Files\\\\nodejs\\\\node.exe");
		cmd.addArgument("C:\\Users\\A1Q5SAYJ\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");


		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executer= new DefaultExecutor();
		executer.setExitValue(1);

		try {
			executer.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void stopServer() {
		Runtime runtime= Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	@BeforeClass
	public  void configBC() throws InterruptedException, MalformedURLException {

		//Common Desired capabilities of our device.
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "vivo 1820");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		dc.setCapability(MobileCapabilityType.UDID, "USYSSW4P9SW8CESC");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		dc.setCapability(MobileCapabilityType.NO_RESET,"false");
		dc.setCapability(MobileCapabilityType.FULL_RESET,"false");


		//Details about our Testing app.
		dc.setCapability("appPackage","com.airtel.xsafe");
		dc.setCapability("appActivity","com.airtel.xsafesdk.ui.activity.SplashScreenActivity");

		if(checkIfServerIsRunning(4723)) {
			stopServer();		
		}


		startServer();
		driver= new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);

		System.out.println("Server started successfully");
		System.out.println("Application Launched Successfully");
	}


	@Test
	public void Tc1() throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Enter which date you want to download cloud videos");
		String date = myObj.nextLine();
		System.out.println("The date you given is  : " + date);



		//Next
		driver.findElement(By.id("com.airtel.xsafe:id/btn_submit")).click();
		driver.findElement(By.id("com.airtel.xsafe:id/btn_submit")).click();
		driver.findElement(By.id("com.airtel.xsafe:id/btn_submit")).click();

		//Enter your Mobile Number.
		driver.findElementById("com.airtel.xsafe:id/tie").sendKeys("7060128763");
		driver.hideKeyboard();
		driver.findElement(By.id("com.airtel.xsafe:id/btn_continue")).click();

		//Enter OTP
		Thread.sleep(3000);
		driver.findElement(By.id("com.airtel.xsafe:id/tie")).sendKeys("123456");
		Thread.sleep(1000);
		driver.findElement(By.id("com.airtel.xsafe:id/btn_continue")).click();

		//Enter your Display name.
		Thread.sleep(1000);
		driver.findElement(By.id("com.airtel.xsafe:id/tie")).sendKeys("AirXS");
		driver.findElement(By.id("com.airtel.xsafe:id/btn_continue")).click();

		//Skip for Now
		Thread.sleep(3000);
		driver.findElement(By.id("com.airtel.xsafe:id/btn_negative")).click();

		//Cancel 
		Thread.sleep(2000);
		driver.findElement(By.id("com.airtel.xsafe:id/iv_cancel")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.airtel.xsafe:id/iv_cancel")).click();


		//vertical cam list.
		Thread.sleep(1000);
		driver.findElementById("com.airtel.xsafe:id/switch_layout").click();


		//Configurate The Cam
		Thread.sleep(2000);
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Sunayana locked\").instance(0))")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.airtel.xsafe:id/tie")).sendKeys("DLOAWE");
		driver.findElementById("com.airtel.xsafe:id/btn_positive").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Videos\"]/android.widget.FrameLayout/android.widget.ImageView").click();
		Thread.sleep(3000);
		driver.findElementById("com.airtel.xsafe:id/iv_filter").click();
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Sunayana\").instance(0))")).click();//Change camera name you want in filter page
		driver.findElementById("com.airtel.xsafe:id/btn_done").click();

		//Go to day and get text
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Today Date and Time is : "+dtf.format(now));  
		System.out.println("");

		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='"+date+"']").click();

		Thread.sleep(3000);
		System.out.println("Total Videos form app is : "+driver.findElementById("com.airtel.xsafe:id/tv_today_no").getText());
		System.out.println("");
		String totalVideo = driver.findElementById("com.airtel.xsafe:id/tv_today_no").getText();
		String totalVideos = totalVideo; 
		totalVideos = totalVideos.replaceAll("\\p{P}","");
		int tvideos=Integer.parseInt(totalVideos); 

		//Download the video

		System.out.println("Sr.no ,"+"   Time   , "+"Duration ,  "+"validation ,  "+"Time for download"+"  ,  SystemTime");

		Thread.sleep(3000);
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ScrollView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup").click();

		Thread.sleep(1000);
		driver.findElementById("com.airtel.xsafe:id/fl_more").click();

		Thread.sleep(1000);
		String duration = driver.findElementById("com.airtel.xsafe:id/tv_duration").getText();

		Thread.sleep(1000);
		String time = driver.findElementById("com.airtel.xsafe:id/tv_timeStamp").getText();

		Thread.sleep(1000);
		driver.findElementById("com.airtel.xsafe:id/tv_download").click();

		Thread.sleep(1000);
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		long T1 = System.currentTimeMillis();

		Thread.sleep(1000);
		driver.findElementById("com.airtel.xsafe:id/iv_play_pause").click();

		long startTime = System.nanoTime();

		try {
			String toastMessages=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
			Assert.assertEquals("Video Downloaded", toastMessages);//Actual validation
			long T2 = System.currentTimeMillis();
			System.out.println("  1   , "+time+" ,  "+duration+"   ,     "+"PASS"+"    ,       "+(T2-T1)/1000+" Sec"+"         ,   "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());

		} catch (Exception e) {
			System.out.println("  1   , "+time+" ,  "+duration+"   ,     "+"FAIL"+"                          ,   "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());
		} 

		Thread.sleep(1000);
		driver.findElementById("com.airtel.xsafe:id/iv_next").click();


		for (int i = 2; i <= tvideos; i++) {

			Thread.sleep(3000);
			driver.findElementById("com.airtel.xsafe:id/fl_more").click();

			Thread.sleep(1000);
			String duration1 = driver.findElementById("com.airtel.xsafe:id/tv_duration").getText();//10

			Thread.sleep(1000);
			String time1 = driver.findElementById("com.airtel.xsafe:id/tv_timeStamp").getText();//11

			Thread.sleep(1000);
			driver.findElementById("com.airtel.xsafe:id/tv_download").click();
			long T3 = System.currentTimeMillis();

			Thread.sleep(1000);
			driver.findElementById("com.airtel.xsafe:id/iv_play_pause").click();

			try {
				String toastMessages1=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
				Assert.assertEquals("Video Downloaded", toastMessages1);//Actual validation
				long T4 = System.currentTimeMillis();
				System.out.println("  "+i+"   , "+time1+" ,  "+duration1+"   ,     "+"PASS"+"    ,       "+(T4-T3)/1000+" Sec"+"         ,   "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());

			} catch (Exception  e) {



				try {
					driver.findElementById("com.airtel.xsafe:id/fl_more").click();

					Thread.sleep(1000);
					String duration2 = driver.findElementById("com.airtel.xsafe:id/tv_duration").getText();//10

					Thread.sleep(1000);
					String time2 = driver.findElementById("com.airtel.xsafe:id/tv_timeStamp").getText();//11

					Thread.sleep(1000);
					driver.findElementById("com.airtel.xsafe:id/tv_download").click();
					long T5 = System.currentTimeMillis();

					String toastMessages1=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
					Assert.assertEquals("Video Downloaded", toastMessages1);//Actual validation
					long T6 = System.currentTimeMillis();
					System.out.println("  "+i+"   , "+time2+" ,  "+duration2+"   ,     "+"PASS"+"    ,       "+(T6-T5)/1000+" Sec"+"         ,   "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());

				} catch (Exception e2) {
					System.out.println("  "+i+"   , "+time1+" ,  "+duration1+"   ,     "+"FAIL"+"                          ,   "+LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond());

					driver.toggleWifi();//wifi off

					Thread.sleep(2000);
					driver.toggleWifi();//wifi on
					Thread.sleep(2000);
					driver.openNotifications();
					Thread.sleep(1000);
					driver.findElementById("com.android.systemui:id/btn_dismiss").click();
				}



			}


			Thread.sleep(1000);
			driver.findElementById("com.airtel.xsafe:id/iv_next").click();
		}

		//Uplayer
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Total time taken for all video download is : "+timeElapsed / 1000000/1000/60+" Minutes");
		System.out.println();
		Thread.sleep(10000);
		Activity activity = new Activity("uplayer.video.player", "android.video.player.activity.MainActivity");
		driver.startActivity(activity);

		Assert.assertEquals("AirtelXSafe", driver.findElementById("uplayer.video.player:id/txt_title").getText());

		System.out.println("Total video from video player is : "+driver.findElementById("uplayer.video.player:id/txt_count").getText());

		System.out.println("Total size of video is           : "+driver.findElementById("uplayer.video.player:id/txt_size").getText());



	}

	@AfterClass
	public void tearDown() {
		//driver.quit();
		//stopServer();
		System.out.println("Closing the server and driver");
	}	


}





































