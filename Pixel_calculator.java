package com.ta.Mobile_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Pixel_calculator {
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "94BAY0LTVT");
		
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(1000);
		driver.findElement(By.id("digit_1")).click();
		driver.findElement(By.id("digit_4")).click();
		driver.findElement(By.id("op_mul")).click();
		driver.findElement(By.id("digit_5")).click();
		driver.findElement(By.id("eq")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText());
		driver.quit();
	}

}
