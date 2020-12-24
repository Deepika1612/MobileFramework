package appium.mobileframework;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

  static AndroidDriver<AndroidElement> driver;
  public static AppiumDriverLocalService service = null;

  /**
   * The startAppiumServer method starts the server.
   */
  public AppiumDriverLocalService startAppiumServer() {
    boolean check = checkIfServerIsRunnning(4723);

    if (!check) {
      service = AppiumDriverLocalService.buildDefaultService();
      service.start();
      
    }

    return service;
  }

  /**
   * This method is to make sure that the server is running on the correct port.
   */
  public static boolean checkIfServerIsRunnning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(port);

      serverSocket.close();
    } catch (IOException e) {
      // If control comes here, then it means that the port is in use
      isServerRunning = true;
    } finally {
      serverSocket = null;
    }
    return isServerRunning;
  }

  /**
   * This method is Start the android emulator.
   */
  public static void startEmulator() throws IOException, InterruptedException {

    Runtime.getRuntime().exec(System.getProperty("user.dir") 
        + "\\src\\main\\java\\resources\\startEmulator.bat");
    Thread.sleep(6000);
  }

  /**
   * This method is to kill the previous used node.
   */
  public static void killNodes() throws IOException {

    Runtime.getRuntime().exec(System.getProperty("user.dir") 
        + "\\src\\main\\java\\resources\\killNodes.bat");
  }

  /**
   * This method is to get the screenshot for a test case.
   */
  public static void getScreenshot(String methodName) throws IOException {
    File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    System.out.println("Screenshot taken");
    FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + methodName + ".png"));

  }

  /**
   * This method is invoke the Android Driver and set Desired Capabilities.
   */
  public static AndroidDriver<AndroidElement> capabilities(String appName) 
      throws IOException, InterruptedException {

    FileInputStream file = new FileInputStream(
        System.getProperty("user.dir") 
        + "\\src\\main\\java\\Appium\\MobileFramework\\global.properties");
    Properties prop = new Properties();
    prop.load(file);

    File f = new File("src");
    File fs = new File(f, (String) prop.get(appName));
    String device = (String) prop.get("deviceName");

    if (device.equalsIgnoreCase("TestApp")) {
      startEmulator();
    }

    DesiredCapabilities cap = new DesiredCapabilities();
    cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
    cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
    cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "300");

    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    System.out.println(driver.getPageSource());

    return driver;

  }
  
  public static void closure() {
    driver.quit();
  }

}
