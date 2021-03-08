package com.ta.Mobile_test;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Ebay_mobileAuto {
static AndroidDriver<MobileElement> driver;
	
	public static void main(String[] args) throws Exception {
		Launch();
		scrollUp();
	}

public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "com.ebay.mobile");
		cap.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		cap.setCapability("noReset",true);
		
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		
	}
public static void scrollUp() throws Exception {

	WebDriverWait wait = new WebDriverWait(driver,20);
	/*       scroll up three times    */
	TouchAction action = new TouchAction(driver);
	action.press(PointOption.point(600, 600))
    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
    .moveTo(PointOption.point(600, 100))
    .release().perform();
	Thread.sleep(1000);
	
	action.press(PointOption.point(600, 600))
    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
    .moveTo(PointOption.point(600, 100))
    .release().perform();
	Thread.sleep(1000);
	
	action.press(PointOption.point(600, 600))
    .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
    .moveTo(PointOption.point(600, 100))
    .release().perform();
	Thread.sleep(1000);
	
	MobileElement FootBall = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	          + ".resourceId(\"com.ebay.mobile:id/sub_interest_container\"))"
	          + ".scrollIntoView(new UiSelector().text(\"Football\"))");
	FootBall.click();
	}
}
