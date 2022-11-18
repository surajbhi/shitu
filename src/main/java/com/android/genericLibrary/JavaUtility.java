package com.android.genericLibrary;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class JavaUtility {

	public static AndroidDriver<WebElement> driver;

	/**
	 * This method will generated a random number and return it to the caller
	 * @return 
	 */
	public int getRandomNumber() {
		Random ran= new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	/**
	 * This method will return the current date
	 * @return 
	 */
	public String getCurrentDate() {
		Date date= new Date();
		String currentDate= date.toString();
		return currentDate;
	}

	/**
	 * This method will return date in specified format
	 * @return 
	 */
	public String getFinalDateFormat() {
		Date date= new Date();
		String d=date.toString();
		String[] dte=d.split(" ");
		String YYYY=dte[5];
		String DD=dte[2];
		String MM=dte[1];
		String today=YYYY+"-"+MM+"-"+DD;
		return today;
	}

	/**
	 * This method will convert String to integer
	 * @return 
	 */
	public int getStringToInteger(String str) {
		int intt=Integer.parseInt(str);
		return intt;
	}

	/**
	 * This method for get date and time form system
	 */
	public void systemDateTime() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println("Today Date and Time is : "+dtf.format(now)); 

	}


	/**
	 * This method for send data or parameter in console
	 */

	public void scanner() {

		@SuppressWarnings("resource")
		Scanner myObj = new Scanner(System.in); 
		System.out.println("Enter which date you want to download cloud videos");
		String date = myObj.nextLine();
		System.out.println("The date you given is  : " + date);
	}
	
	/**
	 * This method for get date and time form system
	 * @return 
	 */
	public Object onlyDate(String need) {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(need);
		String str = formatter.format(date);
		return str; 

	}














}

