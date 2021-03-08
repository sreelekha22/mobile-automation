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

public class Mobile_FF {
	static AndroidDriver<MobileElement> driverMob;

	public static void main(String[] args) throws Exception {
		Launch();
		//Search();
		private_browser();
	}
public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "org.mozilla.firefox");
		cap.setCapability("appActivity", "org.mozilla.fenix.HomeActivity");
		cap.setCapability("noReset",true);

		driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		/*
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement SignInToFirefox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/fxa_sign_in_button")));  
		SignInToFirefox.click();
		
		WebElement UseEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/signInEmailButton")));  
		UseEmail.click();
		
		WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));  
		Email.click();
		Email.sendKeys("minnulucky.reddy@gmail.com");
		
		WebElement Continue = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.Button")));  
		Continue.click();
		
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));  
		password.click();
		password.sendKeys("lalith123");
		
		WebElement repeat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vpassword")));  
		repeat.click();
		repeat.sendKeys("lalith123");
		
		WebElement age = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("age")));  
		age.click();
		age.sendKeys("44");
		
		WebElement create_account = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-btn")));  
		create_account.click();
		*/
	}
	public static void Search() throws Exception {
		WebDriverWait wait = new WebDriverWait(driverMob,20);
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/toolbar_wrapper")));  
		search.click();
		
		WebElement enterText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/mozac_browser_toolbar_edit_url_view")));  
		enterText.click();
		enterText.sendKeys("covid-19");
		
		MobileElement select = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"org.mozilla.firefox:id/mozac_browser_awesomebar_title\"))"
		          + ".scrollIntoView(new UiSelector().text(\"covid-19 california\"))");
		select.click();
	}
	public static void private_browser() throws Exception {
		WebDriverWait wait = new WebDriverWait(driverMob,20);
		WebElement pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/privateBrowsingButton")));  
		pb.click();
		
		WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/toolbar_wrapper")));  
		search.click();
		
		WebElement enterText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("org.mozilla.firefox:id/mozac_browser_toolbar_edit_url_view")));  
		enterText.click();
		enterText.sendKeys("songs");

	}
}
