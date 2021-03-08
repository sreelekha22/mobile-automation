package com.ta.Mobile_test;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Pixel_contacts {
	
	static AndroidDriver<MobileElement> driverMob;

	public static void main(String[] args) throws Exception {
		Launch();
		//scrollAndClick();
		//createNewContact();
		OpenCameraInContactsApp();

	}
public static void Launch() throws Exception {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID"); //"platformName", "ANDROID"
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "94BAY0LTVT"); //deviceName
		
		cap.setCapability("appPackage", "com.google.android.contacts");
		cap.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		
		driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
	}
	public static void scrollAndClick() throws Exception {
		
		MobileElement scrollview = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.google.android.contacts:id/contacts_list_container\"))"
				+ ".scrollIntoView(new UiSelector().text(\"Anisha\"))");
		scrollview.click();
	}
	
	public static void createNewContact() throws Exception {
		
		MobileElement CreateNewContact = driverMob.findElementById("com.google.android.contacts:id/floating_action_button");
		CreateNewContact.click();
		Thread.sleep(2000);
		MobileElement FirstName = driverMob.findElementByXPath("//android.widget.EditText[@text='First name']");
		FirstName.click();
		FirstName.sendKeys("Lucy");
		Thread.sleep(1000);
		MobileElement phone = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.android.contacts:id/raw_contacts_editor_view\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Phone\"))");
		phone.click();
		phone.sendKeys("9876");
		Thread.sleep(1000);
		MobileElement save = driverMob.findElementById("com.google.android.contacts:id/menu_save");
		save.click();
		Thread.sleep(1000);
		System.out.println("New contact is created.");
	}
	public static void OpenCameraInContactsApp() throws Exception {
		
		MobileElement scrollview = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.google.android.contacts:id/contacts_list_container\"))"
				+ ".scrollIntoView(new UiSelector().text(\"Anisha\"))");
		scrollview.click();
		Thread.sleep(1000);
		MobileElement edit = driverMob.findElementById("com.google.android.contacts:id/floating_action_button");
		edit.click();
		Thread.sleep(1000);
		MobileElement camera = driverMob.findElementById("com.google.android.contacts:id/photo_icon");
		camera.click();
		Thread.sleep(1000);
		MobileElement takephoto = (MobileElement) driverMob.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
		          + ".resourceId(\"com.google.android.contacts:id/parentPanel\"))"
		          + ".scrollIntoView(new UiSelector().text(\"Take photo\"))");
		takephoto.click();
		Thread.sleep(1000);
		MobileElement shutter = driverMob.findElementById("com.google.android.GoogleCamera:id/shutter_button");
		shutter.click();
		Thread.sleep(1000);
		
		MobileElement shutter1 = driverMob.findElementById("com.google.android.GoogleCamera:id/shutter_button");
		shutter1.click();
		Thread.sleep(1000);
		
		MobileElement savePhoto = driverMob.findElementById("com.google.android.apps.photos:id/cpe_save_button");
		savePhoto.click();
		Thread.sleep(1000);
		
		System.out.println("photo saves to a contact");
	}

}
