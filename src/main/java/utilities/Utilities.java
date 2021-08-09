package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities 
{
	AndroidDriver<AndroidElement> driver;
	public Utilities(AndroidDriver<AndroidElement> driver) 
	{
		this.driver=driver;
	}
public void scrollIntoView(String scrollText)
{
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
			+ "scrollIntoView(text(\""+scrollText+"\"));");
}
public void scrollIntoViewResourceId(String scrollTextView)
{
driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
	    + ".resourceId(\"psl.seatseller.android:id/bus_list\")).scrollIntoView("
	    + "new UiSelector().text(\""+scrollTextView+"\"));");
}
}
