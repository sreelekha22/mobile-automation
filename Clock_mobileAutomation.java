package com.ta.Mobile_test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Clock_mobileAutomation {
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		Launch();
		//CreateNewAlarm();
		//EnableOrDisableAlarm();
		//DeleteParticularAlarm();	
		
	}
	
public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "com.google.android.deskclock");
		cap.setCapability("appActivity", "com.android.deskclock.DeskClock");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}
public static void CreateNewAlarm() throws Exception {
	MobileElement alarm = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.google.android.deskclock:id/app_bar_layout\"))"
	          + ".scrollIntoView(new UiSelector().text(\"ALARM\"))");
	alarm.click();
	
	MobileElement CreateNewAlarm = driver.findElementById("com.google.android.deskclock:id/fab");
	CreateNewAlarm.click();
	
	WebDriverWait wait = new WebDriverWait(driver,20);
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
	MobileElement alarm = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.google.android.deskclock:id/app_bar_layout\"))"
	          + ".scrollIntoView(new UiSelector().text(\"ALARM\"))");
	alarm.click();
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement Enable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/onoff")));      
	Enable.click();
}
public static void DeleteParticularAlarm() {
	MobileElement alarm = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.google.android.deskclock:id/app_bar_layout\"))"
	          + ".scrollIntoView(new UiSelector().text(\"ALARM\"))");
	alarm.click();
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"9:00 AM Alarm\"]")));      
	dropdown.click();

	WebElement delete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.google.android.deskclock:id/delete")));      
	delete.click();

}

}
