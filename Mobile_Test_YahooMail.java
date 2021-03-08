package com.ta.Mobile_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_Test_YahooMail {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		//AndroidDriver<MobileElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
		
		cap.setCapability("appPackage", "com.yahoo.mobile.client.android.mail");
		cap.setCapability("appActivity", "com.yahoo.mobile.client.android.mail.activity.MainActivity");
		cap.setCapability("noReset",true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);



	}

}
