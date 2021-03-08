package com.ta.Mobile_test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Walmart_AppAutomation {
	
	static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		Launch();
		StartShopping();
	}
public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "com.walmart.android");
		cap.setCapability("appActivity", "com.walmart.grocery.screen.start.MainActivity");
		cap.setCapability("noReset",true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		/* without "noreset" you should run this code */
		 
//		WebElement Allow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.packageinstaller:id/permission_allow_button")));  
//		Allow.click();
//		
//		WebElement GotIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.walmart.android:id/spotlight_button")));  
//		GotIt.click();
//		
//		WebElement GotIt1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.walmart.android:id/got_it_button")));  
//		GotIt1.click();
	}
public static void StartShopping() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement Departments = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.walmart.android:id/main_bottom_navigation_btn_departments")));  
	Departments.click();
	Thread.sleep(1000);
	MobileElement SchoolSupplies = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.walmart.android:id/pager\"))"
	          + ".scrollIntoView(new UiSelector().text(\"School Supplies\"))");
	SchoolSupplies.click();
	MobileElement ToolsForSeriousStudy = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.walmart.android:id/miniapp_holder\"))"
	          + ".scrollIntoView(new UiSelector().text(\"Tools for Serious Study\"))");
	
	MobileElement AddItem = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.walmart.android:id/miniapp_holder\"))"
	          + ".scrollIntoView(new UiSelector().text(\"Add\"))");
	AddItem.click();
	Thread.sleep(2000);
}
	
}
