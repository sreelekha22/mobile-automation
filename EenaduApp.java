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

public class EenaduApp {
	static AndroidDriver<MobileElement> driverMob;
	public static void main(String[] args) throws Exception {
		Launch();
		notification();
		settings();
		cinema();
	}
		public static void Launch() throws Exception {
			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
			
			cap.setCapability("appPackage", "com.eenadu");
			cap.setCapability("appActivity", "com.eenadu.launch.LauncherActivity");
			//cap.setCapability("noReset",true);

			driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
			WebDriverWait wait = new WebDriverWait(driverMob,20);
			WebElement choose = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.LinearLayout")));  
			choose.click();
			Thread.sleep(3000);

	}
		public static void notification() throws Exception {
			WebDriverWait wait = new WebDriverWait(driverMob,20);
			WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eenadu:id/img_notifications")));  
			menu.click();
			MobileElement select = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
			          + ".resourceId(\"com.eenadu:id/txt_title\"))"
			          + ".scrollIntoView(new UiSelector().text(\"గ్రహం-అనుగ్రహం\"))");
			select.click();
			WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));  
			back.click();
			Thread.sleep(1000);
			WebElement backAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));  
			backAgain.click();
		}
		public static void settings() throws Exception {
			WebDriverWait wait = new WebDriverWait(driverMob,20);
			WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eenadu:id/img_notifications")));  
			menu.click();
			WebElement settings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.eenadu:id/img_notifications")));  
			settings.click();
			WebElement off = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.android.settings:id/switch_widget")));  
			off.click();
			WebElement back = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));  
			back.click();
			Thread.sleep(1000);
			WebElement backAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")));  
			backAgain.click();
		}
		public static void cinema() throws Exception {
			WebDriverWait wait = new WebDriverWait(driverMob,20);
			WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"సినిమా\"]")));  
			menu.click();
		}

}
