import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.omg.CORBA.Environment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class PgmServer {

	static String Appium_Node_Path="C:/Program Files/nodejs/node.exe";
	static String Appium_JS_Path="C:/Users/ravi.m/AppData/Roaming/npm/node_modules/appium/lib/main.js";
	@Test
	public void startServer()
	{
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

	public void stopServer() {
	    Runtime runtime = Runtime.getRuntime();
	    try {
	        System.out.print("Server Stopped");
	        runtime.exec("taskkill /F /IM node.exe");
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}