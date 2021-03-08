package com.ta.Mobile_test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Pixel_clock {
	
	static AndroidDriver<MobileElement> driverMob;
	
	public static void main(String[] args) throws Exception {
		Launch();
		//CreateNewAlarm();
		//EnableOrDisableAlarm();
		DeleteParticularAlarm();
	}
	public static void Launch() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "94BAY0LTVT");
		
		cap.setCapability("appPackage", "com.google.android.deskclock");
		cap.setCapability("appActivity", "com.android.deskclock.DeskClock");
	    
		driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		Thread.sleep(1000);
	}
	
	public static void CreateNewAlarm() throws Exception {
		MobileElement alarm = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.google.android.deskclock:id/cities\"))"
		          + ".scrollIntoView(new UiSelector().resourceId(\"com.google.android.deskclock:id/tab_menu_alarm\"))");
		alarm.click();
		
		MobileElement CreateNewAlarm = driverMob.findElementById("com.google.android.deskclock:id/fab");
		CreateNewAlarm.click();
		
		WebDriverWait wait = new WebDriverWait(driverMob,20);
		WebElement CreateNewAlarm1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/toggle_mode")));      
		CreateNewAlarm1.click();
		
		WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/input_hour")));      
		hour.click();
		hour.clear();
		hour.sendKeys("7");
		
		WebElement minute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/input_minute")));      
		minute.click();
		minute.clear();
		minute.sendKeys("30");
		
		WebElement ampm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/am_pm_spinner")));      
		ampm.click();
		
		WebElement am = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/text1")));      
		am.click();
		
		WebElement ok = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));      
		ok.click();
		
		System.out.println("New alarm is created.");
		Thread.sleep(2000);
	}
	public static void EnableOrDisableAlarm() {
		MobileElement alarm = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.google.android.deskclock:id/cities\"))"
		          + ".scrollIntoView(new UiSelector().resourceId(\"com.google.android.deskclock:id/tab_menu_alarm\"))");
		alarm.click();
		WebDriverWait wait = new WebDriverWait(driverMob,20);
		WebElement Enable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/onoff")));      
		Enable.click();
	}
	public static void DeleteParticularAlarm() {
		MobileElement alarm = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.google.android.deskclock:id/cities\"))"
		          + ".scrollIntoView(new UiSelector().resourceId(\"com.google.android.deskclock:id/tab_menu_alarm\"))");
		alarm.click();
		WebDriverWait wait = new WebDriverWait(driverMob,20);
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@index='1']")));      
		dropdown.click();

		WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/delete")));      
		delete.click();

	}

}
