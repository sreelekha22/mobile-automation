package com.ta.Mobile_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_Test_calculator {
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		//AppiumDriver<WebElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
		
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		driver.findElement(By.id("digit_1")).click();
		driver.findElement(By.id("digit_4")).click();
		driver.findElement(By.id("op_mul")).click();
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("eq")).click();
		System.out.println(driver.findElement(By.id("result")).getText());
		driver.quit();
	
	}

}
