package com.ta.Mobile_test;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Chrome_MobileAutomation {
	
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		Launch();
		//Search();
		//History();
		//ClickOnIcon();
		
	}
public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "com.android.chrome");
		cap.setCapability("appActivity", "com.google.android.apps.chrome.IntentDispatcher");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement AcceptAndContinue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/terms_accept")));  
		AcceptAndContinue.click();
		
		WebElement Continue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/positive_button")));  
		Continue.click();
		
		WebElement OkGotIt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/positive_button")));  
		OkGotIt.click();
		
	}
public static void Search() {
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement Search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/search_box_text")));  
	Search.click();
	
	WebElement Search1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/url_bar")));  
	Search1.click();
	Search1.sendKeys("covid-19");
	
	WebElement enter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='covid-19 california']")));  
	enter.click();
	System.out.println("Search is successful.");
}
public static void History() {
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement Menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.chrome:id/menu_button")));  
	Menu.click();
	MobileElement History = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.android.chrome:id/app_menu_list\"))"
	          + ".scrollIntoView(new UiSelector().text(\"History\"))");
	History.click();
	System.out.println("Search history is displayed.");
}
public static void ClickOnIcon() {
	WebDriverWait wait = new WebDriverWait(driver,20);
	WebElement Amazonicon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Amazon.com']")));  
	Amazonicon.click();
	System.out.println("Amazon page is launched.");
	
}
}
