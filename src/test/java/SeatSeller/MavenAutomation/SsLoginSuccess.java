package SeatSeller.MavenAutomation;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import automationClass.SsBaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.LoginPage;
import pageObjects.SrcDesSearchPage;
import utilities.Utilities;

public class SsLoginSuccess extends SsBaseClass
{
@Test
public void ssTest() throws IOException, InterruptedException
{
	startServer();
	
	startEmulator();
	
	AndroidDriver<AndroidElement> driver = capabilitiesSS("ssApkFile"); //Apk FileName
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	LoginPage login=new LoginPage(driver);
	login.ssUserName.sendKeys("ravi.manogaran26@gmail.com");
	login.ssPassword.sendKeys("Ravi@123");
    login.ssLoginBtn.click();
	SrcDesSearchPage srcDes= new SrcDesSearchPage(driver);
	srcDes.src.click();        
	Thread.sleep(10000);
	Utilities util=new Utilities(driver);
	driver.findElement(By.id("psl.seatseller.android:id/edt_city_input")).sendKeys("Banga");
	util.scrollIntoView("Bangalore");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Bangalore']")).click();
	Thread.sleep(10000);
	srcDes.des.click();
	driver.findElement(By.xpath("//android.widget.EditText[@text='ENTER DESTINATION ']")).sendKeys("Che");
	util.scrollIntoView("Chennai");
	driver.findElement(By.xpath("//android.widget.TextView[@text='Chennai']")).click();
	Thread.sleep(10000);
	srcDes.searchBtn.click();
    int busCount=driver.findElements(By.id("psl.seatseller.android:id/tv_bus_details")).size();
    System.out.println(busCount);
    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
    	    + ".resourceId(\"psl.seatseller.android:id/bus_list\")).scrollIntoView("
    	    + "new UiSelector().text(\"Shama Sardar Travels HPM\"));").click();
    driver.findElement(By.xpath("//*[@text='RU1']")).click();
    // androidDriver.findElementByAccessibilityId(element).getAttribute("clickable").equals("true")   
   String baseFare = driver.findElement(By.id("psl.seatseller.android:id/base_fare_tv")).getText(); // ? 849.00
    String slBaseFare=baseFare.substring(2);
   driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
   Thread.sleep(5000);
  String bpName=  driver.findElement(By.xpath("//android.widget.TextView[@text='Majestic']")).getText();
  System.out.println(bpName);
  driver.findElement(By.xpath("//android.widget.TextView[@text='Majestic']")).click();
   String dbName = driver.findElement(By.xpath("//android.widget.TextView[@text='Chengalpat Toll']")).getText();
   System.out.println(dbName);
   driver.findElement(By.xpath("//android.widget.TextView[@text='Chengalpat Toll']")).click();
   //System.out.println(driver.getPageSource());  - get the complete 
   Thread.sleep(5000);
   driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
   driver.findElement(By.id("psl.seatseller.android:id/down_arrow")).click();
   String conBbpName = driver.findElement(By.id("psl.seatseller.android:id/txt_bp_name")).getText();
   String[] confirmBpName = conBbpName.split("-");// String Split
   String confirmBpName1=confirmBpName[1];
  String conDbpName = driver.findElement(By.id("psl.seatseller.android:id/txt_dp_name")).getText();
  String[] confirmDbpName = conDbpName.split("-");// String Split
  String confirmDbpName1=confirmDbpName[1];
  System.out.println(confirmDbpName[1]);
  assertEquals(bpName, confirmBpName1.substring(1)); // removing the space  //BP assert  
  System.out.println(" Boarding Point Pass");
  assertEquals(dbName, confirmDbpName1.substring(1)); // removing the space  //DB assert  
  System.out.println(" Dropping Point Pass");
  String infoBaseFare = driver.findElement(By.id("psl.seatseller.android:id/fare_txt")).getText();
  System.out.println(slBaseFare);
  String conBaseBare=infoBaseFare.substring(4);
  assertEquals(conBaseBare, slBaseFare);
  System.out.println("Base Fare Pass");
  //service.stop();
}
}
