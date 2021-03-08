package com.ta.Mobile_test;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Mobile_Test_Amazon {
	static AndroidDriver<MobileElement> driverMob;
	//static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws Exception {
		launch();
	    signout();
		//CheckItemAddedInyourcart();
		//DeleteItemFromYourcart();
		//CheckStatusOfYourOrder();
	}
	public static void launch() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); 
		
		cap.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		cap.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		cap.setCapability("noReset",true);
		
		driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		driverMob.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public static void signout() throws Exception{
		TouchAction action = new TouchAction(driverMob);
		//action.press(0, 300)).waitAction(500).moveTo(900, 300).release().perform();
		action.press(PointOption.point(0, 300))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
        .moveTo(PointOption.point(900, 300))
        .release().perform();
		Thread.sleep(1000);
		
		MobileElement settings = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.amazon.mShop.android.shopping:id/mash_fragment_stack_container\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Settings\"))");
		settings.click();
		Thread.sleep(1000);
		MobileElement signOut = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.amazon.mShop.android.shopping:id/anp_drawer_item\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Sign Out\"))");
		signOut.click();
		Thread.sleep(2000);
		MobileElement Accept = driverMob.findElementById("android:id/button2");
		Accept.click();
		Thread.sleep(1000);
		System.out.println("Signsout of app and displays login screen.");
		
	}
	public static void CheckItemAddedInyourcart() throws Exception {
		
		MobileElement cartButton = driverMob.findElementById("com.amazon.mShop.android.shopping:id/chrome_action_bar_cart");
		cartButton.click();
		Thread.sleep(2000);
		MobileElement Item = driverMob.findElementByClassName("android.view.View");
		System.out.println("Is item displayed ? " + Item.isDisplayed());
		Thread.sleep(2000);
		
	}
	public static void DeleteItemFromYourcart() throws Exception {
		MobileElement cartButton = driverMob.findElementById("com.amazon.mShop.android.shopping:id/chrome_action_bar_cart");
		cartButton.click();
		Thread.sleep(1000);
		MobileElement delete = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.amazon.mShop.android.shopping:id/mash_web_fragment\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Delete\"))");
		delete.click();
		System.out.println("Cart is empty.");
		Thread.sleep(2000);
		TouchAction action = new TouchAction(driverMob);
		//action.press((PointOption.point(0, 300)).waitAction(500).moveTo(900, 300).release().perform();
		action.press(PointOption.point(0, 300))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
        .moveTo(PointOption.point(900, 300))
        .release().perform();
		Thread.sleep(1000);
		
		MobileElement Home = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.amazon.mShop.android.shopping:id/mash_fragment_stack_container\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Home\"))");
		Home.click();
		Thread.sleep(2000);
		System.out.println("Home page is Displayed.");
	}
	public static void CheckStatusOfYourOrder() throws Exception {
		TouchAction action = new TouchAction(driverMob);
		//action.press(0, 300).waitAction(500).moveTo(900, 300).release().perform();
		action.press(PointOption.point(0,300))
        .waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
        .moveTo(PointOption.point(900, 300))
        .release().perform();
		Thread.sleep(1000);
		
		MobileElement YourOrders = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.amazon.mShop.android.shopping:id/mash_fragment_stack_container\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Your Orders\"))");
		YourOrders.click();
		Thread.sleep(1000);
		MobileElement Itemtext = driverMob.findElementByClassName("android.view.View");
		System.out.println("Is your order status is displayed ? " + Itemtext.isDisplayed());
		Thread.sleep(2000);
		
		
	}

}
