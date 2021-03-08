package com.ta.Mobile_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Mobile_Test_Contacts {
	public static Properties prop;
	public Mobile_Test_Contacts() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + 
			  "/src/test/java/com/ta/Mobile_test/mob.properties");
			prop.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//static AndroidDriver<MobileElement> driver;
	static AndroidDriver<MobileElement> driverMob;
	public static void main(String[] args) throws Exception {
		
		Launch();
		//scrollAndClick();
		//createNewContact();
		//OpenCameraInContactsApp();
		
	}
	public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554"); //deviceName
		
		cap.setCapability("appPackage", "com.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}
	public static void scrollAndClick() throws Exception {
//		MobileElement scrollview = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
//		          + ".resourceId(\"android:id/list\"))"
//		          + ".scrollIntoView(new UiSelector().text(\"kalki\"))");
		
		MobileElement scrollview = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"android:id/list\"))"
				+ ".scrollIntoView(new UiSelector().text(\"kalki\"))");
	
		scrollview.click();
	}
	
	public static void createNewContact() throws Exception {
		
		MobileElement CreateNewContact = driverMob.findElementById("com.android.contacts:id/floating_action_button_container");
		CreateNewContact.click();
		Thread.sleep(2000);
		MobileElement selection = driverMob.findElementById("android:id/icon");
		selection.click();
		MobileElement FirstName = driverMob.findElementByClassName("android.widget.EditText");
		FirstName.click();
		FirstName.sendKeys("Lucy");
		Thread.sleep(1000);
		MobileElement phone = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.android.contacts:id/raw_contacts_editor_view\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Phone\"))");
		phone.click();
		phone.sendKeys("9876");
		Thread.sleep(1000);
		MobileElement save = driverMob.findElementById("com.android.contacts:id/editor_menu_save_button");
		save.click();
		Thread.sleep(1000);
		System.out.println("New contact is created.");
	}
	public static void OpenCameraInContactsApp() throws Exception {
		
		MobileElement scrollview = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"android:id/list\"))"
		          + ".scrollIntoView(new UiSelector().text(\"kalki\"))");
		scrollview.click();
		Thread.sleep(1000);
		MobileElement edit = driverMob.findElementById("com.android.contacts:id/menu_edit");
		edit.click();
		Thread.sleep(1000);
		MobileElement camera = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.android.contacts:id/contact_editor_fragment\"))"
		          + ".scrollIntoView(new UiSelector().resourceId(\"com.android.contacts:id/photo_icon\"))");
		camera.click();
		Thread.sleep(1000);
		MobileElement takephoto = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.android.contacts:id/parentPanel\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Take photo\"))");
		takephoto.click();
		Thread.sleep(1000);
		MobileElement shutter = driverMob.findElementById("com.android.camera2:id/shutter_button");
		shutter.click();
		Thread.sleep(1000);
	}
	
}
