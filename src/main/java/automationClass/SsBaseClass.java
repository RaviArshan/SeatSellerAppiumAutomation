package automationClass;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SsBaseClass 
{
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> capabilitiesSS(String appName) throws IOException
	{
	FileInputStream  file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Global.Properties");
	Properties prop=new Properties();
	prop.load(file);
	File f=new File("src");
	File fs=new File(f,prop.getProperty(appName));
	DesiredCapabilities desire=new DesiredCapabilities();
	desire.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("EmulatorName"));
	desire.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	desire.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>
	(new URL("http://127.0.0.1:4723/wd/hub"),desire);
	return driver;
	}
	static String appiumPath="C:/Users/ravi.m/AppData/Roaming/npm/node_modules/appium/lib/main.js";
	static String nodePath="C:/Program Files/nodejs/node.exe";
	public void  startServer()
	{
		System.out.print("Welcome");
		CommandLine cmd = new CommandLine("C:/Program Files/nodejs/node.exe");
	    cmd.addArgument("C:/Users/ravi.m/AppData/Roaming/npm/node_modules/appium/lib/appium.js");
	    cmd.addArgument("--address");
	    cmd.addArgument("127.0.0.1");
	    cmd.addArgument("--port");
	    cmd.addArgument("4723");

	    DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
	    DefaultExecutor executor = new DefaultExecutor();
	    executor.setExitValue(1);
	    try {
	        System.out.print("Server Started");
	        executor.execute(cmd, handler);
	        Thread.sleep(10000);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		//C:\Users\ravi.m\eclipse-workspace\MavenAutomation\src\main\java\Resources\Emulator.bat
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Emulator.bat");
		Thread.sleep(6000);
	}
	public static boolean checkIfServerRunning(int port)        //4723
	{
		System.out.println("Start checkIfServerRunning() ");
		boolean isServerRunning=false;
		ServerSocket serverSocket;
		try
		{
			serverSocket=new ServerSocket(port);
			serverSocket.close();
					
		}
		catch(IOException e)
		{
			System.out.println("server running in port "+port);
			isServerRunning=true;
		}
		finally
		{
			serverSocket=null;
		}
		return isServerRunning;
	}
}
