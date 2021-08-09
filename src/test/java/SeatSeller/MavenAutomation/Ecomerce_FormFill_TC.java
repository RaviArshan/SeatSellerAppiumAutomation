package SeatSeller.MavenAutomation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import automationClass.SsBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecomerce_FormFill_TC extends SsBaseClass
{
@Test
public void ecommerce() throws IOException
{
	AndroidDriver<AndroidElement> androidDriver = capabilitiesSS("ecomerceFile");
	androidDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	androidDriver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Ravi");
	androidDriver.hideKeyboard();
	androidDriver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).
	//scrollIntoView(new UiSelector().textMatches(\"" + menuText + "\").instance(0));")); 

	androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))."
			+ "scrollIntoView(text(\"Bhutan\").instance(0));");
	androidDriver.findElement(By.xpath("//android.widget.TextView[@text='Bhutan']")).click();
	androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
    + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
    + "new UiSelector().text(\"Jordan 6 Rings\"));");
	int proCount=androidDriver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();
	System.out.println(proCount);
	for(int i=0;i<proCount;i++)
	{
	String prodName = androidDriver.findElements(By.id("com.androidsample.generalstore:id/productName"))
			.get(i).getText();
	if(prodName.contentEquals("Jordan 6 Rings"))
	{
	
		androidDriver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		break;

	}
	}
}
}
